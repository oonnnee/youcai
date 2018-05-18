package com.agriculture.youcai.controller.manage;

import com.agriculture.youcai.dataobject.Guest;
import com.agriculture.youcai.dataobject.Pricelist;
import com.agriculture.youcai.dataobject.PricelistKey;
import com.agriculture.youcai.dataobject.Product;
import com.agriculture.youcai.dto.PricelistDTO;
import com.agriculture.youcai.enums.ResultEnum;
import com.agriculture.youcai.exception.YoucaiException;
import com.agriculture.youcai.service.GuestService;
import com.agriculture.youcai.service.PricelistService;
import com.agriculture.youcai.service.ProductService;
import com.agriculture.youcai.utils.ResultVOUtils;
import com.agriculture.youcai.utils.comparator.DateComparator;
import com.agriculture.youcai.vo.PricelistDateVO;
import com.agriculture.youcai.vo.PricelistVO;
import com.agriculture.youcai.vo.ResultVO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/manage/pricelist")
public class PricelistController {

    @Autowired
    private PricelistService pricelistService;

    @Autowired
    private GuestService guestService;

    @Autowired
    private ProductService productService;


    @GetMapping("/pdateList")
    public ResultVO<Page<PricelistDateVO>> pdateList(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ){
        /*------------ 1.准备 -------------*/
        // 分页
        page = page<0 ? 0:page;
        size = size<=0 ? 10:size;
        Pageable pageable = new PageRequest(page, size);

        /*------------ 2.查询 -------------*/
        List<PricelistDateVO> pricelistDateVOS = new ArrayList<>();
        Page<Guest> guestPage = guestService.findAll(pageable);
        for (Guest guest : guestPage.getContent()){
            List<Pricelist> pricelists = pricelistService.findById_GuestId(guest.getId());
            Set<Date> dates = new TreeSet<>(new DateComparator());
            for (Pricelist pricelist : pricelists){
                dates.add(pricelist.getId().getPdate());
            }
            PricelistDateVO pricelistVO = new PricelistDateVO(guest.getId(), guest.getName(), dates);
            pricelistDateVOS.add(pricelistVO);
        }

        Page<PricelistDateVO> pricelistDateVOPage = new PageImpl<PricelistDateVO>(pricelistDateVOS, pageable, pricelistDateVOS.size());
        return ResultVOUtils.success(pricelistDateVOPage);
    }

    @PostMapping("/save")
    public ResultVO save(
            @RequestParam String guestId,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date pdate,
            @RequestParam String products
    ){
        List<PricelistDTO> pricelistDTOS = new ArrayList<>();
        try {
            pricelistDTOS = new Gson().fromJson(products,
                    new TypeToken<List<PricelistDTO>>() {
                    }.getType());
        } catch (Exception e) {
            throw new YoucaiException(ResultEnum.MANAGE_PRICELIST_SAVE_PRICES_PARSE_ERROR);
        }
        List<Pricelist> pricelists = pricelistDTOS.stream().map(e ->
                new Pricelist(new PricelistKey(pdate, guestId, e.getProductId()),
                        e.getPrice(), e.getNote())
        ).collect(Collectors.toList());
        pricelistService.save(pricelists);
        return ResultVOUtils.success();
    }

    @PostMapping("/delete")
    public ResultVO delete(
            @RequestParam String guestId,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date pdate
    ){
        pricelistService.delete(guestId, pdate);
        return ResultVOUtils.success();
    }

    @GetMapping("/find")
    public ResultVO find(
            @RequestParam String guestId,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date pdate
    ){
        List<PricelistDTO> pricelistDTOS = new ArrayList<>();

        List<Pricelist> pricelists = pricelistService.findById_GuestIdAndId_pdate(guestId, pdate);
        for (Pricelist pricelist : pricelists){
            String productId = pricelist.getId().getProductId();
            Product product = productService.findOne(productId);
            PricelistDTO pricelistDTO = new PricelistDTO();
            pricelistDTO.setProductId(productId);
            pricelistDTO.setProductCode(product.getPCode());
            pricelistDTO.setProductName(product.getName());
            pricelistDTO.setProductImg(product.getImgfile());
            pricelistDTO.setProductUnit(product.getUnit());
            pricelistDTO.setPrice(pricelist.getPrice());
            pricelistDTO.setNote(pricelist.getNote());
            pricelistDTOS.add(pricelistDTO);
        }

        PricelistVO pricelistVO = new PricelistVO();

        pricelistVO.setGuestId(guestId);
        pricelistVO.setPdate(pdate);
        pricelistVO.setPricelistDTOS(pricelistDTOS);

        return ResultVOUtils.success(pricelistVO);
    }

}

package com.agriculture.youcai.controller.manage;

import com.agriculture.youcai.dataobject.Product;
import com.agriculture.youcai.service.ProductService;
import com.agriculture.youcai.utils.ResultVOUtils;
import com.agriculture.youcai.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/manage/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/save")
    public ResultVO<Product> save(Product product){
        Product saveResult = productService.save(product);
        return ResultVOUtils.success(saveResult);
    }

    @PostMapping("/delete")
    public ResultVO delete(
            @RequestParam String id
    ){
        productService.delete(id);
        return ResultVOUtils.success();
    }

    @PostMapping("/update")
    public ResultVO<Product> update(Product product){
        Product updateResult = productService.update(product);
        return ResultVOUtils.success(updateResult);
    }

    @GetMapping("/find")
    public ResultVO<Product> findOne(
            @RequestParam String id
    ){
        Product findResult = productService.findOne(id);
        return ResultVOUtils.success(findResult);
    }

    @GetMapping("/list")
    public ResultVO<Page<Product>> list(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size
    ){
        /*------------ 1.准备 -------------*/
        page = page<0 ? 0:page;
        size = size<=0 ? 10:size;
        Pageable pageable = new PageRequest(page, size);

        /*------------ 2.查询 -------------*/
        Page<Product> productPage = productService.findAll(pageable);
        return ResultVOUtils.success(productPage);
    }

    @GetMapping("/findBy")
    public ResultVO<Page<Product>> findByPCodeIn(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size,
            @RequestParam(required = false) String name,
            @RequestParam(required = false, name = "PCodes") String codeStr
    ){
        /*------------ 1.准备 -------------*/
        // 分页
        Pageable pageable = new PageRequest(page, size);
        // 产品大类编码列表
        List<String> codes = null;
        if (StringUtils.isEmpty(codeStr) == false){
            String[] codeArr = codeStr.split(",");
            codes = Arrays.asList(codeArr);
        }

        /*------------ 2.查询 -------------*/
        Page<Product> findResult = productService.findBy(name, codes, pageable);

        return ResultVOUtils.success(findResult);
    }
}

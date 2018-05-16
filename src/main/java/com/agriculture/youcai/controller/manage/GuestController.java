package com.agriculture.youcai.controller.manage;


import com.agriculture.youcai.dataobject.Guest;
import com.agriculture.youcai.enums.ResultEnum;
import com.agriculture.youcai.exception.YoucaiException;
import com.agriculture.youcai.service.GuestService;
import com.agriculture.youcai.utils.ResultVOUtils;
import com.agriculture.youcai.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manage/guest")
public class GuestController {

    @Autowired
    private GuestService guestService;

    @PostMapping("/save")
    public ResultVO save(Guest guest){
        //TODO 【管理端】新增客户，表单校验
        Guest saveResult = guestService.save(guest);
        return ResultVOUtils.success(saveResult);
    }

    @PostMapping("/update")
    public ResultVO update(Guest guest){
        //TODO 【管理端】更新客户，表单校验
        Guest updateResult = guestService.update(guest);
        return ResultVOUtils.success(updateResult);
    }

    @GetMapping("/find")
    public ResultVO findOne(
            @RequestParam String id
    ){
        return ResultVOUtils.success(guestService.findOne(id));
    }

    @GetMapping("/list")
    public ResultVO findAll(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ){
        /*------------ 1.准备 -------------*/
        page = page<0 ? 0:page;
        size = size<=0 ? 10:size;
        Pageable pageable = new PageRequest(page, size);

        /*------------ 2.查询 -------------*/
        Page<Guest> guestPage = guestService.findAll(pageable);
        return ResultVOUtils.success(guestPage);
    }

    @PostMapping("/delete")
    public ResultVO delete(
            @RequestParam String id
    ){
        guestService.delete(id);
        return ResultVOUtils.success();
    }

}

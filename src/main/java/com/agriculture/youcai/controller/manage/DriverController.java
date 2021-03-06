package com.agriculture.youcai.controller.manage;

import com.agriculture.youcai.dataobject.Driver;
import com.agriculture.youcai.service.DriverService;
import com.agriculture.youcai.utils.ResultVOUtils;
import com.agriculture.youcai.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manage/driver")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping("/save")
    public ResultVO<Driver> save(Driver driver){
        Driver saveResult = driverService.save(driver);
        return ResultVOUtils.success(driver);
    }

    @PostMapping("/delete")
    public ResultVO delete(
            @RequestParam Integer id
    ){
        driverService.delete(id);
        return ResultVOUtils.success();
    }

    @PostMapping("/update")
    public ResultVO<Driver> update(Driver driver){
        Driver updateResult = driverService.update(driver);
        return ResultVOUtils.success(updateResult);
    }

    @GetMapping("/find")
    public ResultVO<Driver> find(
            @RequestParam Integer id
    ){
        Driver findResult = driverService.findOne(id);
        return ResultVOUtils.success(findResult);
    }

    @GetMapping("/findByNameLike")
    public ResultVO<Page<Driver>> findByNameLike(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(required = false) String name
    ){
        /*------------ 1.准备 -------------*/
        page = page<0 ? 0:page;
        size = size<=0 ? 10:size;
        Pageable pageable = new PageRequest(page, size);

        /*------------ 2.查询 -------------*/
        Page<Driver> driverPage = driverService.findByNameLike(name, pageable);
        return ResultVOUtils.success(driverPage);
    }

    @GetMapping("/list")
    public ResultVO<Page<Driver>> list(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ){
        /*------------ 1.准备 -------------*/
        page = page<0 ? 0:page;
        size = size<=0 ? 10:size;
        Pageable pageable = new PageRequest(page, size);

        /*------------ 2.查询 -------------*/
        Page<Driver> driverPage = driverService.list(pageable);
        return ResultVOUtils.success(driverPage);
    }
}

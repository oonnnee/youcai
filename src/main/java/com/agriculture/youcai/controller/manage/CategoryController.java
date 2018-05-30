package com.agriculture.youcai.controller.manage;

import com.agriculture.youcai.dataobject.Category;
import com.agriculture.youcai.service.CategoryService;
import com.agriculture.youcai.utils.ResultVOUtils;
import com.agriculture.youcai.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/manage/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/map")
    public ResultVO<Map<String, String>> map(){
        Map<String, String> categoryMap = categoryService.findAllInMap();
        return ResultVOUtils.success(categoryMap);
    }

    @GetMapping("/list")
    public ResultVO<List<Category>> list(){
        List<Category> categories = categoryService.findAll();
        return ResultVOUtils.success(categories);
    }
}

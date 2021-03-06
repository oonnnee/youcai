package com.agriculture.youcai.controller.manage;

import com.agriculture.youcai.dataobject.Category;
import com.agriculture.youcai.dataobject.Product;
import com.agriculture.youcai.service.CategoryService;
import com.agriculture.youcai.service.ProductService;
import com.agriculture.youcai.utils.ResultVOUtils;
import com.agriculture.youcai.vo.CategoryWithProductsVO;
import com.agriculture.youcai.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/manage/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    
    @Autowired
    private ProductService productService;

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

    @GetMapping("/listWithProducts")
    public ResultVO<List<CategoryWithProductsVO>> listWithProducts(){
        /*------------ 1.查询数据 -------------*/
        // 产品大类数据
        List<Category> categories = categoryService.findAll();
        // 产品列表数据
        List<Product> products = productService.findAll();
        /*------------ 2.数据拼装 -------------*/
        List<CategoryWithProductsVO> categoryWithProductsVOS = new ArrayList<>();
        for (Category category : categories){
            CategoryWithProductsVO categoryWithProductsVO = new CategoryWithProductsVO();
            categoryWithProductsVO.setCategoryCode(category.getCode());
            categoryWithProductsVO.setCategoryName(category.getName());
            categoryWithProductsVO.setNote(category.getNote());
            categoryWithProductsVO.setProducts(new ArrayList<>());
            categoryWithProductsVOS.add(categoryWithProductsVO);
        }
        for (Product product : products){
            for (CategoryWithProductsVO categoryWithProductsVO : categoryWithProductsVOS){
                if (categoryWithProductsVO.getCategoryCode().equals(product.getPCode())){
                    categoryWithProductsVO.getProducts().add(product);
                    break;
                }
            }
        }
        return ResultVOUtils.success(categoryWithProductsVOS);
    }
}

package com.agriculture.youcai.vo;

import com.agriculture.youcai.dataobject.Product;
import lombok.Data;

import java.util.List;

@Data
public class CategoryWithProductsVO {

    private String categoryCode;
    private String categoryName;
    private String note;

    private List<Product> products;

}

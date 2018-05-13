package com.agriculture.youcai.service;

import com.agriculture.youcai.dataobject.Category;

import java.util.List;

public interface CategoryService {

    Category findOne(String code);

    List<Category> findAll();

}

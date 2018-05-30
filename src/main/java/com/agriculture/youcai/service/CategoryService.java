package com.agriculture.youcai.service;

import com.agriculture.youcai.dataobject.Category;

import java.util.List;
import java.util.Map;

public interface CategoryService {

    Category findOne(String code);

    List<Category> findAll();

    Map<String, String> findAllInMap();
}

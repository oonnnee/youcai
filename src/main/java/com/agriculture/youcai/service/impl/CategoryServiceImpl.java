package com.agriculture.youcai.service.impl;

import com.agriculture.youcai.dataobject.Category;
import com.agriculture.youcai.enums.ResultEnum;
import com.agriculture.youcai.exception.YoucaiException;
import com.agriculture.youcai.repository.CategoryRepository;
import com.agriculture.youcai.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category findOne(String code) {
        return categoryRepository.findOne(code);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}

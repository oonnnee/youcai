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
        if (code == null){
            throw new YoucaiException(ResultEnum.MANAGE_CATEGORY_FIND_ONE_NULL_CODE);
        }
        Category findResult = categoryRepository.findOne(code);
        if (findResult == null){
            throw new YoucaiException(ResultEnum.MANAGE_CATEGORY_FIND_ONE_NOT_EXIST);
        }
        return findResult;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}

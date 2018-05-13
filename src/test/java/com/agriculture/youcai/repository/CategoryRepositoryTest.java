package com.agriculture.youcai.repository;

import com.agriculture.youcai.dataobject.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryRepositoryTest {

    private static final String NAME = "["+CategoryRepositoryTest.class.getName()+"]"+" ";

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    @Transactional
    public void test(){
        Category category = new Category();
        category.setCode("0001");
        category.setName("蔬菜类");
        category.setNote("绿色有机蔬菜！");

        Category result = null;


        result = categoryRepository.save(category);
        assertTrue(NAME+"save", result != null);

        category.setNote("好吃的蔬菜");
        result = categoryRepository.save(category);
        assertTrue(NAME+"update", result.getNote().equals("好吃的蔬菜"));

        result = categoryRepository.findOne("0001");
        assertTrue(NAME+"findOne", result != null);

        categoryRepository.delete("0001");
        result = categoryRepository.findOne("0001");
        assertTrue(NAME+"delete", result == null);
    }

}
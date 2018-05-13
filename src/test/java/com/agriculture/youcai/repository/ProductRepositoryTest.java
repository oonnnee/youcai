package com.agriculture.youcai.repository;

import com.agriculture.youcai.dataobject.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepositoryTest {

    private static final String NAME = "["+ProductRepositoryTest.class.getName()+"]"+" ";

    @Autowired
    private ProductRepository productRepository;

    @Test
    @Transactional
    public void test(){
        Product product = new Product();
        product.setId("123");
        product.setName("小白菜");
        product.setPCode("0001");
        product.setUnit("千克");
        product.setPrice(new BigDecimal(2.3));
        product.setImgfile("http://xxx.png");
        product.setNote("好吃的小白菜");

        Product result = null;


        result = productRepository.save(product);
        assertTrue(NAME+"save", result != null);

        product.setPrice(new BigDecimal(2.5));
        result = productRepository.save(product);
        assertTrue(NAME+"update", result.getPrice().equals(new BigDecimal(2.5)));

        result = productRepository.findOne("123");
        assertTrue(NAME+"findOne", result != null);

        productRepository.delete("123");
        result = productRepository.findOne("123");
        assertTrue(NAME+"delete", result == null);
    }

}
package com.agriculture.youcai.repository;

import com.agriculture.youcai.dataobject.Pricelist;
import com.agriculture.youcai.dataobject.PricelistKey;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PricelistRepositoryTest {

    private static final String NAME = "["+PricelistRepositoryTest.class.getName()+"]"+" ";

    @Autowired
    private PricelistRepository pricelistRepository;

    @Test
    @Transactional
    public void test(){
        Pricelist pricelist = new Pricelist();
        PricelistKey id = new PricelistKey();
        id.setPdate(new Date());
        id.setGuestId("123");
        id.setProductId("123");
        pricelist.setId(id);
        pricelist.setPrice(new BigDecimal(3.4));
        pricelist.setNote("便宜小白菜");

        Pricelist result = null;


        result = pricelistRepository.save(pricelist);
        assertTrue(NAME+"save", result != null);

        pricelist.setPrice(new BigDecimal(3.5));
        result = pricelistRepository.save(pricelist);
        assertTrue(NAME+"update", result.getPrice().equals(new BigDecimal(3.5)));

        result = pricelistRepository.findOne(id);
        assertTrue(NAME+"findOne", result != null);

        pricelistRepository.delete(id);
        result = pricelistRepository.findOne(id);
        assertTrue(NAME+"delete", result == null);
    }

}
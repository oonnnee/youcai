package com.agriculture.youcai.repository;

import com.agriculture.youcai.dataobject.Order;
import com.agriculture.youcai.dataobject.OrderKey;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderRepositoryTest {

    private static final String NAME = "["+OrderRepositoryTest.class.getName()+"]"+" ";

    @Autowired
    private OrderRepository orderRepository;


    @Test
    @Transactional
    public void test() throws ParseException {
        Order order = new Order();
        OrderKey id = new OrderKey();
        id.setOdate(new Date());
        id.setGuestId("123");
        id.setProductId("123");
        order.setId(id);
        order.setPrice(new BigDecimal(2.8));
        order.setNum(new BigDecimal(100));
        order.setAmount(new BigDecimal(2.8*100));
        order.setNote("note");

        Order result = null;

        result = orderRepository.save(order);
        assertTrue(NAME+"save",result != null);

        order.setNote("hi,note");
        result = orderRepository.save(order);
        assertTrue(NAME+"update",result.getNote().equals("hi,note"));

        result = orderRepository.findOne(id);
        assertTrue(NAME+"findOne",result != null);

        orderRepository.delete(id);
        result = orderRepository.findOne(id);
        assertTrue(NAME+"delete",result == null);

    }
}
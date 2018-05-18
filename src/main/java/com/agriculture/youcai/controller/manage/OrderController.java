package com.agriculture.youcai.controller.manage;

import com.agriculture.youcai.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manage/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
}

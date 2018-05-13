package com.agriculture.youcai.repository;

import com.agriculture.youcai.dataobject.Order;
import com.agriculture.youcai.dataobject.OrderKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, OrderKey> {
}

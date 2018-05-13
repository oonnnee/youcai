package com.agriculture.youcai.repository;

import com.agriculture.youcai.dataobject.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {



}

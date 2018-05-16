package com.agriculture.youcai.service;

import com.agriculture.youcai.dataobject.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    Product save(Product product);

    void delete(String id);

    Product update(Product product);

    Product findOne(String id);

    Page<Product> findAll(Pageable pageable);

    Page<Product> findByPCodeIn(List<String> pCodes, Pageable pageable);

}

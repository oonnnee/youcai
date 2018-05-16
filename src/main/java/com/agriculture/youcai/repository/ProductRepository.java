package com.agriculture.youcai.repository;

import com.agriculture.youcai.dataobject.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {

    Page<Product> findByPCodeIn(List<String> pCodes, Pageable pageable);

}

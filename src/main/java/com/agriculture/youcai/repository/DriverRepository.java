package com.agriculture.youcai.repository;

import com.agriculture.youcai.dataobject.Driver;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Integer> {

    Page<Driver> findByNameLike(String name, Pageable pageable);


}

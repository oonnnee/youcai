package com.agriculture.youcai.service;

import com.agriculture.youcai.dataobject.Driver;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DriverService {

    Driver save(Driver driver);

    void delete(Integer id);

    Driver update(Driver driver);

    Driver findOne(Integer id);

    Page<Driver> list(Pageable pageable);

    Page<Driver> findByNameLike(String name, Pageable pageable);

}

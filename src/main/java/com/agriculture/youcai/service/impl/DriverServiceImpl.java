package com.agriculture.youcai.service.impl;

import com.agriculture.youcai.dataobject.Driver;
import com.agriculture.youcai.enums.ResultEnum;
import com.agriculture.youcai.exception.YoucaiException;
import com.agriculture.youcai.repository.DriverRepository;
import com.agriculture.youcai.service.DriverService;
import com.agriculture.youcai.utils.KeyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Override
    public Driver save(Driver driver) {
        Driver saveResult = driverRepository.save(driver);
        if (saveResult == null){
            throw new YoucaiException(ResultEnum.MANAGE_DRIVER_SAVE_ERROR);
        }
        return saveResult;
    }

    @Override
    public void delete(Integer id) {
        driverRepository.delete(id);
    }

    @Override
    public Driver update(Driver driver) {
        if (driver.getId() == null){
            throw new YoucaiException(ResultEnum.MANAGE_DRIVER_UPDATE_NULL_ID);
        }
        Driver updateResult = driverRepository.save(driver);
        if (updateResult == null){
            throw new YoucaiException(ResultEnum.MANAGE_DRIVER_SAVE_ERROR);
        }
        return updateResult;
    }

    @Override
    public Driver findOne(Integer id) {
        Driver findResult = driverRepository.findOne(id);
        return findResult;
    }

    @Override
    public Page<Driver> list(Pageable pageable) {
        Page<Driver> driverPage = driverRepository.findAll(pageable);
        return driverPage;
    }

    @Override
    public Page<Driver> findByNameLike(String name, Pageable pageable) {
        if (StringUtils.isEmpty(name)){
            return driverRepository.findAll(pageable);
        }
        return driverRepository.findByNameLike("%"+name+"%", pageable);
    }
}

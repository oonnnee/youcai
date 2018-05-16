package com.agriculture.youcai.service.impl;

import com.agriculture.youcai.dataobject.Product;
import com.agriculture.youcai.enums.ResultEnum;
import com.agriculture.youcai.exception.YoucaiException;
import com.agriculture.youcai.repository.ProductRepository;
import com.agriculture.youcai.service.ProductService;
import com.agriculture.youcai.utils.KeyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        /*------------ 1.准备 -------------*/
        // 生成产品id
        product.setId(KeyUtils.generate());

        /*------------ 2.保存 -------------*/
        Product saveResult = productRepository.save(product);
        if (saveResult == null){
            throw new YoucaiException(ResultEnum.MANAGE_PRODUCT_SAVE_ERROR);
        }
        return saveResult;
    }

    @Override
    public void delete(String id) {
        productRepository.delete(id);
    }

    @Override
    public Product update(Product product) {
        Product updateResult = productRepository.save(product);
        if (updateResult == null){
            throw new YoucaiException(ResultEnum.MANAGE_PRODUCT_UPDATE_ERROR);
        }
        return updateResult;
    }

    @Override
    public Product findOne(String id) {
        return productRepository.findOne(id);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Page<Product> findByPCodeIn(List<String> pCodes, Pageable pageable) {
        return productRepository.findByPCodeIn(pCodes, pageable);
    }
}

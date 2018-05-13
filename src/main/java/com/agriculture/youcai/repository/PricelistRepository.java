package com.agriculture.youcai.repository;

import com.agriculture.youcai.dataobject.Pricelist;
import com.agriculture.youcai.dataobject.PricelistKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PricelistRepository extends JpaRepository<Pricelist, PricelistKey> {

}


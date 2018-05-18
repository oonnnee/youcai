package com.agriculture.youcai.service.impl;

import com.agriculture.youcai.dataobject.Pricelist;
import com.agriculture.youcai.repository.PricelistRepository;
import com.agriculture.youcai.service.PricelistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class PricelistServiceImpl implements PricelistService {

    @Autowired
    private PricelistRepository pricelistRepository;

    @Override
    public List<Pricelist> findById_GuestId(String guestId) {
        return pricelistRepository.findById_GuestId(guestId);
    }

    @Override
    @Transactional
    public void save(List<Pricelist> pricelists) {
        for (Pricelist pricelist : pricelists){
            pricelistRepository.save(pricelist);
        }
    }

    @Override
    public void delete(String guestId, Date pdate) {
        pricelistRepository.deleteById_GuestIdAndId_Pdate(guestId, pdate);
    }

    @Override
    public List<Pricelist> findById_GuestIdAndId_pdate(String guestId, Date pdate) {
        return pricelistRepository.findById_GuestIdAndId_Pdate(guestId, pdate);
    }
}

package com.agriculture.youcai.service.impl;

import com.agriculture.youcai.dataobject.Pricelist;
import com.agriculture.youcai.dataobject.PricelistKey;
import com.agriculture.youcai.dataobject.Product;
import com.agriculture.youcai.repository.PricelistRepository;
import com.agriculture.youcai.service.PricelistService;
import com.agriculture.youcai.service.ProductService;
import com.agriculture.youcai.utils.comparator.DateComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class PricelistServiceImpl implements PricelistService {

    @Autowired
    private PricelistRepository pricelistRepository;

    @Autowired
    private ProductService productService;

    @Override
    public List<Pricelist> findById_GuestId(String guestId) {
        List<Pricelist> pricelists = pricelistRepository.findById_GuestId(guestId);
        return pricelists;
    }

    @Override
    public void save(List<Pricelist> pricelists) {
        List<Product> products = productService.findAll();
        Map<String, Pricelist> pricelistMap = new HashMap<>();
        for (Pricelist pricelist : pricelists){
            pricelistMap.put(pricelist.getId().getProductId(), pricelist);
        }
        Date pdate = pricelists.get(0).getId().getPdate();
        String guestId = pricelists.get(0).getId().getGuestId();
        for (Product product : products){
            Pricelist pricelist = pricelistMap.get(product.getId());
            if (pricelist != null){
                pricelistRepository.save(pricelist);
            }else{
                PricelistKey pricelistKey = new PricelistKey(pdate, guestId, product.getId());
                try {
                    pricelistRepository.delete(pricelistKey);
                }catch (Exception e){}
            }
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

    @Override
    public List<Date> findPdatesByGuestId(String guestId) {
        List<Date> dates = pricelistRepository.findDistinctId_PdateById_GuestId(guestId);
        return dates;
    }

    @Override
    public Map<String, Pricelist> findProductIdMap(String guestId, Date pdate) {
        List<Pricelist> pricelists = this.findById_GuestIdAndId_pdate(guestId, pdate);
        Map<String, Pricelist> map = new HashMap<>();
        for (Pricelist pricelist : pricelists){
            map.put(pricelist.getId().getProductId(), pricelist);
        }
        return map;
    }
}

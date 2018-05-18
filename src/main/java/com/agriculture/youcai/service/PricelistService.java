package com.agriculture.youcai.service;

import com.agriculture.youcai.dataobject.Pricelist;

import java.util.Date;
import java.util.List;

public interface PricelistService {

    List<Pricelist> findById_GuestId(String guestId);

    List<Pricelist> findById_GuestIdAndId_pdate(String guestId, Date pdate);

    void save(List<Pricelist> pricelists);

    void delete(String guestId, Date pdate);
}

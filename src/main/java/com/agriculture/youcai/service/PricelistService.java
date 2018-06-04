package com.agriculture.youcai.service;

import com.agriculture.youcai.dataobject.Pricelist;
import com.agriculture.youcai.dto.excel.pricelist.Export;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface PricelistService {

    List<Pricelist> findById_GuestId(String guestId);

    List<Pricelist> findById_GuestIdAndId_pdate(String guestId, Date pdate);

    // productId: pricelist
    Map<String, Pricelist> findProductIdMap(String guestId, Date pdate);

    void save(List<Pricelist> pricelists);

    void delete(String guestId, Date pdate);

    List<Date> findPdatesByGuestId(String guestId);

    Export getExcelExport(String guestId, Date pdate);
}

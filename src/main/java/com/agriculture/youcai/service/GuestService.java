package com.agriculture.youcai.service;

import com.agriculture.youcai.dataobject.Guest;
import com.agriculture.youcai.vo.ResultVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface GuestService {

    Guest save(Guest guest);

    void delete(String id);

    Guest findOne(String id);

    Page<Guest> findAll(Pageable pageable);

    Guest update(Guest guest);
}

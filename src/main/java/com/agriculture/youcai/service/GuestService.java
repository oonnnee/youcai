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

    /*------------ 更新用户，不包括密码 -------------*/
    Guest update(Guest guest);

    /*------------ 更新用户密码 -------------*/
    void updatePwd(String id, String pwd);

    Page<Guest> findByNameLike(String name, Pageable pageable);

    Page<Guest> findByIdLike(String id, Pageable pageable);

    Long countAll();
}

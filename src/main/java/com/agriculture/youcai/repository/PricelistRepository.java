package com.agriculture.youcai.repository;

import com.agriculture.youcai.dataobject.Pricelist;
import com.agriculture.youcai.dataobject.PricelistKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Transactional
public interface PricelistRepository extends JpaRepository<Pricelist, PricelistKey> {

    List<Pricelist> findById_GuestId(String guestId);

    List<Pricelist> findById_GuestIdAndId_Pdate(String guestId, Date pdate);

    @Modifying
    @Query("delete from Pricelist where guest_id=?1 and pdate=?2")
    void deleteById_GuestIdAndId_Pdate(String guestId, Date pdate);

}


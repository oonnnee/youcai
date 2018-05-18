package com.agriculture.youcai.repository;

import com.agriculture.youcai.dataobject.Guest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, String> {

    Page<Guest> findByNameLike(String name, Pageable pageable);

    Page<Guest> findByIdLike(String id, Pageable pageable);
}

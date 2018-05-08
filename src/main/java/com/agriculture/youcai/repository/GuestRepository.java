package com.agriculture.youcai.repository;

import com.agriculture.youcai.dataobject.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, String> {
}

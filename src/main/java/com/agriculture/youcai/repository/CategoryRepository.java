package com.agriculture.youcai.repository;

import com.agriculture.youcai.dataobject.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {
}

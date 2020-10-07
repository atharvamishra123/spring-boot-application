package com.demo.shopping.com.repositories;

import com.demo.shopping.com.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryRepository extends JpaRepository<Category,Integer> {

    public Category findById(int id);
}

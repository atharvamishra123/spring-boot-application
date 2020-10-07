package com.demo.shopping.com.repositories;

import com.demo.shopping.com.Entity.Category;
import com.demo.shopping.com.Entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProductRepository extends JpaRepository<Products,Integer> {

    List<Products> findByCategory(Category category);
    Products findById(int pid);
}

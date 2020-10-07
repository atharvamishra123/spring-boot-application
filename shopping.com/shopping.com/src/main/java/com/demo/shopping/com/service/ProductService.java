package com.demo.shopping.com.service;

import com.demo.shopping.com.Entity.Category;
import com.demo.shopping.com.Entity.Products;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    List<Category> getAllCategory();
    List<Products> getAllProducts();
    void saveProductCategory(Category productCategory);
    void saveDifferetProducts(Category category);
    void saveProduct(Products products);
}

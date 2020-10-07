package com.demo.shopping.com.service;

import com.demo.shopping.com.Entity.Category;
import com.demo.shopping.com.Entity.Products;
import com.demo.shopping.com.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private CategoryRepository productsRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Category> getAllCategory() {
        List<Category> categories= productsRepository.findAll();
        return categories;
    }

    @Override
    public List<Products> getAllProducts() {
        return null;
    }

    @Override
    @Transactional
    public void saveProductCategory(Category productCategory) {
        entityManager.persist(productCategory);
    }

    @Override
    @Transactional
    public void saveDifferetProducts(Category category) {
        entityManager.merge(category);
    }

    @Override
    @Transactional
    public void saveProduct(Products products) {
        entityManager.merge(products);
    }

}

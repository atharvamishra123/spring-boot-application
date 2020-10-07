package com.demo.shopping.com.controllers;

import com.demo.shopping.com.Entity.Products;
import com.demo.shopping.com.Entity.User;
import com.demo.shopping.com.repositories.ProductRepository;
import com.demo.shopping.com.service.ProductServiceImpl;
import com.demo.shopping.com.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {

    @Autowired
    private ProductServiceImpl productService;
    @Autowired
    private ProductRepository productReposetory;
    /*@Autowired
    private CategoryRepository categoryRepository;*/
    @Autowired
    private UserServiceImpl userService;

    /*@GetMapping("/v1")
    public String productsList(){
        Category category = categoryRepository.findById(1);
        System.out.println(category + "/n");
        List<Products> list=productReposetory.findByCategory(category);
        System.out.println(list);
        return "abcd";
    }*/

    /*To add Products
    @GetMapping("/add")
    public String addproduct(){

        Category category = new Category();
        category.setName("c3");
        productService.saveProductCategory(category);

        Category category1 = productService.productcategoryById(3);
        Products products = new Products();
        products.setProductname("c3p2");
        products.setCost("556");

        List<Products> list = new ArrayList<>();
        list.add(products);
        category1.setProducts(list);
        products.setCategory(category1);
        productService.saveProductCategory(category1);

        return "productadded..!";
        }*/

       /*@GetMapping("/v1")
       public String addUser(){
              User user = new User();
              user.setUsername("atharva");
              user.setLastname("mishra");
              user.setEmail("atharva@gmail.com");
              user.setPassword("12345");
              userService.saveUser(user);
              return "abcd";
       }*/

       /*@GetMapping("/add")
       public String addproduct()
       {
           User user = userService.finduserbyId(2);
           Products products = new Products();
           products = productReposetory.findById(1);
           products.setUser(user);
           productService.saveProduct(products);
           return "productadded..!";
       }*/
}
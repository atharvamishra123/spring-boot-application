package com.demo.shopping.com.controllers;

import com.demo.shopping.com.Entity.Category;
import com.demo.shopping.com.Entity.Products;
import com.demo.shopping.com.Entity.User;
import com.demo.shopping.com.repositories.CategoryRepository;
import com.demo.shopping.com.repositories.ProductRepository;
import com.demo.shopping.com.repositories.UserRepository;
import com.demo.shopping.com.service.ProductServiceImpl;
import com.demo.shopping.com.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
@RequestMapping("/addtocart")
public class AddToCartController {

    @Autowired
    private ProductServiceImpl productService;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private CategoryRepository categoryRepository;

    private List<Products> addedproducts = new ArrayList<>();

    @GetMapping("/selectedproduct/{pid}")
    public String addtocart(@PathVariable("pid") int pid, Model model, Authentication auth){
        Category category = categoryRepository.findById(1);
        Products products = productRepository.findById(pid);
        addedproducts.add(products);
        List<Products> productsList = productRepository.findByCategory(category);
        model.addAttribute("relatedproducts",productsList);
        return "products";
    }

    @GetMapping("/showcart")
    public String showCart(Model model){
        List<Products> cart = addedproducts;
        model.addAttribute("products",cart);
        return "usercart";
    }

    @GetMapping("/placeorder")
    public String Cart(Model model,Authentication authentication){
        String username = authentication.getName();
        Optional<User> authenicateduser = userRepository.findUserByUsername(username);
        User auth_user = authenicateduser.orElseThrow(()->new UsernameNotFoundException("Bad Creadentials!"));
        int id = auth_user.getId();
        List<Products> added;
        added=addedproducts;
        System.out.println(added);
        User user = userRepository.findById(id);
        user.setProducts(addedproducts);
        userService.saveUserProducts(user);
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("allcategory",categories);
        return "mainpage";
    }
}
















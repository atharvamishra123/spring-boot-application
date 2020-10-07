package com.demo.shopping.com.controllers;

import com.demo.shopping.com.Entity.Category;
import com.demo.shopping.com.Entity.Products;
import com.demo.shopping.com.Entity.User;
import com.demo.shopping.com.repositories.CategoryRepository;
import com.demo.shopping.com.repositories.ProductRepository;
import com.demo.shopping.com.service.ProductServiceImpl;
import com.demo.shopping.com.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/www.shopping.com")
public class ApplicationViewController {

    @Autowired
    private ProductServiceImpl productService;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/showcategory")
    public String fetchallProducts(Model model){
        List<Category> categories = productService.getAllCategory();
        model.addAttribute("allcategory",categories);
        return "mainpage";
    }

    @GetMapping("/showproducts/{cid}")
    public String getProducts(@PathVariable("cid") int cid,Model model){
        int product_id=cid;
        Category category = categoryRepository.findById(product_id);
        List<Products> productsList = productRepository.findByCategory(category);
        model.addAttribute("relatedproducts",productsList);
        return "products";
    }

    @GetMapping("/registration")
    public String userRegistration(Model model){
        model.addAttribute("user",new User());
        return "registration";
    }

    @PostMapping("/submit")
    public String RedirectView(@ModelAttribute("user") User user,Model model){
        userService.saveUser(user);
        model.addAttribute("allcategory",productService.getAllCategory());
        return "mainpage";
    }
}

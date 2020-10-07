package com.demo.shopping.com.Entity;

import javax.persistence.*;

@Entity
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String productname;
    private String cost;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST},
            fetch = FetchType.LAZY)
    private Category category;


    public Products(String productname, String cost) {
        this.productname = productname;
        this.cost = cost;
    }

    public Products() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", productname='" + productname + '\'' +
                ", cost='" + cost + '\'' +
                '}';
    }
}

package com.lavanya.SimpleWebApp.service;

import com.lavanya.SimpleWebApp.model.Product;
import com.lavanya.SimpleWebApp.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public List<Product> getallproducts() {
        return  repo.findAll();
    }

    public Product getproductdetails(int id){
        return repo.findById(id).orElse(new Product());
    }
}

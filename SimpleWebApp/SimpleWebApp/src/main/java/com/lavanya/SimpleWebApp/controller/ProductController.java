package com.lavanya.SimpleWebApp.controller;

import com.lavanya.SimpleWebApp.model.Product;
import com.lavanya.SimpleWebApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService service;

    @RequestMapping("/")
    public String greet()
    {return "Hello World!";}

    @GetMapping("/products")
    public List<Product> getAllProducts(){
         return service.getallproducts();
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getproduct(@PathVariable int id){
        Product product= service.getproductdetails(id);

        if(product != null)
            return new ResponseEntity<>(product, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

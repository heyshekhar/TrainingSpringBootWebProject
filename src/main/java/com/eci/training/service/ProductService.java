package com.eci.training.service;

import java.util.List;

import com.eci.training.domain.Product;

public interface ProductService {

    int createNewProduct(Product toBeSaved); // POST /products + Json data , 201 + location header + Json data
    										 // 400 Bad Request

    Product findById(int id); // GET /products/id, 200 + Json data or 404

    List<Product> findAll(); // GET /products, 200 + Json data 

    void removeProduct(int id); // DELETE /products/id, 204 or 404

}

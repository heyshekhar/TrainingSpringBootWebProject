package com.eci.training.dal;

import java.util.List;

import com.eci.training.domain.Product;

public interface ProductDAO {
    
    public Product save(Product toBeSaved);
    public Product findById(int id);
    public List<Product> findAll();
    public void removeById(int id);

}

package com.eci.training.dal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.eci.training.domain.Product;

/*@Profile("inMemory")
@Repository*/
public class InMemoryProductDAO implements ProductDAO {

    Map<Integer,Product> db = new ConcurrentHashMap<>();
    AtomicInteger idSequence = new AtomicInteger(0);
    
    @Override
    public Product save(Product toBeSaved) {
        int id = idSequence.incrementAndGet();
        toBeSaved.setId(id);
        db.put(id, toBeSaved);
        return toBeSaved;
    }
    @Override
    public Product findById(int id) {
        return db.get(id);
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<Product>(db.values());
    }
    @Override
    public void removeById(int id) {
        db.remove(id);
        
    }
    
}
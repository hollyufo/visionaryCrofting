package com.visionaryCrofting.demo.service;

import com.visionaryCrofting.demo.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {

    public Optional<Product> getById(Long id);
    public List<Product> getAll() ;
    public int count();
    public Product save(Product product) ;
    public void deleteById(Long id);

}

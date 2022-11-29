package com.visionaryCrofting.demo.service.implementation;

import com.visionaryCrofting.demo.entity.Product;
import com.visionaryCrofting.demo.repositories.ProductRepository;
import com.visionaryCrofting.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class ProductServiceImp implements ProductService {

    @Autowired
    ProductRepository productRepository;
    @Override
    public Optional<Product> getById(Long id) {
        return productRepository.findById(id);
    }
    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public int count() {
        return productRepository.findAll().size();
    }

    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public Product update(Product t) {
        return null;
    }
    @Override
    public void deleteById(Long id) {
            productRepository.deleteById(id);
    }
}
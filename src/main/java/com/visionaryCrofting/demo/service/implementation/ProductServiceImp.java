package com.visionaryCrofting.demo.service.implementation;

import com.visionaryCrofting.demo.entity.Product;
import com.visionaryCrofting.demo.entity.Stock;
import com.visionaryCrofting.demo.repositories.ProductRepository;
import com.visionaryCrofting.demo.repositories.StockRepository;
import com.visionaryCrofting.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
public class ProductServiceImp implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    StockRepository stockRepository;
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
        Product byRef = this.findByRef(product.getRef());
        if (byRef != null) return null;
        return productRepository.save(product);
    }

    @Override
    public Product update(Product t) {
        Product byRef = this.findByRef(t.getRef());
        if (byRef == null) return null;
        return productRepository.save(t);
    }
    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product findByRef(String ref) {
        return productRepository.findByRef(ref);
    }

    @Override
    @Transactional
    public int deleteByRef(String ref) {
        return productRepository.deleteByRef(ref);
    }
}

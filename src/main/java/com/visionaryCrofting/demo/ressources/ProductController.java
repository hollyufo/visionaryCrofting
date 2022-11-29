package com.visionaryCrofting.demo.ressources;

import com.visionaryCrofting.demo.entity.Product;
import com.visionaryCrofting.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("${api.endpoint}/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/id/{id}")
    public Optional<Product> getByID(Long id) {return productService.getById(id);}

    @GetMapping("/")
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/count")
    public int count() {
        return productService.count();
    }

    @PostMapping("/")
    public Product save(@RequestBody Product product) {
        return (Product) productService.save(product);
    }

    @PutMapping("/")
    public Product update(@RequestBody Product product) {return (Product) productService.update(product);}

    @DeleteMapping("/id/{aLong}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }

}

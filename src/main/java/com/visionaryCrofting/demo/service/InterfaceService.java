package com.visionaryCrofting.demo.service;

import com.visionaryCrofting.demo.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface InterfaceService<T> {

    public Optional<T> getById(Long id);
    public List<T> getAll() ;
    public int count();
    public T save(T t);


    public void deleteById(Long id);

}

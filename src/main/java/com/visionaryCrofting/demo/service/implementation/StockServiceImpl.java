package com.visionaryCrofting.demo.service.implementation;

import com.visionaryCrofting.demo.entity.*;
import com.visionaryCrofting.demo.repositories.StockRepository;
import com.visionaryCrofting.demo.service.AppelOffreService;
import com.visionaryCrofting.demo.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class StockServiceImpl implements StockService {
    private Product product;
    private AppelOffreServiceImpl appelOffreServiceImpl;
    @Autowired
    StockRepository repository;
    @Autowired
    AppelOffreService aoService;

    @Override
    public Stock save(Stock stock) {
        return repository.save(stock);
    }
    @Override
    public void deleteById(Long id){
        repository.deleteById(id);
    }
    @Override
    public Stock updateStock(Stock stock){
        return  repository.save(stock);
    }


}

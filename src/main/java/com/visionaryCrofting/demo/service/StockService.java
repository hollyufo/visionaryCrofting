package com.visionaryCrofting.demo.service;

import com.visionaryCrofting.demo.entity.Stock;
import org.springframework.stereotype.Service;

@Service
public interface StockService {


    Stock save(Stock stock);
    void deleteById(Long id);
    Stock updateStock(Stock stock);


}

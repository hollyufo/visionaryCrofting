package com.visionaryCrofting.demo.service;

import com.visionaryCrofting.demo.entity.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientService {
    List<Client> getAllClients();
}

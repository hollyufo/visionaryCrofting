package com.visionaryCrofting.demo.service.implementation;

import com.visionaryCrofting.demo.entity.Client;
import com.visionaryCrofting.demo.repositories.ClientRepository;
import com.visionaryCrofting.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientServiceImp implements ClientService {
    @Autowired
    ClientRepository clientRepository;
    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
}

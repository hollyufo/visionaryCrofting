package com.visionaryCrofting.demo.service;

import com.visionaryCrofting.demo.entity.Client;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ClientService {
    List<Client> getAllClients();
    Optional<Client> getOnById(Long id);
}

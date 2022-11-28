package com.visionaryCrofting.demo.ressources;

import com.visionaryCrofting.demo.entity.Client;
import com.visionaryCrofting.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientRessource {

    @Autowired
    ClientService clientService;

    @GetMapping("/")
    public List<Client> getAllClients(){
        return clientService.getAllClients();
    }
}

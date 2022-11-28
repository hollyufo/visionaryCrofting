package com.visionaryCrofting.demo.ressources;

import com.visionaryCrofting.demo.entity.Client;
import com.visionaryCrofting.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientRessource {

    @Autowired
    ClientService clientService;

    @GetMapping("/")
    public List<Client> getAllClients(){
        return clientService.getAllClients();
    }

    @GetMapping("/{client_id}")
    public Optional<Client> getClientById(@PathVariable Long client_id){
        Optional<Client> client = clientService.getOnById(client_id);
        if(client.isPresent()){
            return client;
        }else{
            throw new IllegalStateException("Id non trouvé");
        }

    }
}

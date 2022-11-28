package com.visionaryCrofting.demo.service.implementation;

import com.visionaryCrofting.demo.entity.Client;
import com.visionaryCrofting.demo.repositories.ClientRepository;
import com.visionaryCrofting.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ClientServiceImp implements ClientService {
    @Autowired
    ClientRepository clientRepository;
    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> getOnById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public Optional<Client> addClient(Client client) {
        Pattern patternEmail = Pattern.compile("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,})$");
        Pattern patternPassword = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
        if (client.getEmail()!=null && client.getPassword() !=null && client.getTel() !=null){
            Matcher matcherEmail = patternEmail.matcher(client.getEmail());
            Matcher matcherPassword = patternPassword.matcher(client.getPassword());
            if(matcherEmail.matches() && matcherPassword.matches()) {
                Optional<Client> clientByEmail = clientRepository.findByEmail(client.getEmail());
                if (clientByEmail.isPresent()) {
                    throw new IllegalStateException("Email existe déja");
                } else {
                    return Optional.of(clientRepository.save(client));
                }
            }else{
                throw new IllegalStateException("Email or password Format Invalid");
            }
        }else{
            throw new IllegalStateException("il faut remplire tous les champs");
        }
    }
}

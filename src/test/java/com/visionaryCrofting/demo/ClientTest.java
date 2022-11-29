package com.visionaryCrofting.demo;

import com.visionaryCrofting.demo.entity.Client;
import com.visionaryCrofting.demo.repositories.ClientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
public class ClientTest {
    ClientRepository clientRepository;
    @Autowired
    public ClientTest(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    @Test
    public void addClient(){
        Client client = new Client("saida@gmail.com","Azerty@123","0677889900", List.of());
        Client result=null;
        Pattern patternEmail = Pattern.compile("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,})$");
        Pattern patternPassword = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
        if (client.getEmail()!=null && client.getPassword() !=null && client.getTel() !=null){
            Matcher matcherEmail = patternEmail.matcher(client.getEmail());
            Matcher matcherPassword = patternPassword.matcher(client.getPassword());
            if(matcherEmail.matches() && matcherPassword.matches()) {
                Optional<Client> clientByEmail = clientRepository.findByEmail(client.getEmail());
                if (clientByEmail.isPresent()) {
                    result = null;
                    throw new IllegalStateException("Email existe déja");
                } else {
                    result = clientRepository.save(client);
                }
            }else{
                result = null;
                throw new IllegalStateException("Email or password Format Invalid");
            }
        }else{
            result = null;
            throw new IllegalStateException("il faut remplire tous les champs");
        }

        Assertions.assertSame(client,result);
    }
    @Test
    public void updatClient(){
        Optional<Client> result=null;
        Pattern patternEmail = Pattern.compile("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,})$");
        Pattern patternPassword = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
        Optional<Client> client = clientRepository.findById(Long.valueOf(1));
        if(client.isPresent()){
            Client client1 = client.get();
            client1.setEmail("");
            client1.setPassword("");
            client1.setTel("");
            client1.setCommandes(List.of());
            if ((client1.getEmail()!=null || client1.getEmail().length()>0) && client1.getPassword() !=null && client1.getTel() !=null){
                Matcher matcherEmail = patternEmail.matcher(client1.getEmail());
                Matcher matcherPassword = patternPassword.matcher(client1.getPassword());
                if(matcherEmail.matches() && matcherPassword.matches()) {
                    Optional<Client> clientByEmail = clientRepository.findByEmail(client1.getEmail());
                    if (clientByEmail.isPresent()) {
                        result = null;
                        throw new IllegalStateException("Email existe déja");
                    } else {
                        clientRepository.save(client1);
                        result = clientRepository.findById(Long.valueOf(1));
                    }
                }else{
                    result = null;
                    throw new IllegalStateException("Email or password Format Invalid");
                }
            }else{
                result = null;
                throw new IllegalStateException("il faut remplire tous les champs");
            }
        }else {
            result = null;
            throw new IllegalStateException("id non existe");
        }
        Assertions.assertNotSame(client,result);
    }

}

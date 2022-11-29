package com.visionaryCrofting.demo.service;
import com.visionaryCrofting.demo.entity.Commande;
import com.visionaryCrofting.demo.repositories.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandService {
    public final CommandeRepository commandeRepository;
    @Autowired
    public CommandService(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }
    // get all commande
    public List<Commande> getAllCommande(){
        return commandeRepository.findAll();
    }
    // get commande by id
    public Commande getCommandeById(Long id){
        return commandeRepository.findById(id).orElse(null);
    }
    // get commande by ref
    public Commande getCommandeByRef(String ref){
        return commandeRepository.findByRef(ref);
    }
    // add commande
    public Commande addCommande(Commande commande){
        // chcking if commande is empty
        if(commande.getRef() == null){
            return null;
        }else {
            return commandeRepository.save(commande);
        }
    }
    // delete commande
    public String deleteCommande(Long id){
        commandeRepository.deleteById(id);
        return "Commande deleted";
    }
}

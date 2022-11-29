package com.visionaryCrofting.demo.service;

import com.visionaryCrofting.demo.entity.Commande;

import java.util.List;

public interface CommandService {
    public List<Commande> getAllCommande();
    public Commande getCommandeById(Long id);
    public Commande getCommandeByRef(String ref);
    public Commande addCommande(Commande commande);
    public String deleteCommande(Long id);

}

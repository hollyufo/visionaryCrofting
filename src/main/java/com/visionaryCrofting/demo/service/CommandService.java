package com.visionaryCrofting.demo.service;

import com.visionaryCrofting.demo.entity.CommandeItem;
import com.visionaryCrofting.demo.repositories.CommandeItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandService {
    private final CommandeItemRepository commandeItemRepository;

    @Autowired
    public CommandService(CommandeItemRepository commandeItemRepository) {
        this.commandeItemRepository = commandeItemRepository;
    }
    public List<CommandeItem> getAllCommandeItem(){
        return commandeItemRepository.findAll();
    }



}

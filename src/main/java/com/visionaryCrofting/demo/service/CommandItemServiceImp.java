package com.visionaryCrofting.demo.service;

import com.visionaryCrofting.demo.entity.CommandeItem;
import com.visionaryCrofting.demo.entity.Product;
import com.visionaryCrofting.demo.repositories.CommandeItemRepository;
import com.visionaryCrofting.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CommandItemServiceImp implements InterfaceService<CommandeItem> {
    @Autowired
    CommandeItemRepository commandeItemRepository;

    @Override
    public Optional<CommandeItem> getById(Long id) {
        return commandeItemRepository.findById(id);
    }

    @Override
    public List<CommandeItem> getAll() {
        return commandeItemRepository.findAll();
    }

    @Override
    public int count() {
        return commandeItemRepository.findAll().size();
    }

    @Override
    public CommandeItem save(CommandeItem commandeItem) {
        return commandeItemRepository.save(commandeItem);
    }

    @Override
    public void deleteById(Long id) {
        commandeItemRepository.deleteById(id);
    }
}

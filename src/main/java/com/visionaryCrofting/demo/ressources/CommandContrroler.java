package com.visionaryCrofting.demo.ressources;


import com.visionaryCrofting.demo.entity.CommandeItem;
import com.visionaryCrofting.demo.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Command")
public class CommandContrroler {
    public final CommandService commandService;
    @Autowired
    public CommandContrroler(CommandService commandService) {
        this.commandService = commandService;
    }
    @GetMapping("/all")
    public List<CommandeItem> getAllCommandeItem(){
        return commandService.getAllCommandeItem();
    }
}

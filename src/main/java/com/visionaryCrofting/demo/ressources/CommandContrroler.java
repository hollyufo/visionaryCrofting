package com.visionaryCrofting.demo.ressources;


import com.visionaryCrofting.demo.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Command")
public class CommandContrroler {
    public final CommandService commandService;
    @Autowired
    public CommandContrroler(CommandService commandService) {
        this.commandService = commandService;
    }
    @GetMapping("/all")
    public String getAllCommandeItem(){
        return commandService.getAllCommandeItem().toString();
    }
}

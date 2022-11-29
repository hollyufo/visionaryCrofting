package com.visionaryCrofting.demo.ressources;

import com.visionaryCrofting.demo.entity.CommandeItem;
import com.visionaryCrofting.demo.entity.Product;
import com.visionaryCrofting.demo.service.InterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("${api.endpoint}/commandItem")
public class CommandItemController {
    @Autowired
    private InterfaceService interfaceService;

    @GetMapping("/id/{id}")
    public Optional<CommandeItem> getByID(Long id) {
        if(id<=0){
            System.out.println("id doit etre superieur strictement de 0");
            return null;
        }
        else
            return interfaceService.getById(id);
    }

    @GetMapping("/")
    public List<CommandeItem> getAll() {
        return interfaceService.getAll();
    }

    @GetMapping("/count")
    public int count() {
        return interfaceService.count();
    }

    @PostMapping("/")
    public CommandeItem save(@RequestBody CommandeItem commandeItem) {
        return (CommandeItem) interfaceService.save(commandeItem);
    }

    @DeleteMapping("/id/{aLong}")
    public void deleteById(@PathVariable Long id) {
        interfaceService.deleteById(id);
    }
}

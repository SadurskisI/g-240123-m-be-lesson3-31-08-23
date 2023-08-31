package de.telran.g240123mbelesson3310823.controllers;


import de.telran.g240123mbelesson3310823.domain.entity.Client;
import de.telran.g240123mbelesson3310823.domain.entity.CommonBasket;
import de.telran.g240123mbelesson3310823.domain.entity.CommonClient;
import de.telran.g240123mbelesson3310823.repository.ClientRepository;
import de.telran.g240123mbelesson3310823.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class CommonClientController {

    @Autowired
    private ClientService service;

    @GetMapping
    public List<Client> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Client getById(@PathVariable int id){
       return service.getById(id);
    }

    @PostMapping("/client")
    public void add(@RequestBody Client client){
        service.add(client);
//        ----------- не работает
    }


    public void deleteById(@RequestBody int id){
        service.deleteById(id);
        // не проверял
    }


    public void deleteByName(String name){
        service.deleteByName(name);
        // не проверял
    }


    public void getCount(){
        service.getCount();
    }



}

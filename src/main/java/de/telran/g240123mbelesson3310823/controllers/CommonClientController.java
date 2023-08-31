package de.telran.g240123mbelesson3310823.controllers;


import de.telran.g240123mbelesson3310823.domain.entity.Client;
import de.telran.g240123mbelesson3310823.domain.entity.CommonClient;
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
    public List<Client> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Client getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    public void add(@RequestBody CommonClient client) {
        service.add(client);
    }

    @GetMapping("/removeById/{id}")
    public void removeById(@PathVariable int id) {
        service.removeById(id);
    }

    @GetMapping("/removeByName/{name}")
    public void removeByName(@PathVariable String name) {
        service.removeByName(name);
    }

    @GetMapping("/getCount")
    public int getCount() {
        return service.getCount();
    }

    @GetMapping("/getTotalById/{id}")
    public double getTotalPriceById(@PathVariable int id) {
        return service.getTotalPriceById(id);
    }

    @GetMapping("/getAvgById/{id}")
    public double getAveragePriceById(@PathVariable int id) {
        return service.getAveragePriceById(id);
    }

    @GetMapping("/addToBasketById/{clientId}/{productId}")
    public void addToBasketById(@PathVariable int clientId, @PathVariable int productId) {
        service.addToBasketById(clientId, productId);
    }

    @GetMapping("/deleteFromBasketById/{clientId}/{productId}")
    public void deleteFromBasket(@PathVariable int clientId, @PathVariable int productId) {
        service.deleteFromBasket(clientId, productId);
    }

    @GetMapping("/clearBasketById/{clientId}")
    public void clearBasket(@PathVariable int clientId) {
        service.clearBasket(clientId);
    }
}

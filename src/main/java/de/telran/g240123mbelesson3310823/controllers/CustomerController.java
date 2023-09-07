package de.telran.g240123mbelesson3310823.controllers;


import de.telran.g240123mbelesson3310823.domain.entity.Customer;
import de.telran.g240123mbelesson3310823.domain.entity.common.CommonCustomer;
import de.telran.g240123mbelesson3310823.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping
    public List<Customer> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Customer getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    public void add(@RequestBody CommonCustomer customer) {
        service.add(customer);
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

    @GetMapping("/addToCartById/{clientId}/{productId}")
    public void addToCartById(@PathVariable int clientId, @PathVariable int productId) {
        service.addToCartById(clientId, productId);
    }

    @GetMapping("/deleteFromCartById/{clientId}/{productId}")
    public void deleteFromCart(@PathVariable int clientId, @PathVariable int productId) {
        service.deleteFromCart(clientId, productId);
    }

    @GetMapping("/clearCartById/{clientId}")
    public void clearCart(@PathVariable int clientId) {
        service.clearCart(clientId);
    }
}

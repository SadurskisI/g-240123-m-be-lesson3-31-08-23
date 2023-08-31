package de.telran.g240123mbelesson3310823.controllers;

import de.telran.g240123mbelesson3310823.domain.entity.CommonProduct;
import de.telran.g240123mbelesson3310823.domain.entity.Product;
import de.telran.g240123mbelesson3310823.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class CommonProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    public void add(@RequestBody CommonProduct product) {
        service.add(product);
    }

    @GetMapping("/removeById/{id}")
    public void removeById(@PathVariable int id) {
        service.deleteById(id);
    }

    @GetMapping("/removeByName/{name}")
    public void removeByName(@PathVariable String name) {
        service.deleteByName(name);
    }

    @GetMapping("/getCount")
    public int getCount() {
        return service.getCount();
    }

    @GetMapping("/getTotalPrice")
    public double getTotalPrice() {
        return service.getTotalPrice();
    }

    @GetMapping("/getAvgPrice")
    public double getAveragePrice() {
        return service.getAveragePrice();
    }

}

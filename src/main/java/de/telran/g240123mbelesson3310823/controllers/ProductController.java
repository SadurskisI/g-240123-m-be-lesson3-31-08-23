package de.telran.g240123mbelesson3310823.controllers;

import de.telran.g240123mbelesson3310823.domain.entity.common.CommonProduct;
import de.telran.g240123mbelesson3310823.domain.entity.Product;
import de.telran.g240123mbelesson3310823.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

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
    public Product add(@RequestBody CommonProduct product) {
       service.add(product);
       return product;
    }

    @GetMapping("/delete/{id}")
    public void removeById(@PathVariable int id) {
        service.deleteById(id);
    }

    @GetMapping("/deleteName/{name}")
    public void deleteByName(@PathVariable String name) {
        service.deleteByName(name);
    }

    @GetMapping("/count")
    public int getCount() {
        return service.getCount();
    }

    @GetMapping("/total")
    public double getTotalPrice() {
        return service.getTotalPrice();
    }

    @GetMapping("/average")
    public double getAveragePrice() {
        return service.getAveragePrice();
    }

}

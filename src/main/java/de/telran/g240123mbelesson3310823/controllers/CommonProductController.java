package de.telran.g240123mbelesson3310823.controllers;

import de.telran.g240123mbelesson3310823.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class CommonProductController {

    @Autowired
    private ProductService service;
}

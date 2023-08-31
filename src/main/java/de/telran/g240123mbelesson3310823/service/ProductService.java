package de.telran.g240123mbelesson3310823.service;

import de.telran.g240123mbelesson3310823.domain.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAll();

    Product getById(int id);

    void add(Product product);

    void deleteById(int id);

    void deleteByName(String name);

    int getCount();

    double getTotalPrice();

    double getAveragePrice();
}

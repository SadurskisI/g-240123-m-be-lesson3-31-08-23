package de.telran.g240123mbelesson3310823.domain.entity;

import de.telran.g240123mbelesson3310823.domain.entity.Product;

import java.util.List;

public interface Basket {
    double getTotalCost();
    void addProduct(Product product);
    List<Product> getProducts();
}

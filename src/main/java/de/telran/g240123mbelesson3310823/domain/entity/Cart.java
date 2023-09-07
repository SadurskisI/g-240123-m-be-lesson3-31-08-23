package de.telran.g240123mbelesson3310823.domain.entity;

import java.util.List;

public interface Cart {
    List<Product> getProducts();
    void addProduct(Product product);
    double getTotalCost();

}

package de.telran.g240123mbelesson3310823.repository;

import de.telran.g240123mbelesson3310823.domain.entity.Client;


import java.util.List;

public interface CustomerRepository {

    List<Client> getAll();

    Client getById(int id);

    void add(String name);

    void delete(int id);

    void addToCartById(int customerId, int productId);

    void deleteFromCart(int customerId, int productId);

    void clearCart(int customerId);
}
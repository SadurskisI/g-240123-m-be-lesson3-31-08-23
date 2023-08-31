package de.telran.g240123mbelesson3310823.service;

import de.telran.g240123mbelesson3310823.domain.entity.Client;

import java.util.List;

public interface ClientService {

    List<Client> getAll();

    Client getById(int id);

    void add(Client client);

    void deleteById(int id);

    void deleteByName(String name);

    int getCount();

    double getTotalPriceById(int id);

    double getAveragePriceById(int id);

    void addToCartById(int clientId, int productId);

    void deleteFromCart(int clientId, int productId);

    void clearCart(int clientId);
}

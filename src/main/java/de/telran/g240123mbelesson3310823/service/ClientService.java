package de.telran.g240123mbelesson3310823.service;

import de.telran.g240123mbelesson3310823.domain.entity.Client;

import java.util.List;

public interface ClientService {

    List<Client> getAll();

    Client getById(int id);

    void add(Client client);

    void removeById(int id);

    void removeByName(String name);

    int getCount();

    double getTotalPriceById(int id);

    double getAveragePriceById(int id);

    void addToBasketById(int clientId, int productId);

    void deleteFromBasket(int clientId, int productId);

    void clearBasket(int clientId);
}

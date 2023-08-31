package de.telran.g240123mbelesson3310823.repository;

import de.telran.g240123mbelesson3310823.domain.entity.Client;

import java.util.List;

public interface ClientRepository {

    Client findById(int id);
    List<Client> getClients();
    void removeById(int id);
    void addClient(String name);
}

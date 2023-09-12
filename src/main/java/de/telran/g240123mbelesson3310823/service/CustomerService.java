package de.telran.g240123mbelesson3310823.service;

import de.telran.g240123mbelesson3310823.domain.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getAll();

    Customer getById(int id);

    void add(Customer customer);

    void removeById(int id);

    void removeByName(String name);

    int getCount();

    double getTotalPriceById(int id);

    double getAveragePriceById(int id);

    void addToCartById(int customerId, int productId);

    void deleteFromCart(int customerId, int productId);

    void clearCart(int customerId);
}

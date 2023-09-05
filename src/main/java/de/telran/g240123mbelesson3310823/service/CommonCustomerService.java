package de.telran.g240123mbelesson3310823.service;

import de.telran.g240123mbelesson3310823.domain.entity.Basket;
import de.telran.g240123mbelesson3310823.domain.entity.Client;
import de.telran.g240123mbelesson3310823.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CommonCustomerService implements ClientService {

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private ProductService productService;

    @Override
    public List<Client> getAll() {
        return repository.getAll();
    }

    @Override
    public Client getById(int id) {
        return repository.getById(id);
    }

    @Override
    public void add(Client client) {
        repository.add(client.getName());
    }

    @Override
    public void removeById(int id) {
        repository.delete(id);
    }

    @Override
    public void removeByName(String name) {
        int idToDelete = repository.getAll().stream().filter(x -> x.getName().equals(name)).findFirst().get().getId();
        repository.delete(idToDelete);
    }

    @Override
    public int getCount() {
        return repository.getAll().size();
    }

    @Override
    public double getTotalPriceById(int id) {
        return repository.getById(id).getBasket().getTotalCost();
    }

    @Override
    public double getAveragePriceById(int id) {
        Basket basket = repository.getById(id).getBasket();
        return basket.getTotalCost() / basket.getProducts().size();
    }

    @Override
    public void addToBasketById(int customerId, int productId) {
        repository.addToCartById(customerId, productId);
    }

    @Override
    public void deleteFromBasket(int customerId, int productId) {
        repository.deleteFromCart(customerId, productId);
    }

    @Override
    public void clearBasket(int customerId) {
        repository.clearCart(customerId);
    }
}
package de.telran.g240123mbelesson3310823.service;

import de.telran.g240123mbelesson3310823.domain.entity.Basket;
import de.telran.g240123mbelesson3310823.domain.entity.Client;
import de.telran.g240123mbelesson3310823.domain.entity.Product;
import de.telran.g240123mbelesson3310823.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CommonClientService implements ClientService{

    @Autowired
    private ClientRepository repository;
    @Autowired
    private ProductService productService;



    @Override
    public List<Client> getAll() {
        return repository.getClients();
    }

    @Override
    public Client getById(int id) {
        return repository.findById(id);
    }

    @Override
    public void add(Client client) {
        repository.addClient(client.getName());
    }

    @Override
    public void deleteById(int id) {
        repository.removeById(id);
    }

    @Override
    public void deleteByName(String name) {
        int idToDelete = repository.getClients().stream().filter(x -> x.getName().equals(name)).findFirst().get().getId();
        repository.removeById(idToDelete);
    }

    @Override
    public int getCount() {
        return repository.getClients().size();
    }

    @Override
    public double getTotalPriceById(int id) {
        return repository.findById(id).getBasket().getTotalCost();
    }

    @Override
    public double getAveragePriceById(int id) {
        Basket basket = repository.findById(id).getBasket();
        return basket.getTotalCost() / basket.getProducts().size();

    }

    @Override
    public void addToCartById(int clientId, int productId) {
        Client client = repository.findById(clientId);
        Product product = productService.getById(productId);
        client.getBasket().addProduct(product);
    }

    @Override
    public void deleteFromCart(int clientId, int productId) {
        Client client = repository.findById(clientId);
        client.getBasket().getProducts().removeIf(x -> x.getId() == productId);
    }

    @Override
    public void clearCart(int clientId) {
        Client client = repository.findById(clientId);
        client.getBasket().getProducts().clear();
    }
}

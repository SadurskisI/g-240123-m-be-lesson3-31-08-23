package de.telran.g240123mbelesson3310823.repository;

import de.telran.g240123mbelesson3310823.domain.databasae.Database;
import de.telran.g240123mbelesson3310823.domain.entity.Client;
import de.telran.g240123mbelesson3310823.domain.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;

public class CommonCustomerRepository implements CustomerRepository {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private Database database;

    @Override
    public List<Client> getAll() {
        try {
            return database.select("Select all customers").stream().map(x -> (Client) x).toList();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Client getById(int id) {
        try {
            return (Client) database.select("Select customer where id = " + id).get(0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(String name) {
        try {
            database.execute("Add new customer name = " + name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try {
            database.execute("Delete customer where id = " + id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addToCartById(int customerId, int productId) {
        Client client = getById(customerId);
        Product product = productRepository.getById(productId);
        client.getBasket().addProduct(product);
    }

    @Override
    public void deleteFromCart(int customerId, int productId) {
        Client client = getById(customerId);
        client.getBasket().getProducts().removeIf(x -> x.getId() == productId);
    }

    @Override
    public void clearCart(int customerId) {
        Client client = getById(customerId);
        client.getBasket().getProducts().clear();
    }
}
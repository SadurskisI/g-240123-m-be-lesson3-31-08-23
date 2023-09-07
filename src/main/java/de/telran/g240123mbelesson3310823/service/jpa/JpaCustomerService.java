package de.telran.g240123mbelesson3310823.service.jpa;

import de.telran.g240123mbelesson3310823.domain.entity.Cart;
import de.telran.g240123mbelesson3310823.domain.entity.Customer;
import de.telran.g240123mbelesson3310823.domain.entity.jpa.JpaCart;
import de.telran.g240123mbelesson3310823.domain.entity.jpa.JpaCustomer;
import de.telran.g240123mbelesson3310823.repository.jpa.JpaCustomerRepository;
import de.telran.g240123mbelesson3310823.repository.jpa.JpaProductRepository;
import de.telran.g240123mbelesson3310823.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JpaCustomerService implements CustomerService {

    @Autowired
    private JpaCustomerRepository repository;

    @Autowired
    private JpaProductRepository productRepository;


    @Override
    public List<Customer> getAll() {
        return new ArrayList<>(repository.findAll());
    }

    @Override
    public Customer getById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void add(Customer customer) {
        repository.save(new JpaCustomer(0,customer.getName(),   ));
        ///////////////////
    }

    @Override
    public void removeById(int id) {
        repository.deleteById(id);
    }

    @Override
    public void removeByName(String name) {
        repository.deleteByName(name);
    }

    @Override
    public int getCount() {
        return (int)repository.count();
    }

    @Override
    public double getTotalPriceById(int id) {
        return repository.findById(id).get().getCart().getTotalCost();
    }

    @Override
    public double getAveragePriceById(int id) {
        return repository.findById(id).get().getCart().getTotalCost() /
                repository.findById(id).get().getCart().getProducts().size();
    }

    @Override
    public void addToCartById(int clientId, int productId) {
        repository.findById(clientId).get().getCart().addProduct();
        /////////////
    }

    @Override
    public void deleteFromCart(int clientId, int productId) {
        //////////////
    }

    @Override
    public void clearCart(int clientId) {
        ////////////
    }
}

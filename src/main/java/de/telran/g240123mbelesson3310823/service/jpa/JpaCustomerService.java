package de.telran.g240123mbelesson3310823.service.jpa;

import de.telran.g240123mbelesson3310823.domain.entity.Cart;
import de.telran.g240123mbelesson3310823.domain.entity.Customer;
import de.telran.g240123mbelesson3310823.domain.entity.Product;
import de.telran.g240123mbelesson3310823.domain.entity.jpa.JpaCart;
import de.telran.g240123mbelesson3310823.domain.entity.jpa.JpaCustomer;
import de.telran.g240123mbelesson3310823.repository.jpa.JpaCartRepository;
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

    private JpaCartRepository cartRepository;


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
        JpaCustomer savedCustomer = repository.save(new JpaCustomer(0,customer.getName()));
        cartRepository.save(new JpaCart(savedCustomer));
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
        return getById(id).getCart().getTotalCost();
    }

    @Override
    public double getAveragePriceById(int id) {
        Cart cart = getById(id).getCart();
        return cart.getTotalCost() / cart.getProducts().size();
    }

    @Override
    public void addToCartById(int customerId, int productId) {
        Customer customer = repository.findById(customerId).orElse(null);
        Product product = productRepository.findById(productId).orElse(null);
        Cart cart = customer.getCart();
        cart.addProduct(product);
    }

    @Override
    public void deleteFromCart(int customerId, int productId) {
        ((JpaCart) getById(customerId).getCart()).removeProduct(productRepository.findById(productId).orElse(null));
    }

    @Override
    public void clearCart(int customerId) {
        ((JpaCart) getById(customerId).getCart()).clear();
    }
}

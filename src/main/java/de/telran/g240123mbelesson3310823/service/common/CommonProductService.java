package de.telran.g240123mbelesson3310823.service.common;

import de.telran.g240123mbelesson3310823.domain.entity.Product;
import de.telran.g240123mbelesson3310823.repository.ProductRepository;
import de.telran.g240123mbelesson3310823.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class CommonProductService implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.getAll();
    }

    @Override
    public Product getById(int id) {
        return productRepository.getById(id);
    }

    @Override
    public void add(Product product) {
        productRepository.add(product.getName(),product.getPrice());
    }

    @Override
    public void deleteById(int id) {
        productRepository.delete(id);
    }

    @Override
    public void deleteByName(String name) {
        Product product = productRepository.getAll().stream().filter(o -> o.getName().equals(name)).findFirst().get();
        productRepository.delete(product.getId());
    }

    @Override
    public int getCount() {
        return productRepository.getAll().size();
    }

    @Override
    public double getTotalPrice() {
        return productRepository.getAll().stream().mapToDouble(x -> x.getPrice()).sum();
    }

    @Override
    public double getAveragePrice() {
        return getTotalPrice() / getCount();
//        return productRepository.getAll().stream().mapToDouble(x -> x.getPrice()).average().orElse(0);
    }
}

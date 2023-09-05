package de.telran.g240123mbelesson3310823.repository;

import de.telran.g240123mbelesson3310823.domain.entity.Product;

import java.util.List;

public class MySqlProductRepository implements ProductRepository{
    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public Product getById(int id) {
        return null;
    }

    @Override
    public void add(String name, double price) {

    }

    @Override
    public void delete(int id) {

    }
}

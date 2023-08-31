package de.telran.g240123mbelesson3310823.repository;

import de.telran.g240123mbelesson3310823.domain.entity.Product;

import java.util.List;

public interface ProductRepository {

        List<Product> getAll();

        Product getById(int id);

        void add(String name, double price);

        void delete(int id);
}


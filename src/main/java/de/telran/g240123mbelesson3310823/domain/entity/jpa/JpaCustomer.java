package de.telran.g240123mbelesson3310823.domain.entity.jpa;

import de.telran.g240123mbelesson3310823.domain.entity.Cart;
import de.telran.g240123mbelesson3310823.domain.entity.Customer;
import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class JpaCustomer implements Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "customer")
    private JpaCart cart;

    public JpaCustomer() {
    }

    public JpaCustomer(int id, String name) {
        this.id = id;
        this.name = name;
    }


    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Cart getCart() {
        return cart;
    }
}

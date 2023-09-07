package de.telran.g240123mbelesson3310823.domain.entity.common;

import de.telran.g240123mbelesson3310823.domain.entity.Cart;
import de.telran.g240123mbelesson3310823.domain.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class CommonCustomer implements Customer {

    private int id;
    private String name;
    private Cart cart;

}

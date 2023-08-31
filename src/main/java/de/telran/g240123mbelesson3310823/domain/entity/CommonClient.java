package de.telran.g240123mbelesson3310823.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class CommonClient implements Client {

    private int id;
    private String name;
    private Basket basket;

}

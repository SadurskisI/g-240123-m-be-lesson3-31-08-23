package de.telran.g240123mbelesson3310823.domain.databasae;

import de.telran.g240123mbelesson3310823.domain.entity.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommonDatabase implements Database{

    private List<Product> products = new ArrayList<>();
    private List<Client> clients = new ArrayList<>();

    private int idProductCounter = 5;
    private int idClientCounter = 3;

    public CommonDatabase(){
        products.add(new CommonProduct(1,"Milk",3.5));
        products.add(new CommonProduct(2,"Sugar",2.0));
        products.add(new CommonProduct(3,"Butter",6.0));
        products.add(new CommonProduct(4,"Oat flakes",1.5));
        products.add(new CommonProduct(5,"Eggs",3.5));


        clients.add(new CommonClient(1,"Vasya",new CommonBasket()));
        clients.add(new CommonClient(2,"Anya",new CommonBasket()));
        clients.add(new CommonClient(3,"Masha",new CommonBasket()));
    }


    @Override
    public void execute(String query) throws SQLException {
//        "Add new client name = Vasya" - такие запросы выполняет метод execute
//        "Delete client where id = 1" - такие запросы выполняет метод execute
        if (!query.startsWith("Add")&&!query.startsWith("Delete")){
            throw new SQLException();
        }
        String[] parts = query.split(" ");
        if (parts[0].equals("Add")){
            if (parts[2].equals("client")){
                clients.add(new CommonClient(++idClientCounter,parts[5],new CommonBasket()));
            }
            if (parts[2].equals("product")){
                products.add(new CommonProduct(++idProductCounter,parts[5],Double.parseDouble(parts[8])));
            }
        }
        if (parts[0].equals("Delete")){
            if (parts[1].equals("client")){
                clients.removeIf(x -> x.getId()==Integer.parseInt(parts[5]));
            }
            if (parts[1].equals("product")){
                products.removeIf(x -> x.getId()==Integer.parseInt(parts[5]));
            }
        }
    }

    @Override
    public List<Object> select(String query) throws SQLException {
        if (!query.startsWith("Select")) {
            throw new SQLException();
        }

        String[] parts = query.split(" ");
        List<Object> result = new ArrayList<>();

        if (parts.length == 3) {
            if (parts[2].equals("clients")) {
                result.addAll(clients);
            }

            if (parts[2].equals("products")) {
                result.addAll(products);
            }
        }

        if (parts.length == 6) {
            if (parts[1].equals("client")) {
                result.add(clients.stream().filter(x -> x.getId() == Integer.parseInt(parts[5])).toList().get(0));
            }

            if (parts[1].equals("product")) {
                result.add(products.stream().filter(x -> x.getId() == Integer.parseInt(parts[5])).toList().get(0));
            }
        }

        return result;
    }
}

package com.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DoIterate {

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();
        list.add("ankit");
        list.add("pramod");
        list.add("irfan");
        list.add("jai");

        list.forEach(n -> {
            //list.add("aaa");
            //list.remove("jai");
            System.out.println(n);
        });

        System.out.println("-------------------------------");

        List<Product> products = new ArrayList<>();
        products.add(new Product(111,"laptop",50000));
        products.add(new Product(100,"mouse",5000));
        products.add(new Product(112,"keyboard", 7000));

        Collections.sort(products, (p1, p2) -> {
            //return p1.getName().compareTo(p2.getName());
            //return Integer.valueOf(p1.getId()).compareTo(Integer.valueOf(p2.getId()));
            if(p1.getPrice()<p2.getPrice())
                return -1;
            else if (p1.getPrice() == p2.getPrice())
                return 0;
            else
                return 1;
        });
        products.forEach( p -> System.out.println(p));

    }
}

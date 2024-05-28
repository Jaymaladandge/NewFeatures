package com.functional.test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SupplierTest {

    public <T> Supplier<List<T>> supply(){
       // return ()-> new ArrayList<>();
       return ArrayList::new;
    }

    public static void main(String[] args) {

        Supplier<Double> random = ()-> Math.random();
        System.out.println(random.get());

        Supplier<LocalDateTime> supplier = ()-> LocalDateTime.now();
        System.out.println(supplier.get());

        System.out.println();
        Supplier<List<String>> supplier1 = new SupplierTest().supply();
        System.out.println(supplier1.get());
    }
}

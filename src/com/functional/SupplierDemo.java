package com.functional;

import com.functional.test.SupplierTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class SupplierDemo {


    public <T> Supplier<List<T>> supply() {
        // return ()-> new ArrayList<>();
        return ArrayList::new;
    }

    public static Product getProduct(Supplier<Product> supplier) {
        Product product = supplier.get();
        product.setName("Laptop");
        product.setPrice(50000);
        return product;
    }

    public static void main(String[] args) throws InterruptedException {

        Product product = SupplierDemo.getProduct(Product::new);
        System.out.println("Product : " + product);

        Supplier<List<String>> supplier1 = new SupplierTest().supply();
        System.out.println(supplier1.get());

        Supplier<String> sup = () -> "Hello Java...!";
        System.out.println(sup.get());

        Supplier<Integer> sup1 = () -> new Random().nextInt(10);

        for (int i = 1; i <= 5; i++) {
            System.out.print(sup1.get() + " : ");
        }


        System.out.println("--------------------------------------");
        LocalDateTime time = LocalDateTime.now();
        Supplier<LocalDateTime> supplier = LocalDateTime::now;

        Thread.sleep(5000);

        System.out.println("time : " + time);
        System.out.println("supplier : " + supplier.get());

        Thread.sleep(7000);

        System.out.println("time later : " + time);
        System.out.println("supplier later : " + supplier.get());

        System.out.println();

        Supplier<Product> supplier2 = () -> new Product(10000, "desktop");
        System.out.println("-----"+supplier2.get());

    }
}

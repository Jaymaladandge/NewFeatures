package com.functional;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerDemo {

    static void showDetails(String name, int age) {
        System.out.println(name + " " + age);
    }

    public void display(Map<Integer, String> map, String name) {
        System.out.println("--------" + name + "--------");
        map.forEach((key, value) -> {
            System.out.println(key + " " + value);
        });
    }

    public void show(List<String> list) {
        list.forEach(name -> System.out.println(name));
    }

    public static void printValues(List<String> list, Consumer<String> consumer) {
        for (String s : list) {
            consumer.accept(s);
        }
    }


    public static void main(String[] args) {

        ConsumerDemo demo = new ConsumerDemo();

        //Consumer consumer = (msg) -> System.out.println("Hello "+msg);
        Consumer consumer = System.out::println;
        consumer.accept("Java");


        Consumer<Product> con = (p) -> p.setPrice(50f);
        Product product = new Product();
        con.accept(product);
        product.showPrice();

        Product product1 = new Product();
        Consumer<Integer> con1 = product1::setPrice;
        con1.accept(50);
        product1.showPrice();

        System.out.println("---------------");

        ArrayList<String> list = new ArrayList<>();
        list.add("Vaibhav");
        list.add("Heramb");
        list.add("Pramod");
        list.add("Rupali");

        Consumer<List> consumer1 = demo::show;
        consumer1.accept(list);

        System.out.println("-----------------------------------------------------");


        BiConsumer biCon = (a, b) -> System.out.println("Sum " + ((int) a + (int) b));
        biCon.accept(10, 20);


        BiConsumer<Integer, Integer> compare = (Integer age, Integer grade) -> {
            if (age < 18 && grade < 40)
                System.out.println("Not eligible");
            else
                System.out.println("Eligible");
        };
        compare.accept(16, 30);


        BiConsumer<String, Integer> consume = ConsumerDemo::showDetails;
        consume.accept("Ram", 36);
        consume.accept("Sham", 30);

        BiConsumer<String, Integer> consum = (name, age) -> ConsumerDemo.showDetails(name, age);
        consum.accept("Pramod", 27);


        Map<Integer, String> map = new HashMap<>();
        map.put(111, "Kiran");
        map.put(222, "Rupali");
        map.put(333, "Pramod");
        map.put(444, "Pavan");

        BiConsumer<Map, String> biConsumer = demo::display;
        biConsumer.accept(map, "Employees");

        System.out.println("---------------------------------------------------------------------------------");

        ConsumerDemo.printValues(list, System.out::println);

        System.out.println("--------------------------------------------------------------");
        Consumer<String> consumer2 = a -> System.out.println(a + " world");
        Consumer<String> consumer3 = b -> System.out.println(b + " Java");
        consumer2.andThen(consumer3).accept("Hello");


        System.out.println();
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        Consumer<List<Integer>> consumer4 = (num) -> {
            for (int i = 0; i < num.size(); i++) {
                num.set(i, num.get(i) * 4);
            }
        };

        Consumer<List<Integer>> consumer5 = numList -> numList.forEach(System.out::println);
        consumer4.andThen(consumer5).accept(nums);
    }

}



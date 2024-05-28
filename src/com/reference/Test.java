package com.reference;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(45, 3, 89, 52, 52, 76);
        nums = nums.stream().sorted().collect(Collectors.toList());
        System.out.println("===Ascending sort ===" + nums);

        nums = nums.stream().sorted((a, b) -> b.compareTo(a)).collect(Collectors.toList());
        System.out.println("====Descending sort====" + nums);

        nums = nums.stream().sorted(Integer::compareTo).collect(Collectors.toList());
        System.out.println("======Sorted=====" + nums);

        String[] names = {"Deepali", "Rupali", "Paurnima", "Kanchan", "kanchan"};
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println("====Ascending sort with method reference====" + Arrays.toString(names));

        Comparator<String> comp = String::compareToIgnoreCase;
        Arrays.sort(names, comp.reversed());
        System.out.println("=====Descending sort with method reference=====" + Arrays.toString(names));

        System.out.println("\n");

        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee(25, "Raja", "Ramesh"));
        list.add(new Employee(30, "Sai", "Adithya"));
        list.add(new Employee(35, "Chaitanya", "Krishna"));
        list.add(new Employee(28, "Jai", "Dev"));

        list.stream().sorted(new NameSort()::compare).forEach(System.out::println);

        List<String> fruits = new ArrayList<>();
        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("mango");
        fruits.add("orange");

        Function<List<String>, Set<String>> f3 = HashSet::new;
        Set<String> set = f3.apply(fruits);
        System.out.println(set);


        Function<String, String> lowerCaseFunction = (String input) -> input.toLowerCase();
        String result = lowerCaseFunction.apply("\nJAVA Guides");
        System.out.println(result);


        System.out.println("---------------------------------------------------------------------");

        Function<String, Fruit> createFruit = Fruit::new;
        Fruit fruit = createFruit.apply("Apple");
        System.out.println("Fruit : " + fruit);

        //In above call we call 2 parameterized constructor of Fruit class.
        //The Function interface is often used for this purpose. The Function<T, R> interface represents a function that
        //accepts one argument and produces a result.


        SingleParameter single = Fruit::new;
        Fruit fruit1 = single.getFruit("Mango");
        System.out.println("Fruit : " + fruit1);

        System.out.println("----------------------");

        DiFunction<String, String, Fruit> diFunction = Fruit::new;
        Fruit fruit2 = diFunction.apply("Guava", "winter");
        System.out.println("Fruit : " + fruit2 + "\n");

        DiFunction<String, String, Employee> diFunction1 = Employee::new;
        Employee employee = diFunction1.apply("aaa", "bbb");
        System.out.println("Employee : " + employee + "\n");

        DoubleParameter doublePara = Fruit::new;
        Fruit fruit3 = doublePara.getFruit("Banana", "All Season");
        System.out.println("Fruit : " + fruit3);


        //Using a method reference to call a three-parameter constructor in Java involves using a functional interface
        // that matches the constructor's parameter list. Since Java's standard library does not provide a built-in
        // functional interface for a function that takes three arguments and returns a result, we need to define our own.


        Function<Fruit,String> function = Fruit::getName;
        String name = function.apply(new Fruit("Apple","All season"));
        System.out.println("Fruit name : "+name);

    }
}

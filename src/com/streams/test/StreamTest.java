package com.streams.test;

import com.streams.Employee;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {

        List<Employee> list = new ArrayList<Employee>();
        list.add(new Employee(1, "Ram", 50000));
        list.add(new Employee(5, "Shyam", 35000));
        list.add(new Employee(7, "vijay", 20000));
        list.add(new Employee(2, "Seeta", 32000));
        list.add(new Employee(4, "Chhaya", 15000));

        List employees = list.stream().filter(e -> e.getSalary() > 30000).collect(Collectors.toList());
        System.out.println(employees);


        Employee[] emps = list.stream().toArray(emp -> new Employee[list.size()]); //toArray(Employee[]::new)
        System.out.println("\nArray of employees : " + Arrays.toString(emps));


        List list1 = list.stream().filter(e -> e.getSalary() < 30000).map(emp -> emp.getSalary()).collect(Collectors.toList());
        System.out.println("list1 : " + list1 + "\n");

        list.stream().filter(e -> e != null).filter(emp -> emp.getSalary() > 30000).collect(Collectors.toList()).forEach(System.out::println);

        Optional<Employee> optional = list.stream().findFirst();
        if (optional.isPresent())
            System.out.println("\nFirst object : " + optional.get());
        else
            System.out.println("No value");


        Optional<Employee> employee = list.stream().filter(emp -> emp.getSalary() > 30000).findAny();
        if (optional.isPresent())
            System.out.println(optional.get());


        int num = 10;
        List<Integer> integers = Arrays.asList(10, 12, 2, 4, 8, 5, 7);
        Optional<Integer> integerOptional = integers.stream().filter(i -> i % 2 == 0).sorted().filter(i -> i > num).findFirst();
        if (integerOptional.isPresent()) {
            System.out.println(integerOptional.get());
        }


        //Stream.empty().findFirst().get(); A java.util.NoSuchElementException is thrown


        list.stream().sorted((e1, e2) -> Double.valueOf(e1.getSalary()).compareTo(Double.valueOf(e2.getSalary()))).forEach(System.out::println);
        System.out.println("\n------------------Id sort------------------");
        list.stream().sorted((e1, e2) -> {
            if (e1.getId() > e2.getId())
                return 1;
            else if (e1.getId() == e2.getId())
                return 0;
            else
                return -1;
        }).forEach(System.out::println);


        Employee employee1 = list.stream().max((e1, e2) -> e1.getName().compareTo(e2.getName())).orElseThrow(NoSuchElementException::new);
        System.out.println("\nemployee1 : " + employee1);


        double maxSal = list.stream().mapToDouble(Employee::getSalary).max().getAsDouble();
        System.out.println("Maximum salary : "+maxSal);


        double averageSal = list.stream().mapToDouble(Employee::getSalary).average().getAsDouble();
        System.out.println("Average sal : "+averageSal);


        Double reduction = list.stream().map(Employee::getSalary).reduce(0.0,Double::max);
        System.out.println("reduction to max : "+reduction);


        List<Integer> list2 = Arrays.asList(1, 1, 2, 2, 3, 4, 5);
        list2.stream().distinct().forEach(System.out::println);


        boolean allEven = list2.stream().allMatch(i -> i % 2 == 0); //returns false as soon as it encounters 1, which is not divisible by 2.
        boolean anyEven = list2.stream().anyMatch(i -> i % 2 == 0); //Here, again short-circuiting is applied and true is returned immediately after the first element.
        boolean noneMatch = list2.stream().noneMatch(i -> i % 3 == 0);// it simply returns false as soon as it encounters 3, which is divisible by 3.

        System.out.println("allEven :" +allEven+" anyEven :"+anyEven+" noneMatch :"+noneMatch);



        System.out.println("-----------------------------lazy Invocation--------------------------------------");

        list.stream().filter(emp -> {
            Employee.counterIncr();
            return emp.getSalary()>40000;}); //this code will not execute. stream pipeline is missing the terminal operation.


        long count = list.stream()
            .filter(emp->{
                Employee.counterIncr();
                return emp.getSalary()>40000;
            })
            .map(e ->{
                System.out.println("map method called");
                return e.getName();
            })
            .count();

        System.out.println("Count is : "+count);    //now intermediate operations will be executed
        System.out.println("-------------------");



        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Optional<Integer> result = numbers.stream()
                .filter(n -> {
                    System.out.println("Filtering: " + n);
                    return n % 2 == 0;
                })
                .map(n -> {
                    System.out.println("Mapping: " + n);
                    return n * 2;
                })
                .filter(n -> {
                    System.out.println("Filtering > 10: " + n);
                    return n > 10;
                })
                .findFirst();

        System.out.println("Result: " + result.orElse(null));




        System.out.println("----------------------------Collector specific------------------------------------");


        List<String> list3 = Arrays.asList("Hello", "world", "java", "stream", "java");
        Set<String> set = list3.stream().map(x -> x.toUpperCase()).collect(Collectors.toSet());
        System.out.println(set);


        List<Integer> list4 = Arrays.asList(1, 2, 3, 4, 5);
        List<String> strings = list4.stream().map(String::valueOf).collect(Collectors.toList());
        System.out.println(strings);


        HashSet<String> toSet = list3.stream().collect(Collectors.toCollection(() -> new HashSet<>())); //toCollection(HashSet::new);
        System.out.println("toSet :  "+toSet);


        List<String> words = Arrays.asList("hello", "world", "java", "stream");
        Map<String, Integer> map = words.stream().collect(Collectors.toMap(word -> word, word -> word.length()));
        System.out.println(map);


        long counter = words.stream().collect(Collectors.counting());
        System.out.println("count : " + counter);


        String join = words.stream().collect(Collectors.joining());
        System.out.println("join : " + join);


        Map<Integer, List<String>> map1 = words.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(map1);


        Map<Boolean, List<String>> map2 = words.stream().collect(Collectors.partitioningBy(w -> w.length() > 5));
        System.out.println(map2);



    }

}

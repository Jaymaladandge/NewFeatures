package com.streams.test;

import com.streams.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MapTest {

    public static void main(String[] args) {

        IntStream stream = IntStream.of(1,6,4,5,3,8);
        stream.mapToObj(Integer::valueOf).forEach(System.out::println);


        List<Employee> list = new ArrayList<>();
        list.add(new Employee(111,"praful",50000,"mumbai"));
        list.add(new Employee(222,"prasad",20000,"pune"));
        list.add(new Employee(333,"saloni",15000,"mumbai"));
        list.add(new Employee(444,"aparna",35000,"pune"));
        list.add(new Employee(555,"praful",40000,"mumbai"));

        list.stream().collect(Collectors.groupingBy(Employee::getCity)).forEach((k,v)-> System.out.println(k+" "+v));
        System.out.println("------------------------------------------------");

        list.stream().collect(Collectors.groupingBy(e -> e.getCity(), Collectors.counting())).forEach((k,v)->System.out.println(k+" "+v));
        System.out.println("------------------------------------------------");

        //instead of entire student object returns only name
        list.stream().collect(Collectors.groupingBy(e ->e.getCity(), Collectors.mapping(e->e.getName(), Collectors.toList()))).forEach((k,v)-> System.out.println(k+" "+v));
        System.out.println("--------------------------------------------------");

        list.stream().collect(Collectors.groupingBy(e->e.getCity(),
                        TreeMap::new,
                        Collectors.mapping(e->e.getName(), Collectors.toList())))
                        .forEach((k,v)->System.out.println(k+" "+v));

    }

}

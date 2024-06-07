package com.optional;

import com.streams.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(111,"Ishan",35000));
        employees.add(new Employee(222,"Riya",40000));
        employees.add(new Employee(333,"Nayan",15000));
        employees.add(new Employee(444,"Tara",20000));



        Optional<Integer> optional = Optional.empty();
        Optional<Employee> optional1 = Optional.of(new Employee(111,"Ram",50000));
        Optional<Employee> optional2 = Optional.ofNullable(new Employee(222,"Shyam",60000));
        //Optional optional3 = Optional.of(null);   java.lang.NullPointerException
        Optional<Employee> optional3 = Optional.ofNullable(null);


        int i = optional.isPresent() ? optional.get() : 0;
        System.out.println("i : "+i);

        String empName = optional1.isPresent() ? optional1.get().getName() : "No value";
        System.out.println("empName : "+empName);

        String name = optional2.isPresent() ? optional2.get().getName() : "dummy";
        System.out.println("name : "+name);

        Employee employee = optional3.isPresent() ? optional3.get() : new Employee(0,"dummy",0.0);
        System.out.println("employee : "+employee);
        System.out.println("------------------------------------------------");



        Employee employee1 = optional3.orElse(new Employee(0,"dummy",0.0));
        System.out.println("employee1 : "+employee1);

        Employee employee2 = optional3.orElseGet(()-> employees.get(0));
        System.out.println("employee2 : "+employee2);

        Employee employee3 = optional1.orElseThrow(NoSuchElementException::new);
        System.out.println("employee3 : "+employee3);
        System.out.println("----------------------------------------------");



        String s = optional2.filter(emp -> emp.getSalary()>50000).map(emp -> emp.getName()).orElse("Salary s less than 50000");
        System.out.println("Employee name having sal<50k : "+s);

        optional2.ifPresent(emp ->{
            double tax = emp.getSalary()>50000 ? emp.getSalary()*0.10 : 0.0;
            emp.setSalary(emp.getSalary()+tax);
            System.out.println(emp.getSalary());
        });























    }


}

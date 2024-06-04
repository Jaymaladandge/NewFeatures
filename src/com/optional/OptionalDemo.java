package com.optional;

import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalDemo {

    public static void main(String[] args) {

        Optional<String> name = getName();

        if(name.isPresent()){
            System.out.println(name.get());
        }
        name.ifPresent(s -> System.out.println(s));

        System.out.println("--------------getName1()---------------");
        Optional<String> name1 = getName1();
        System.out.println(name1.isPresent());

        System.out.print("name1.ifPresent : ");
        name1.ifPresent(s -> System.out.println(s));

        String na = name.orElse("NA");
        System.out.println("\n-----name-----"+na);

        String na1 = name1.orElseGet(()->"NA");
        System.out.println("----name----"+na1);

        System.out.print("toUpperCase : ");
        name.map( n -> n.toUpperCase()).ifPresent(System.out::println);

        //String na2 = name1.orElseThrow(()-> new NoSuchElementException());
        //System.out.println("------name------"+na2);


        System.out.println("------------==================------------");

        String[] str = new String[10];
        Optional opt = Optional.ofNullable(str[5]);
        opt.ifPresent(System.out::println);

        Optional<String> optional = Optional.empty();
        System.out.println(""+optional.map(String::toLowerCase));

    }

    public static Optional<String> getName(){
        String name = "Ram";
        return Optional.of(name);
    }

    public static Optional<String> getName1(){
        String name = null;
        //return Optional.ofNullable(name); // if use Optional.of() it will throw NullPointerException coz name is null
        return Optional.empty(); //whenever we want to return null optional use empty()
    }


}

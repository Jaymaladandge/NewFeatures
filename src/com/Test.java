package com;

import com.reference.Employee;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Test {

    int[] i = {0};
    static void validateAge(int age) throws InvalidAgeException {

        if(age<18){
            throw new InvalidAgeException("Age cant be less than 18 !!!!");
        }else{
            System.out.println("Validated...");
        }
    }

    static void method1(int age) throws InvalidAgeException {
        validateAge(age);
    }
    public static void main(String[] args) {

        try {
            method1(17);
        } catch (InvalidAgeException e) {
          e.printStackTrace();
        }

        final Employee e1 = new Employee(21,"sanket","chaudhary");
        System.out.println("e1 : "+e1);
        e1.setFirstName("pramod");
        System.out.println("e1 : "+e1);

      //  e1 =  new Employee(21,"sanket","chaudhary");

        System.out.println("--------------------------------------------------------");

        String s = "aaasdfg";
        String out = s.chars()
                .mapToObj(c -> Character.valueOf((char) c)) // bit messy as chars() returns an IntStream, not a CharStream (which doesn't exist)
                .distinct()
                .map(Object::toString)
                .collect(Collectors.joining(","));
        System.out.println("=========="+out);

        System.out.println("---------------------------------------------------------");

        int[] i = {1,2,3,4};
        alter(i);
        System.out.println("i "+ Arrays.toString(i));

    }

    public static void alter(int[] i){
        int[] j = {2};
        i = j;
    }
}

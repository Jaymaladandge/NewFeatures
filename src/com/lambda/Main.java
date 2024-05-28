package com.lambda;

public class Main {



    public static void main(String[] args) {

        Drawable drawable = () -> System.out.println("Draw invoked ...!"); // no need of {} for single line in body
        drawable.draw();

        Calculator calculator = (a, b) -> a+b;  //no need of return statement for single line in body, no need of datatype for parameter
        System.out.println(calculator.sum(10,10));

        Printable printable = (a, b) -> a+b;
        System.out.println(printable.print(10,5));

        Sayable sayable = (msg) -> {
            String s1 = "I would like to say";
            s1 = s1 + " "+msg;
            return s1;
        };
        System.out.println(sayable.say("time is precious...!"));

        Runnable runnable = () ->{
            System.out.println("Run method invoked...!");
        };
        runnable.run();

        System.out.println("----------------------------------");

        //We cant modify local variable if use that variable inside lambda otherwise we can.
        String s ="Hello";
        Sayable sayable1 = (msg) -> {
            //
            return msg;
            };
        System.out.println(sayable1.say("Java"));
        s="SQL";
        System.out.println(s);
    }
}

//    Streams allow Lambda Functions to execute in sequential and parallel as well. if the Lambda Expression will update
//    the local variable defined outside, it might result in an incorrect value. local values are saved in stack,
//    each thread has its own call stack, and no thread can access other thread stack
//    Lambda can capture static variables, instance variables, and local variables, but only local variables must be final
//    or effectively final.


@FunctionalInterface //should contain only 1 abstract method.
interface Drawable{
    void draw();
    default void draw1(){};

    public static void draw2(){}
}
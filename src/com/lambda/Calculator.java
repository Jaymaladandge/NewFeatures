package com.lambda;

@FunctionalInterface
public interface Calculator {

    int sum(int a, int b);

    @Override
    public String toString(); //Overridden from Object class
}

//@FunctionalInterface
interface Printable {

    float print(int a, float b);
}

@FunctionalInterface
interface Sayable{
    String say(String msg);
}

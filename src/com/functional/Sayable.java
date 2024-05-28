package com.functional;

@FunctionalInterface
public interface Sayable
{
    void say(String msg);
    String toString();
}

//@FunctionalInterface
interface Doable extends Sayable{
    void doIt();
}

interface Printable{

    default void print(){
        System.out.println("Printing something");
    }
}
@FunctionalInterface
interface Showable extends Printable{
    void show();
}

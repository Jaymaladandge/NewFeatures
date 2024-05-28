package com.reference;

public class MethodRefDemo {

    public static void main(String[] args) {

        System.out.println("Learning method reference...!");

        WorkInterface work = () -> { Stuff.doStuff();};  //using lamda expression
        work.doTask();

        WorkInterface wrk = Stuff::doStuff;     //using method reference
        wrk.doTask();
        System.out.println("================================");

        Runnable runnable = Stuff::doStuff;
        runnable.run();

    }
}

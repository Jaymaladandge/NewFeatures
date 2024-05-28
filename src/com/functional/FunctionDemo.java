package com.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionDemo {

    static String show(String msg){
        return "Hello "+msg;
    }

    public int add(List<Integer> list){
        return list.stream().mapToInt(Integer::intValue).sum();
    }

    public String find(int num, List<Integer> list){
        if(list.contains(num))
            return "Number is in list";
        else
            return "Number not found";
    }

    public static void main(String[] args) {

        Sayable say = (msg) -> System.out.println("hello...!"+msg);
        say.say("Java");

        FunctionDemo demo = new FunctionDemo();

        Function<String, String> fun = FunctionDemo::show;
        System.out.println(fun.apply("Java"));
        

        ArrayList<Integer> list = new ArrayList<>();
        list.add(65);
        list.add(25);
        list.add(57);
        list.add(26);

        Function<List<Integer>, Integer> fun1 = demo::add;
        System.out.println("Sum : "+fun1.apply(list));

        Function fnd = num -> {                             //Using lambda
            if(list.contains(num))
                return "Number is in list";
            else
                return "Number not found";
        };
        System.out.println("Search result : "+fnd.apply(57));

        BiFunction<Integer, List<Integer>, String> findFun = demo::find;        //Using method reference
        System.out.println("search result : "+findFun.apply(27, list));


        Function<Integer,Integer> square = (num)-> num*num;
        System.out.println("Square : "+square.apply(10));

    }
}

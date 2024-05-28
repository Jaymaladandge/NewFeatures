package com.functional.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerTest {

    static class Student{
        public int age;
        public String name;

        public Student(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    static public void showMsg(String msg){
        System.out.println(msg);
    }

    static public void showMsg(String msg,String name){
        System.out.println(msg+" "+name);
    }

    public void addList(List<Integer> list){
      int sum = list.stream().mapToInt(num->num.intValue()).sum();
        System.out.println("Sum : "+sum);
    }

    public static void main(String[] args) {

        Consumer<String> con = (msg) -> ConsumerTest.showMsg(msg);
        con.accept("Hello Java");

        BiConsumer<String, String> biCon = (msg, name) -> ConsumerTest.showMsg(msg,name);
        biCon.accept("Hello","Java");

        BiConsumer<String, String> biConsumer = ConsumerTest::showMsg;
        biConsumer.accept("Hello", "Oracle");

        List<Integer> list = new ArrayList<Integer>();
        list.add(40); list.add(30); list.add(10); list.add(5);

        Consumer<List<Integer>> consumer = (nums) -> new ConsumerTest().addList(nums);
        consumer.accept(list);

        System.out.println();
        list.forEach(System.out::println);

        System.out.println("---------------------------------------------");
        Consumer<Student> consumer1 = s1 -> s1.age += 1;
        Consumer<Student> consumer2 = System.out::println;
        List<Student> studentList = Arrays.asList(new Student(18, "andy"), new Student(19, "jack"), new Student(20, "Dan"));
        System.out.println("Before chaining:");
        studentList.forEach(consumer2);
        System.out.println("----");
        System.out.println("After chaining:");
        studentList.forEach(consumer1.andThen(consumer2));
    }
}

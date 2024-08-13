package com.functional.test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateTest {

    public static void main(String[] args) {

        Predicate<Integer> predicate = (x) -> x > 10;
        System.out.println(predicate.test(15));

        Predicate<Integer> less = a -> a < 50;
        System.out.println(predicate.and(less).test(70));

        Predicate<String> predicate1 = s -> s.contains("a");
        System.out.println(predicate1.test("SQL"));

        BiPredicate<Integer, Integer> biPredicate = (a, b) -> a % b == 0;
        System.out.println(biPredicate.test(10, 5));

        List<String> list = Arrays.asList("Java", "SQL", "HTML", null);
        Predicate<String> predicate2 = subject -> subject != null && subject.length() < 4;
        list.stream().filter(predicate2).forEach(System.out::println);

        Predicate<String> predicate3 = Objects::nonNull;
        System.out.println("Is null : "+predicate3.test(null));

    }
}

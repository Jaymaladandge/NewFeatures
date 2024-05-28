package com.functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateDemo {

    public boolean checkEligibility(int age){
        return age>18;
    }

    public List<String> addCountries(List<String> countries, Predicate<String> predicate){
        List<String> countryList = new ArrayList<>();
        countries.forEach( country -> {
            if(predicate.test(country))
                countryList.add(country);
        });
        return countryList;
    }

    public static void main(String[] args) {

        PredicateDemo demo = new PredicateDemo();

        Predicate<Integer> pre = n -> n>100;
        System.out.println(pre.test(500));


        Predicate<Integer> pred = age -> age>18;
        System.out.println("Eligible : "+pred.test(18));

        Predicate<Integer> predi = demo::checkEligibility;
        System.out.println("Eligibility : "+predi.test(20));


        Predicate<String> predic = s -> s.length() > 6;

        List<String> names = Arrays.asList("Rupali","Pramod","Dipali","Vaibhav");
        names.forEach( n -> {
            if (predic.test(n))
                System.out.println(n);
        });

        System.out.println("----------------------------------------");

        String[] countries = {"India", "Australia", "England", "South Africa", "Srilanka", "Newzealand", "West Indies"};
        List<String> list = Arrays.asList(countries);

        Predicate<String> pre1 = c -> c.startsWith("S");
        Predicate<String> pre2 = c -> c.contains("In");

        //Using method reference
        BiFunction<List<String>, Predicate<String>, List<String>> list1 = demo::addCountries;
        System.out.println(list1.apply(list,pre1));

        //Using lamda
        BiFunction<List<String>, Predicate<String>, List<String>> list2 = (lst, predicate) -> demo.addCountries(list, pre2);
        System.out.println(list2.apply(list, pre2));


        BiPredicate<Integer, String> byPre = (age, name) ->{
            System.out.print(name +" is eligible for vote ? ");
            return age>18;
        };
        System.out.println(byPre.test(21,"Paurnima"));

        System.out.println("\n------------------Stream use case------------------");
        List<String> lst = list.stream().filter(pre1).collect(Collectors.toList());
        System.out.println(lst);
        list.stream().filter(pre2).forEach(System.out::println);

    }
}

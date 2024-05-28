package com.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {

        /*List<Integer> nums = Arrays.asList(5,3,7,8,1);
        Stream<Integer> data = nums.stream();
        Stream<Integer> mappedData = data.map(n -> n*2);
        mappedData.forEach(n -> System.out.println(n));*/

        Arrays.asList(5,3,7,8,1).stream().filter(n -> n%2!=0).map(n->n*2).forEach(System.out::println);
        System.out.println("-----------------------------");

        int result = Arrays.asList(5,26,78,25,1).stream().filter(n->n%2!=0).map(n->n*2).reduce(0,(a,b)->a+b);
        System.out.println("result : "+result);

        System.out.println("----------------------------------");
        String[] names = {"Pavan", "Kiran","Paurnima", "Deepali"};
        Stream<String> stream = Stream.of(names);
        stream.forEach(s -> System.out.println(s));


        System.out.println("---------------------------------");
        Map<Integer, String> map = new HashMap<>();
        map.put(222,"bbb");
        map.put(111,"ddd");
        map.put(555,"ppp");
        map.put(777,"hhh");

        map.forEach((k,v)-> System.out.println(k+" "+v));
        map.entrySet().stream().forEach(System.out::println);

        System.out.println("--------------even key entry---------------");
        map.entrySet().stream().filter(k-> k.getKey()%2==0).forEach(System.out::println);


        ArrayList<Employee> empList = new ArrayList<>();
        empList.add(new Employee(5,"Heramb",50000));
        empList.add(new Employee(1,"Rupali",60000));
        empList.add(new Employee(2,"Kanchan",70000));
        empList.add(new Employee(3,"Paurnima",40000));

        List<Employee> list = empList.stream().filter(e->e.getSalary()>50000).collect(Collectors.toList());
        list.forEach(e-> System.out.println(e));

        System.out.println("----------------------------");
        empList.stream().filter(e->e.getName().contains("i"))
                        .sorted((e1,e2)->e1.getName().compareTo(e2.getName()))
                        .forEach(System.out::println);


        long count = empList.stream().filter(e->e.getName().contains("i")).count();
        System.out.println("Count : "+count);

        System.out.println("--------------------------------------------------------------------------------");

        List<Integer> num = Arrays.asList(45,3,98,14,2,2);
        num.stream().map(n->n*2).forEach(System.out::println);


        List<String> nameList = Arrays.asList("kANCHAN","kiran","heramb","deepali");
        Set<String> blockcase = nameList.stream().map(n->n.toUpperCase()).collect(Collectors.toSet());
        blockcase.forEach(System.out::println);


        System.out.println("---------map----------");
        List<String> lst = num.stream().map(n-> {return n+"";}).collect(Collectors.toList());
        lst.forEach(System.out::println);

        System.out.println("============");

        ArrayList list1 = new ArrayList();
        list1.add("aaa");
        list1.add(12);
        list1.add("bbb");
        list1.add(25);

        List<String> list2 = (List<String>) list1.stream().filter(o -> o instanceof String).collect(Collectors.toList());
        list2.forEach(System.out::println);

        ArrayList<Integer> list3 = new ArrayList<>();
        for(Object o : list1){
            if(o instanceof Integer)
               list3.add((Integer) o);
        }
        System.out.println(list3);
        System.out.println("============");


        num.stream().distinct().forEach(System.out::println);


        System.out.println("----Stateless operations doesn’t need to know about any other element to be able to emit a result.---");
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(5,"John Smith", 20000));
        employees.add(new Employee(2,"Susan Johnson", 42000));
        employees.add(new Employee(1,"Erik Taylor",55000));
        employees.add(new Employee(3,"Jack Anderson", 14000));
        employees.add(new Employee(4,"Sarah Lewis",130000));

        employees.stream().filter(e->{
            System.out.println("Filtering employee "+e.getName());
            return e.getSalary()<80000;
        }).map(e-> {
            System.out.println("Mapping employee "+e.getName());
            e.setSalary(e.getSalary()*1.05);
            return e;
        }).
        collect(Collectors.toList());


        System.out.println("----------------------------------------------------------");
        employees.stream().
                filter(e -> {
                    System.out.println("Filtering employee "+e.getName());
                    return e.getSalary()<80000;
                }).
                sorted((e1,e2)->e1.getName().compareTo(e2.getName())).
                map(e -> {
                    System.out.println("Mapping employee "+e.getName());
                    e.setSalary(e.getSalary()*1.05);
                    return e;
                }).
                collect(Collectors.toList());


        System.out.println("----------------------------");
        employees.stream().limit(2).forEach(System.out::println);

        Random random = new Random();
        random.ints().limit(3).forEach(System.out::println);


        double value = empList.stream().map(e -> e.getSalary()).reduce(0.0, (a,b) -> Double.sum(a,b));
        System.out.println("value : "+value);


        List<String> list4 = Arrays.asList("5","7","3","4","2");
        int sum = list4.stream().map(s -> Integer.valueOf(s)).reduce(0,(a,b)->a+b);
        System.out.println("sum : "+sum);

        int sum1 = list4.stream().mapToInt(n -> Integer.parseInt(n)).sum();
        System.out.println("sum1 : "+sum1);


        List<Integer> list6 =  Arrays.asList(4,6,3,8,7);
        Optional<Integer> optional = list6.stream().reduce(Integer::sum);
        System.out.println("-----list6-----"+optional.get());


        int min = list6.stream().reduce((a,b)-> a<b ? a:b).get();
        System.out.println("min with lambda : "+min);

        int min1 = list6.stream().reduce(Integer::min).get();  //using Integer class method
        System.out.println("min with method reference : "+min1);

        System.out.println("-------------list5-------------");
        List<String> list5 = Arrays.asList("Geeks", "for", "gfg","GeeksforGeeks", "GeeksQuiz");
        list5.stream().mapToInt(String::length).forEach(s-> System.out.print(s+" "));


        String s = list5.stream().reduce((s1, s2) -> s1.length()>s2.length()? s1:s2).get();
        System.out.println("\nlargest string : "+s);

        int max = list6.stream().reduce(0,(a,b)-> a > b ? a : b);
        System.out.println("max : "+max);


        System.out.println("\n-------------Populate list-------------");
        List<Employee> employees1 = new ArrayList<>();
        employees.stream().forEach(employees1::add);
        employees1.stream().forEach(System.out::println);


        System.out.println("-------------------------------");

        List<Integer> nums = Arrays.asList(10,65,75,31,45);
        int fourthMax = nums.stream().sorted().collect(Collectors.toList()).get(3);
        System.out.println("fourthMax : "+fourthMax);


    }

}

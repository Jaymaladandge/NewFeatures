package com.streams.test;

import java.util.stream.IntStream;

public class MapTest {

    public static void main(String[] args) {

        IntStream stream = IntStream.of(1,6,4,5,3,8);
        stream.mapToObj(Integer::valueOf).forEach(System.out::println);


    }

}

package com;

import com.functional.Product;

import java.util.Arrays;
import java.util.List;

public class ObjectsClassDemo {

    public static void main(String[] args) {
        List<Product> products = Arrays.asList(new Product(10000, "laptop"), new Product(0, null));
        products.forEach(System.out::println);
    }
}

//    The Objects class in Java, introduced in Java 7, is part of the java.util package and provides utility methods for
//    operating on objects. These methods include null-safe operations, comparison, hash code generation, and more.
//    helps write more concise and null-safe code.

// int hashCode = Objects.hash("field1", 123, true);
// Composite Hash Codes: The Objects.hash(Object... values) method simplifies the generation of hash codes for objects containing multiple fields.
// This is particularly useful when overriding hashCode in complex objects.

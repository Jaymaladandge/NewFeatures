package com;


import java.util.Arrays;

public class GettingName {

    public static void main(String[] args) {

    String string[] = {"akshaya","pramod","abhaya","sanket","aniket"};
    System.out.println("String Array"+ Arrays.toString(string));
    
    String str1 = "hello\u200Bworld";
    System.out.println(str1.strip());
    
    String str2 = "hello\u200Bworld";
    System.out.println(str2);
    System.out.println(str2.trim());
    }

}


/*
 
Whitespace Handling: strip() handles a wider range of whitespace characters than trim().
Unicode Support: strip() is better suited for handling Unicode strings and internationalization.
Availability: strip() is a newer method introduced in Java 11.
  
 */
 
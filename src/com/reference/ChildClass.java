package com.reference;

public class ChildClass extends  SuperClass{

    public void childHello(){
        System.out.println("I am inside ChildTest class");
    }

    public void testHello(){

       A a = super::superHello;
       a.sayHello();

        A a2= this::childHello;
        a2.sayHello();
    }


    public static void main(String[] args) {

        ChildClass childClass = new ChildClass();
        childClass.testHello();


    }
}

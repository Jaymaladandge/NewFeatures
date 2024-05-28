package com.reference;

public class Fruit {

    private String name;
    private String season;

    public  Fruit(){
        System.out.println("Fruit() invoked");
    }

    public Fruit(String name) {
        System.out.println("Fruit(String name) invoked");
        this.name = name;
    }

    public Fruit(String name, String season) {
        System.out.println("Fruit(String name, String season) invoked");
        this.name = name;
        this.season = season;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", season='" + season + '\'' ;
    }
}


interface SingleParameter{
    Fruit getFruit(String name);
}

interface DoubleParameter{
    Fruit getFruit(String name,String season);
}

interface DiFunction<T,U,R>{
    R apply(T t,U u);
}

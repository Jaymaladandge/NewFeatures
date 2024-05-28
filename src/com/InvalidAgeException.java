package com;

public class InvalidAgeException extends Exception{

    public InvalidAgeException(){
        super();
    }

    public InvalidAgeException(String msg){
        super(msg);
    }
}

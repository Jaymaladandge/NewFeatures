package com.reference;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Stuff {

    public static void doStuff(){
        System.out.println("I am doing task...");
        LocalDate now = LocalDate.now();
        System.out.println("Now : "+now.toString());

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        System.out.println("Date : "+ dateFormat.format(date));


        System.out.println("Time : "+dateFormat.format(Calendar.getInstance().getTime()));

    }
}

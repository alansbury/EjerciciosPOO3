package com.campusdual.ejercicio1;

import org.w3c.dom.ls.LSOutput;

public class Ejercicio1 {

    public static void main(String[] args) {
        System.out.println("hello world!");

       int year = 1960;
       boolean bisiesto = false;
       if (year%4 == 0){
           if (year%100 == 0){
               if (year%400 == 0){
                   bisiesto = true;
               }else{
                   bisiesto = false;
               }
           }else{
               bisiesto = true;
           }
       }else {
           bisiesto = false;
       }






    }
}

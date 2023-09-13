package com.campusdual.ejercicio2;

import com.campusdual.ejercicio4.Kb;

import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {

        while (true){
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Introduce un ano");
        Integer year = Kb.nextInt();

        boolean bisiesto = false;
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    bisiesto = true;
                } else {
                    bisiesto = false;
                }
            } else {
                bisiesto = true;
            }
        } else {
            bisiesto = false;
        }

        if (bisiesto == true) {
            System.out.println("bisiesto");
        } else {
            System.out.println("non bisiesto");


        }

    }
    }
}
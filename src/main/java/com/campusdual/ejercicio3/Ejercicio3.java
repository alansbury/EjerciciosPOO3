package com.campusdual.ejercicio3;

import com.campusdual.ejercicio4.Kb;

import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) {
        while (true) {
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Dame un numero do 1 ó 20");
            Integer numero_a_comprobar = Kb.nextInt();

            if (0 < numero_a_comprobar && numero_a_comprobar < 21 && numero_a_comprobar % 1 == 0) {
                switch (numero_a_comprobar) {
                    case 2:
                    case 3:
                    case 5:
                    case 7:
                    case 11:
                    case 13:
                    case 17:
                    case 19:
                        System.out.println("o teu número é primo");
                        break;
                    default:
                        System.out.println("o teu número non é primo");
                        break;
                }
            } else {
                System.out.println("número non válido");

            }


        }

    }


}

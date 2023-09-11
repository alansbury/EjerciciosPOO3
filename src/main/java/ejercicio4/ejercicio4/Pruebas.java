package ejercicio4.ejercicio4;


import java.sql.SQLOutput;
import java.util.Scanner;

public class Pruebas{

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        while(salir == false) {

            System.out.println("elige 1, 2 o 3");

            String valueMenu = scanner.nextLine().trim();

            switch (valueMenu) {
                case "1":
                    System.out.println( "a o b");

                    String valueMenuB = scanner.nextLine().toUpperCase().trim();
                    switch (valueMenuB) {
                        case "A":
                            System.out.println("HAS ELEGIDO A");
                            break;
                        case "B":
                            System.out.println("HAS ELEGIDO B");
                            break;
                    }

                    break;

                case "2":

                    System.out.println("Elige entre A y B");
                    String foodNewOrNot = scanner.nextLine().toUpperCase().trim();
                    if (foodNewOrNot.equals("A")) {

                        System.out.println("has elegido a");

                    } else {
                        System.out.println("has elegido b");

                    }
                    break;


                case "3":
                    System.out.println("Fin do programa");

                    salir = true;
                    break;
                default:
                    System.out.println("DEFAULT");
                    break;


            }
        }
    }


}
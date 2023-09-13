package com.campusdual.ejercicio4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Kb {


    public static Integer getOption(Integer min,Integer max){
        Integer option = 0;
        Boolean notvalid = true;
        do{
            try {
                option = Kb.sureNextInt(min, max);
                notvalid = option<min || option>max;
            }catch (InputMismatchException e){
                System.out.println("Debes elixir un número entre "+min+" y "+max);
                Kb.nextLine();
            }
            if(notvalid){
                System.out.println("Debes elixir un número entre "+min+" y "+max);
            }
        }while(notvalid);
        return option;
    }


    public static Integer nextInt(){
        Scanner keyboard = new Scanner(System.in);
        String resultString = keyboard.nextLine().trim();
        Integer result = 0;
        try{
            result = Integer.parseInt(resultString);
        }catch (Exception e){
            throw new InputMismatchException();
        }
        return result;
    }

    public static Integer sureNextInt(Integer min, Integer max){
        Integer resultado = null;
        boolean notvalid=true;
        do {
            try {
                resultado = nextInt();
                notvalid=false;
            } catch (InputMismatchException e) {
                System.out.println("Debes elixir un número entre "+min+" y "+max);
            }
        }while(notvalid);
        return resultado;
    }

    public static String nextLine(){
        Scanner keyboard = new Scanner(System.in);
        String result = keyboard.nextLine().trim();
        return result;
    }

    public static boolean isStringMadeOfDigits(String input) {
        // Check if the input string is null or empty
        if (input == null || input.isEmpty()) {
            return false;
        }

        // Iterate through each character in the input string
        for (char c : input.toCharArray()) {
            // Check if the character is not a digit (0-9)
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        // All characters are digits
        return true;
    }

}

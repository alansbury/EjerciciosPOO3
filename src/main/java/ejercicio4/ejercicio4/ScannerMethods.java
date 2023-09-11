package ejercicio4.ejercicio4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerMethods {


    public static Integer nextInt() throws InputMismatchException{
        Scanner keyboard = new Scanner(System.in);
        String resultString = keyboard.nextLine().trim();
        Integer result = 0;

        try {
            result = Integer.parseInt(resultString);
        }catch (Exception e){
            System.out.println("Por favor elixe un número entre o 1 e o 4");
            throw new InputMismatchException();
        }
        return result;
    }
}

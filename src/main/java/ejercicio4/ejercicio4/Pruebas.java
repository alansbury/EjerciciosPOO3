package ejercicio4.ejercicio4;



public class Pruebas{

    public static void main(String[] args) {


        boolean salir = false;
        while(!salir) {

            System.out.println("elige 1, 2 o 3");

            String valueMenu = Kb.nextLine().trim();

            switch (valueMenu) {
                case "1":
                    System.out.println( "a o b");

                    String valueMenuB = Kb.nextLine().toUpperCase().trim();
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
                    String foodNewOrNot = Kb.nextLine().toUpperCase().trim();
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
package ejercicio4.ejercicio4;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Menu {

    public Menu() {

        Scanner scanner = new Scanner(System.in);
        String mainMenu = "\n" +
                "-1. Crear/reiniciar dieta: crea o remplaza la dieta inicial\n" +
                "-2. Mostrar información: muestra calorías y macronutrientes de la dieta\n" +
                "-3. Agregar alimento: agrega un alimento a la dieta actual y añade ese alimento a la lista de alimentos disponible\n" +
                "-4. Salir";

        String menuChoseTypeOfDiet = "-1. Sin limite\n" +
                "-2. Por calorías\n" +
                "-3. Por macronutrientes\n" +
                "-4. Por datos personales";
        Diet dieta = null;
        boolean goOutOfWhileLoop = false;
        while (goOutOfWhileLoop == false) {

            System.out.println(mainMenu);
            Integer userElectionInMainMenu = null;

            userElectionInMainMenu = Kb.getOption(1, 4);

            switch (userElectionInMainMenu) {
                case 1:
                    System.out.println(menuChoseTypeOfDiet);

                    int valueMenuB = ScannerMethods.nextInt();
                    switch (valueMenuB) {
                        case 1:
                            dieta = new Diet();
                            break;
                        case 2:
                            dieta = createDietWithCaloriesLimit(scanner);
                            break;
                        case 3:
                            dieta = createDietWithMacroLimits(scanner);
                            break;
                        case 4:
                            dieta = createDietWithPersonalData(scanner);
                            break;
                    }

                    break;

                case 2:
                    showInfoOfDiet(dieta);
                    break;
                case 3:

                    if (dieta == null){
                        System.out.println("Precisas crear unha dieta primeiro");
                    }else{
                        System.out.println("" +
                                "-1. Nuevo alimento\n" +
                                "-2. Alimento existente");



                        int userElectionFoodNewOrExisting = Kb.getOption(1, 2);



                        addNewFoodOrChangeQuantityOfExistingFood(userElectionFoodNewOrExisting, scanner, dieta);
                    }

                    break;


                case 4:
                    System.out.println("Fin do programa");
                    if (dieta != null){
                        System.out.println(dieta.toString());
                    }
                    goOutOfWhileLoop = true;
                    break;

                default:
                    //System.out.println("value menu es " + valueMenu);
                    //System.out.println("entra en default");
                    System.out.println("Elixe un número entre 1 e 4.");
                    break;


            }
        }

    }


    private Food asksUserDataOfNewFoodAndCreatesIt(Scanner scanner) throws InputMismatchException {

        String nameFoodCreatedByUser = null;

        while ( nameFoodCreatedByUser == null || nameFoodCreatedByUser.length() > 20  ) {
            System.out.println("Introduce o nome do alimento.");
            scanner.nextLine();
            String provisionalName = scanner.nextLine().trim();
            while(Kb.isStringMadeOfDigits(provisionalName) || provisionalName.length() > 14){
                System.out.println("Introduce un nome de menos de 14 letras");
                provisionalName = scanner.nextLine().trim();
            }
            nameFoodCreatedByUser = provisionalName;
            provisionalName = null;

        }



        System.out.println("Introduce os carbohidratos do alimento");
        int carbs = addCarbsProteinsOrFatsToFoodBeforeCreate(scanner);

        System.out.println("Introduce as graxas do alimento");
        int fats = addCarbsProteinsOrFatsToFoodBeforeCreate(scanner);

        System.out.println("Introduce as proteínas do alimento");
        int proteins = addCarbsProteinsOrFatsToFoodBeforeCreate(scanner);




        return new Food(nameFoodCreatedByUser, carbs, fats, proteins);
    }

    private int addCarbsProteinsOrFatsToFoodBeforeCreate(Scanner scanner){
        String provisional = scanner.nextLine().trim();

        while (!Kb.isStringMadeOfDigits(provisional) || provisional.length() > 7){
            System.out.println("Escribe un número de 7 díxitos ou menos");
            provisional = scanner.nextLine().trim();
        }
        int macroQuantityInFood = Integer.parseInt(provisional);
        return macroQuantityInFood;
    }

    private void showInfoOfDiet(Diet dieta) {

        if (dieta == null){
            System.out.println("Non hai dieta para mostrar aínda");
        }else{
            System.out.println("calorias na dieta: " + dieta.getTotalCalories());
            if(dieta.maxCalories != null){
                System.out.println("cun límite de: " + dieta.getMaxCalories());
            }
            System.out.println("proteinas na dieta: " + dieta.getTotalProtein());
            if(dieta.maxProteins != null){
                System.out.println("cun límite de: " + dieta.getMaxProteins());
            }
            System.out.println("carbohidratos na dieta: " + dieta.getTotalCarbs());
            if(dieta.maxCarbs != null){
                System.out.println("cun " +
                        "límite de: " + dieta.getMaxCarbs());
            }
            System.out.println("graxas na dieta: " + dieta.getTotalFats());
            if (dieta.maxFats != null){
                System.out.println("cun límite de: " + dieta.getMaxFats());
            }

        }


    }

    private Diet createDietWithMacroLimits(Scanner scanner) {

        System.out.println("Introduce o número de graxas máximas ou pulsa enter se non queres limitar.");
        String max_fats = scanner.nextLine();
        Integer max_fatsInt =null;


        if (!max_fats.equals("")){

            while (!Kb.isStringMadeOfDigits(max_fats) || max_fats.length() > 6){

                System.out.println("Por favor escribe un número de menos de 6 cifras");
                max_fats = scanner.nextLine();
            }
            max_fatsInt = Integer.parseInt(max_fats);
        }


        System.out.println("Introduce o número de carbohidratos máximos ou pulsa enter se non queres limitar.");
        String max_carbs = scanner.nextLine();
        Integer max_carbsInt =null;

        if (!max_carbs.equals("")){
            while(!Kb.isStringMadeOfDigits(max_carbs) || max_carbs.length() > 6){
                System.out.println("Por favor escribe un número de menos de 6 cifras");
                max_carbs = scanner.nextLine();
            }

            max_carbsInt = Integer.parseInt(max_carbs);
        }

        System.out.println("Introduce o número de proteinas máximas ou pulsa enter se non queres limitar.");
        String max_proteins = scanner.nextLine();
        Integer max_proteinsInt =null;

        if (!max_proteins.equals("")){
            while(!Kb.isStringMadeOfDigits(max_proteins) || max_proteins.length() > 6){
                System.out.println("Por favor escribe un número de menos de 6 cifras");
                max_proteins = scanner.nextLine().trim();
            }
            max_proteinsInt = Integer.parseInt(max_proteins);
        }

        return new Diet(max_fatsInt, max_carbsInt, max_proteinsInt);
    }


    private Diet createDietWithPersonalData(Scanner scanner) {
        String gender = "Z";

        while(!gender.equals("H") && !gender.equals("M")){
            System.out.println("Introduce H para home, M para muller");
            gender = scanner.nextLine().toUpperCase().trim();
        }

        boolean women = false;
        if (gender.equals("M")) {
            women = true;
        } else {
            women = false;
        }

        System.out.println("Introduce a idade"); //
        String ageString = scanner.nextLine().trim(); //
        int ageInt; //
        while (!Kb.isStringMadeOfDigits(ageString) || ageString.length() >= 3){
            System.out.println("Escribe unha idade entre 0 e 99");
            ageString = scanner.nextLine().trim();

        }
        ageInt = Integer.parseInt(ageString);


        System.out.println("Introduce a altura en centímetros");
        String heightString = scanner.nextLine().trim();
        int heightInt;

        while(!(Kb.isStringMadeOfDigits(heightString) && (40 < Integer.parseInt(heightString)) && (Integer.parseInt(heightString) < 210))){
            System.out.println("Escribe unha altura entre 40 e 210");
            heightString = scanner.nextLine().trim();

        }
        heightInt = Integer.parseInt(heightString);




        System.out.println("Introduce o peso");
        int weight = scanner.nextInt();

        return new Diet(women, ageInt, heightInt, weight);
    }


    private Diet createDietWithCaloriesLimit(Scanner scanner) {
        System.out.println("Introduce o número de calorías máximas");
        String max_calories = scanner.nextLine();
        Integer max_caloriesInt =null;

        if (!max_calories.equals("")){

            while (!Kb.isStringMadeOfDigits(max_calories) || max_calories.length() > 6){

                System.out.println("Por favor escribe un número de menos de 6 cifras");
                max_calories = scanner.nextLine();
            }
            max_caloriesInt = Integer.parseInt(max_calories);
        }


        return new Diet(max_caloriesInt);
    }


    private void addNewFoodOrChangeQuantityOfExistingFood(int foodNewOrNot, Scanner scanner, Diet diet) {

        if (foodNewOrNot == 1) {

            Food food = asksUserDataOfNewFoodAndCreatesIt(scanner);

            System.out.println("Introduce a cantidade de alimento");
            int quantity = scanner.nextInt();

            diet.addFoodIfItsUnderLimits(food, quantity);


        } else {
            if(diet.getFoodsInDiet().isEmpty()){
                System.out.println("Aínda non hai alimentos na túa lista");

            }else{

                System.out.println("Elixe o alimento da lista");
                int num = 0;

                for (int i = 0; i < diet.getFoodsInDiet().size(); i++) {


                    System.out.println("-" + ++num + "." + " " + diet.getFoodsInDiet().get(i).getName() + ", " + diet.getQuantitiesInDiet().get(i) + " gramos");

                }

                int selectedFoodNumber = Kb.getOption(1, diet.getFoodsInDiet().size()-1);
                int selectedFoodIndexInArray = selectedFoodNumber - 1;

                System.out.println("Cantos gramos queres engadir de " + diet.getFoodsInDiet().get(selectedFoodIndexInArray).getName());
                int addedQuantity = scanner.nextInt();


                Integer currentQuantityOfThatFood = diet.getQuantitiesInDiet().get(selectedFoodIndexInArray);
                diet.getQuantitiesInDiet().set(selectedFoodIndexInArray, currentQuantityOfThatFood + addedQuantity);
                System.out.println("O alimento elexido pasou de ter " + currentQuantityOfThatFood + " gramos a " + (currentQuantityOfThatFood + addedQuantity));


            }

        }

    }


}













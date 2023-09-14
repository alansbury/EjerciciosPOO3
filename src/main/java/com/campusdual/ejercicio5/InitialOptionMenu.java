package com.campusdual.ejercicio5;

import com.campusdual.ejercicio5.enums.Days;
import com.campusdual.ejercicio5.enums.Gender;
import com.campusdual.ejercicio5.exceptions.MaxCaloriesReachedException;
import com.campusdual.ejercicio5.exceptions.MaxCarbsReachedException;
import com.campusdual.ejercicio5.exceptions.MaxFatsReachedException;
import com.campusdual.ejercicio5.exceptions.MaxProteinsReachedException;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class InitialOptionMenu {

    private Diet diet = null;

    private List<Food> foodList;

    public InitialOptionMenu() {
        foodList = new ArrayList<>();
    }


    public void showMenuProgram() {
        System.out.println("########################################################");
        System.out.println("################# Inicio ###############################");
        System.out.println("########################################################");
        Integer option;
        do {
            System.out.println("Escriba una opción:");
            System.out.println("===================================");
            System.out.println("1-Pacientes");
            System.out.println("2-Dietas");
            System.out.println("3-Salir");
            option = Kb.getOption(1, 3);
            switch (option) {
                case 1:
                    showPatientOptions();
                    break;
                case 2:
                    showDietOptions();
                    break;
                case 3:
                    System.out.println("Gracias por usar el programa, hasta pronto :)");
                    break;


            }
        } while (option != 3);
    }


    private void showPatientOptions() {
        System.out.println("########################################################");
        System.out.println("#################  Pacientes  ##########################");
        System.out.println("########################################################");
        Integer option;

        System.out.println("Escriba una opción:");
        System.out.println("===================================");
        System.out.println("1-Añadir paciente");
        System.out.println("2-Lista de pacientes");
        System.out.println("3-Menú inicial");

        option = Kb.getOption(1, 3);
        switch (option) {
            case 1:
                askDataAndCreatesPatientAndPutItInArray();
                break;
            case 2:
                showsPatientsListToModifyDataDeleteOrAddDiet();
                break;
            case 3:
                break;
        }

    }


    private static void askDataAndCreatesPatientAndPutItInArray() {

        System.out.println("Nombre del paciente:");
        String name = Kb.nextLine();
        System.out.println("Apellidos del paciente:");
        String surname = Kb.nextLine();
        System.out.println("Peso:");
        int weight = Kb.forceNextInt();
        System.out.println("Altura:");
        int height = Kb.forceNextInt();
        System.out.println("Edad:");
        int age = Kb.forceNextInt();
        Gender gender = askUserForGender();

        Patient patient = new Patient(name, surname, weight, height, age, gender);
        Patients.getPatientsArrayList().add(patient);

        System.out.println("Has creado paciente " + patient.getFullname() + "y lo has añadido a la lista.");


    }

    private void showsPatientsListToModifyDataDeleteOrAddDiet() {


        if (Patients.getPatientsArrayList().isEmpty()) {
            System.out.println("No hay pacientes para mostrar.");

        } else {
            Patient selectedPatient;
            int i = 1;
            for (Patient p : Patients.getPatientsArrayList()) {
                System.out.println(i + " - " + p.getFullname());
                i++;
            }
            System.out.println(i + " - Salir");

            int selection = Kb.getOption(1, i);

            if (selection == i) return;
            selectedPatient = Patients.getPatientsArrayList().get(selection - 1);


            System.out.println("SELECCIONADO: " + selectedPatient.getFullname());
            System.out.println("1: Modificar datos");
            System.out.println("2: Dietas");
            System.out.println("3: Borrar");
            System.out.println("4: Salir");

            selection = Kb.getOption(1, 4);

            switch (selection) {
                case 1:
                    modifyPatientData(selectedPatient);
                    break;

                case 2:

                    seePatientDietsAndEditThem(selectedPatient);
                    break;
                case 3:
                    deletePatient(selectedPatient);
                    break;
                case 4:

                    break;


            }
        }


    }

    private void seePatientDietsAndEditThem(Patient patient) {
        boolean empty = true;


        for (Map.Entry<String, Diet> set : patient.getDietsForPatientHash().entrySet()) {
            if (set.getValue() != null) {
                empty = false;
            }
        }

        int i = 1;
        if (empty) {
            System.out.println("No hay dietas que mostrar para este paciente.");


        } else {
            Set<String> keys = patient.getDietsForPatientHash().keySet();



            for (Map.Entry<String, Diet> entry : patient.getDietsForPatientHash().entrySet()) {
                String key1 = entry.getKey();
                Diet diet1 = entry.getValue();
                if (diet1 != null) {
                    System.out.println(i + " - BORRAR " + key1 + ": " + diet1.getName());
                    i++;
                }

            }


        }

        System.out.println(i++ + " - Agregar dieta a este paciente");
        System.out.println(i + " - Salir");

        int selection = Kb.getOption(1, i);
        if (selection <= i - 2) { //si seleccionas o numero de algunha dieta, borrala.

            List<Map.Entry<String, Diet>> listWithIndices = new ArrayList<>();

            for (Map.Entry<String, Diet> entry : patient.getDietsForPatientHash().entrySet()) {
                listWithIndices.add(entry);

            }
            deleteDietFromPatient(patient, listWithIndices.get(selection - 1).getKey());

        } else {
            if (selection == (i - 1)) { //se seleccionas o penultimo numero agregas a este paciente unha dieta a elexir

                addDietToPatient(patient);
            }
            //else: salir
        }

    }


    private void addDietToPatient(Patient patient, Diet diet) {
//TODO VER COMO SIMPLIFICAR AS DUAS FUNCIONS CO MESMO NOME A UNHA SOLA

        System.out.println("Elige el día de la semana:");
        for (int i = 1; i < 8; i++){
            System.out.println(i + ". " + Days.getNameFromNumber(i));
        }



        int selected = Kb.getOption(1, 7);

        String selectedDay = Days.getNameFromNumber(selected);


       patient.getDietsForPatientHash().put(selectedDay, diet);

    }

    private void addDietToPatient(Patient patient) {
        System.out.println("Elige el día de la semana:");
        for (int i = 1; i < 8; i++){
            System.out.println(i + ". " + Days.getNameFromNumber(i));
        }
        int selected = Kb.getOption(1, 7);
        String selectedDay = Days.getNameFromNumber(selected);


        System.out.println("Elige dieta a añadir");
        int ix = 1;
        for (Diet dietX : Diets.getDietsArrayList()) {
            System.out.println(ix + ". " + Diets.getDietsArrayList().get(ix - 1).getName());
            ix++;
        }
        System.out.println(ix + ". Crear nueva dieta");

        int election = Kb.getOption(1, ix);
        Diet dietToAdd;
        if (election < ix) {
            dietToAdd = Diets.getDietsArrayList().get(election - 1);

            patient.getDietsForPatientHash().put(selectedDay, dietToAdd);

        } else if (election == ix) {

            dietToAdd = createsDietOfSelectedTypeAndPutsItInArrayReturnsDiet();
            patient.getDietsForPatientHash().put(selectedDay, dietToAdd);


        }


    }

    private static void deleteDietFromPatient(Patient patient, String nameOfDiet) {

        patient.getDietsForPatientHash().remove(nameOfDiet);

    }


    private static void deleteDietFromGlobalListAfterCheckingIfSomeoneIsUsingIt(Diet diet) {

        boolean notInUse = true;
        System.out.println("1");


        for (Patient patient : Patients.getPatientsArrayList()) {

            for (Map.Entry<String, Diet> entry : patient.getDietsForPatientHash().entrySet()) {
                if (entry.getValue() == diet) {
                    notInUse = false;
                    break;
                }
            }
        }

        if (notInUse) {
            Diets.getDietsArrayList().remove(diet);
            System.out.println("Dieta " + diet.getName() + " ha sido borrada");
        } else {
            System.out.println("La dieta " + diet.getName() + " no puedes ser borrada porque se encuentra en uso.");
        }
    }

    private static void modifyPatientData(Patient patient) {
        System.out.println("Selecciona el dato que quieres cambiar:");
        System.out.println("1 - Nombre");
        System.out.println("2 - Apellido");
        System.out.println("3 - Peso");
        System.out.println("4 - Altura");
        System.out.println("5 - Edad");
        System.out.println("6 - Sexo");
        System.out.println("7 - Salir");


        int selection = Kb.getOption(1, 7);

        switch (selection) {
            case 1:
                System.out.println("Introduce nuevo nombre:");
                String newName = Kb.nextLine();
                patient.setName(newName);
                break;
            case 2:
                System.out.println("Introduce nuevo apellido:");
                String newSurname = Kb.nextLine();
                patient.setSurname(newSurname);
                break;
            case 3:
                System.out.println("Introduce nuevo peso:");
                int newWeight = Kb.nextInt();
                patient.setWeight(newWeight);
                break;
            case 4:
                System.out.println("Introduce nueva altura:");
                int newHeight = Kb.nextInt();
                patient.setWeight(newHeight);
                break;
            case 5:
                System.out.println("Introduce nueva edad:");
                int newAge = Kb.nextInt();
                patient.setWeight(newAge);
                break;

            case 6:

                Gender gender = askUserForGender();
                patient.setGender(gender);

                break;
            case 7:
                break;
        }
    }

    private static void deletePatient(Patient patient) {
        Patients.getPatientsArrayList().remove(patient);
        System.out.println(patient.getFullname() + " borrado");
    }

    private static Gender askUserForGender() {
        Gender genderSlctd = Gender.FEMALE;
        String genderStr = "";
        while ((!genderStr.equals("H") && (!genderStr.equals("M")))) {
            System.out.println("Sexo (H/M):");
            genderStr = Kb.nextLine().trim().toUpperCase();
        }
        if (genderStr.equals("H")) {
            genderSlctd = Gender.MALE;
        }
        return genderSlctd;
    }


    public void showDietOptions() {
        System.out.println("########################################################");
        System.out.println("################# Programa de dietas ###################");
        System.out.println("########################################################");
        Integer option;
        do {
            System.out.println("Escriba una opción:");
            System.out.println("===================================");
            System.out.println("1-Agregar nueva dieta");
            System.out.println("2-Listar dietas");
            System.out.println("3-Salir");
            option = Kb.getOption(1, 4);
            switch (option) {
                case 1:
                    // createsDietOfSelectedTypeAndPutsItInArrayVoidVersion();
                    Diet dietaProvisional = createsDietOfSelectedTypeAndPutsItInArrayReturnsDiet();
                    askUserIfTheyWantToAsociateDietToPatient(dietaProvisional);
                    dietaProvisional = null;
                    break;
                case 2:
                    showsDietsInTheArray();
                    break;
                case 3:
                    break;
            }
        } while (option != 3);
    }


    private void showsDietsInTheArray() {
        Diet selectedDiet;
        int numeroSeleccion;
        if (Diets.getDietsArrayList().isEmpty()) {
            System.out.println("No hay dietas que mostrar");
        } else {
            int i = 1;
            System.out.println("Elige la dieta que quieras modificar o borrar:");
            for (Diet diet : Diets.getDietsArrayList()) {
                System.out.println(i + " - " + Diets.getDietsArrayList().get(i - 1).getName());
                i++;
            }
            System.out.println(i + " - Salir");

            numeroSeleccion = Kb.getOption(1, Diets.getDietsArrayList().size() + 1);
            if (numeroSeleccion == Diets.getDietsArrayList().size() + 1) {

                return;
            }

            selectedDiet = Diets.getDietsArrayList().get(numeroSeleccion - 1);

            System.out.println("1. Ver \n" +
                    "2. Modificar \n" +
                    "3. Borrar \n" +
                    "4. Salir");
            numeroSeleccion = Kb.getOption(1, 3);
            switch (numeroSeleccion) {
                case 1:
                    showDetailsMenu(selectedDiet);
                    break;
                case 2:
                    modifyDiet(selectedDiet);
                    break;
                case 3:
                    deleteDietFromGlobalListAfterCheckingIfSomeoneIsUsingIt(selectedDiet);
                    break;
                case 4:
                    break;
            }


        }

    }


    private void askUserIfTheyWantToAsociateDietToPatient(Diet dieta) {
        System.out.println("1 - Asociar dieta recién creada a un paciente");
        System.out.println("2 - Salir");

        int option = Kb.getOption(1, 2);
        switch (option) {
            case 1:


                System.out.println("1 - Crear nuevo cliente");
                System.out.println("2 - Cliente ya registrado");
                System.out.println("3 - Salir");

                int tipoDeCliente = Kb.getOption(1, 2);

                switch (tipoDeCliente) {
                    case 1:
                        System.out.println("el programa todavía no permite se puede agregar dieta a nuevo cliente");
                        break;
                    case 2:
                        if (Patients.getPatientsArrayList().isEmpty()) {
                            System.out.println("No hay pacientes para mostrar.");

                        } else {
                            Patient selectedPatient;
                            int i = 1;
                            for (Patient p : Patients.getPatientsArrayList()) {
                                System.out.println(i + " - " + p);
                                i++;
                            }
                            System.out.println(i + " - Salir");

                            int selection = Kb.getOption(1, i);

                            if (selection == i) return;
                            selectedPatient = Patients.getPatientsArrayList().get(selection - 1);

                            addDietToPatient(selectedPatient, dieta);
                            System.out.println("Se ha añadido la dieta " + dieta.getName() + " a " + selectedPatient.getFullname());

                        }
                        break;
                    case 3:
                        break;
                }


                break;
            case 2:
                break;
        }


    }


    private void modifyDiet(Diet diet) {
        int indexOfDietInArray = Diets.getDietsArrayList().indexOf(diet);
        System.out.println("Selecciona el dato que quieras modificar");
        System.out.println("1 - Nombre");
        System.out.println("2 - Calorías máximas");
        System.out.println("3 - Grasas máximas");
        System.out.println("4 - Proteínas máximas");
        System.out.println("5 - Carbohidratos máximos");
        System.out.println("6 - Añadir alimento");


        int selection = Kb.getOption(1, 6);
        int value;
        switch (selection) {
            case 1:
                System.out.println("Introduce el nuevo nombre: ");
                String name = Kb.nextLine();
                Diets.getDietsArrayList().get(indexOfDietInArray).setName(name);
                break;
            case 2:
                System.out.println("Introduce las nuevas calorías máximas");
                value = Kb.nextInt();
                Diets.getDietsArrayList().get(indexOfDietInArray).setMaxCalories(value);
                break;
            case 3:
                System.out.println("Introduce las nuevas grasas máximas");
                value = Kb.nextInt();
                Diets.getDietsArrayList().get(indexOfDietInArray).setMaxFats(value);
                break;
            case 4:
                System.out.println("Introduce las nuevas proteínas máximas");
                value = Kb.nextInt();
                Diets.getDietsArrayList().get(indexOfDietInArray).setMaxProteins(value);
                break;
            case 5:
                System.out.println("Introduce los nuevos carbohidratos máximos");
                value = Kb.nextInt();
                Diets.getDietsArrayList().get(indexOfDietInArray).setMaxCarbs(value);
                break;
            case 6:
                addFoodMenu(Diets.getDietsArrayList().get(indexOfDietInArray));


        }

    }


    private void addFoodMenu(Diet diet) {
        if (diet == null) {
            System.out.println("Para agregar alimentos hace falta iniciar una dieta");
            return;
        }
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("Agregar Alimentos a la dieta");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("Escriba una opción:");
        System.out.println("===================================");
        System.out.println("1-Agregar un nuevo alimento");
        System.out.println("2-Agregar un alimento ya existente");

        Integer option = Kb.getOption(1, 2);
        switch (option) {
            case 1:
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                System.out.println("Datos de nuevo alimento");
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                System.out.println("Nombre del alimento:");
                String name = Kb.nextLine();
                System.out.println("Carbohidratos:");
                Integer carbs = Kb.forceNextInt();
                System.out.println("Grasas:");
                Integer fats = Kb.forceNextInt();
                System.out.println("Proteínas:");
                Integer proteins = Kb.forceNextInt();
                System.out.println("Gramos:");
                Integer grams = Kb.forceNextInt();
                Food newFood = new Food(name, carbs, fats, proteins);
                validateAndAddFoodToDiet(newFood, grams, diet);
                foodList.add(newFood);
                break;
            case 2:
                if (foodList.isEmpty()) {
                    System.out.println("Para agregar un alimento existente, tienen que existir alimentos previos");
                    break;
                }
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                System.out.println("Escoja un alimento");
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                Integer i = 1;
                for (Food food : foodList) {
                    System.out.println(i + "- " + food.getName());
                    i++;
                }
                System.out.println(i + "- Cancelar");
                int element = Kb.getOption(1, i);
                if (element == i) {
                    System.out.println("Cancelando alimento");
                    break;
                }
                Food storedFood = foodList.get(element - 1);
                System.out.println("indique el número de gramos de " + storedFood.getName());
                Integer foodGrams = Kb.forceNextInt();
                validateAndAddFoodToDiet(storedFood, foodGrams, diet);
                break;
        }
    }

    private void validateAndAddFoodToDiet(Food food, Integer grams, Diet diet) {
        try {
            diet.addFood(food, grams);
        } catch (MaxCaloriesReachedException ecal) {
            System.out.println("Se ha alcanzado el máximo valor de calorías permitido");
        } catch (MaxCarbsReachedException ecar) {
            System.out.println("Se ha alcanzado el máximo valor de carbohidratos permitido");
        } catch (MaxFatsReachedException efat) {
            System.out.println("Se ha alcanzado el máximo valor de grasas permitido");
        } catch (MaxProteinsReachedException epro) {
            System.out.println("Se ha alcanzado el máximo valor de proteínas permitido");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public Diet creatDietOfChosenTypeAndReturnsItWithoutPuttingItInArray() {
        String nameDiet;
        Diet dietNew;
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("Crear/reiniciar dieta");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("Escriba una opción:");
        System.out.println("===================================");
        System.out.println("1-Dieta sin límite");
        System.out.println("2-Dieta por calorías");
        System.out.println("3-Dieta por macronutrientes");
        System.out.println("4-Dieta por datos personales");
        Integer option = Kb.getOption(1, 4);
        switch (option) {
            case 1:
                System.out.println("Escribe el nombre de la dieta.");
                dietNew = new Diet(Kb.nextLine());
                this.diet = dietNew;
                System.out.println("Se ha creado una dieta sin límites");
                return dietNew;

            case 2:
                System.out.println("Escribe el nombre de la dieta.");
                nameDiet = Kb.nextLine();
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                System.out.println("Escriba número de calorias");
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                Integer calories = Kb.forceNextInt();
                dietNew = new Diet(nameDiet, calories);
                this.diet = dietNew;

                System.out.println("Se ha creado una dieta con " + calories + " calorías máximas");
                return dietNew;

            case 3:
                System.out.println("Escribe el nombre de la dieta.");
                nameDiet = Kb.nextLine();
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                System.out.println("Escriba los macronutrientes");
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                System.out.println("Carbohidratos:");
                Integer carbs = Kb.forceNextInt();
                System.out.println("Grasas:");
                Integer fats = Kb.forceNextInt();
                System.out.println("Proteínas:");
                Integer proteins = Kb.forceNextInt();
                dietNew = new Diet(nameDiet, fats, carbs, proteins);
                this.diet = dietNew;

                System.out.println("Se ha creado una dieta con Carbohidratos:" + carbs + ", Grasas:" + fats + " ,Proteínas:" + proteins);
                return dietNew;

            case 4:
                System.out.println("Escribe el nombre de la dieta.");
                nameDiet = Kb.nextLine();
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                System.out.println("Escriba los datos personales del paciente");
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                System.out.println("Peso:");
                Integer weight = Kb.forceNextInt();
                System.out.println("Altura:");
                Integer height = Kb.forceNextInt();
                System.out.println("Edad:");
                Integer age = Kb.forceNextInt();
                System.out.println("Mujer u Hombre(m/h):");
                String sexCharacter = Kb.nextLine();
                dietNew = new Diet(nameDiet, "m".equalsIgnoreCase(sexCharacter), age, height, weight);
                this.diet = dietNew;

                System.out.println("Se ha creado una dieta de " + this.diet.getMaxCalories() + " calorías máximas");
                return dietNew;

        }
        return null;
    }



    private Diet createsDietOfSelectedTypeAndPutsItInArrayReturnsDiet() {

        Diet diet = creatDietOfChosenTypeAndReturnsItWithoutPuttingItInArray();
        Diets.getDietsArrayList().add(diet);
        return diet;


    }

    private void showDetailsMenu(Diet diet) {
        if (diet != null) {
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println("Detalles de la dieta");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            if (diet.getMaxCalories() != null) {
                System.out.println("El número máximo de calorías es:" + diet.getMaxCalories());
            }
            if (diet.getMaxCarbs() != null || diet.getMaxFats() != null || diet.getMaxProteins() != null) {
                System.out.println("Los valores máximos de macronutrientes son: Carbohidratos:" + diet.getMaxCarbs() + " , Grasas:" + diet.getMaxFats() + " , Proteinas:" + diet.getMaxProteins());
            }
            System.out.println("Número de alimentos de la dieta:" + diet.getFoodNumber());
            System.out.println("Calorías:" + diet.getTotalCalories());
            System.out.println("Carbohidratos:" + diet.getTotalCarbs());
            System.out.println("Grasas:" + diet.getTotalFats());
            System.out.println("Proteínas:" + diet.getTotalProteins());
            System.out.println("Alimentos de la dieta:" + diet.getDietIntakes());
        } else {
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println("La dieta no esta iniciada");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        }
    }


}

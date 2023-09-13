package ejercicio4.ejercicio4;


import com.campusdual.ejercicio5.Diet;
import com.campusdual.ejercicio5.Diets;
import com.campusdual.ejercicio5.Food;
import com.campusdual.ejercicio5.Kb;
import com.campusdual.ejercicio5.Patient;
import com.campusdual.ejercicio5.Patients;
import com.campusdual.ejercicio5.exceptions.MaxCaloriesReachedException;
import com.campusdual.ejercicio5.exceptions.MaxCarbsReachedException;
import com.campusdual.ejercicio5.exceptions.MaxFatsReachedException;
import com.campusdual.ejercicio5.exceptions.MaxProteinsReachedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Pruebas{

/*

    package com.campusdual.ejercicio5;

import com.campusdual.ejercicio5.exceptions.MaxCaloriesReachedException;
import com.campusdual.ejercicio5.exceptions.MaxCarbsReachedException;
import com.campusdual.ejercicio5.exceptions.MaxFatsReachedException;
import com.campusdual.ejercicio5.exceptions.MaxProteinsReachedException;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

    public class InitialOptionMenu {





        public void showMenuProgram(){

            do{

                option = com.campusdual.ejercicio5.Kb.getOption(1,3);
                switch (option){
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
            }while(option != 3);
        }


        private void showPatientOptions(){


            option = com.campusdual.ejercicio5.Kb.getOption(1,3);
            switch (option){
                case 1:
                    askDataAndCreatesPatientAndPutItInArray();
                    break;
                case 2:
                    showsPatientsListToModifyOrDelete();
                    break;
                case 3:
                    System.out.println("Gracias por usar el programa, hasta pronto :)");
                    break;
            }

        }


        private static void askDataAndCreatesPatientAndPutItInArray(){


            String gender = "Z";
            boolean woman = true;
            while((gender.equals("H") && (gender.equals("M")))){
                System.out.println("Sexo (H/M):");
                gender = com.campusdual.ejercicio5.Kb.nextLine().trim().toUpperCase();
            }
            if (gender=="H"){
                woman = false;
            }


            System.out.println("Has creado paciente " + patient.getName() + " " + patient.getSurname() + "y lo has añadido a la lista.");



        }

        private void showsPatientsListToModifyOrDelete(){


            if (Patients.getPatientsArrayList().isEmpty()){

                System.out.println("No hay pacientes para mostrar.");

            }else{


                Patient selectedPatient;
                int i = 1;
                for (Patient p : Patients.getPatientsArrayList()){
                    System.out.println(i + " - " + p.getName() + " " + p.getSurname());
                    i++;
                }
                System.out.println(i + " - Salir");

                int selection = com.campusdual.ejercicio5.Kb.getOption(1, i);

                if (selection == i) return;
                selectedPatient = Patients.getPatientsArrayList().get(selection -1);



                selection = com.campusdual.ejercicio5.Kb.getOption(1,3);

                switch (selection){
                    case 1:
                        modifyPatientData(selectedPatient);
                        break;

                    case 2:

                        seePatientDietsAndEditThem(selectedPatient);
                        break;
                    case 3:
                        deletePatient(selectedPatient);
                        break;


                }
            }










        }

        private void seePatientDietsAndEditThem(Patient patient){
            boolean empty = true;


            for(Map.Entry<String, com.campusdual.ejercicio5.Diet> set : patient.getDietsForPatientHash().entrySet()){
                if (set.getValue() !=null){
                    empty = false;
                }
            }
            if(empty == true){
                System.out.println("No hay dietas que mostrar para este paciente.");


            }else{
                Set<String> keys = patient.getDietsForPatientHash().keySet();
                List<String> keysList = new ArrayList<>(keys);




                for(String key : keysList){





                    int i = 1;


                    for (Map.Entry<String, com.campusdual.ejercicio5.Diet> entry : patient.getDietsForPatientHash().entrySet()){
                        String key1 = entry.getKey();
                        com.campusdual.ejercicio5.Diet diet1 = entry.getValue();
                        if (diet1 != null){
                            System.out.println(i + " - BORRAR " + key1 + ": " + diet1.getName());
                            i++;
                        }

                    }

                    System.out.println(i++ + " - Agregar dieta a este paciente");
                    System.out.println(i + " - Salir");

                    int selection = com.campusdual.ejercicio5.Kb.getOption(1, i);
                    if (selection <= i-2){

                        List<Map.Entry<String, com.campusdual.ejercicio5.Diet>> listWithIndices = new ArrayList<>();

                        int index = 0;
                        for (Map.Entry<String, com.campusdual.ejercicio5.Diet> entry : patient.getDietsForPatientHash().entrySet()) {
                            listWithIndices.add(entry);

                        }

                        deleteDietFromPatient(patient, listWithIndices.get(selection-1).getKey());
                        //
                    }
                    else{
                        if (selection == (i-1)){

                            addDietToPatient(patient);
                        }
                        else{
                            //salir
                        }
                    }
                }

            }

        }

        private  void addDietToPatient(Patient patient){
            System.out.println("Elige el día de la semana:");
            System.out.println("1. Lunes");
            System.out.println("2. Martes");
            System.out.println("3. Miércoles");
            System.out.println("4. Jueves");
            System.out.println("5. Viernes");
            System.out.println("6. Sábado");
            System.out.println("7. Domingo");
            int selected = com.campusdual.ejercicio5.Kb.getOption(1, 7);
            String selectedDay = "";

            switch (selected){
                case 1:
                    selectedDay = "Lunes";
                    break;
                case 2:
                    selectedDay = "Martes";
                    break;
                case 3:
                    selectedDay = "Miércoles";
                    break;
                case 4:
                    selectedDay = "Jueves";
                    break;
                case 5:
                    selectedDay = "Viernes";
                    break;
                case 6:
                    selectedDay = "Sábado";
                    break;
                case 7:
                    selectedDay = "Domingo";
                    break;
            }

            com.campusdual.ejercicio5.Diet diet = null;

            System.out.println("Elige dieta a añadir");
            int ix = 1;
            for (com.campusdual.ejercicio5.Diet dietX : com.campusdual.ejercicio5.Diets.getDietsArrayList()){
                System.out.println(ix + ". " + com.campusdual.ejercicio5.Diets.getDietsArrayList().get(ix-1).getName());
                ix++;
            }
            System.out.println(ix + ". Crear nueva dieta");

            int election = com.campusdual.ejercicio5.Kb.getOption(1, ix);
            com.campusdual.ejercicio5.Diet dietToAdd = null;
            if (election < ix){
                dietToAdd = com.campusdual.ejercicio5.Diets.getDietsArrayList().get(election-1);

                patient.getDietsForPatientHash().put(selectedDay, dietToAdd);
                System.out.println(patient.getDietsForPatientHash());
            }
            else{
                createsDietOfSelectedTypeAndPutsItInArray();

            }





        }

        private static void deleteDietFromPatient(Patient patient, String nameOfDiet){

            patient.getDietsForPatientHash().remove(nameOfDiet);

        }


        private static void deleteDietFromGlobalListAfterCheckingIfSomeoneIsUsingIt(com.campusdual.ejercicio5.Diet diet){

            boolean notInUse = true;
            System.out.println("1");


            for (Patient patient : Patients.getPatientsArrayList()){
                System.out.println("dentro loop");
                for (Map.Entry<String, com.campusdual.ejercicio5.Diet> entry : patient.getDietsForPatientHash().entrySet()){
                    if (entry.getValue() == diet){
                        notInUse = false;

                    }
                }
            }

            System.out.println("fuera loop");
            if(notInUse){
                com.campusdual.ejercicio5.Diets.getDietsArrayList().remove(diet);
                System.out.println("Dieta " + diet.getName() + " ha sido borrada");
            }else{
                System.out.println("La dieta " + diet.getName() + " no puedes ser borrada porque se encuentra en uso.");
            }


        }

        private static void modifyPatientData(Patient patient){
            System.out.println("Selecciona el dato que quieres cambiar:");
            System.out.println("1 - Nombre");
            System.out.println("2 - Apellido");
            System.out.println("3 - Peso");
            System.out.println("4 - Altura");
            System.out.println("5 - Edad");
            System.out.println("6 - Sexo");


            int selection = com.campusdual.ejercicio5.Kb.getOption(1, 6);

            switch (selection){
                case 1:
                    System.out.println("Introduce nuevo nombre:");
                    String newName = com.campusdual.ejercicio5.Kb.nextLine();
                    patient.setName(newName);
                case 2:
                    System.out.println("Introduce nuevo apellido:");
                    String newSurname = com.campusdual.ejercicio5.Kb.nextLine();
                    patient.setSurname(newSurname);
                case 3:
                    System.out.println("Introduce nuevo peso:");
                    int newWeight = com.campusdual.ejercicio5.Kb.nextInt();
                    patient.setWeight(newWeight);
                case 4:
                    System.out.println("Introduce nueva altura:");
                    int newHeight = com.campusdual.ejercicio5.Kb.nextInt();
                    patient.setWeight(newHeight);
                case 5:
                    System.out.println("Introduce nueva edad:");
                    int newAge = com.campusdual.ejercicio5.Kb.nextInt();
                    patient.setWeight(newAge);
                case 6:
                    boolean woman = true;
                    String gender = com.campusdual.ejercicio5.Kb.nextLine();
                    while((gender.equals("H") && (gender.equals("M")))){
                        System.out.println("Sexo (H/M):");
                        gender = com.campusdual.ejercicio5.Kb.nextLine().trim().toUpperCase();
                    }
                    if (gender=="H"){
                        woman = false;
                    }
                    patient.setWoman(woman);

            }





        }

        private static void deletePatient(Patient patient){
            Patients.getPatientsArrayList().remove(patient);
            System.out.println(patient.getName() +" "+ patient.getSurname() + " borrado");
            System.out.println("JUCHE: " +
                    Patients.getPatientsArrayList());
        }



        public void showDietOptions(){
            System.out.println("########################################################");
            System.out.println("################# Programa de dietas ###################");
            System.out.println("########################################################");
            Integer option;
            do{
                System.out.println("Escriba una opción:");
                System.out.println("===================================");
                System.out.println("1-Agregar nueva dieta");
                System.out.println("2-Listar dietas");
                System.out.println("3-Salir del programa");
                option = com.campusdual.ejercicio5.Kb.getOption(1,4);
                switch (option){
                    case 1:
                        createsDietOfSelectedTypeAndPutsItInArray();
                        break;
                    case 2:
                        showsDietsInTheArray();
                        break;
                    case 3:
                        System.out.println("Gracias por usar el programa, hasta pronto :)");
                        break;
                }
            }while(option != 3);
        }





        private void showsDietsInTheArray(){
            com.campusdual.ejercicio5.Diet selectedDiet;
            int numeroSeleccion;
            if (com.campusdual.ejercicio5.Diets.getDietsArrayList().isEmpty()){
                System.out.println("No hay dietas que mostrar");
            }else{
                int i = 1;
                System.out.println("Elige la dieta que quieras modificar o borrar:");
                for(com.campusdual.ejercicio5.Diet diet: com.campusdual.ejercicio5.Diets.getDietsArrayList()){
                    System.out.println(i + " - " + com.campusdual.ejercicio5.Diets.getDietsArrayList().get(i-1).getName());
                    i++;
                }

                numeroSeleccion = com.campusdual.ejercicio5.Kb.getOption(1, com.campusdual.ejercicio5.Diets.getDietsArrayList().size() +1);
                if(numeroSeleccion == com.campusdual.ejercicio5.Diets.getDietsArrayList().size() +1){
                    return;
                }

                selectedDiet = com.campusdual.ejercicio5.Diets.getDietsArrayList().get(numeroSeleccion - 1);

                System.out.println("1. Modificar \n" +
                        "2. Borrar");
                numeroSeleccion = com.campusdual.ejercicio5.Kb.getOption(1, 2);
                switch (numeroSeleccion){
                    case 1:
                        modifyDiet(selectedDiet);
                        break;
                    case 2:
                        deleteDietFromGlobalListAfterCheckingIfSomeoneIsUsingIt(selectedDiet);
                        break;
                }


            }

        }

        private void deleteDietFromArray(com.campusdual.ejercicio5.Diet diet){
            com.campusdual.ejercicio5.Diets.getDietsArrayList().remove(diet);
        }

        private void modifyDiet(com.campusdual.ejercicio5.Diet diet){
            int indexOfDietInArray = com.campusdual.ejercicio5.Diets.getDietsArrayList().indexOf(diet);
            System.out.println("Selecciona el dato que quieras modificar");
            System.out.println("1 - Nombre");
            System.out.println("2 - Calorías máximas");
            System.out.println("3 - Grasas máximas");
            System.out.println("4 - Proteínas máximas");
            System.out.println("5 - Carbohidratos máximos");
            System.out.println("6 - Añadir alimento");


            int selection = com.campusdual.ejercicio5.Kb.getOption(1, 6);
            int value;
            switch (selection){
                case 1:
                    System.out.println("Introduce el nuevo nombre: ");
                    String name = com.campusdual.ejercicio5.Kb.nextLine();
                    com.campusdual.ejercicio5.Diets.getDietsArrayList().get(indexOfDietInArray).setName(name);
                    break;
                case 2:
                    System.out.println("Introduce las nuevas calorías máximas");
                    value = com.campusdual.ejercicio5.Kb.nextInt();
                    com.campusdual.ejercicio5.Diets.getDietsArrayList().get(indexOfDietInArray).setMaxCalories(value);
                    break;
                case 3:
                    System.out.println("Introduce las nuevas grasas máximas");
                    value = com.campusdual.ejercicio5.Kb.nextInt();
                    com.campusdual.ejercicio5.Diets.getDietsArrayList().get(indexOfDietInArray).setMaxFats(value);
                    break;
                case 4:
                    System.out.println("Introduce las nuevas proteínas máximas");
                    value = com.campusdual.ejercicio5.Kb.nextInt();
                    com.campusdual.ejercicio5.Diets.getDietsArrayList().get(indexOfDietInArray).setMaxProteins(value);
                    break;
                case 5:
                    System.out.println("Introduce los nuevos carbohidratos máximos");
                    value = com.campusdual.ejercicio5.Kb.nextInt();
                    com.campusdual.ejercicio5.Diets.getDietsArrayList().get(indexOfDietInArray).setMaxCarbs(value);
                    break;
                case 6:
                    addFoodMenu(com.campusdual.ejercicio5.Diets.getDietsArrayList().get(indexOfDietInArray));


            }

        }


        private void addFoodMenu(com.campusdual.ejercicio5.Diet diet) {
            if(diet==null){
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

            Integer option = com.campusdual.ejercicio5.Kb.getOption(1,2);
            switch (option){
                case 1:
                    System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                    System.out.println("Datos de nuevo alimento");
                    System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                    System.out.println("Nombre del alimento:");
                    String name = com.campusdual.ejercicio5.Kb.nextLine();
                    System.out.println("Carbohidratos:");
                    Integer carbs = com.campusdual.ejercicio5.Kb.forceNextInt();
                    System.out.println("Grasas:");
                    Integer fats = com.campusdual.ejercicio5.Kb.forceNextInt();
                    System.out.println("Proteínas:");
                    Integer proteins = com.campusdual.ejercicio5.Kb.forceNextInt();
                    System.out.println("Gramos:");
                    Integer grams = com.campusdual.ejercicio5.Kb.forceNextInt();
                    com.campusdual.ejercicio5.Food newFood = new com.campusdual.ejercicio5.Food(name,carbs,fats,proteins);
                    validateAndAddFoodToDiet(newFood,grams, diet);
                    foodList.add(newFood);
                    break;
                case 2:
                    if(foodList.size()==0){
                        System.out.println("Para agregar un alimento existente, tienen que existir alimentos previos");
                        return;
                    }
                    System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                    System.out.println("Escoja un alimento");
                    System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                    Integer i = 1;
                    for(com.campusdual.ejercicio5.Food food:foodList){
                        System.out.println(i+"- "+food.getName());
                        i++;
                    }
                    System.out.println(i+"- Cancelar");
                    Integer element = com.campusdual.ejercicio5.Kb.getOption(1,i);
                    if(element==i){
                        System.out.println("Cancelando alimento");
                        return;
                    }
                    com.campusdual.ejercicio5.Food storedFood = foodList.get(element-1);
                    System.out.println("indique el número de gramos de "+storedFood.getName());
                    Integer foodGrams = com.campusdual.ejercicio5.Kb.forceNextInt();
                    validateAndAddFoodToDiet(storedFood,foodGrams, diet);
                    break;
            }
        }

        private void validateAndAddFoodToDiet(Food food, Integer grams, com.campusdual.ejercicio5.Diet diet){
            try{
                diet.addFood(food,grams);
            }catch (MaxCaloriesReachedException ecal){
                System.out.println("Se ha alcanzado el máximo valor de calorías permitido");
            }catch (MaxCarbsReachedException ecar){
                System.out.println("Se ha alcanzado el máximo valor de carbohidratos permitido");
            }catch (MaxFatsReachedException efat){
                System.out.println("Se ha alcanzado el máximo valor de grasas permitido");
            }catch (MaxProteinsReachedException epro){
                System.out.println("Se ha alcanzado el máximo valor de proteínas permitido");
            }catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        private  void createsDietOfSelectedTypeAndPutsItInArray() {
            String nameDiet;
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println("Crear/reiniciar dieta");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println("Escriba una opción:");
            System.out.println("===================================");
            System.out.println("1-Dieta sin límite");
            System.out.println("2-Dieta por calorías");
            System.out.println("3-Dieta por macronutrientes");
            System.out.println("4-Dieta por datos personales");
            Integer option = com.campusdual.ejercicio5.Kb.getOption(1,4);
            switch (option){
                case 1:
                    System.out.println("Escribe el nombre de la dieta.");
                    this.diet = new com.campusdual.ejercicio5.Diet(com.campusdual.ejercicio5.Kb.nextLine());
                    com.campusdual.ejercicio5.Diets.getDietsArrayList().add(this.diet);
                    System.out.println("Se ha creado una dieta sin límites");
                    break;
                case 2:
                    System.out.println("Escribe el nombre de la dieta.");
                    nameDiet = com.campusdual.ejercicio5.Kb.nextLine();
                    System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                    System.out.println("Escriba número de calorias");
                    System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                    Integer calories = com.campusdual.ejercicio5.Kb.forceNextInt();
                    this.diet = new com.campusdual.ejercicio5.Diet(nameDiet, calories);
                    com.campusdual.ejercicio5.Diets.getDietsArrayList().add(this.diet);
                    System.out.println("Se ha creado una dieta con "+calories+" calorías máximas");
                    break;
                case 3:
                    System.out.println("Escribe el nombre de la dieta.");
                    nameDiet = com.campusdual.ejercicio5.Kb.nextLine();
                    System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                    System.out.println("Escriba los macronutrientes");
                    System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                    System.out.println("Carbohidratos:");
                    Integer carbs = com.campusdual.ejercicio5.Kb.forceNextInt();
                    System.out.println("Grasas:");
                    Integer fats = com.campusdual.ejercicio5.Kb.forceNextInt();
                    System.out.println("Proteínas:");
                    Integer proteins = com.campusdual.ejercicio5.Kb.forceNextInt();
                    this.diet = new com.campusdual.ejercicio5.Diet(nameDiet, fats,carbs,proteins);
                    com.campusdual.ejercicio5.Diets.getDietsArrayList().add(this.diet);
                    System.out.println("Se ha creado una dieta con Carbohidratos:"+carbs+", Grasas:"+fats+" ,Proteínas:"+proteins);
                    break;
                case 4:
                    System.out.println("Escribe el nombre de la dieta.");
                    nameDiet = com.campusdual.ejercicio5.Kb.nextLine();
                    System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                    System.out.println("Escriba los datos personales del paciente");
                    System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                    System.out.println("Peso:");
                    Integer weight = com.campusdual.ejercicio5.Kb.forceNextInt();
                    System.out.println("Altura:");
                    Integer height = com.campusdual.ejercicio5.Kb.forceNextInt();
                    System.out.println("Edad:");
                    Integer age = com.campusdual.ejercicio5.Kb.forceNextInt();
                    System.out.println("Mujer u Hombre(m/h):");
                    String sexCharacter = Kb.nextLine();
                    this.diet = new Diet(nameDiet,"m".equalsIgnoreCase(sexCharacter),age,height,weight);
                    Diets.getDietsArrayList().add(this.diet);
                    System.out.println("Se ha creado una dieta de "+this.diet.getMaxCalories()+" calorías máximas");
                    break;
            }
        }

        private void showDetailsMenu() {
            if(this.diet!=null){
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                System.out.println("Detalles de la dieta");
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                if(this.diet.getMaxCalories()!=null){
                    System.out.println("El número máximo de calorías es:"+this.diet.getMaxCalories());
                }
                if(this.diet.getMaxCarbs() != null || this.diet.getMaxFats() != null || this.diet.getMaxProteins() != null){
                    System.out.println("Los valores máximos de macronutrientes son: Carbohidratos:"+this.diet.getMaxCarbs()+" , Grasas:"+this.diet.getMaxFats()+" , Proteinas:"+this.diet.getMaxProteins());
                }
                System.out.println("Número de alimentos de la dieta:"+this.diet.getFoodNumber());
                System.out.println("Calorías:"+this.diet.getTotalCalories());
                System.out.println("Carbohidratos:"+this.diet.getTotalCarbs());
                System.out.println("Grasas:"+this.diet.getTotalFats());
                System.out.println("Proteínas:"+this.diet.getTotalProteins());
                System.out.println("Alimentos de la dieta:"+this.diet.getDietIntakes());
            }else{
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                System.out.println("La dieta no esta iniciada");
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            }
        }





    }











 */




}
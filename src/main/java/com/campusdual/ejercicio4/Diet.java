package com.campusdual.ejercicio4;

import java.util.ArrayList;


public class Diet {

    String name = null;

    Integer maxCalories = null;
    Integer maxFats = null;
    Integer maxCarbs = null;
    Integer maxProteins = null;
    Integer totalCalories = 0;
    Integer totalCarbs = 0;
    Integer totalProtein = 0;
    Integer totalFats = 0;


    private ArrayList<Food> foodsInDiet = new ArrayList<Food>();

    private ArrayList<Integer> food_quantity = new ArrayList<Integer>();

    Diet() {
        System.out.println("Creouse unha nova dieta sen límite de calorías");
    }

    Diet(Integer maxCalories) {

        this.maxCalories = maxCalories;


    }

    Diet(Integer maxFats, Integer maxCarbs, Integer maxProtein) {
        this.maxFats = maxFats;
        this.maxCarbs = maxCarbs;
        this.maxProteins = maxProtein;

    }

    Diet(Boolean women, Integer age, Integer height, Integer weight) {

        if (women = true) {
            this.maxCalories = (int) ((10 * weight) + (6.25 * height)) - (5 * age) - 161;
        } else {
            this.maxCalories = (int) ((10 * weight) + (6.25 * height)) - (5 * age) + 5;
        }

    }


    public void addFoodIfItsUnderLimits(Food food, Integer quantity) {


        //teño que saber cantas calorias ten esta comida nesta cantidade
        Integer caloriesInThisNewAddedFood = food.getCalories(quantity);

        //teño que sumar esas calorias ás calorias acumulada na dieta
        //correxir calculos aqui arriba
        Integer caloriesProvisionallyAdded = totalCalories + caloriesInThisNewAddedFood;
        Integer carbsProvisionallyAdded = totalCarbs + food.getCarbos();
        Integer fatsProvisionallyAdded = totalFats + food.getFats();
        Integer proteinProvisionallyAdded = totalProtein + food.getProteins();

        boolean highInSomething = false;

        if (maxCalories != null && caloriesProvisionallyAdded > maxCalories) {
            System.out.println("Demasiadas calorías na dieta.");
            highInSomething = true;
        }

        if (maxCarbs != null && carbsProvisionallyAdded > maxCarbs) {
            System.out.println("Demasiadas carbohidratos na dieta.");
            highInSomething = true;
        }
        if (maxFats != null && fatsProvisionallyAdded > maxFats) {
            System.out.println("Demasiadas graxas na dieta.");
            highInSomething = true;
        }
        if (maxProteins != null && proteinProvisionallyAdded > maxProteins) {
            System.out.println("Demasiadas proteinas na dieta.");
            highInSomething = true;
        }
        if (highInSomething) {
            System.out.println("O alimento non se engadiu á dieta");
        }
        if (!highInSomething) {

            foodsInDiet.add(food);
            Foods.getFoodsByDefault().add(food);
            food_quantity.add(quantity);
            totalCalories = totalCalories + caloriesInThisNewAddedFood;

            totalCarbs = totalCarbs + (food.getCarbos() * quantity / 100);
            totalFats = totalFats + (food.getCarbos() * quantity / 100);
            totalProtein = totalProtein + (food.getProteins() * quantity / 100);

            System.out.println("Alimento engadido á dieta.");

        }


    }


    Integer getTotalCalories() {
        return this.totalCalories;
    }

    Integer getTotalCarbs() {
        return this.totalCarbs;
    }

    Integer getTotalFats() {
        return this.totalFats;
    }

    Integer getTotalProtein() {
        return this.totalProtein;
    }

    Integer getMaxCalories() {
        return this.maxCalories;
    }

    Integer getMaxProteins(){
        return this.maxProteins;
    }

    Integer getMaxFats(){
        return this.maxFats;
    }

    Integer getMaxCarbs(){
        return this.maxCarbs;
    }


    public ArrayList<Food> getFoodsInDiet() {
        return this.foodsInDiet;
    }

    public ArrayList<Integer> getQuantitiesInDiet() {
        return this.food_quantity;
    }

    @Override
    public String toString() {
        String intro = "Os alimentos da dieta son: \n";

        for (int i = 0; i < foodsInDiet.size(); i++) {
            intro = intro + foodsInDiet.get(i).getName() + ": " + food_quantity.get(i) + "\n";
        }

        return intro;
    }
}


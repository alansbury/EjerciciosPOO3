package com.campusdual.ejercicio5;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Patient {

    private static final String MONDAY = "Lunes";
    private static final String TUESDAY = "Martes";
    private static final String WEDNESDAY = "Miércoles";
    private static final String THURSDAY = "Jueves";
    private static final String FRIDAY = "Viernes";
    private static final String SATURDAY = "Sábado";
    private static final String SUNDAY = "Domingo";

    private String name;
    private String surname;
    private int weight;
    private int height;
    private int age;
    private boolean woman;


    private LinkedHashMap<String, Diet> dietsForPatientHash = new LinkedHashMap<>();

    public void setDietsForPatientHash(LinkedHashMap<String, Diet> dietsForPatientHash) {
        this.dietsForPatientHash = dietsForPatientHash;
    }

    public LinkedHashMap<String, Diet> getDietsForPatientHash() {
        return dietsForPatientHash;
    }

    public Patient(String name, String surname, int weight, int height, int age, boolean woman) {
        this.name = name;
        this.surname = surname;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.woman = woman;

        dietsForPatientHash.put(MONDAY, null);
        dietsForPatientHash.put(TUESDAY, null);
        dietsForPatientHash.put(WEDNESDAY, null);
        dietsForPatientHash.put(THURSDAY, null);
        dietsForPatientHash.put(FRIDAY, null);
        dietsForPatientHash.put(SATURDAY, null);
        dietsForPatientHash.put(SUNDAY, null);



    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    public int getAge() {
        return age;
    }

    public boolean isWoman() {
        return woman;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWoman(boolean woman) {
        this.woman = woman;
    }
}

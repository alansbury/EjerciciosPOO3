package com.campusdual.ejercicio5;

import com.campusdual.ejercicio5.enums.Days;
import com.campusdual.ejercicio5.enums.Gender;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class Patient {


    private String name;
    private String surname;
    private String fullname;
    private int weight;
    private int height;
    private int age;
    private Gender gender;



    private LinkedHashMap<String, Diet> dietsForPatientHash = new LinkedHashMap<>();

    public void setDietsForPatientHash(LinkedHashMap<String, Diet> dietsForPatientHash) {
        this.dietsForPatientHash = dietsForPatientHash;
    }

    public LinkedHashMap<String, Diet> getDietsForPatientHash() {
        return dietsForPatientHash;
    }

    public Patient(String name, String surname, int weight, int height, int age, Gender gender) {

        this.fullname = name + " " + surname;
        this.name = name;
        this.surname = surname;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.gender = gender;



        for (int i = 1; i < 8; i++ ){

            dietsForPatientHash.put(Days.getNameFromNumber(i), null);
        }



    }

    public String getFullname() {
        return fullname;
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

    public Gender getGender() {
        return gender;
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

    public void setGender(Gender gender) {
        this.gender = gender;
    }


    public String toString(){
        String result = name+";"+surname+";"+weight+";"+height+";"+age+";";

        ArrayList<String> daysArrayList = new ArrayList<>(Arrays.asList("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"));

        boolean first = true;
        int i = 1;
        int b = 0;
        for(String day: dietsForPatientHash.keySet()){
            if(first){
              //  String dietName = getDietsForPatientHash().get(daysArrayList.get(b).getName());
                result = result+i+":"+getDietsForPatientHash().get(daysArrayList.get(b));
                first = false;
            }else{
                result = result+","+i+":"+getDietsForPatientHash().get(daysArrayList.get(b)) ;
            }
            i++;
            b++;
        }



        return result;
    }
}

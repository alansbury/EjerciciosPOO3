package com.campusdual.ejercicio5;

import java.util.ArrayList;

public class Patients {


    private static ArrayList<Patient> patientsArrayList = new ArrayList<Patient>();



    public static ArrayList<Patient> getPatientsArrayList() {
        return patientsArrayList;
    }

    public static void setPatientsArrayList(ArrayList<Patient> patientsArrayList) {
        Patients.patientsArrayList = patientsArrayList;
    }
}

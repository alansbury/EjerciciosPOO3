package com.campusdual.ejercicio5;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class StaticMethods {


    public static void toDocument(String string){
        try {

            FileWriter myWriter = new FileWriter(".\\Patients.txt", true);
            myWriter.write(string  + System.lineSeparator());
            myWriter.close();
            System.out.println("Escritura exitosa.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error.");
            e.printStackTrace();
        }

    }


    public static void writeListInDocument(String fileNameWOExtention, ArrayList arrayList){

        try {
            File file = new File(".\\"+ fileNameWOExtention + ".txt");
            if (file.delete()) {
                System.out.println("Archivo eliminado: " + file.getName());
            } else {
                System.out.println("No se pudo eliminar el archivo.");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        for (Object object : arrayList){
            String objectString = object.toString();
            toDocument(objectString);
        }

    }



}

package com.campusdual.ejercicio5;

//--Teniendo en cuenta el programa anterior(ejercicio4):
//--Realiza los cambios necesarios para:
//  -La dieta ya no será única si no que se guardará en una lista de dietas. Esta lista tendrá un nombre para poder ser recuperado.
//  Será necesario cambiar el menú para gestionar esta lista. Ahora en ved de crear/reemplazar dieta lo que haremos será:
//    a- Agregar dieta: Añade una dieta a la lista. Podemos reutilizar el menú antiguo de crear/reemplazar
//    b- Mostrar detalles de dieta: Muestra los detalles de una dieta y permite modificarla
//    c- Eliminar dieta: Elimina una dieta de la lista(Siempre que no la tenga asignada un paciente)
//
//  -Se pueden dar de alta personas: Las personas tendrán los siguientes atributos: nombre, apellidos, peso, altura, edad y sexo.
//    -Las personas podrán tener asignadas una lista de dietas que se catalogarán de lunes a domingo sacadas de la lista de dietas anterior.
//    -Se agregara un apartado nuevo al menú de "Gestión de pacientes" con las siguientes funcionalidades:
//      1- Dar de alta un paciente : Agregará un paciente nuevo a la lista de pacientes
//      2- Listar y Mostrar detalles de un paciente : Mostrará el detalle de un paciente así como todas sus dietas listadas de Lunes a domingo
//      3- Asignar una dieta: Muestra la lista de dietas general y puede asignarle una a un día de la semana del paciente.
//      4- Dar de baja un paciente: Elimina los datos de un paciente(No borra sus dietas asignadas dado que pueden estar asignadas a otro paciente)

import com.campusdual.ejercicio5.enums.Gender;

import java.io.File;
import java.io.IOException;

public class Menu {
    public static void main(String[] args) {

       Patients.getPatientsArrayList().add(new Patient("AAAA", "BBBB", 12, 23,23, Gender.FEMALE));
       // Patients.getPatientsArrayList().add(new Patient("CCCC", "DDD", 12, 23,23, true));
        Diets.getDietsArrayList().add(new Diet("prueba"));
       // Diets.getDietsArrayList().add(new Diet("prueba2"));


        try {
            File myFile = new File("Patients.txt");
            if (myFile.createNewFile()) {
                System.out.println("Archivo creado: " + myFile.getName());
            } else {
                System.out.println("El archivo ya existe.");
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error.");
            e.printStackTrace();
        }


        InitialOptionMenu initialOptionMenu = new InitialOptionMenu();
        initialOptionMenu.showMenuProgram();
    }
}

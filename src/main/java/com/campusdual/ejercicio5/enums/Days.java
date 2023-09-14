package com.campusdual.ejercicio5.enums;

public enum Days {


    MON(1, "Lunes"),
    TUES(2, "Martes"),
    WEDNES(3, "Miércoles"),
    THURS(4, "Jueves"),
    FRI(5, "Viernes"),
    SATUR(6, "Sábado"),
    SUN(7, "Domingo");


    private Integer number;
    private String name;

    public Integer getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    private Days(Integer number, String name) {
        this.name = name;
        this.number = number;
    }

    public static String getNameFromNumber(Integer number){
        for(Days day : values()){
            if (day.number == number){
                return day.name;
            }
        }
        return null;
    }


}
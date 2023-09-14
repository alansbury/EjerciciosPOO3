package com.campusdual.ejercicio5.enums;

public enum Gender {

    MALE, FEMALE;


    public static Gender getByString(String string){

        if ("m".equals(string.toLowerCase().trim())){
            return MALE;

        }else if("f".equals(string.toLowerCase().trim())){
            return FEMALE;
        }

        return MALE;

    }


}

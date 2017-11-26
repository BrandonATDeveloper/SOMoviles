package com.example.brand.eva2_9_custom_adapter;

/**
 * Created by Brand on 19/10/2017.
 */

public class datosTemperatura {
    int idImageClima;
    String cuidad;
    int temperatura;
    String descripcionClima;

    public datosTemperatura(){
        idImageClima = R.drawable.sunny;
        cuidad = "Chihuahua";
        temperatura = 1000;
        descripcionClima = "Soleado";
    }

    public datosTemperatura(int image, String cuidadC, int temp, String desClima){
        idImageClima = image;
        cuidad = cuidadC;
        temperatura = temp;
        descripcionClima = desClima;
    }

}

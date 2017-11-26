package com.example.brand.eva2_10_practica1;

/**
 * Created by Brand on 24/10/2017.
 */

public class datosRestaurante {
    String nombreRestaurant, descripcion, direccion, telefono;
    int imagen;

    public datosRestaurante(){
        nombreRestaurant = "Barrafina";
        descripcion  = "Rico y delicioso";
        direccion = "Periferico de la Juventud #123";
        telefono = "6142521134";
        imagen = R.drawable.barrafina;
    }

    public datosRestaurante(String res, String des, String dir, String tel, int img){
        nombreRestaurant = res;
        descripcion = des;
        direccion = dir;
        telefono = tel;
        imagen = img;
    }
}

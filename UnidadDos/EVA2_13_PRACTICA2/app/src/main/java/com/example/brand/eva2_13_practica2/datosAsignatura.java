package com.example.brand.eva2_13_practica2;

/**
 * Created by Brand on 14/11/2017.
 */

public class datosAsignatura {
    String docente, asignatura;
    int creditos, image,id, idimg;

    public datosAsignatura(){
        id = 1;
        docente = "Ashley Smith";
        asignatura = "Fundamentos de Programación";
        creditos = 5;
        image = R.drawable.m1;
        idimg = R.drawable.progra;
    }

    public datosAsignatura(int iden, String doc, String asig, int cre, int img, int idenimg){
        id = iden;
        docente = doc;
        asignatura = asig;
        creditos = cre;
        image = img;
        idimg = idenimg;
    }

}

package com.example.brand.eva2_2_intentos_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Principal extends AppCompatActivity {

    Intent inLanzaSec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        //accion --> quien ñanza
        //data --Z quien va lanzar
        inLanzaSec = new Intent(this, Secundaria.class);
    }

    public void onClick(View v) {
        startActivity(inLanzaSec);
    }

}

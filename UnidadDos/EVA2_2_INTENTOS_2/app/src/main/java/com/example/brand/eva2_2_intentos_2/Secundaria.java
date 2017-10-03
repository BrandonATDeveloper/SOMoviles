package com.example.brand.eva2_2_intentos_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Secundaria extends AppCompatActivity {

    Intent inLanzarPri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);
        inLanzarPri = new Intent(this,Principal.class);
    }

    public  void onClick(View v){
        //finish();
        startActivity(inLanzarPri);
    }

}

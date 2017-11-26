package com.example.brand.eva2_9_custom_adapter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ClimaDetalle extends AppCompatActivity {

    ImageView imgClima;
    TextView cuidad, des, temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clima_detalle);
        imgClima = (ImageView)findViewById(R.id.imgClima);
        cuidad = (TextView)findViewById(R.id.cuidadDet);
        des = (TextView)findViewById(R.id.desc);
        temp = (TextView)findViewById(R.id.tempDet);
        //Recuperar el intento
        Intent inDatos = getIntent();
        //acceder  al bundle
        Bundle bnDatos = inDatos.getExtras();
        //leer los datos
        imgClima.setImageResource(bnDatos.getInt("IMAGEN"));
        cuidad.setText(bnDatos.getString("CUIDAD"));
        des.setText(bnDatos.getInt("TEMP") + "°C");
        temp.setText(bnDatos.getString("DESC"));
    }

    public void onClick(){
        finish();
    }

}

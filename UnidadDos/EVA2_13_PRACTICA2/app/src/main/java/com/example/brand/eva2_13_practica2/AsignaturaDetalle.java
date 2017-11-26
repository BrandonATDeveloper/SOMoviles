package com.example.brand.eva2_13_practica2;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class AsignaturaDetalle extends AppCompatActivity {

    TextView asignatura, docente, creditos;
    ImageView img2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignatura_detalle);
        asignatura = (TextView)findViewById(R.id.asigDetalle);
        docente = (TextView)findViewById(R.id.docenteDetalle);
        creditos = (TextView)findViewById(R.id.creditosDetalle);
        img2 = (ImageView)findViewById(R.id.imageView3);
        //Recuperar el intento
        Intent inDatos = getIntent();
        //acceder  al bundle
        Bundle bnDatos = inDatos.getExtras();
        //leer los datos
        img2.setImageResource(bnDatos.getInt("IMAGEN"));
        asignatura.setText(bnDatos.getString("ASIGNATURA"));
        docente.setText(bnDatos.getString("DOCENTE"));
        creditos.setText(bnDatos.getInt("CREDITOS")+"");
    }
}

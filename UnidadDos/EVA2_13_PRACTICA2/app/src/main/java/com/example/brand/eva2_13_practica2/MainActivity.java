package com.example.brand.eva2_13_practica2;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener {

    datosAsignatura[] asignaturas = {new datosAsignatura(1,"Ashley Smith","Fundamentos de Programación", 5, R.drawable.m1, R.drawable.progra),
            new datosAsignatura(2, "Carlos Rivera","Redes de Computadora", 4, R.drawable.m2, R.drawable.redes),
            new datosAsignatura(3, "Jonathan Blais","Fundamento de BD", 5, R.drawable.m3, R.drawable.bd),
            new datosAsignatura(1, "Mario Cuevas","Programacion Orientada a Objetos", 5, R.drawable.m4, R.drawable.progra),
            new datosAsignatura(2, "Samantha Nolasco","Conmutacion", 4, R.drawable.m5, R.drawable.redes),
            new datosAsignatura(3, "Ashley Smith","Taller de Base de Datos", 5, R.drawable.m1, R.drawable.bd),
            new datosAsignatura(1, "Carlos Rivera","Estructura de Datos", 5, R.drawable.m2, R.drawable.progra),
            new datosAsignatura(2, "Jonathan Blais","Administracion de Redes", 4, R.drawable.m3, R.drawable.redes),
            new datosAsignatura(3, "Mario Cuevas","Administracion de BD", 5, R.drawable.m4, R.drawable.bd),
            new datosAsignatura(1, "Samantha Nolasco","Topicos Avanzados", 5, R.drawable.m5, R.drawable.progra),
            new datosAsignatura(2, "Ashley Smith","Taller de SO", 4, R.drawable.m1, R.drawable.redes),
            new datosAsignatura(3, "Carlos Rivera","Base de Datos Moviles", 5, R.drawable.m2, R.drawable.bd),
    };
    ListView lista;
    ImageView img;
    TextView asig;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = (ListView)findViewById(R.id.list);
        img = (ImageView)findViewById(R.id.imageView);
        asig = (TextView)findViewById(R.id.asig);
        lista.setAdapter(new asignaturaAdapter(this, R.layout.asignatura, asignaturas));
        lista.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent inMostrarDet = new Intent(this, AsignaturaDetalle.class);
        //Datos
        Bundle  bnDatos = new Bundle();
        bnDatos.putInt("ASIGIMG", asignaturas[i].idimg);
        bnDatos.putInt("IMAGEN", asignaturas[i].image);
        bnDatos.putString("DOCENTE", asignaturas[i].docente);
        bnDatos.putString("ASIGNATURA", asignaturas[i].asignatura);
        bnDatos.putInt("CREDITOS", asignaturas[i].creditos);
        inMostrarDet.putExtras(bnDatos);
        //lanzamos detalle
        startActivity(inMostrarDet);
        if (asignaturas[i].id == 1){
            img.setImageResource(R.drawable.progra);
            asig.setText("Programación");
        }else if (asignaturas[i].id == 2){
            img.setImageResource(R.drawable.redes);
            asig.setText("Redes");
        }else if (asignaturas[i].id == 3){
            img.setImageResource(R.drawable.bd);
            asig.setText("Base de Datos");
        }
    }
}

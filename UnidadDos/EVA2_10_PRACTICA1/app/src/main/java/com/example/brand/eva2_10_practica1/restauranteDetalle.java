package com.example.brand.eva2_10_practica1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class restauranteDetalle extends AppCompatActivity {

    TextView restaurante, descripcion, direccion;
    Button telefono;
    ImageView imageView2;
    Intent hacerLLamada;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurante_detalle);
        restaurante = (TextView)findViewById(R.id.restaurante);
        descripcion = (TextView)findViewById(R.id.descripcion);
        direccion = (TextView)findViewById(R.id.direccion);
        telefono = (Button)findViewById(R.id.telefono);
        imageView2 = (ImageView)findViewById(R.id.imageView2);
        //Recuperar el intento
        Intent inDatos = getIntent();
        //acceder  al bundle
        Bundle bnDatos = inDatos.getExtras();
        //leer los datos
        imageView2.setImageResource(bnDatos.getInt("IMAGEN"));
        restaurante.setText(bnDatos.getString("RESTAURANTE"));
        descripcion.setText(bnDatos.getString("DESC"));
        direccion.setText(bnDatos.getString("DIRECCION"));
        telefono.setText(bnDatos.getString("TEL"));
    }

    public void onClick(View v){
        String tel = telefono.getText().toString();
        tel = "tel:" + tel;
        //ACTION_DIAL pantalla de marcacion
        //Uri tel:####
        hacerLLamada = new Intent(Intent.ACTION_CALL, Uri.parse(tel));
        startActivity(hacerLLamada);
    }

}

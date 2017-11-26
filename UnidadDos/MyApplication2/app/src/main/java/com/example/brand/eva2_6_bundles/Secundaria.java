package com.example.brand.eva2_6_bundles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Secundaria extends AppCompatActivity {

    TextView datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);
        datos = (TextView)findViewById(R.id.textView5);
        Intent inDatos = getIntent();
        Bundle bnDatos = inDatos.getExtras();
        datos.setText("");
        datos.append("\n" + bnDatos.getString("NOMBRE"));
        datos.append("\n" + bnDatos.getString("APELLIDO"));
        datos.append("\n" + bnDatos.getInt("EDAD"));
        datos.append("\n" + bnDatos.getDouble("SALARIO"));
        if (bnDatos.getBoolean("GENERO"))
            datos.append("\n" + "Masculino");
        else
            datos.append("\n" + "Femenino");
    }

    public void onClick2(){
        finish();
    }

}

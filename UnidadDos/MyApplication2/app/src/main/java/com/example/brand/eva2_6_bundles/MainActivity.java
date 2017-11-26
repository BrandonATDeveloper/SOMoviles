package com.example.brand.eva2_6_bundles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText nom, ape, edad, salario;
    RadioButton sexo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nom = (EditText)findViewById(R.id.name);
        ape = (EditText)findViewById(R.id.lastName);
        edad = (EditText)findViewById(R.id.age);
        salario = (EditText)findViewById(R.id.salary);
        sexo = (RadioButton) findViewById(R.id.Hombre);

    }

    public void onClick(View v){
        Intent inEnviarDatos = new Intent(this, Secundaria.class);
        Bundle bnDatos = new Bundle();
        bnDatos.putString("NOMBRE",nom.getText().toString());
        bnDatos.putString("APELLIDO",ape.getText().toString());
        bnDatos.putInt("EDAD",Integer.parseInt(edad.getText().toString()));
        bnDatos.putDouble("SALARIO",Double.parseDouble(salario.getText().toString()));
        bnDatos.putBoolean("GENERO",sexo.isChecked());
        inEnviarDatos.putExtras(bnDatos);
        startActivity(inEnviarDatos);
    }

}

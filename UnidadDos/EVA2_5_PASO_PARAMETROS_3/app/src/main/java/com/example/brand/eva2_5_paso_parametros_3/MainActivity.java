package com.example.brand.eva2_5_paso_parametros_3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText dato;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dato = (EditText)findViewById(R.id.dato);
    }

    public void enviar(View v){
        Intent intent = new Intent(MainActivity.this,Secundaria.class);
        String sMensa = dato.getText().toString();
        intent.putExtra("MENSAJE",sMensa);
        startActivity(intent);
    }

}

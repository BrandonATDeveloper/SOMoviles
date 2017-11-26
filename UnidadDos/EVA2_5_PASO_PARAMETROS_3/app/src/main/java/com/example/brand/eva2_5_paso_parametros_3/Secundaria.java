package com.example.brand.eva2_5_paso_parametros_3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Secundaria extends AppCompatActivity {

    TextView dato2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);
        dato2 = (TextView)findViewById(R.id.textView);
        //RECUPER LA INFORMACION DEL INTENTO
        Intent inDato = getIntent();
        String sMensa = inDato.getStringExtra("MENSAJE");
        dato2.setText(sMensa);
    }
}

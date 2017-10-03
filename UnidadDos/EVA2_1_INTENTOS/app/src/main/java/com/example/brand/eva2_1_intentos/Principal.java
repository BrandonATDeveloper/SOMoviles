package com.example.brand.eva2_1_intentos;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Principal extends AppCompatActivity {

    EditText telefono;
    Intent hacerLLamada;
    Button llamar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        telefono = (EditText)findViewById(R.id.editText);
        llamar = (Button)findViewById(R.id.button);
    }

    public void onClick(View v) {
        String sCade = telefono.getText().toString();
        sCade = "tel:" + sCade;
        //ACTION_DIAL pantalla de marcacion
        //Uri tel:####
        hacerLLamada = new Intent(Intent.ACTION_CALL, Uri.parse(sCade));
        startActivity(hacerLLamada);
    }

}

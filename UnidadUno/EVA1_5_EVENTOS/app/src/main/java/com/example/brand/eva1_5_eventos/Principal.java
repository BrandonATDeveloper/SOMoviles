package com.example.brand.eva1_5_eventos;

import android.icu.util.ValueIterator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Principal extends AppCompatActivity implements View.OnClickListener {

    Button bListen, bAnonima;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        bListen = (Button)findViewById(R.id.bListen);
        bAnonima = (Button)findViewById(R.id.bAnonima);
        bListen.setOnClickListener(this);
        bAnonima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Principal.this, "Hello World!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void doClick(View v){
        Toast.makeText(this, "Hello World!!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "Hello World!!", Toast.LENGTH_SHORT).show();
    }
}

package com.example.brand.eva2_8_listas;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final int MIS_DATOS = 1000;
    TextView texto;
    Intent inPedirDatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto = (TextView)findViewById(R.id.textView);
        inPedirDatos = new Intent(this, Secundario.class);
    }

    public void onClick(View v){
        startActivityForResult(inPedirDatos, MIS_DATOS);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == MIS_DATOS){
            if (resultCode == Activity.RESULT_OK){
                String sCade = data.getStringExtra("DATOS");
                texto.setText(sCade);
            }
        }
    }
}

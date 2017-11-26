package com.example.brand.eva2_11_cuadros_de_dialogo;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Context cnApp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cnApp = getApplicationContext();
    }

    public void onClickDialogo(View v){
        new AlertDialog.Builder(this).setTitle("CUADRO DE DIALOGO PERSONAL").setMessage("Hola Mundo")
                .setPositiveButton("+", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(cnApp, "Boton Positivo", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("-", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(cnApp, "Boton Negativo", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNeutralButton("+-", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(cnApp, "Boton Neutral", Toast.LENGTH_SHORT).show();
                    }
                }).create().show();
    }

    public void onClickDialogoPersonalizado(View v){
        final Dialog digMiDialogo = new Dialog(this);
        digMiDialogo.setContentView(R.layout.cuadrodialogo);
        TextView txt;
        final EditText etx;
        Button btn;
        txt = (TextView)digMiDialogo.findViewById(R.id.textView);
        etx = (EditText)digMiDialogo.findViewById(R.id.editText);
        btn = (Button)digMiDialogo.findViewById(R.id.button3);

        txt.setText("MI CUADRO DE DIALOGO");
        btn.setText("CLICK ME!");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(cnApp, etx.getText().toString(), Toast.LENGTH_SHORT).show();
                digMiDialogo.dismiss();
            }
        });
        digMiDialogo.show();
    }

}

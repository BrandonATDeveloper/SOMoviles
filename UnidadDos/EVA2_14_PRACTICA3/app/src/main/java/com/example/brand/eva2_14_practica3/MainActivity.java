package com.example.brand.eva2_14_practica3;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Context context;
    Button lanzar, salir;
    String usuario = "Brandon", contraseña= "12345";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lanzar = (Button)findViewById(R.id.access);
        salir = (Button)findViewById(R.id.salir);
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        context = getApplicationContext();
    }

    public void loginPerzonalizado(View v){
        final Dialog digMiDialogo = new Dialog(this);
        digMiDialogo.setContentView(R.layout.login);
        ImageView img;
        Button ok, cancel;
        final EditText user, pass;
        img = (ImageView)digMiDialogo.findViewById(R.id.imageView2);
        int aleatorio = (int) (Math.random()*5);
        System.out.println(aleatorio);
        switch (aleatorio){
            case 0:
                img.setImageResource(R.drawable.d);
                break;
            case 1:
                img.setImageResource(R.drawable.m);
                break;
            case 2:
                img.setImageResource(R.drawable.medicine);
                break;
            case 3:
                img.setImageResource(R.drawable.movil);
                break;
            case 4:
                img.setImageResource(R.drawable.progra);
                break;
        }
        user  = (EditText)digMiDialogo.findViewById(R.id.usuario);
        pass = (EditText)digMiDialogo.findViewById(R.id.contraseña);
        ok = (Button)digMiDialogo.findViewById(R.id.acc);
        cancel = (Button)digMiDialogo.findViewById(R.id.cancel);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usua, contra;
                usua = user.getText().toString();
                contra = pass.getText().toString();
                if (usua.equals(usuario) && contra.equals(contraseña)){
                    Intent intent = new Intent(MainActivity.this, PostActivity.class);
                    startActivity(intent);
                    Toast.makeText(context, "Acceso Autorizado", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(context, "Usuario y/o Contraseña incorrectas. Acceso Denegado", Toast.LENGTH_SHORT).show();
                }
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                digMiDialogo.dismiss();
            }
        });
        digMiDialogo.show();
    }

}

package com.example.brand.eva2_7_activity_result;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URI;

public class Principal extends AppCompatActivity {

    private final int MIS_DATOS = 1000;
    private final int MIS_CONTACTOS = 2000;
    TextView dato;
    Intent inRegresaDatos, inRegresaContacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        dato = (TextView)findViewById(R.id.textView);
        inRegresaDatos = new Intent(this, Secundario.class);
        Uri uriContactos = android.provider.ContactsContract.Contacts.CONTENT_URI;
        inRegresaContacto = new Intent(Intent.ACTION_PICK, uriContactos);
    }


    public void onClick(View v){
        startActivityForResult(inRegresaDatos,MIS_DATOS);
    }

    public void onClickContactos(View v){
        startActivityForResult(inRegresaContacto,MIS_CONTACTOS);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == MIS_DATOS){ //que actividad regresa los resultados
            if (resultCode == Activity.RESULT_OK){ //acepto y envio los datos
                //recuperar datos
                dato.setText(data.getStringExtra("MIS_DATOS"));
            }
        }else if (requestCode == MIS_CONTACTOS){
            if (resultCode == Activity.RESULT_OK){
                String sContacto = data.getDataString();
                Intent inEditarContacto = new Intent(Intent.ACTION_EDIT, Uri.parse(sContacto));
                startActivity(inEditarContacto);
                //Toast.makeText(this, data.getDataString(), Toast.LENGTH_SHORT).show();
            }
        }
    }

}

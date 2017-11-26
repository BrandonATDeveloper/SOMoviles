package com.example.brand.eva2_12_permisos;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText tel;
    Intent inLlamar;
    boolean permisos = false;
    final int PERMISO_LLAMAR = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tel =(EditText)findViewById(R.id.editText);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this, "No tenemos permisos", Toast.LENGTH_SHORT).show();
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, PERMISO_LLAMAR);
        }else{
            permisos = true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISO_LLAMAR){
            Toast.makeText(this, permissions[0], Toast.LENGTH_SHORT).show();
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Permiso Concedido", Toast.LENGTH_SHORT).show();
                permisos = true;
            }else{
                Toast.makeText(this, "Permisos Denegados", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void onClick (View v){
        if (permisos){
            String sCade = "tel:" + tel.getText().toString();
            inLlamar = new Intent(Intent.ACTION_CALL, Uri.parse(sCade));
            startActivity(inLlamar);
        }else{
            Toast.makeText(this, "No tenemos permisos", Toast.LENGTH_SHORT).show();
        }

    }

}

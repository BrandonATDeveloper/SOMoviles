package com.example.brand.eva3_13_media_player_service;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //Reproductor más elaborado, lista de canciones, parar, siguiente, seleccionar canciones

    Intent intRolasService;

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intRolasService = new Intent(this, RolasService.class);
        startService(intRolasService);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    stopService(intRolasService);
                } catch (Exception e) {
                }
            }
        });
    }
}

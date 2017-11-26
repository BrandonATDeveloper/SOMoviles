package com.example.brand.eva3_10_servicios;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button)findViewById(R.id.button);
        intent = new Intent(this, MyService.class);
        startService(intent);
    }

    public void onClick(View v){
        try {
            stopService(intent);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

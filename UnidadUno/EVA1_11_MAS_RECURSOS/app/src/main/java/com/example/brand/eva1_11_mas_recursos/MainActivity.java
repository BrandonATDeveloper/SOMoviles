package com.example.brand.eva1_11_mas_recursos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int iVal = (int)(Math.random() * 10) + 1;
        if(iVal > 5) {
            setTheme(R.style.BlueTheme);
            setContentView(R.layout.layout_primero);
        }else {
            setTheme(R.style.RedTheme);
            setContentView(R.layout.activity_main);
        }
    }
}

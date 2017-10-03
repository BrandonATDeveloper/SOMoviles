package com.example.brand.eva1_4_mas_widgets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    EditText introName;
    TextView showName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        introName = (EditText)findViewById(R.id.introName);
        showName = (TextView)findViewById(R.id.showName);

    }

    public void elClick(View v){
        String sNom;
        sNom = introName.getText().toString();
        showName.setText(sNom);
    }
}

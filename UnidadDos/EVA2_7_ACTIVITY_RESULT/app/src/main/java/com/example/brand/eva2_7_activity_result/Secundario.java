package com.example.brand.eva2_7_activity_result;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Secundario extends AppCompatActivity {

    EditText dato;
    Intent inResu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundario);
        dato = (EditText)findViewById(R.id.editText);
        inResu = getIntent();
    }

    public void miClick(View v){
        String sCade = dato.getText().toString();
        inResu.putExtra("MIS_DATOS",sCade);
        setResult(Activity.RESULT_OK,inResu);
        finish();
    }

}

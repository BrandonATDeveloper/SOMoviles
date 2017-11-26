package com.example.brand.eva2_4_intentos_paso_parametros_2;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText pagWeb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pagWeb = (EditText)findViewById(R.id.editText2);
    }

    public void miClick(View v){
        String sBuscar = pagWeb.getText().toString();
        Intent inBuscarWeb = new Intent(Intent.ACTION_WEB_SEARCH);
        //Agregar busqueda
        inBuscarWeb.putExtra(SearchManager.QUERY,sBuscar);
        startActivity(inBuscarWeb);
    }

}

package com.example.brand.eva2_8_listas;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Secundario extends AppCompatActivity implements ListView.OnItemClickListener {

    String [] arrayDatos = {"Tacos", "Tortas", "Tamales", "Dogos", "Enchiladas"
            , "Burritos", "Montados", "uebito con cabsun", "Chamorros", "Costillas", "Hamburguesas"};
    ListView list;
    Intent inDatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundario);
        list = (ListView)findViewById(R.id.list);
        list.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arrayDatos));
        inDatos = getIntent();
        list.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        inDatos.putExtra("DATOS",arrayDatos[i]);
        setResult(Activity.RESULT_OK, inDatos);
        finish();
    }
}

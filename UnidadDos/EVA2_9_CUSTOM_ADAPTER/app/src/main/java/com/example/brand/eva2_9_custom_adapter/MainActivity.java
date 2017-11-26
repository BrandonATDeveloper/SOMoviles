package com.example.brand.eva2_9_custom_adapter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener {

    datosTemperatura[] adtCuidadEstado = {new datosTemperatura(R.drawable.sunny, "Chihuahua", 25, "Soleado"),
            new datosTemperatura(R.drawable.sunny, "Cuauhtemoc", 20, "Soleado"),
            new datosTemperatura(R.drawable.cloudy, "Delicias", 28, "Nublado"),
            new datosTemperatura(R.drawable.rainy, "Parral", 27, "Lluvioso"),
            new datosTemperatura(R.drawable.cloudy, "Jimenez", 30, "Nublado"),
            new datosTemperatura(R.drawable.sunny, "Cuidad Juarez", 32, "Soleado"),
            new datosTemperatura(R.drawable.sunny, "Casa grandes", 31, "Soleado"),
            new datosTemperatura(R.drawable.light_rain, "Camargo", 18, "Lluvioso")};
    ListView listaClima;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaClima = (ListView)findViewById(R.id.listClima);
        listaClima.setAdapter(new climaAdapter(this, R.layout.clima, adtCuidadEstado));
        listaClima.setOnItemClickListener(this);
    }



    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent inMostrarDet = new Intent(this, ClimaDetalle.class);
        //Datos
        Bundle  bnDatos = new Bundle();
        bnDatos.putInt("IMAGEN", adtCuidadEstado[i].idImageClima);
        bnDatos.putString("CUIDAD", adtCuidadEstado[i].cuidad);
        bnDatos.putInt("TEMP", adtCuidadEstado[i].temperatura);
        bnDatos.putString("DESC", adtCuidadEstado[i].descripcionClima);
        inMostrarDet.putExtras(bnDatos);
        //lanzamos detalle
        startActivity(inMostrarDet);
    }
}

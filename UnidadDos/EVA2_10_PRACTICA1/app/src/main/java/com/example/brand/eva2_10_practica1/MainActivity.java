package com.example.brand.eva2_10_practica1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener {

    datosRestaurante[] restaurantes = {new datosRestaurante("Barrafina", "Rico y Delicioso", "Periferico de la juventud #123", "6142521234", R.drawable.barrafina),
            new datosRestaurante("Bourke Street Bakery", "Rico y Delicioso", "Periferico de la juventud #123", "6142521234", R.drawable.bourkestreetbakery),
            new datosRestaurante("Cafe Dead End", "Rico y Delicioso", "Periferico de la juventud #123", "6142521234", R.drawable.cafedeadend),
            new datosRestaurante("Cafe Loisl", "Rico y Delicioso", "Periferico de la juventud #123", "6142521234", R.drawable.cafeloisl),
            new datosRestaurante("Cafe Lore", "Rico y Delicioso", "Periferico de la juventud #123", "6142521234", R.drawable.cafelore),
            new datosRestaurante("Confessional", "Rico y Delicioso", "Periferico de la juventud #123", "6142521234", R.drawable.confessional),
            new datosRestaurante("Donostia", "Rico y Delicioso", "Periferico de la juventud #123", "6142521234", R.drawable.donostia),
            new datosRestaurante("Five Leaves", "Rico y Delicioso", "Periferico de la juventud #123", "6142521234", R.drawable.fiveleaves),
            new datosRestaurante("Forkee Restaurant", "Rico y Delicioso", "Periferico de la juventud #123", "6142521234", R.drawable.forkeerestaurant),
            new datosRestaurante("Grahama Venue Meats", "Rico y Delicioso", "Periferico de la juventud #123", "6142521234", R.drawable.grahamavenuemeats),
            new datosRestaurante("Haighs Chocolate", "Rico y Delicioso", "Periferico de la juventud #123", "6142521234", R.drawable.haighschocolate),
            new datosRestaurante("Homei", "Rico y Delicioso", "Periferico de la juventud #123", "6142521234", R.drawable.homei),
            new datosRestaurante("Palomino Espresso", "Rico y Delicioso", "Periferico de la juventud #123", "6142521234", R.drawable.palominoespresso),
            new datosRestaurante("Petite Oyster", "Rico y Delicioso", "Periferico de la juventud #123", "6142521234", R.drawable.petiteoyster),
            new datosRestaurante("Posatelier", "Rico y Delicioso", "Periferico de la juventud #123", "6142521234", R.drawable.posatelier),
            new datosRestaurante("Royal Oak", "Rico y Delicioso", "Periferico de la juventud #123", "6142521234", R.drawable.royaloak),
            new datosRestaurante("Teakha", "Rico y Delicioso", "Periferico de la juventud #123", "6142521234", R.drawable.teakha),
            new datosRestaurante("Thai Cafe", "Rico y Delicioso", "Periferico de la juventud #123", "6142521234", R.drawable.thaicafe),
            new datosRestaurante("Traif", "Rico y Delicioso", "Periferico de la juventud #123", "6142521234", R.drawable.traif),
            new datosRestaurante("Upstate", "Rico y Delicioso", "Periferico de la juventud #123", "6142521234", R.drawable.upstate),
            new datosRestaurante("Waffle Wolf", "Rico y Delicioso", "Periferico de la juventud #123", "6142521234", R.drawable.wafflewolf),
    };
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView)findViewById(R.id.listaRes);
        list.setAdapter(new resAdapter(this, R.layout.restaurante, restaurantes));
        list.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent inMostrarDet = new Intent(this, restauranteDetalle.class);
        //Datos
        Bundle  bnDatos = new Bundle();
        bnDatos.putInt("IMAGEN", restaurantes[i].imagen);
        bnDatos.putString("RESTAURANTE", restaurantes[i].nombreRestaurant);
        bnDatos.putString("DESC", restaurantes[i].descripcion);
        bnDatos.putString("DIRECCION", restaurantes[i].direccion);
        bnDatos.putString("TEL", restaurantes[i].telefono);
        inMostrarDet.putExtras(bnDatos);
        //lanzamos detalle
        startActivity(inMostrarDet);
    }
}

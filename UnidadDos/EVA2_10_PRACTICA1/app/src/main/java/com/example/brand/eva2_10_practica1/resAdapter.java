package com.example.brand.eva2_10_practica1;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Brand on 13/11/2017.
 */

public class resAdapter extends ArrayAdapter<datosRestaurante> {
    Context cnContexto;
    int iLayout;
    datosRestaurante[] dtDatosRestaurante;

    public resAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull datosRestaurante[] objects) {
        super(context, resource, objects);
        cnContexto = context;
        iLayout = resource;
        dtDatosRestaurante = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ImageView imgRes;
        TextView res, des;
        View vwFila = convertView;
        if (vwFila == null){//la lista se llen apr primera vez
            LayoutInflater liCrearLayout = ((Activity)cnContexto).getLayoutInflater();
            vwFila = liCrearLayout.inflate(iLayout, parent, false);
        }
        imgRes = (ImageView)vwFila.findViewById(R.id.imageView);
        res = (TextView) vwFila.findViewById(R.id.nomRes);
        des = (TextView)vwFila.findViewById(R.id.desRes);
        //llenar con datos
        imgRes.setImageResource(dtDatosRestaurante[position].imagen);
        res.setText(dtDatosRestaurante[position].nombreRestaurant);
        des.setText(dtDatosRestaurante[position].descripcion);
        return vwFila;
    }
}

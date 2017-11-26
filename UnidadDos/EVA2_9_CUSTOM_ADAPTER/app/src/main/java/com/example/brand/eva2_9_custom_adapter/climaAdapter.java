package com.example.brand.eva2_9_custom_adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Brand on 23/10/2017.
 */

public class climaAdapter extends ArrayAdapter<datosTemperatura> {
    Context cnContexto;
    int iLayout;
    datosTemperatura[] dtDatosClima;

    public climaAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull datosTemperatura[] objects) {
        super(context, resource, objects);
        cnContexto = context;
        iLayout = resource;
        dtDatosClima = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ImageView imgClima;
        TextView cuidad, des, temp;
        View vwFila = convertView;
        if (vwFila == null){//la lista se llen apr primera vez
            LayoutInflater liCrearLayout = ((Activity)cnContexto).getLayoutInflater();
            vwFila = liCrearLayout.inflate(iLayout, parent, false);
        }
        imgClima = (ImageView)vwFila.findViewById(R.id.imgClima);
        cuidad = (TextView) vwFila.findViewById(R.id.cuidadClima);
        des = (TextView)vwFila.findViewById(R.id.descripcion);
        temp = (TextView)vwFila.findViewById(R.id.temp);
        //llenar con datos
        imgClima.setImageResource(dtDatosClima[position].idImageClima);
        cuidad.setText(dtDatosClima[position].cuidad);
        des.setText(dtDatosClima[position].descripcionClima);
        temp.setText(dtDatosClima[position].temperatura + "°C" );
        return vwFila;
        //return super.getView(position, convertView, parent);
    }
}

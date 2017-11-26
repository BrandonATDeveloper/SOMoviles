package com.example.brand.eva2_13_practica2;

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
 * Created by Brand on 14/11/2017.
 */

public class asignaturaAdapter extends ArrayAdapter<datosAsignatura> {
    Context cnContexto;
    int iLayout;
    datosAsignatura[] dtDatosAsignatura;

    public asignaturaAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull datosAsignatura[] objects) {
        super(context, resource, objects);
        cnContexto = context;
        iLayout = resource;
        dtDatosAsignatura = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ImageView imgAsig;
        TextView asig;
        View vwFila = convertView;
        if (vwFila == null){//la lista se llen apr primera vez
            LayoutInflater liCrearLayout = ((Activity)cnContexto).getLayoutInflater();
            vwFila = liCrearLayout.inflate(iLayout, parent, false);
        }
        imgAsig = (ImageView)vwFila.findViewById(R.id.imageView2);
        asig = (TextView) vwFila.findViewById(R.id.asignatura);
        //llenar con datos
        imgAsig.setImageResource(dtDatosAsignatura[position].idimg);
        asig.setText(dtDatosAsignatura[position].asignatura);
        return vwFila;
    }
}

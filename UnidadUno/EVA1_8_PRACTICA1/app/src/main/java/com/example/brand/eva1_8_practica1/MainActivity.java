package com.example.brand.eva1_8_practica1;

import android.print.PrintManager;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener{

    RadioGroup Menu;
    RadioGroup Extras;
    Button Total;
    TextView Des;
    TextView lblTotal;
    CheckBox Azucar, Crema;
    EditText cantidad;
    int cafe, extra, total;
    String cafeDes = "cafe", cafeEx = "extra";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Menu = (RadioGroup)findViewById(R.id.Menu);
        Extras = (RadioGroup)findViewById(R.id.Extras);
        Menu.setOnCheckedChangeListener(this);
        Extras.setOnCheckedChangeListener(this);
        Azucar = (CheckBox)findViewById(R.id.Azucar);
        Crema = (CheckBox)findViewById(R.id.Crema);
        Total = (Button)findViewById(R.id.Total);
        cantidad = (EditText)findViewById(R.id.cantidad);
        cantidad.setText("1");
        Des = (TextView)findViewById(R.id.Descripcion);
        lblTotal = (TextView)findViewById(R.id.lblTotal);

    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        if(checkedId == R.id.Americano){
            cafe = 20;
            cafeDes = "Americano";
            Des.setText(cafeDes + " con " + cafeEx);
        }else if(checkedId == R.id.Expresso){
            cafe = 30;
            cafeDes = "Expresso";
            Des.setText(cafeDes + " con " + cafeEx);
        }else if(checkedId == R.id.Capuchino){
            cafe = 48;
            cafeDes = "Capuchino";
            Des.setText(cafeDes + " con " + cafeEx);
        }else{
            cafe = 0;
        }
    }

    @Override
    public void onClick(View v) {
        try {
            int valor = Integer.parseInt(cantidad.getText().toString());
            cantidad.setText("1");
            extra = 0;
            if (Azucar.isChecked()) {
                extra = 1;
                cafeEx = "Azucar";
                Des.setText(cafeDes + " con " + cafeEx);
                cafe = valor * cafe;
                extra = valor * extra;
                total = cafe + extra;
                Toast.makeText(this, "El total de su compra es: " + total, Toast.LENGTH_SHORT).show();
            } else if (Crema.isChecked()) {
                extra = 1;
                cafeEx = "Crema";
                Des.setText(cafeDes + " con " + cafeEx);
                cafe = valor * cafe;
                extra = valor * extra;
                total = cafe + extra;
                Toast.makeText(this, "El total de su compra es: " + total, Toast.LENGTH_SHORT).show();
            } else if (Azucar.isEnabled() && Crema.isEnabled()) {
                extra = 2;
                cafeEx = "Azucar y Crema";
                cafe = valor * cafe;
                extra = valor * extra;
                total = cafe + extra;
                Des.setText(cafeDes + " con " + cafeEx);
                Toast.makeText(this, "El total de su compra es: " + total, Toast.LENGTH_SHORT).show();
            } else {
                extra = 0;
                cafeEx = "Extra";
                total = cafe + extra;
                cafe = valor * cafe;
                extra = valor * extra;
                Des.setText(cafeDes + " con " + cafeEx);
                Toast.makeText(this, "El total de su compra es: " + total, Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e){
            Toast.makeText(this, "Asegurese de introducir la cantidad", Toast.LENGTH_SHORT).show();
        }
    }

}

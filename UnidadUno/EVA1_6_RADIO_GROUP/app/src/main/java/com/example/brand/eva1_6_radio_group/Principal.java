package com.example.brand.eva1_6_radio_group;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Principal extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    RadioGroup radioComida;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        radioComida = (RadioGroup)findViewById(R.id.radioComida);
        radioComida.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        if(checkedId == R.id.radioBurger){
            Toast.makeText(this, "Usted comera burgers", Toast.LENGTH_SHORT).show();
        }else if(checkedId == R.id.radioEnchiladas){
            Toast.makeText(this, "Usted comera Enchiladas", Toast.LENGTH_SHORT).show();
        }else if(checkedId == R.id.radioMontados){
            Toast.makeText(this, "Usted comera Montados", Toast.LENGTH_SHORT).show();
        }else if(checkedId == R.id.radioTortas){
            Toast.makeText(this, "Usted comera Tortas", Toast.LENGTH_SHORT).show();
        }

    }
}

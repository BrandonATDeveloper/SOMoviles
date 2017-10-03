package com.example.brand.eva1_9_practica2;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Principal extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{

    EditText año;
    RadioGroup Region, Genero;
    RadioButton regionDes, ameLat, asia, africa, hombre, mujer;
    TextView vida, deceso;
    int ultRegion = 0, ultGenre = 0, globalYears, globalBirth;
    int[] arrayDifGen = {10, 9, 8, 7, 6, 4};
    int[][] arreglo = new int[][]{
            {75, 60, 45, 35}, //50's
            {75, 65, 50, 45}, //60's
            {80, 70, 65, 55}, //70's
            {80, 75, 65, 60}, //80's
            {85, 75, 60, 55}, //90's
            {90, 70, 65, 60} //2000's
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        año = (EditText)findViewById(R.id.Año);
        Region = (RadioGroup)findViewById(R.id.region);
        Genero = (RadioGroup)findViewById(R.id.Genero);
        vida = (TextView)findViewById(R.id.expVida);
        deceso = (TextView)findViewById(R.id.fechaDes);
        regionDes = (RadioButton)findViewById(R.id.regionDes);
        ameLat = (RadioButton)findViewById(R.id.ameLan);
        asia = (RadioButton)findViewById(R.id.Asia);
        africa = (RadioButton)findViewById(R.id.Africa);
        hombre = (RadioButton)findViewById(R.id.Hombre);
        mujer = (RadioButton)findViewById(R.id.Mujer);
        Region.setOnCheckedChangeListener(this);
        Genero.setOnCheckedChangeListener(this);
        año.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                    calcularFecha(ultGenre, globalYears, ultRegion);
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        int years = 0, region = ultRegion, genre = ultGenre;

        //Sacar la región
        if (checkedId == R.id.regionDes) {
            region = 0;
        } else if (checkedId == R.id.ameLan) {
            region = 1;
        } else if (checkedId == R.id.Asia) {
            region = 2;
        } else if (checkedId == R.id.Africa) {
            region = 3;
        }

        //Para resolver cambios de region
        ultRegion = region;

        switch (checkedId) {
            case R.id.Hombre:
                genre = 0;
                break;
            case R.id.Mujer:
                genre = 1;
                break;
        }

        //Para resolver cambios de region y valores globales
        ultGenre = genre;
        globalYears = years;

        calcularFecha(genre, years, region);
    }

    public void calcularFecha(int genre, int years, int region) {
        int birth = Integer.parseInt(año.getText().toString());

        //Sacar la decada
        if ((1950 <= birth) && (birth <= 1959)) {
            years = 0;
        } else if ((1960 <= birth) && (birth <= 1969)) {
            years = 1;
        } else if ((1970 <= birth) && (birth <= 1979)) {
            years = 2;
        } else if ((1980 <= birth) && (birth <= 1989)) {
            years = 3;
        } else if ((1990 <= birth) && (birth <= 1999)) {
            years = 4;
        } else if ((2000 <= birth) && (birth <= 2010)) {
            years = 5;
        } else {
            Toast.makeText(this, "Introduce una fecha entre 1950 y 2010", Toast.LENGTH_SHORT).show();
        }

        globalBirth = birth;

        //"Funcion" para sacar la expactavida de vida
        int expVida = genre == 0 ? arreglo[years][region] - arrayDifGen[years] : arreglo[years][region] + arrayDifGen[years];

        //Para fecha de deceso -5 por el ejemplo
        int fecDec = birth + (expVida - 5);

        //Establecer textViews
        vida.setText("" + expVida);
        deceso.setText("" + fecDec);
    }

}

package com.example.brand.eva1_7_recursos;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Principal extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    TextView txtName, txtLname, txtAge;
    EditText editName, editLname, editAge;
    RadioGroup radioIdioma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        txtName = (TextView)findViewById(R.id.txtName);
        txtLname = (TextView)findViewById(R.id.textLname);
        txtAge = (TextView)findViewById(R.id.textAge);
        editName = (EditText)findViewById(R.id.editName);
        editLname = (EditText)findViewById(R.id.editLname);
        editAge = (EditText)findViewById(R.id.editAge);
        radioIdioma = (RadioGroup)findViewById(R.id.radioIdioma);
        radioIdioma.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        if(R.id.radioEs == checkedId){
            txtName.setText(R.string.nom_lbl);
            txtLname.setText(R.string.ape_lbl);
            txtAge.setText(R.string.edad_lbl);
            editName.setText(R.string.nom_hint);
            editLname.setText(R.string.ape_hint);
            editAge.setText(R.string.edad_hint);
        }else{
            txtName.setText(R.string.nom_lbl_en);
            txtLname.setText(R.string.ape_lbl_en);
            txtAge.setText(R.string.edad_lbl_en);
            editName.setText(R.string.nom_hint_en);
            editLname.setText(R.string.ape_hint_en);
            editAge.setText(R.string.edad_hint_en);
        }
    }
}

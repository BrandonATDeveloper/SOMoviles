package com.example.brand.eva1_14_orientation_login;

import android.content.res.Configuration;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class Principal extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    EditText edtTxtNombre, edtTxtApellido, edtTxtEdad, edtTxtOrganizacion, edtTxtCorreo;
    RadioGroup Sexo;
    RadioButton Hombre, Mujer;
    Button Agregar;

    String sexoGlobal = "Indefindo";
    boolean match = false;

    ArrayList<Datos> listaDatos = new ArrayList<Datos>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int display_mode = getResources().getConfiguration().orientation;
        if (display_mode == Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.activity_principal);
            conexionWidgets();
        } else {
            setContentView(R.layout.landscape);
            conexionWidgets();
        }

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            setContentView(R.layout.activity_principal);
            conexionWidgets();
        }else if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.landscape);
            conexionWidgets();
        }
    }

    public void conexionWidgets() {
        edtTxtNombre = (EditText) findViewById(R.id.edtTxtNombre);
        edtTxtApellido = (EditText) findViewById(R.id.edtTxtApellido);
        edtTxtEdad = (EditText) findViewById(R.id.edtTxtEdad);
        edtTxtOrganizacion = (EditText) findViewById(R.id.edtTxtOrganizacion);
        edtTxtCorreo = (EditText) findViewById(R.id.edtTxtCorreo);
        Sexo = (RadioGroup) findViewById(R.id.Sexo);
        Hombre = (RadioButton) findViewById(R.id.Hombre);
        Mujer = (RadioButton) findViewById(R.id.Mujer);
        Agregar = (Button) findViewById(R.id.Agregar);
        Sexo.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        if (checkedId == R.id.Hombre) {
            sexoGlobal = "Hombre";
        } else if (checkedId == R.id.Mujer) {
            sexoGlobal = "Mujer";
        } else {
            sexoGlobal = "Indefinido";
        }
    }

    public void guardarDatos(View v) {

        String nombreG = edtTxtNombre.getText().toString(),
                apellidoG = edtTxtApellido.getText().toString(),
                orgG = edtTxtOrganizacion.getText().toString(),
                correoG = edtTxtCorreo.getText().toString(),
                sexoG = sexoGlobal;

        int edadG;
        String editTextEdad = edtTxtEdad.getText().toString();
        if (TextUtils.isEmpty(editTextEdad)) {
            edadG = 0;
        } else {
            edadG = Integer.parseInt(editTextEdad);
        }

//        Log.e("Nombre: ", nombreG);
//        Log.e("Apellido: ", apellidoG);
//        Log.e("Org: ", orgG);
//        Log.e("Correo: ", correoG);
//        Log.e("Sexo: ", sexoG);
//        Log.e("Edad: ", "" + edadG);

        for (Datos datos : listaDatos) {
            String string = datos.toString();
//            Log.e("Correo", correoG);
            if (match == false) {
                match = string.contains(correoG);
            } else {
                match = true;
            }
//            Log.e("Match", ""+match);
//            Log.e("String", string);
//            Log.e("Separador", "-----------------------");
        }

//        Datos datoARegistrar = new Datos(nombreG, apellidoG, orgG, correoG, sexoG, edadG);
//        listaDatos.add(datoARegistrar);
        if (isValidEmail(correoG) == true) {
            if (match == false) {
                listaDatos.add(new Datos(nombreG, apellidoG, orgG, correoG, sexoG, edadG));
                Toast.makeText(this, "Cantidad de registros guardados: " + listaDatos.size(), Toast.LENGTH_SHORT).show();
                reiniciarCaptura();
            } else {
                Toast.makeText(this, "Correo ya registrado, ingresar otro", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "Cantidad de registros guardados: " + listaDatos.size(), Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Correo no valido, ejemplo correo@servidor.dominio", Toast.LENGTH_SHORT).show();
        }

        //Log para verificar ArrayList
//        for (Datos d:listaDatos){
//            Log.e("Datos", d.toString());
//        }
    }

    public final static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    private void reiniciarCaptura() {
        edtTxtNombre.setText("");
        edtTxtApellido.setText("");
        edtTxtOrganizacion.setText("");
        edtTxtCorreo.setText("");
        Sexo.clearCheck();
        edtTxtEdad.setText("");
    }
}

    class Datos {
        String nombre, apellido, org, correo, sexo;
        int edad;

        Datos(String nombre, String apellido, String org, String correo, String sexo, int edad) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.org = org;
            this.correo = correo;
            this.sexo = sexo;
            this.edad = edad;
        }

        //Para facilitar el Log
        @Override
        public String toString() {
    //        return "Datos[nombre="+nombre+", apellido="+apellido+", org="+org+", correo="+correo+", sexo="+sexo+", edad="+edad+"]";
            return nombre + "," + apellido + "," + edad + "," + org + "," + correo + "," + sexo;
        }
}

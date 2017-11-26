package com.example.brand.eva_3_intentos_paso_parametros;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Principal extends AppCompatActivity {

    EditText pNumber, msg;
    Button exe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        pNumber = (EditText)findViewById(R.id.phoneNumber);
        msg = (EditText)findViewById(R.id.msg);
        exe = (Button)findViewById(R.id.button);
    }

    public void miClick(View v){
        //smsto: [Telefono]
        String sTel = "smsto:" + pNumber.getText().toString();
        String sMes = msg.getText().toString();
        Intent inEnviarSMS = new Intent(Intent.ACTION_SENDTO, Uri.parse(sTel));
        //Extra ara el mensaje
        inEnviarSMS.putExtra("sms_body",sMes);
        startActivity(inEnviarSMS);
    }

}

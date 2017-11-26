package com.example.brand.eva3_7_asynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = (TextView)findViewById(R.id.txt);
        miClase mcaMiObjAisn = new miClase();
        mcaMiObjAisn.execute(100, 200);
    }

    private class miClase extends AsyncTask<Integer, String, Void>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            txt.setText("Iniciando Nuestra Tarea");
        }

        @Override
        protected Void doInBackground(Integer... integers) {
            int start = integers[0];
            int fin = integers[1];
            for (int i=start; i < fin; i++){
                try{
                    Thread.sleep(300);
                    publishProgress(i + " - ");
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            txt.append(values[0]);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }

}

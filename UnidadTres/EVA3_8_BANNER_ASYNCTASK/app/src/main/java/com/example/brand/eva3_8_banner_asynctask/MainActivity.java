package com.example.brand.eva3_8_banner_asynctask;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int iNoImg = 0;
    ImageView image;
    SeekBar sk;
    Handler hnBanner = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (iNoImg){
                case 0:
                    image.setImageResource(R.drawable.f1);
                    iNoImg++;
                    break;
                case 1:
                    image.setImageResource(R.drawable.f2);
                    iNoImg++;
                    break;
                case 2:
                    image.setImageResource(R.drawable.f3);
                    iNoImg = 0;
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = (ImageView) findViewById(R.id.img);
        sk = (SeekBar) findViewById(R.id.seek);
    }

    private class myClass extends AsyncTask<Integer, String, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(MainActivity.this, "INICIANDO TAREA", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected Void doInBackground(Integer... integers) {
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }
}

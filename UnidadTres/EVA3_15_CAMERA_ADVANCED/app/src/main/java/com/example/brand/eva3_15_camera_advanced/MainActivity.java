package com.example.brand.eva3_15_camera_advanced;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Spinner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public static final int MEDIA_TYPE_IMAGE = 1;
    int tiempo = 0;

    int PERMISSION_ALL = 1;
    String[] PERMISSIONS = {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA};

    private static Camera c;
    private CameraPreview mPreview;
    private Camera.PictureCallback mPicture = new Camera.PictureCallback() {
        @Override
        public void onPictureTaken(byte[] data, Camera camera) {
            File picFile = getOutputMediaFile(MEDIA_TYPE_IMAGE);
            try {
                FileOutputStream fos = new FileOutputStream(picFile);
                fos.write(data);
                fos.close();
            } catch (FileNotFoundException e) {
                Log.e("FileNotFoundEx", "File not found: " + e.getMessage());
                e.getStackTrace();
            } catch (IOException e) {
                Log.e("IOEx", "I/O error writing file: " + e.getMessage());
                e.getStackTrace();
            }
        }
    };

    FrameLayout camera_preview;
    Button btn;
    Spinner spn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (checkCameraHardware(this)) {
            if (hasPermissions(this, PERMISSIONS)) {
                /** A safe way to get an instance of the Camera object. */
                initCamera();
            }
        } else {
            ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_ALL);
        }
    }

    /**
     * Check if this device has a camera
     */
    private boolean checkCameraHardware(Context context) {
        if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
            // this device has a camera
            return true;
        } else {
            // no camera on this device
            return false;
        }
    }

    public static Camera getCameraInstance() {
        Camera c = null;
        try {
            c = Camera.open(); //intentando pbtener una instancia de Camera
        } catch (Exception e) {
        }
        return c;
    }

    void initCamera() {
        c = getCameraInstance();

        mPreview = new CameraPreview(this, c);
        camera_preview = (FrameLayout) findViewById(R.id.frameCamera);
        camera_preview.addView(mPreview);

        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //						c.takePicture(null, null, mPicture);
                TimerTask timerTask = new TimerTask() {
                    @Override
                    public void run() {
                        TareaAsync asyncTakePhoto = new TareaAsync();
                        asyncTakePhoto.execute();
                        cancel();
                    }
                };

                Timer hacerTimer = new Timer();
                hacerTimer.schedule(timerTask, tiempo * 1000);

            }
        });
        spn = (Spinner) findViewById(R.id.spn);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.timer, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn.setAdapter(adapter);
        spn.setOnItemSelectedListener(this);
    }

    private File getOutputMediaFile(int type) {
        // To be safe, you should check that the SDCard is mounted
        // using Environment.getExternalStorageState() before doing this.

        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DCIM), getPackageName());
        // This location works best if you want the created images to be shared
        // between applications and persist after your app has been uninstalled.

        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                Log.d("MyCameraApp", "failed to create directory");
                return null;
            }
        }

        // Create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File mediaFile;
        if (type == MEDIA_TYPE_IMAGE) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                    "MAGR_IMG_" + timeStamp + ".jpg");
        } else {
            return null;
        }
        return mediaFile;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (c == null) {
            initCamera();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPreview.getHolder().removeCallback(mPreview);
        releaseCamera();
    }

    private void releaseCamera() {
        if (c != null) {
            c.stopPreview();
            c.release();
            c = null;
        }
    }

    public static boolean hasPermissions(Context context, String... permissions) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }

    class TareaAsync extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            c.takePicture(null, null, mPicture);

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            c.stopPreview();
            c.startPreview();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                tiempo = 0;
                break;
            case 1:
                tiempo = 3;
                break;
            case 2:
                tiempo = 5;
                break;
            case 3:
                tiempo = 7;
                break;
            default:
                tiempo = 0;
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        tiempo = 0;
    }

}

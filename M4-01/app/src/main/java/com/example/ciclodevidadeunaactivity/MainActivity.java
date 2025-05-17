package com.example.ciclodevidadeunaactivity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "CicloDeVida";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate() ejecutado - Actividad creada");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() ejecutado - Actividad visible");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() ejecutado - Actividad interactiva");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() ejecutado - La actividad está pausada");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() ejecutado - La actividad ya no está visible");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart() ejecutado - La actividad se está reiniciando");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() ejecutado - La actividad está siendo destruida");
    }
}

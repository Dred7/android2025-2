package com.example.calculadora1902;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnReinicio;
    TextView txvMiTexto;
    String cadena = "";

     int numero1 = 0;
    int numero2 = 1;
    int resultado = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //Log.println(Log.INFO, null, "oncrete savedInstanceState, Persistance");
        txvMiTexto = findViewById(R.id.txv_main);
        btnReinicio = findViewById(R.id.btn_reinicio);
        btnReinicio.setOnClickListener(this);

        /*cadena += "\n| onCreate()";
        txvMiTexto.setText(cadena);*/
    }

    /*@Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        Log.println(Log.INFO, null, "onCrete");
        cadena += "\n| onCreate(savedInstance, persistaentState)";
        txvMiTexto.setText(cadena);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.println(Log.INFO, null, "onStart");
        cadena += "\n| onStart()";
        txvMiTexto.setText(cadena);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.println(Log.INFO, null, "onPause");
        cadena += "\n| onPause()";
        txvMiTexto.setText(cadena);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.println(Log.INFO, null, "onStop");
        cadena += "\n| onStop()";
        txvMiTexto.setText(cadena);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.println(Log.INFO, null, "onDestroy");
        cadena += "\n| onDestroy()";
        txvMiTexto.setText(cadena);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.println(Log.INFO, null, "onRestart");
        cadena += "\n| onRestart()";
        txvMiTexto.setText(cadena);
    }*/

    @Override
    public void onClick(View v) {

        resultado = numero1 + numero2;
        numero1 = numero2;
        numero2 = resultado;
        txvMiTexto.setText(cadena + resultado);
    }
}
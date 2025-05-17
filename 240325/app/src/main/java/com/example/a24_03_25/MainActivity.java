package com.example.a24_03_25;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnAgrega1, btnAgrega2;
    LinearLayout root, root2;

    int contador = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //inflado de vistas, es agarrar un xml desde un java y le agregamos contenido
        setContentView(R.layout.activity_main);
        root = findViewById(R.id.lytMain);
        root2 = findViewById(R.id.lytMain2);

        btnAgrega1 = findViewById(R.id.btnAgrega1);
        btnAgrega2 = findViewById(R.id.btnAgrega2);
        btnAgrega1.setOnClickListener(v -> {
            generaImagen1();
        });
        btnAgrega2.setOnClickListener(v -> {
            generaImagen2();
        });
    }
    void generaImagen1(){
        LinearLayout lytIzq = (LinearLayout) LinearLayout.inflate(this, R.layout.item_izquierda, null);
        Button izq = new Button(this);
        izq.setMinimumHeight(100);
        izq.setMinimumWidth(MATCH_PARENT);
        izq.setText("" + contador);
        contador++;

        lytIzq.addView(izq);
        //se agrega layout a la vista root
        root.addView(lytIzq);
        lytIzq.setMinimumWidth(MATCH_PARENT);
        lytIzq.setBackgroundColor(getResources().getColor(R.color.naranja, getTheme()));
    }

    void generaImagen2(){
        LinearLayout lytIzq = (LinearLayout) LinearLayout.inflate(this, R.layout.item_derecha, null);
        Button izq = new Button(this);
        izq.setMinimumHeight(100);
        izq.setMinimumWidth(MATCH_PARENT);
        izq.setText("" + contador);
        contador++;

        lytIzq.addView(izq);
        //se agrega layout a la vista root
        root2.addView(lytIzq);
        lytIzq.setMinimumWidth(MATCH_PARENT);
        lytIzq.setBackgroundColor(getResources().getColor(R.color.naranja, getTheme()));
    }

}
package com.example.centraldeaviones;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private ControladorColision controlador;
    private TextView txtPaso, txtColisiones;
    private GridLayout grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controlador = new ControladorColision();

        controlador.agregarAvion(new Avion(2, 2, Direccion.DERECHA));
        controlador.agregarAvion(new Avion(4, 2, Direccion.IZQUIERDA));
        controlador.agregarAvion(new Avion(7, 2, Direccion.DERECHA));
        controlador.agregarAvion(new Avion(6, 2, Direccion.IZQUIERDA));
        controlador.agregarAvion(new Avion(5, 2, Direccion.DERECHA));
        controlador.agregarAvion(new Avion(3, 2, Direccion.DERECHA));
        controlador.agregarAvion(new Avion(8, 2, Direccion.IZQUIERDA));


        txtPaso = findViewById(R.id.txtPaso);
        txtColisiones = findViewById(R.id.txtColisiones);
        grid = findViewById(R.id.grid);

        findViewById(R.id.btnSiguiente).setOnClickListener(v -> {
            controlador.siguientePaso();
            actualizarVista();
        });

        findViewById(R.id.btnAnterior).setOnClickListener(v -> {
            controlador.pasoAnterior();
            actualizarVista();
        });

        actualizarVista();
    }

    private void actualizarVista() {
        txtPaso.setText("Paso: " + controlador.pasos);
        txtColisiones.setText("Colisiones: " + controlador.colisiones);

        grid.removeAllViews();

        for (int i = 0; i < 100; i++) {
            TextView cell = new TextView(this);
            cell.setLayoutParams(new ViewGroup.LayoutParams(100, 100));
            cell.setBackgroundColor(Color.WHITE);
            grid.addView(cell);
        }

        for (Avion avion : controlador.aviones) {
            int index = avion.y * 10 + avion.x;
            if (index >= 0 && index < 100) {
                TextView cell = (TextView) grid.getChildAt(index);
                cell.setBackgroundColor(Color.BLUE);
            }
        }
    }
}

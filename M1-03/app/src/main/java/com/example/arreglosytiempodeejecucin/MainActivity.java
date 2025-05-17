package com.example.arreglosytiempodeejecucin;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity"; // Para el logcat

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Llamamos al método para realizar las actividades
        ejecutarTarea();
    }

    private void ejecutarTarea() {
        int[] arreglo = new int[1_000_000]; // Arreglo con 1 millón de elementos

        // Generar números aleatorios
        Random random = new Random();
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = random.nextInt();
        }

        // Medir tiempo antes de ordenar
        long inicio = System.currentTimeMillis();

        // Ordenar el arreglo
        Arrays.sort(arreglo);

        // Medir tiempo después de ordenar
        long fin = System.currentTimeMillis();
        long tiempoTotal = fin - inicio;

        // Imprimir resultados en logcat
        Log.d(TAG, "Tiempo de ordenamiento: " + tiempoTotal + " milisegundos");
        Log.d(TAG, "Primer elemento ordenado: " + arreglo[0]);
        Log.d(TAG, "Último elemento ordenado: " + arreglo[arreglo.length - 1]);
    }
}

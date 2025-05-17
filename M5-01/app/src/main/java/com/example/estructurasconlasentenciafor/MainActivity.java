package com.example.estructurasconlasentenciafor;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "FibonacciApp";
    private int posicion = 0;
    private final HashMap<Integer, Long> memo = new HashMap<>();

    private TextView tvFibonacci;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvFibonacci = findViewById(R.id.tvFibonacci);
        Button btnAvance = findViewById(R.id.btnAvance);
        Button btnRetroceso = findViewById(R.id.btnRetroceso);

        // Iniciar en posición 0
        actualizarTexto();

        btnAvance.setOnClickListener(v -> {
            posicion++;
            actualizarTexto();
        });

        btnRetroceso.setOnClickListener(v -> {
            if (posicion > 0) {
                posicion--;
                actualizarTexto();
            }
        });
    }

    // Actualiza el TextView con el valor actual de Fibonacci
    private void actualizarTexto() {
        long valor = fibonacci(posicion);
        tvFibonacci.setText(String.valueOf(valor));
        Log.d(TAG, "Posición: " + posicion + " => Fibonacci: " + valor);
    }

    // Cálculo de Fibonacci con memoization y recursividad
    private long fibonacci(int n) {
        if (n <= 1) return 1;

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        long resultado = fibonacci(n - 1) + fibonacci(n - 2);
        memo.put(n, resultado);
        return resultado;
    }
}

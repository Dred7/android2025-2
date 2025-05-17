package com.example.miprimercalculadoraenandroidstudio;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Calculadora";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        double a = 10.0;
        double b = 10; // prueba división por 0 y NaN
        char operador = '*';

        double resultado = calcular(a, b, operador);

        if (Double.isNaN(resultado)) {
            Log.e(TAG, "Resultado inválido (NaN)");
        } else {
            Log.d(TAG, "Resultado: " + resultado);
        }
    }

    // Método principal de cálculo
    private double calcular(double x, double y, char op) {
        double resultado;

        switch (op) {
            case '+':
                resultado = x + y;
                break;
            case '-':
                resultado = x - y;
                break;
            case '*':
                resultado = x * y;
                break;
            case '/':
                resultado = (y != 0) ? x / y : Double.NaN;
                break;
            default:
                Log.e(TAG, "Operador inválido");
                return Double.NaN;
        }

        return resultado;
    }
}

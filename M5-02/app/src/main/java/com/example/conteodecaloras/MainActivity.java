package com.example.conteodecaloras;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "ConteoCalorias";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        procesarArchivoCalorias();
    }

    private void procesarArchivoCalorias() {
        int maxCalorias = 0;
        int caloriasActuales = 0;

        try {
            InputStream is = getAssets().open("input.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String linea;

            while ((linea = reader.readLine()) != null) {
                if (linea.trim().isEmpty()) {
                    if (caloriasActuales > maxCalorias) {
                        maxCalorias = caloriasActuales;
                    }
                    caloriasActuales = 0;
                } else {
                    caloriasActuales += Integer.parseInt(linea.trim());
                }
            }

            // Verificar el último grupo
            if (caloriasActuales > maxCalorias) {
                maxCalorias = caloriasActuales;
            }

            reader.close();
            Log.d(TAG, "El elfo con más calorías lleva un total de: " + maxCalorias);

        } catch (IOException e) {
            Log.e(TAG, "Error al leer el archivo", e);
        } catch (NumberFormatException e) {
            Log.e(TAG, "Error al convertir a número", e);
        }
    }
}


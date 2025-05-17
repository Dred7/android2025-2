package com.example.a19_03_25;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ImageView[][] casillas = new ImageView[3][3]; // Matriz para las casillas
    int[][] tablero = new int[3][3]; // 0 = vacío, 1 = jugador 1 (círculo), 2 = jugador 2 (equis)
    boolean jugador = true; // true = jugador 1, false = jugador 2
    int turnos = 0; // Contador de turnos para verificar empate


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Inicializar casillas y asignar eventos
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String idName = "img" + (i * 3 + j + 1); // Genera "img1", "img2", ..., "img9"
                @SuppressLint("DiscouragedApi") int resID = getResources().getIdentifier(idName, "id", getPackageName());
                casillas[i][j] = findViewById(resID);

                int finalI = i, finalJ = j; // Variables finales para el lambda
                casillas[i][j].setOnClickListener(v -> marcarCasilla(finalI, finalJ));
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Función para marcar una casilla
    private void marcarCasilla(int i, int j) {
        if (tablero[i][j] == 0) { // Solo permite marcar si está vacía
            if (jugador) {
                casillas[i][j].setImageResource(R.drawable.baseline_circle_24);
                tablero[i][j] = 1; // Jugador 1
            } else {
                casillas[i][j].setImageResource(R.drawable.baseline_clear_24);
                tablero[i][j] = 2; // Jugador 2
            }

            turnos++; // Aumentar contador de turnos
            if (verificarGanador()) {
                String ganador = jugador ? "Jugador 1" : "Jugador 2";
                Toast.makeText(this, ganador + " ha ganado!", Toast.LENGTH_LONG).show();
                //reiniciarJuego();
            } else if (turnos == 9) { // Si se han jugado 9 turnos y no hay ganador, es empate
                Toast.makeText(this, "¡Empate!", Toast.LENGTH_LONG).show();
                //reiniciarJuego();
            } else {
                jugador = !jugador; // Cambia de turno
            }
        }
    }

    // Función para verificar si hay un ganador
    private boolean verificarGanador() {
        for (int i = 0; i < 3; i++) {
            // Revisar filas y columnas
            if ((tablero[i][0] == tablero[i][1] && tablero[i][1] == tablero[i][2] && tablero[i][0] != 0) ||
                    (tablero[0][i] == tablero[1][i] && tablero[1][i] == tablero[2][i] && tablero[0][i] != 0)) {
                return true;
            }
        }

        // Revisar diagonales
        if ((tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2] && tablero[0][0] != 0) ||
                (tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0] && tablero[0][2] != 0)) {
            return true;
        }

        return false;
    }

    // Función para reiniciar el juego
    private void reiniciarJuego() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = 0; // Reiniciar tablero
                casillas[i][j].setImageResource(0); // Borrar imágenes
            }
        }
        turnos = 0; // Reiniciar contador de turnos
        jugador = true; // Reiniciar al jugador 1
    }
}

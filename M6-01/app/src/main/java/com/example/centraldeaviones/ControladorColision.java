package com.example.centraldeaviones;

import java.util.*;

public class ControladorColision {
    public List<Avion> aviones = new ArrayList<>();
    private Stack<List<Avion>> historial = new Stack<>();
    public int pasos = 0;
    public int colisiones = 0;

    public void agregarAvion(Avion avion) {
        aviones.add(avion);
    }

    public void siguientePaso() {
        pasos++;

        // Guardar copia profunda
        List<Avion> copia = new ArrayList<>();
        for (Avion avion : aviones) {
            copia.add(new Avion(avion.x, avion.y, avion.direccion));
        }
        historial.push(copia);

        Map<String, Integer> posiciones = new HashMap<>();
        for (Avion avion : aviones) {
            avion.mover();
            String key = avion.x + "," + avion.y;
            posiciones.put(key, posiciones.getOrDefault(key, 0) + 1);
        }

        for (int valor : posiciones.values()) {
            if (valor > 1) colisiones++;
        }
    }

    public void pasoAnterior() {
        if (!historial.isEmpty()) {
            aviones = historial.pop();
            pasos--;
        }
    }
}



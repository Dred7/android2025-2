package com.example.centraldeaviones;

public class Avion {
    public int x, y;
    public Direccion direccion;

    public Avion(int x, int y, Direccion direccion) {
        this.x = x;
        this.y = y;
        this.direccion = direccion;
    }

    public void mover() {
        switch (direccion) {
            case ARRIBA: y--; break;
            case ABAJO: y++; break;
            case IZQUIERDA: x--; break;
            case DERECHA: x++; break;
        }
    }
}

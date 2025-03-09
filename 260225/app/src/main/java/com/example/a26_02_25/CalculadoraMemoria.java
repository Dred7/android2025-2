package com.example.a26_02_25;

public class CalculadoraMemoria implements ICalcudoraMemoria {

    String display = "";

    Operacion operacion;

    @Override
    public String concat(String numero) {
        display += numero;
        return display;
    }

    @Override
    public String concat(Operacion operacion) {
        this.operacion = operacion;
        return Operacion.convert(operacion);
    }

    @Override
    public void clear() {
        display = "";
        operacion = null;
    }
}
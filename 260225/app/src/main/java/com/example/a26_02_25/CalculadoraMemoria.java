package com.example.a26_02_25;

import java.math.BigDecimal;

public class CalculadoraMemoria implements ICalcudoraMemoria {
    private String display = "";

    private Operacion operacion;

    private BigDecimal x;

    private BigDecimal y;

    public String cambiarSigno(){
        if(!display.isEmpty()){
            BigDecimal numero = new BigDecimal(display);
            numero = numero.negate();
            display = numero.toString();
        }
        return display;
    }

    @Override
    public String concat(String numero) {

        if (numero.equals(".")){
            if (display.contains(".")){
                return display;
            }

            if (display.isEmpty()){
                display = "0";
            }
        }

        display += numero;
        return display;
    }

    @Override
    public String concat(Operacion operacion) {
        if(display.isEmpty()){
            throw new CalculadoraException("0");
        }
        this.operacion = operacion;
        this.x = BigDecimal.valueOf(Long.parseLong(display));
        this.display = "";
        return "";//Operacion.convert(operacion);
    }

    @Override
    public Operacion getOperacion() {
        return operacion;
    }

    @Override
    public BigDecimal getX() {
        return x;
    }

    @Override
    public BigDecimal getY() {
        return y;
    }

    @Override
    public void clear() {
        display = "";
        operacion = Operacion.NONE;
        x = BigDecimal.ZERO;
        y = BigDecimal.ZERO;
    }

    @Override
    public void igual() {
        if(display.isEmpty()){
            throw new CalculadoraException("0");
        }
        try{
            this.y = BigDecimal.valueOf(Long.parseLong(display));
        }catch (NumberFormatException e){
            throw new CalculadoraException("0");
        }
    }
}
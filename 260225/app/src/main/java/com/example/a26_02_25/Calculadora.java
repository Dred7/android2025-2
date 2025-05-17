package com.example.a26_02_25;

import java.math.BigDecimal;

public class Calculadora implements ICalculadora {
    @Override
    public BigDecimal calculate(Operacion operacion, BigDecimal x, BigDecimal y) {
        switch (operacion){
            case SUMA:
                return x.add(y);
            case RESTA:
                return x.subtract(y);
            case MULT:
                return x.multiply(y);
            case DIV:
                if(y.compareTo(BigDecimal.ZERO) == 0){
                    throw new CalculadoraException("Ideterminado");
                }
                return x.divide(y);
            case PORC:
                return x.multiply(y).divide(BigDecimal.valueOf(100));
        }
        return BigDecimal.ZERO;
    }
}

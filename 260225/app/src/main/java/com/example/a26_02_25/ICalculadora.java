package com.example.a26_02_25;

import java.math.BigDecimal;

public interface ICalculadora {

    BigDecimal calculate(Operacion operacion, BigDecimal x, BigDecimal y);
}
package com.example.a26_02_25;

import java.math.BigDecimal;

public interface ICalcudoraMemoria {

    String concat(String numero);

    String concat(Operacion operacion);

    Operacion getOperacion();

    BigDecimal getX();

    BigDecimal getY();

    void clear();

    void igual();

    String cambiarSigno();
}

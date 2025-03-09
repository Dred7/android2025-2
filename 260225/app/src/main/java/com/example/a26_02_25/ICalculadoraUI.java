package com.example.a26_02_25;

public interface ICalculadoraUI {

    void clearScreen();
    void showResult(String result);

    String addNumber(String numero);

    void addOperation(Operacion operacion);
}

import java.io.*;
class Main{
	public static void main(String [] args){
		Operacion op = new Operacion(10.0, 10.0, Operando.SUMA);
		ICalculadora calculadora = new CalculadoraImpl();
		Double resultado = calculadora.calcular(op);
		System.out.println("Resultado:" + resultado);
	}
}

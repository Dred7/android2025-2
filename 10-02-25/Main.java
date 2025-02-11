import java.io.*;
import java.util.Scanner;

class Main{
	public static void main(String [] args){
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Ingresa el primer numero: ");
		double num1 = scanner.nextDouble();

		System.out.println("Ingrese el segundo numero: ");
		double num2 = scanner.nextDouble();
		
		System.out.println("Que operacion deseas realizar(SUMA, RESTA, DIV, MULT): ");
		String operacionStr = scanner.next().toUpperCase();

		Operando operacion = Operando.valueOf(operacionStr);

		Operacion op = new Operacion(num1, num2, operacion);
		ICalculadora calculadora = new CalculadoraImpl();
		Double resultado = calculadora.calcular(op);
		System.out.println("Resultado:" + resultado);

		scanner.close();
	}
}

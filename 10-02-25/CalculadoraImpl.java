class CalculadoraImpl implements ICalculadora {

	public Double calcular(Operacion operacion){
		switch (operacion.getOperando()) {
			case SUMA:
				return operacion.getx1() + operacion.getx2();
			case RESTA:
				return operacion.getx1() - operacion.getx2();
			case DIV:
				return operacion.getx1() / operacion.getx2();
			case MULT:
				return operacion.getx1() * operacion.getx2();
			default:
				return 0.0;
		}
	}
}

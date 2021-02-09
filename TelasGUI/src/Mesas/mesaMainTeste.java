package Mesas;

public class mesaMainTeste {

	public static void main(String[] args) {
		ControleMesa cm = new ControleMesa();
		Mesa p = new Mesa(3,4);
		cm.cadrastarMesas(p);
		System.out.println(cm.listarMesas());
	}

}

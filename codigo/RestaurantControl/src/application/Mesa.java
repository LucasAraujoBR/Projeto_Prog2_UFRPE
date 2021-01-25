package application;

import java.util.ArrayList;

public class Mesa {
	
	public Pedido pedido = new Pedido();
	private boolean mesaOcupada;
	private int numeroMesa;
	
	public Mesa() {
		numeroMesa = 0;
		mesaOcupada = false;
	}
	
	public boolean verificarDisponibilidade() {
		return mesaOcupada;
	}
	
	public double conta() {
		return valorConta;
	}
	
	public String relatorioMesas(){
		
	}
	
	
	public int getNumeroMesa() {
		return numeroMesa;
	}

	

}

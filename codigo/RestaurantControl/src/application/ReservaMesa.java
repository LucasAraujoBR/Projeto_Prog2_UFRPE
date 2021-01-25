package application;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ReservaMesa extends Mesa {

	private boolean disponivel;
	private LocalDateTime data;
	private int numeroMesa;
	private int qtdPessoas;
	private ArrayList<String> reservas;
	private String nomeReserva;
	
	public boolean verificarDisponibilidade() {
		return this.mesaOcupada;
	}
	
	public void adicionarReserva() {
		
	}
	
	public void cancelarReserva() {
		
	}
	
	
	
}
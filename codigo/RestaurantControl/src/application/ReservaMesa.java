package application;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ReservaMesa extends Mesa {

	private boolean disponivel;
	private LocalDateTime data;
	private int numeroMesa;
	private int qtdPessoas;
	private ArrayList<ReservaMesa> reservas;
	private String nomeReserva;
	
	public ReservaMesa() {
		nomeReserva = "fulano";
		numeroMesa = 0;
	}
	public ReservaMesa(String nome, int numero) {
		nomeReserva = nome;
		numeroMesa = numero;
	}
	
	public boolean verificarDisponibilidade() {
		return this.mesaOcupada;
	}
	
	public void adicionarReserva(ReservaMesa reserva) {
		if (!reservas.contains(this.numeroMesa))reservas.add(reserva);
		else System.out.println("A mesa "+this.numeroMesa+" já foi reservada.");
	}
	
	public void cancelarReserva(ReservaMesa reserva) {
		if (reservas.contains(reserva)) reservas.remove(reserva);
	}
	
	public String toString() {
		String string = "";
		for (ReservaMesa 
		
	}
	
	
	
	
}
package Restaurante;



public class ReservaMesa {
	
	
	private int numeroMesa;
	private int qtdPessoas;
	private String nomeReserva;
	
	public ReservaMesa(int qtdPessoas, String nomeReserva) {
		this.qtdPessoas = qtdPessoas;
		this.nomeReserva = nomeReserva;
	}

	public int getNumeroMesa() {
		return numeroMesa;
	}

	public void setNumeroMesa(int numeroMesa) {
		this.numeroMesa = numeroMesa;
	}

	public int getQtdPessoas() {
		return qtdPessoas;
	}

	public void setQtdPessoas(int qtdPessoas) {
		this.qtdPessoas = qtdPessoas;
	}

	public String getNomeReserva() {
		return nomeReserva;
	}

	public void setNomeReserva(String nomeReserva) {
		this.nomeReserva = nomeReserva;
	}
	public String toString() {
		return String.format("A reserva foi feita em nome "+this.nomeReserva+" para "+this.qtdPessoas+" pessoas e o numero da mesa eh"+this.numeroMesa);
	}
	
}

package Mesas;

import java.util.ArrayList;
import java.util.Collections;

public class ControleMesa {
	private ArrayList<Mesa> mesas;
	private ArrayList<ReservaMesa> reservas;

	public ControleMesa() {
		this.mesas = new ArrayList<>();
		this.reservas = new ArrayList<>();
	}

	public boolean cadrastarMesas(Mesa p) {
		boolean mesaNExiste = false;
		if (p != null) {
			mesaNExiste = true;

			for (Mesa todas : mesas) {
				if (todas.getNumeroDaMesa() == p.getNumeroDaMesa()) {
					mesaNExiste = false;
				}
			}
			if (mesaNExiste) {
				this.mesas.add(p);
			}
		}

		Collections.sort(mesas);
		return mesaNExiste;

	}

	public void removerMesa(Mesa p) {
		for (Mesa todas : mesas) {
			if (todas.getNumeroDaMesa() == p.getNumeroDaMesa()) {
				mesas.remove(p);
			}
		}
	}

	public void adicionarReserva(ReservaMesa reserva) {
		for (Mesa todas : mesas) {
			if (reserva.getQtdPessoas() <= todas.getNumeroPessoas() && todas.getDisponivel()) {
				reserva.setNumeroMesa(todas.getNumeroDaMesa());
				reservas.add(reserva);
				todas.setDisponivel(false);
				break;
			}
		}
	}

	public void cancelarReserva(ReservaMesa reserva) {
		for (Mesa todas : mesas) {
			if (todas.getNumeroDaMesa() == reserva.getNumeroMesa()) {
				todas.setDisponivel(true);
			}
		}
		reservas.remove(reserva);
	}

	public ArrayList<Mesa> listarMesasDisponiveis() {
		ArrayList<Mesa> disponivel = new ArrayList<>();
		for (Mesa todas : mesas) {
			if (todas.getDisponivel()) {
				disponivel.add(todas);
			}
		}
		return disponivel;
	}

	public ArrayList<Mesa> listarMesas() {
		return mesas;
	}

	public ArrayList<ReservaMesa> listarReservas() {
		return reservas;
	}

	public boolean verificarDisponibilidade(Mesa mesa) {
		return mesa.getDisponivel();
	}

}

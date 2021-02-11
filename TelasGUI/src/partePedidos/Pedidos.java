package partePedidos;

import java.util.ArrayList;

import Mesas.Mesa;

public class Pedidos {
	private int codPedido;
	private String idPedido;
	private double preco;
	private int quantidade;
	private boolean disponivel;

	public Pedidos(int codPedido, String idPedido, int quantidade,double preco, boolean disponivel) {
		super();
		this.codPedido = codPedido;
		this.idPedido = idPedido;
		this.quantidade = quantidade;
		this.disponivel = disponivel;
		this.preco = preco;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getCodPedido() {
		return codPedido;
	}

	public void setCodPedido(int codPedido) {
		this.codPedido = codPedido;
	}

	public String getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(String idPedido) {
		this.idPedido = idPedido;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public boolean getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	@Override
	public String toString() {
		return String.format(idPedido + " | COD: " + codPedido + " | QTD: "+ quantidade + " | R$: " + preco + " | Disponibilidade: " + disponivel);
	}

}

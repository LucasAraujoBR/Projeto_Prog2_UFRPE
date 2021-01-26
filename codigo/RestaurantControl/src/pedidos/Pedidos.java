package pedidos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.ArrayList;

public class Pedidos {
	private LocalDateTime horaPedido;
	private int item;
	private int codigoComanda = 0;

	public Pedidos(LocalDateTime horaPedido, int item, int codigoComanda) {
		this.codigoComanda = 0;
		this.horaPedido = horaPedido;
		this.item = item;
	}

	public LocalDateTime getHoraPedido() {
		return horaPedido;
	}

	public void setHoraPedido(LocalDateTime horaPedido) {
		this.horaPedido = horaPedido;
	}

	public int getItem() {
		return item;
	}

	public void setItem(int item) {
		this.item = item;
	}

	public int getCodigoComanda() {
		return codigoComanda;
	}

	public void setCodigoComanda(int codigoComanda) {
		this.codigoComanda = codigoComanda;
	}

	ArrayList<Pedidos> pedidos = new ArrayList<Pedidos>();

	void adicionarPedido(Pedidos item) {
		pedidos.add(item);

	}

	public void gerarRelatorioPedidos() {
		for (Pedidos pedido : pedidos) {
			
			System.out.println(pedido);
		}

	}
	/*
	 * public int alertaCozinha(){
	 * 
	 * }
	 */
}

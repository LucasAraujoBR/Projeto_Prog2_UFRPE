package partePedidos;

import java.util.ArrayList;
import java.util.Collections;

import Mesas.Mesa;

public class PedidosCRUD {
	private ArrayList<Pedidos> pedidos;
	private ArrayList<Pedidos> ADDpedidos;
	private ArrayList<pedCAD> pedidosCAD;

	public PedidosCRUD() {
		super();
		this.pedidos = new ArrayList<>();
		this.ADDpedidos = new ArrayList<>();
		this.pedidosCAD = new ArrayList<>();

	}

	public void cadrastarPedidos(Pedidos p) {
		if (p != null) {
			boolean pedidoNExiste = true;

			for (Pedidos todas : pedidos) {
				if (todas.equals(p)) {
					pedidoNExiste = false;
				}
			}
			if (pedidoNExiste) {
				this.pedidos.add(p);
			}
		}
		//Collections.sort(pedidos);

	}
	public void cadPED(pedCAD p) {
		if (p != null) {
			boolean pedidoNExiste = true;

			for (pedCAD todas : pedidosCAD) {
				if (todas.equals(p)) {
					pedidoNExiste = false;
				}
			}
			if (pedidoNExiste) {
				this.pedidosCAD.add(p);
			}
		}
		//Collections.sort(pedidos);

	}

	public ArrayList<Pedidos> listarCardapio() {
		return pedidos;
	}
	
	
	public void addPedidos(Mesa p,Pedidos pedido2) {
		boolean addPedido = true;
		for (Pedidos ped : pedidos) {
			if (ped.equals(p)) {
				addPedido = false;
				break;
			}
		}
		if (addPedido) {
			this.ADDpedidos.add(pedido2);
		}
	}
	
	public ArrayList<Pedidos> listarPedidos() {
		return ADDpedidos;
	}
	public ArrayList<pedCAD> listarCadPed() {
		return pedidosCAD;
	}

}

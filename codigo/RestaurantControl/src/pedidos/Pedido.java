package pedidos;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Pedido {
	private LocalDateTime horaPedido;
	private int item;
	private int codigoComanda = 0;

	public Pedido(LocalDateTime horaPedido, int item, int codigoComanda) {
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

	ArrayList<Pedido> pedidos = new ArrayList<Pedido>();

	public void adicionarPedido(int item, int codigoComanda, LocalDateTime horaPedido){
		Pedido novoPedido = new Pedido(horaPedido, codigoComanda, item);
		boolean pedidoNaoExiste = true;
		
		for(Pedido pedidoLista : pedidos) {
			if(pedidoLista.equals(novoPedido)) {
			pedidoNaoExiste = false;
				break;
			}
		}
		if(pedidoNaoExiste) {
			pedidos.add(novoPedido);
		}
		
	}
	public void gerarRelatorioPedidos() {
		for (Pedido pedido : pedidos) {
			System.out.printf("%i   %i", pedido.getItem(), pedido.getCodigoComanda());
			System.out.println(horaPedido);
	}
}
}

package partePedidos;

public class Pedidos {
	private int codPedido;
	private String idPedido;
	private double preco;

	public Pedidos(int codPedido, String idPedido,double preco) {
		super();
		this.codPedido = codPedido;
		this.idPedido = idPedido;

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

	

	@Override
	public String toString() {
		return String.format(idPedido + " |COD: " + codPedido  + " |R$: " + preco);
	}

}

package partePedidos;

public class pedCAD {
	private String nome;
	private int quantidade;
	private double valor;

	public pedCAD(String nome, int quantidade, double valor) {
		super();
		this.nome = nome;
		this.quantidade = quantidade;
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return String.format("Pedido: " + nome + " |Quantidade: " + quantidade + " |Preço: " + valor);
	}

}

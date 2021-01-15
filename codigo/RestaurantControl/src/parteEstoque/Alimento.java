package parteEstoque;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Alimento {

	private String nomeProduto;
	private String codigoBarra;
	private LocalDate dataVencimento;
	private double qtdProduto;
	
	DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Alimento(String nomeProduto, String codigoBarra, String dataVencimento, double qtdProduto) {
		this.nomeProduto = nomeProduto;
		this.codigoBarra = codigoBarra;
		this.dataVencimento = LocalDate.parse(dataVencimento, formatador);
		this.qtdProduto = qtdProduto;
	}
	
	
	
}

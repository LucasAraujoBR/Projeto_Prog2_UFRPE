package parteEstoque;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class Alimento {

	private String nomeProduto;
	private String codigoBarra;
	public String vencimentoString;
	private LocalDate dataVencimento;
	private int qtdProduto;
	//private Funcionario respEstoqueDoAlimento;
	private int qtdMinimaAlimento = 5;
	
	
	DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Alimento(String nomeProduto, String codigoBarra, String dataVencimento, int qtdProduto) {
		this.nomeProduto = nomeProduto;
		this.codigoBarra = codigoBarra;
		this.dataVencimento = LocalDate.parse(dataVencimento, formatador);
		this.qtdProduto = qtdProduto;
		this.vencimentoString = getDataVencimento().format(formatador);
		setQtdMinimaParaFuncionamentoDeUmDia();
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoBarra == null) ? 0 : codigoBarra.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alimento other = (Alimento) obj;
		if (codigoBarra == null) {
			if (other.codigoBarra != null)
				return false;
		} else if (!codigoBarra.equals(other.codigoBarra))
			return false;
		return true;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getCodigoBarra() {
		return codigoBarra;
	}

	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public int getQtdProduto() {
		return qtdProduto;
	}

	public void setQtdProduto(int qtdProduto) throws Exception{
		if(this.qtdProduto - qtdProduto <= 0) {
			this.qtdProduto = 0;
			throw new Exception();
		}
		if(this.qtdProduto - qtdProduto <= this.qtdMinimaAlimento) {
			this.qtdProduto -= qtdProduto;
			throw new Exception();
		}
		else {
			this.qtdProduto -= qtdProduto;
		}
	}

	
	public int getQtdMinimaAlimento() {
		return qtdMinimaAlimento;
	}
	
	public void setQtdMinimaParaFuncionamentoDeUmDia() {
		List<String> alimentosPadrao = Arrays.asList("feijao", "arroz", "fuba", "macaxeira", "peito bovino", "charque","macarrão");
		this.qtdMinimaAlimento = qtdMinimaAlimento;
		
	}
	public String toString() {
		return this.nomeProduto;
	}	
	
}
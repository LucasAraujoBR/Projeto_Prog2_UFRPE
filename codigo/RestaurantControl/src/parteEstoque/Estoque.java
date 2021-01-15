package parteEstoque;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Estoque {
	/*Fazer um menu que contem algumas opções de alimentos a serem colocados no estoque*/
	
	ArrayList<Alimento> alimentos;
	LocalDateTime horaAtual = LocalDateTime.now();
	Funcionario funcionarioAcessando; 
	DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:MM");
	DateTimeFormatter formatadorVencimento = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	
	Estoque() {
		
		
	}
	
	public void adicionarAlimentoEstoque(String nomeProduto, String dataVencimento, String codigoBarra, int quantidade){
		Alimento novoAlimento = new Alimento(nomeProduto, codigoBarra, dataVencimento, quantidade, this.funcionarioAcessando);
		boolean alimentoNaoPresente = true;
		
		for(Alimento alimentoListado : alimentos) {
			if(alimentoListado.equals(novoAlimento)) {
				alimentoNaoPresente = false;
				break;
			}
		}
		if(alimentoNaoPresente) {
			alimentos.add(novoAlimento);
		}
		
	}
	
	public void relatorioEstoque() {
		
		// Cabeçalho
		System.out.println("**********************************************************************************************************************************");
		String cabecalho = String.format("Funcionário : %-20s | Data : %s \nAlimento%5-s|Vencimento%3-s|Código%9-s|Quantidade\n", this.funcionarioAcessando, this.horaAtual.format(formatador), " ", " ", " ");
		
		for(Alimento alimentoEstocado : alimentos) {
			System.out.printf("%-15s|%15s|%-15s|%d\n", alimentoEstocado.getNomeProduto(), alimentoEstocado.getDataVencimento().format(formatadorVencimento),alimentoEstocado.getCodigoBarra(), alimentoEstocado.getQtdProduto());
		}
		System.out.println("**********************************************************************************************************************************");
		
	}
	
	public boolean decrementarEstoque(String codigoBarra, int qtdRetirada) {
		boolean decrementou = true;
		for(Alimento alimentoEstocado : alimentos) {
			if(alimentoEstocado.getCodigoBarra().equals(codigoBarra)) {
				alimentoEstocado.setQtdProduto(qtdRetirada);
			}
		}
	}
	
	public ArrayList<Alimento> pertoDeVencer(int numeroDiasParaVencer) {
		ArrayList<Alimento> alimentosPertoDoVencimento = new ArrayList<Alimento>();
		return alimentosPertoDoVencimento;
	}
	
	public ArrayList<Alimento> estoqueEmBaixa() {
		ArrayList<Alimento> alimentosEmBaixa = new ArrayList<Alimento>();
		return alimentosEmBaixa;
	}
	
	public void listarEstoque() {
		
	}
}

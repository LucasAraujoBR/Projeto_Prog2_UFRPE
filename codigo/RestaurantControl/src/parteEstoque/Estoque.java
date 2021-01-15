package parteEstoque;

import java.util.ArrayList;

public class Estoque {
	ArrayList<Alimento> alimentos;
	
	Estoque() {
		
		
	}
	
	public void addEstoqueComida(String nomeProduto, String dataVencimento, String codigoBarra, double quantidade){
		
	}
	
	public void relatorioEstoque() {
		
	}
	
	public boolean decrementarEstoque() {
		return true;
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

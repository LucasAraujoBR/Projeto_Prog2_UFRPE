package parteCaixa;

import Mesas.Mesa;
import TelaMesas.controllerMesas;
import partePedidos.Pedidos;
import partePedidos.pedCAD;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Caixa {
	private String descricao;
	private static double cofre; 
	private Mesa clienteDaMesa;
	private double contaMesa;
	private static ArrayList<Mesa> contasDoDia;
	public Caixa() {
		this.descricao = "Caixa";
		this.clienteDaMesa = null;
		contaMesa = 0;
		cofre = 0;
		contasDoDia = new ArrayList<>();
		
	}

	public void receberDinheiro() {
		boolean recebeu = confirmarPagamento(gerarConta());
		if(recebeu) {
			contasDoDia.add(clienteDaMesa);
			clienteDaMesa = null;
		}
	}
	
	public String cupomFiscal(ArrayList<pedCAD> pedidos) {
		
		LocalDateTime data = LocalDateTime.now();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/YYYY   HH:mm:ss");
		String nota = String.format("%s\n", data.format(formato));
		String nota2 = String.format(("________________________________________________\n"));
		String nota3 = String.format(("          C U P O M     F I S C A L\n"));
		String nota4 = String.format(("ITEM          DESCRICAO\n"));
		String nota5 = String.format(("QTD.   UN    VL.UNIT(R$)             VL.ITEM(R$)\n"));
		String nota7 = String.format("________________________________________________\n");
		String nota9 = String.format(("                                                    -----------\n"));
		String nota10 = String.format("Subtotal R$                                      %.2f\n",controllerMesas.getMesaSelecionada().preco(pedidos));
		String nota11 = String.format("________________________________________________\n");
		String nota12 = String.format("T O T A L  R $                                   %.2f\n", controllerMesas.getMesaSelecionada().preco(pedidos));
		
        String nota8 = notaFiscal(pedidos,0);
        String cumpom = nota + nota2 + nota3 + nota4 + nota5+nota7+nota8;
		//String cumpom = nota + nota2 + nota3 + nota4 + nota5+nota7+nota8+nota9+nota10+nota11+nota12;
		for(int i = 1;i<pedidos.size();i++) {
			cumpom = cumpom +notaFiscal(pedidos,i);
		}
		
		
		return cumpom+nota9+nota10+nota11+nota12;
		
	}


	public String notaFiscal (ArrayList<pedCAD> pedidos,int numero) {
		String nota10 ="";
		if(numero +1 >= 100)
			System.out.printf ("%d         %s  \n", numero+1,pedidos.get(numero).getNome());
		else if(numero +1 >= 10 )
			System.out.printf ("0%d         %s  \n", numero+1,pedidos.get(numero).getNome());
		else if(numero +1 >= 1) 
		nota10 = String.format("00%d         %s  \n",numero+1,pedidos.get(numero).getNome());
		
		double conta = pedidos.get(numero).getValor() * pedidos.get(numero).getQuantidade();
		String nota100 = String.format("      %d.000 UN x %.2f      ", pedidos.get(numero).getQuantidade(), pedidos.get(numero).getValor());
		int tamanho = 51 - nota100.length();
		if(conta >= 1000)
			tamanho -= 7;
		else if(conta >= 100)
			tamanho -= 6;
		else if(conta >= 10)
			tamanho -= 5;
		else
			tamanho -= 4;
		for(int comeco = 0; comeco < tamanho; comeco++)
			nota100 += " ";
		nota100 += String.format("%.2f\n", conta);
		return nota10+ nota100;
	}
	
	
	public void gerarLucro() {
		
	}
	public void fecharCaixa() {
		contasDoDia.clear();
		
	}
	public static ArrayList<Mesa> gerarContasDiarias() {
		return contasDoDia;
	}
	private boolean confirmarPagamento(double dinheiro) {

		boolean confirma = false;
		if (dinheiro >= 0) {
			setCofre(dinheiro);
			confirma = true;
		}
		return confirma;
	}
	public double gerarConta() {
		return contaMesa;
	}
	
	
	
	public void setClienteDaMesa(Mesa mesa) {
		if(!mesa.equals(null))
			this.clienteDaMesa = mesa;
	}
	private void setCofre(double dinheiro) {
		if(dinheiro > 0)
			cofre += dinheiro;
	}
	public void setContaMesa(double conta) {
		this.contaMesa = conta;
	}
}
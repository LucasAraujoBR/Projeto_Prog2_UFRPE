package parteCaixa;
import Mesas.Mesa;
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
	private ArrayList<Mesa> contasDoDia;
	
	public Caixa() {
		this.descricao = "";
		this.clienteDaMesa = null;
		contaMesa = 0;
		cofre = 0;
		contasDoDia = new ArrayList<>();
	}
	
	public void receberDinheiro() {
		boolean recebeu = confirmarPagamento(gerarConta());
		if(recebeu) {
			gerarCupomFiscal(clienteDaMesa.getPedidos());
			contasDoDia.add(clienteDaMesa);
			clienteDaMesa = null;
		}
		else
			System.out.println("***O valor a se receber é considerado uma subtração***");
	}
	// Precisa ainda receber da classe Pedido a DESCRIÇÃO do item pelo getDescrição()
	// também seu preço por unidade e a quantidade por seus respectivos Gets
	public void gerarCupomFiscal(ArrayList<pedCAD> pedidos) {
		LocalDateTime data = LocalDateTime.now();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/YYYY");
		int item = 1;
		System.out.printf("%s   %s\n", data.toLocalDate().format(formato), data.toLocalTime().toString());
		System.out.println("________________________________________________");
		System.out.println("          C U P O M     F I S C A L");
		System.out.println("ITEM          DESCRICAO");
		System.out.println("QTD.   UN    VL.UNIT(R$)             VL.ITEM(R$)");
		System.out.println("________________________________________________");
		for(pedCAD atualPedido: pedidos) {
			if(item >= 100)
				System.out.printf ("%d         %s  \n", item,  atualPedido.getNome());
			else if(item >= 10 )
				System.out.printf ("0%d         %s  \n", item,  atualPedido.getNome());
			else if(item >= 1) 
				System.out.printf ("00%d         %s  \n", item,  atualPedido.getNome());
			item +=1;
			System.out.printf ("      %d.000 UN x %.2f                 %.2f\n", atualPedido.getQuantidade(), atualPedido.getValor(), (atualPedido.getValor() * atualPedido.getQuantidade()));
		}
		System.out.println("                                     -----------");
		System.out.printf ("Subtotal R$                                %.2f\n", gerarConta());
		System.out.println("________________________________________________");
		System.out.printf("T O T A L  R $                              %.2f\n", gerarConta());
		
	}
	public void gerarLucro() {
		
	}
	public void fecharCaixa() {
		contasDoDia.clear();
		
	}
	public ArrayList<Mesa> gerarContasDiarias() {
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
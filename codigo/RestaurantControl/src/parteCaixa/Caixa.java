package parteCaixa;
import Mesas.Mesa;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Caixa {
	private String descricao;
	private static double cofre; 
	private Caixista funcionarioCaixa;
	private Mesa clienteDaMesa;
	
	public Caixa() {
		this.descricao = "";
		this.funcionarioCaixa = null;
		this.clienteDaMesa = null;
		cofre = 0;
	}
	
	public void receberDinheiro() {
		boolean recebeu = confirmarPagamento(gerarConta());
		if(recebeu) 
			gerarNotaFiscal(clienteDaMesa.getPedidos());
		else
			System.out.println("***O valor a se receber é considerado uma subtração***");
	}
	// Precisa ainda receber da classe Pedido a DESCRIÇÃO do item pelo getDescrição()
	// também seu preço por unidade e a quantidade por seus respectivos Gets
	public void gerarCupomFiscal(ArrayList<Pedido> pedidos) {
		LocalDateTime data = LocalDateTime.now();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/YYYY");
		int item = 1;
		System.out.printf("%s   %s\n", data.toLocalDate().format(formato), data.toLocalTime().toString());
		System.out.println("________________________________________________");
		System.out.println("          C U P O M     F I S C A L");
		System.out.println("ITEM CODIGO   DESCRICAO");
		System.out.println("QTD.   UN    VL.UNIT(R$)             VL.ITEM(R$)");
		System.out.println("________________________________________________");
		for(Pedido atualPedido: pedidos) {
			System.out.printf ("%3d   %s   %s  \n", item, atualPedido.getCodigo(), atualPedido.getDescricao());
			System.out.printf ("      %3.f UN x %2.f                 %2.f\n", atualPedido.getQuantidade(), atualPedido.getPrecoUnidade(), atualPedido.getPrecoUnidade() * atualPedido.getQuantidade());
		}
		System.out.println("                                     -----------");
		System.out.printf ("Subtotal R$                                %2.f\n"), clienteDaMesa.getConta());
		System.out.println("________________________________________________");
		System.out.printf("T O T A L  R $                              %2.f\n", clienteDaMesa.getConta());
		
	}
	public void gerarLucro() {
		
	}
	public void fecharCaixa() {
	
	}
	public void abrirCaixa() {
		
	}
	public ArrayList<Pedido> gerarContasDiarias(ArrayList<Pedido> todosPedidos) {
		
	}
	public void gerarRelatorioGorjetas(Garcom garcom) {
		
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
		return clienteDaMesa.Conta();
	}
	
	
	
	public void setClienteDaMesa(Mesa mesa) {
		if(!mesa.equals(null))
			this.clienteDaMesa = mesa;
	}
	public void setFuncionarioCaixa(Caixista funcionario) {
		if(!funcionario.equals(null)) 
			this.funcionarioCaixa = funcionario;
	}
	private void setCofre(double dinheiro) {
		if(dinheiro > 0)
			cofre += dinheiro;
	}
}

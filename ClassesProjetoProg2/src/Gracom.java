import java.util.ArrayList;

import questao03.Transacao;

public class Gracom extends Funcionario {
	private String descricao = "Garçom";
	private double alteracoesSalario;

	public Gracom(String nome, String cpf, String telefone, String email, double alteracoesSalario) {
		super(nome, cpf, telefone, email);
		this.alteracoesSalario = alteracoesSalario;
	}

	public String gerarRelatorioFuncionarios() {
		return "|Cargo: " + descricao;

	}

	public boolean fecharContaMesa(boolean BNT_fechar_conta_mesa) {
		if (BNT_fechar_conta_mesa == true) {
			return true;
		} else {
			return false;
		}
	}

	public String validarAcesso(String codigo) {
		return codigo;
	}

	public double debitarRenda() {
		double rendaBonusGarcom = 0.0;
		rendaBonusGarcom += this.alteracoesSalario;
		return rendaBonusGarcom;
	}
	public String alertaCozinha(int mesa,String pedido) {
		return pedido+" da mesa "+mesa+" atrasado!";
	}
	//Parte logica desse metodo depende da criação da classe pedido, devo retornar apos obter ela pronta!
	public ArrayList adicionarAoPedido(int mesa,String pedido) {
		ArrayList<Pedido> ped = new ArrayList<Pedido>;
		for (Pedido p : ped) {
			ped.add(p);
		}
	}

}

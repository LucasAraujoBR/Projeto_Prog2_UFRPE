package parteEstoque;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Estoque {
	/*
	 * Fazer um menu que contem algumas opções de alimentos a serem colocados no
	 * estoque
	 */

	List<Alimento> alimentos;
	LocalDateTime horaAtual = LocalDateTime.now();
	// Funcionario funcionarioAcessando;
	DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:MM");
	DateTimeFormatter formatadorVencimento = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public Estoque() {
		alimentos = new ArrayList<Alimento>();
	}

	public boolean adicionarAlimentoEstoque(String nomeProduto, String dataVencimento, String codigoBarra,
			int quantidade) {
		Alimento novoAlimento = new Alimento(nomeProduto, codigoBarra, dataVencimento, quantidade);
		boolean alimentoNaoPresente = true;

		for (Alimento alimentoListado : alimentos) {
			if (alimentoListado.equals(novoAlimento)) {
				return false;
			}
		}
		if (alimentoNaoPresente) {
			alimentos.add(novoAlimento);
		}
		return alimentoNaoPresente;

	}

	public void relatorioEstoque() {

		// Cabeçalho
		System.out.println("***************************************************************");
		String cabecalho = String.format("Funcionário : %10s | Data : %s |Código :%9s\n", "José",
				LocalDate.now().format(formatadorVencimento), "123558");
		System.out.println(cabecalho);
		for (Alimento alimentoEstocado : alimentos) {
			System.out.printf("%-15s|%15s|%15s|%8d\n", alimentoEstocado.getNomeProduto(),
					alimentoEstocado.getDataVencimento().format(formatadorVencimento),
					alimentoEstocado.getCodigoBarra(), alimentoEstocado.getQtdProduto());
		}
		System.out.println("***************************************************************");

	}

	public boolean decrementarEstoque(String codigoBarra, int qtdRetirada) throws Exception {
		for (Alimento alimentoEstocado : alimentos) {
			if (alimentoEstocado.getCodigoBarra().equals(codigoBarra)) {
				alimentoEstocado.setQtdProduto(qtdRetirada);
				return true;
			}
		}
		return false;
	}

	public ArrayList<Alimento> pertoDeVencer(LocalDate diaVencimento) {
		ArrayList<Alimento> alimentosPertoDoVencimento = new ArrayList<Alimento>();
		for (Alimento alimentoEstocado : alimentos) {
			if (alimentoEstocado.getDataVencimento().isBefore(diaVencimento)) {
				alimentosPertoDoVencimento.add(alimentoEstocado);
			}
		}

		return alimentosPertoDoVencimento;
	}

	public ArrayList<Alimento> estoqueEmBaixa(int qtdMinimaEmEstoque) {
		ArrayList<Alimento> alimentosEmBaixa = new ArrayList<Alimento>();

		for (Alimento alimentoEstocado : alimentos) {
			if (alimentoEstocado.getQtdProduto() < qtdMinimaEmEstoque) {
				alimentosEmBaixa.add(alimentoEstocado);
			}
		}
		return alimentosEmBaixa;
	}

	public void listarEstoque() {

	}

	public List<Alimento> getAlimentos() {
		return alimentos;
	}

	public DateTimeFormatter getFormatador() {
		return formatadorVencimento;
	}

	public void setAlimentos(List<Alimento> alimentos) {
		this.alimentos = alimentos;
	}

	public LocalDateTime getHoraAtual() {
		return horaAtual;
	}

	public void setHoraAtual(LocalDateTime horaAtual) {
		this.horaAtual = horaAtual;
	}

}
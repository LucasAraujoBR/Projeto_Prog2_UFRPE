
public class Cozinheiro extends Funcionario {
	private String descricao = "Cozinheiro";

	public Cozinheiro(String nome, String cpf, String telefone, String email) {
		super(nome, cpf, telefone, email);

	}
	public String gerarRelatorioFuncionarios() {
		return "|Cargo: " + descricao;
		
	}
	public String validarAcesso(String codigo) {
		return codigo;
	}
}

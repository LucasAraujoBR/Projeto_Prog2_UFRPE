
public abstract class Funcionario {
	private String nome;
	private String cpf;
	private String telefone;
	private String email;
	public Funcionario(String nome, String cpf, String telefone, String email) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
	}
	
	public String gerarRelatorioFuncionarios() {
		return String.format("Nome: "+nome+"|CPF: "+cpf+"|Telefone: "+telefone+"|email: "+email);
	}
	
}

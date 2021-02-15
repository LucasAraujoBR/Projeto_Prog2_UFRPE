package parteFuncionario;

public class Funcionario {
	private String nome;
	private String cpf;
	private String email;
	private String telefone;
	private String codFuncionario;
	private String cargo;

	public Funcionario(String nome,String cpf,String email,String telefone,String codFuncionario,String cargo) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.codFuncionario = codFuncionario;
		this.cargo = cargo;
		
	}

	

	public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getTelefone() {
		return telefone;
	}



	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}



	public String getCargo() {
		return cargo;
	}



	public void setCargo(String cargo) {
		this.cargo = cargo;
	}



	public String getCodFuncionario() {
		return codFuncionario;
	}



	public void setCodFuncionario(String codFuncionario) {
		this.codFuncionario = codFuncionario;
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return String.format("Cargo: " + this.cargo +"|Email: " + this.email + " |CPF: " + this.cpf + "  |Código de usuário: " + this.codFuncionario + "|Nome: " + this.nome + "|Telefone: " + this.telefone);
	}

}
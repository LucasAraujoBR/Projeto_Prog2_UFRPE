
public class Gerente extends Funcionario{
	private String senha = "gerente1234";
	private String descricao = "Gerente";
	public Gerente(String nome, String cpf, String telefone, String email) {
		super(cpf, email, nome, telefone);	
	}
	
	public String gerarRelatorioFuncionarios() {
		return "|Cargo: " + descricao;
		
	}
	
	public boolean validarAcesso(String senha) {
		if(senha.equals(this.senha)) {
			return true;
		}else {
		return false;
		}
		
	}
	//public arrayList pedidosEmAndamento(); substituido por gerarRelatorio de pedidos da classe Pedidos
	
	

}

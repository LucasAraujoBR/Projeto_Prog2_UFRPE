package application;

public class Usuario {
	
	private String usuarioLogin;
	private String usuarioSenha;
	
	public Usuario() {
		usuarioLogin = "fulano";
		usuarioSenha = "0000";
	}
	
	public void usuarioLogado(String login, String senha) {
		usuarioLogin = login;
		usuarioSenha = senha;
	}
	

	public String getLogin() {
		return usuarioLogin;
	}
	public String getSenha() {
		return usuarioSenha;
	}
	
}



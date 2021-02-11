package parteFuncionario;

import java.util.ArrayList;
import java.util.Collections;

import Mesas.Mesa;

public class FunCAD {
	private ArrayList<Funcionario> fun;
	private ArrayList<String> codFuncionario;
	boolean jaCadastrado = false;

	public FunCAD() {
		this.codFuncionario = new ArrayList<>();
		this.fun = new ArrayList<>();
	}

	public boolean cadrastarFuncionario(Funcionario p) {
		
		boolean FuncionarioExiste = false;
		if (p != null) {
			FuncionarioExiste = true;

			for (Funcionario todas : fun) {
				if (todas.getCodFuncionario().equals(p.getCodFuncionario())) {
					FuncionarioExiste = false;
					this.jaCadastrado = true;
				}
			}
			
			if (FuncionarioExiste) {	
				this.fun.add(p);
			}
			
		}
		return FuncionarioExiste;

	}
	public void cadrastarCodFuncionario(ArrayList<String> codFuncionario2) {
		if (codFuncionario2 != null) {
			boolean FuncionarioExiste = true;

			for (String todas : codFuncionario) {
				if (todas.equals(codFuncionario2)) {
					FuncionarioExiste = false;
					this.jaCadastrado = true;
					break;
				}
			}
			if (FuncionarioExiste == true) {
				this.codFuncionario.addAll(codFuncionario2);
			}
		}

	}
	
	public void removerCodFuncionario(String p) {
		codFuncionario.remove(p);
	}
	public void cadrastarCodFuncionario2(String p) {
		codFuncionario.add(p);
	}
	public void removerFuncionario(Funcionario p) {
		fun.remove(p);
	}

	public boolean isJaCadastrado() {
		return jaCadastrado;
	}

	public ArrayList<Funcionario> listarFuncionario() {
		return fun;
	}
	public ArrayList<String> listarCodFuncionario() {
		return codFuncionario;
	}

}

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

	public void cadrastarFuncionario(Funcionario p) {
		if (p != null) {
			boolean FuncionarioExiste = true;

			for (Funcionario todas : fun) {
				if (todas.equals(p)) {
					FuncionarioExiste = false;
					this.jaCadastrado = true;
					break;
				}
			}
			if (FuncionarioExiste == true) {
				this.fun.add(p);
			}
		}

	}
	public void cadrastarCodFuncionario(String p) {
		if (p != null) {
			boolean FuncionarioExiste = true;

			for (String todas : codFuncionario) {
				if (todas.equals(p)) {
					FuncionarioExiste = false;
					this.jaCadastrado = true;
					break;
				}
			}
			if (FuncionarioExiste == true) {
				this.codFuncionario.add(p);
			}
		}

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

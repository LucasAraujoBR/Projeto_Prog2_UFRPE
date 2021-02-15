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
			boolean FuncionarioExiste = false;

			for (Funcionario todas : fun) {
				if (todas.equals(p)) {
					FuncionarioExiste = true;
					this.jaCadastrado = true;
					break;
				}
			}
			if (FuncionarioExiste == false) {
				this.fun.add(p);
			}
		}

	}
	public void cadrastarCodFuncionario(ArrayList<String> codFuncionario2) {
		if (codFuncionario2 != null) {
			boolean FuncionarioExiste = false;

			for (String todas : codFuncionario) {
				if (todas.equals(codFuncionario2)) {
					FuncionarioExiste = true;
					this.jaCadastrado = true;
					break;
				}
			}
			if (FuncionarioExiste == false) {
				this.codFuncionario.addAll(codFuncionario2);
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

package Mesas;
<<<<<<< HEAD

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
=======
>>>>>>> 7817a9ce8c32892ef6c5632a2d6bb42c7077f078

public class Mesa implements Comparable<Mesa> {
     private IntegerProperty numeroPessoas;
     private IntegerProperty numeroDaMesa;
     private BooleanProperty disponivel;
     private StringProperty nomeMesa;
     private StringProperty nomeReserva;
     private IntegerProperty numeroReservas;
     
    public String getNomeReserva() {
    	return nomeReserva.get();
	}


	public void setNomeReserva(String nomeReserva) {
		this.nomeReserva.set(nomeReserva);
	}


	public Mesa(int numeroPessoas,int numeroDaMesa) {
    	this.numeroDaMesa = new SimpleIntegerProperty(numeroDaMesa);
    	this.numeroPessoas = new SimpleIntegerProperty(numeroPessoas);
    	this.disponivel = new SimpleBooleanProperty(true);
    	this.nomeMesa = new SimpleStringProperty("Mesa");
    	this.nomeReserva = new SimpleStringProperty("");
    	this.numeroReservas  = new SimpleIntegerProperty();
    }
    
 
	/*public String getNomeMesa() {
		return nomeMesa;
	}


	public void setNomeMesa(String nomeMesa) {
		this.nomeMesa = nomeMesa;
	}


	public boolean getDisponivel() {
	return disponivel;
}

    public void setDisponivel(boolean disponivel) {
	  this.disponivel = disponivel;
     }

	public int getNumeroPessoas() {
		return numeroPessoas;
	}
	public void setNumeroPessoas(int numeroPessoas) {
		this.numeroPessoas = numeroPessoas;
	}
	public int getNumeroDaMesa() {
		return numeroDaMesa;
	}
	public void setNumeroDaMesa(int numeroDaMesa) {
		this.numeroDaMesa = numeroDaMesa;
	}*/
	
	public int getNumeroReservas() {
		return numeroReservas.get();
	}


	public void setNumeroReservas(int numeroReservas) {
		this.numeroReservas.set(numeroReservas);;
	}


	public String toString() {
    	return String.format("Numero da mesa eh "+this.numeroDaMesa+" e o numero de pessoas que cabe na mesa eh  "+this.numeroPessoas);
    }


	//@Override
	//public int compareTo(Mesa outra) {
		
		//return (this.getNumeroPessoas() - outra.getNumeroPessoas());
	//}


	public int getNumeroPessoas() {
		return numeroPessoas.get();
	}


	public void setNumeroPessoas(int numeroPessoas) {
		this.numeroPessoas.set(numeroPessoas);
	}


	public int getNumeroDaMesa() {
		return numeroDaMesa.get();
	}


	public void setNumeroDaMesa(int numeroDaMesa) {
		this.numeroDaMesa.set(numeroDaMesa);;
	}


	public boolean getDisponivel() {
		return disponivel.get();
	}


	public void setDisponivel(boolean disponivel) {
		this.disponivel.set(disponivel);;
	}


	public String getNomeMesa() {
		return nomeMesa.get();
	}


	public void setNomeMesa(String nomeMesa) {
		this.nomeMesa.set(nomeMesa);;
	}


	@Override
	public int compareTo(Mesa o) {
		// TODO Auto-generated method stub
		return 0;
	}
}

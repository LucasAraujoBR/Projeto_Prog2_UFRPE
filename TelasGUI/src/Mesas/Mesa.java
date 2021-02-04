package Mesas;

public class Mesa implements Comparable<Mesa> {
     private int numeroPessoas;
     private int numeroDaMesa;
     private boolean disponivel;
     
    public Mesa(int numeroPessoas,int numeroDaMesa) {
    	this.numeroDaMesa = numeroDaMesa;
    	this.numeroPessoas = numeroPessoas;
    	this.disponivel = true;
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
	}
	
	public String toString() {
    	return String.format("Mesa "+this.numeroDaMesa+" cabe  "+this.numeroPessoas + " pessoas.");
    }


	@Override
	public int compareTo(Mesa outra) {
		
		return (this.getNumeroPessoas() - outra.getNumeroPessoas());
	}
}
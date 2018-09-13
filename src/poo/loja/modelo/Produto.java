package poo.loja.modelo;

public class Produto {
	
	private int id;
	private String nome;
	private double valor;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Id=" + id + "\nNome=" + nome + "\nValor=" + valor + "\n";
	}
	
	

}

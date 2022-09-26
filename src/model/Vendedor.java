package model;

public class Vendedor extends Pessoa implements Banco {
	
	private final double COMISSAO = 0.1;
	private int salario;

	public Vendedor(String nome, String email, String cidade, String senha) {
		super(nome, email, cidade, senha);
	}	

}

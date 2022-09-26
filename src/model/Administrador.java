package model;

public class Administrador extends Pessoa implements Banco {

	public Administrador(String nome, String email, String cidade, String senha) {
		super(nome, email, cidade, senha);
	}

}

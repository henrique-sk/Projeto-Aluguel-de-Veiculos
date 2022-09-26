package model;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa implements Banco {

	List<Veiculo> veiculos;
	
	public Cliente(String nome, String email, String cidade, String senha) {
		super(nome, email, cidade, senha);
		this.veiculos = new ArrayList<>();
	}
	

}

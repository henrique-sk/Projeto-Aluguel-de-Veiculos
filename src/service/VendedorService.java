package service;

import java.util.List;
import java.util.Scanner;

import model.Cliente;
import model.Vendedor;
import repository.Repository;

public class VendedorService {
	
	Scanner sc;
	Repository<Vendedor> repository = new Repository<>();
	
	public VendedorService(Scanner sc) {
		this.sc  =  sc;
		this.repository.salvar(new Vendedor("Adam", "adam@vendedor.com", "Gravataí", "1234", 2000));
		this.repository.salvar(new Vendedor("Lilian", "lilian@vendedor.com", "Porto Alegre", "1234", 2500));
		this.repository.salvar(new Vendedor("Ivana", "ivana@vendedor.com", "Esteio", "1234", 2200));
	}
	
	public Vendedor confereEmail(String email) {
		List<Vendedor> vendedoresCadastrados = repository.buscarTodos();
		
		Vendedor vendedor = vendedoresCadastrados.stream()
				.filter(c -> c.getEmail().equals(email))
				.findFirst().orElse(null);
		
		if (vendedor != null) {
			return vendedor;
		}
		return vendedor;
	}

	public boolean conferirSenha(Vendedor vendedorParam, String senha) {
		Vendedor vendedor = repository.buscarPorId(vendedorParam.getId());
		
		return vendedor.getSenha().equals(senha);
	}

	public void verSalario(Vendedor vendedor) {
		System.out.println("Seu salário atual é R$ " + vendedor.getSalario() + "0.");
	}
}

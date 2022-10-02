package service;

import java.util.List;
import java.util.Scanner;

import model.Cliente;
import repository.Repository;

public class ClienteService {
	
	Scanner sc;
	Repository<Cliente> repository = new Repository<>();
	
	public ClienteService(Scanner sc) {
		this.sc = sc;
		this.repository.salvar(new Cliente("Henrique", "henrique@henrique.com", "Canoas", "123"));
		this.repository.salvar(new Cliente("Marlon", "marlon@marlon.com", "Porto Alegre", "123"));
		this.repository.salvar(new Cliente("Paula", "paula@paula.com", "São Leopoldo", "123"));
	}
	
	public Cliente confereEmail(String email) {
		List<Cliente> clientesCadastrados = repository.buscarTodos();
		
		Cliente cliente = clientesCadastrados.stream()
				.filter(c -> c.getEmail().equals(email))
				.findFirst().orElse(null);
		
		if (cliente != null) {
			return cliente;
		}
		
		return this.cadastrarCliente(email);
	}
	
	public boolean conferirSenha(Cliente clienteParam, String senha) {
		Cliente cliente  =  repository.buscarPorId(clienteParam.getId());
		
		return cliente.getSenha().equals(senha);
	}
	
	private Cliente cadastrarCliente(String email) {
		
		System.out.println("Digite seu nome: ");
		String nome = sc.nextLine();
		System.out.println("Digite sua cidade: ");
		String cidade = sc.nextLine();		
		System.out.println("Digite sua senha: ");
		String senha = sc.nextLine();
		
		Cliente cliente = new Cliente(nome, email, cidade, senha);
		
		this.repository.salvar(cliente);
		
		return cliente;
	}
	
	

}

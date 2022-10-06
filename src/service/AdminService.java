package service;

import java.util.List;
import java.util.Scanner;

import exception.SistemaException;
import model.Administrador;
import model.Veiculo;
import model.Vendedor;
import repository.Repository;
import util.Normaliza;

public class AdminService {
	
	Scanner sc;
	VeiculoService veiculoService;
	VendedorService vendedorService;
	Repository<Administrador> repository = new Repository<>();
		
	public AdminService(Scanner sc, VeiculoService veiculoService, VendedorService vendedorService) {
		this.sc = sc;
		this.repository.salvar(new Administrador(
				"Admin", "admin@admin.com", "Porto Alegre", "12345"));
		this.veiculoService = veiculoService;
		this.vendedorService = vendedorService;
	}
	
	public void confereEntrada(int entrada) throws SistemaException {
		sc.nextLine();
		if (entrada == 1) {
			veiculoService.cadastrarVeiculo();
		} else if(entrada == 2) {
			this.removerVeiculo();
		} else if (entrada == 3) {
			vendedorService.cadastrarVendedor();
		} else if (entrada == 4) {
			this.removerVendedor();
		}
	}

	public Administrador confereEmail(String email) {
		List<Administrador> administradoresCadastrados = repository.buscarTodos();
		
		Administrador administrador = administradoresCadastrados.stream()
				.filter(admin -> admin.getEmail().equals(Normaliza.normalizaEmail(email)))
				.findFirst().orElse(null);
		
		if (administrador != null) {
			return administrador;
		}
		return administrador;
	}

	public boolean conferirSenha(Administrador administradorParam, String senha) {
		Administrador administrador = repository.buscarPorId(administradorParam.getId());
		
		return administrador.getSenha().equals(senha);
	}
	
	public void removerVeiculo() throws SistemaException {
		System.out.println("Todos veículos cadastrados e livres no sistema: ");
		veiculoService.buscarTodosVeiculosLivres();
		int veiculoID = sc.nextInt();
		
		Veiculo veiculo = veiculoService.repository.buscarPorId(veiculoID);
		if(veiculo == null) {
			throw new SistemaException("Veículo não encontrado!");
		}		
		veiculoService.repository.removerPorId(veiculoID);

		System.out.println("Veículo removido com sucesso!");
	}
	
	public void removerVendedor() throws SistemaException {
		System.out.println("Todos vendedores cadastrados no sistema: ");
		vendedorService.mostrarTodosVendedores();		
		int vendedorID = sc.nextInt();
		
		Vendedor vendedor = vendedorService.repository.buscarPorId(vendedorID);
		if(vendedor == null) {
			throw new SistemaException("Vendedor não encontrado!");
		}	
		vendedorService.repository.removerPorId(vendedorID);

		System.out.println("Vendedor removido com sucesso!");
	}

}

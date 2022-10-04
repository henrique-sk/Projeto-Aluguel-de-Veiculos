package service;

import java.util.Scanner;

import model.Administrador;
import model.Veiculo;
import repository.Repository;

public class AdminService {
	
	Scanner sc;
	VeiculoService veiculoService;
	VendedorService vendedorService;
	Repository<Administrador> repository = new Repository<>();
		
	public AdminService(Scanner sc, VeiculoService veiculoService) {
		this.sc = sc;
		this.repository.salvar(new Administrador(
				"Admin", "admin@admin.com", "Porto Alegre", "12345"));
		this.veiculoService = veiculoService;
	}
	
	public void confereEntrada(int entrada) {
		sc.nextLine();
		if (entrada == 1) {
			this.veiculoService.cadastrarVeiculo();
		}		
	}

}

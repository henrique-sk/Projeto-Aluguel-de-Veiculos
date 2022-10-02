package service;

import java.util.Scanner;

import model.Administrador;
import model.Veiculo;
import repository.Repository;

public class AdminService {
	
	Scanner sc;
	Repository<Administrador> repository = new Repository<>();
	Repository<Veiculo> veiculoRepository = new Repository<>();
	
	public AdminService(Scanner sc) {
		this.sc = sc;
		this.repository.salvar(new Administrador(
				"Admin", "admin@admin.com", "Porto Alegre", "12345"));
	}
	
	public void confereEntrada(int entrada) {
		sc.nextLine();
		if (entrada == 1) {
			this.cadastrarVeiculo();
		}		
	}
	
	private void cadastrarVeiculo() {
		System.out.println("Qual o modelo do veículo? ");
		String modelo = sc.nextLine();
		System.out.println("Qual a marca do veículo? ");
		String marca = sc.nextLine();
		System.out.println("Qual a cor do veículo? ");
		String cor = sc.nextLine();
		System.out.println("Qual a placa do veículo? ");
		String placa = sc.nextLine();
		System.out.println("Qual o segmento do veículo? ");
		String tipo = sc.nextLine();
		System.out.println("Qual o valor de locação do veículo? ");
		Double valorLocacao = sc.nextDouble();
		
		this.veiculoRepository.salvar(new Veiculo(
				modelo, marca, cor, placa, tipo, valorLocacao));
		
		System.out.println("Veículo cadastrado com sucesso!");
	}
	
	private void teste() {
		System.out.println("teste");
	}

}

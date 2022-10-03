package service;

import java.util.List;
import java.util.Scanner;

import model.Cliente;
import model.Veiculo;
import model.Veiculo.Status;
import repository.Repository;

public class VeiculoService {
	
	Scanner sc;
	Repository<Veiculo> repository = new Repository<>();
	
	public VeiculoService(Scanner sc) {
		this.sc = sc;
		this.repository.salvar(new Veiculo("Cruze", "Chevrolet", "Chumbo", "RTS5643", "carro", 120.0));
		this.repository.salvar(new Veiculo("CB150", "Honda", "Vermelho", "YTS4673", "moto", 80.0));
		this.repository.salvar(new Veiculo("FH 540", "Volvo", "Preto", "UFE4785", "caminhao", 210.0));
	}
	
	
	public void cadastrarVeiculo() {
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
		
		this.repository.salvar(new Veiculo(
				modelo, marca, cor, placa, tipo, valorLocacao));
		
		System.out.println("Veículo cadastrado com sucesso!");
	}
	
	public void buscarTodosVeiculosLivres() {
		List<Veiculo> todosVeiculos = this.repository.buscarTodos();
		
		todosVeiculos.stream().filter(veiculo -> veiculo.getStatus() == Status.LIVRE)
		.forEach(veiculo -> System.out.println(veiculo));
	}
	
	public Veiculo alugarVeiculoPorID(int id) {
		Veiculo veiculo = this.repository.buscarPorId(id);
		
		veiculo.setStatus(Status.ALUGADO);
		
		this.repository.salvar(veiculo);
		
		return veiculo;
	}
}

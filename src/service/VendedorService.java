package service;

import java.util.List;
import java.util.Scanner;

import exception.SistemaException;
import model.Cliente;
import model.Veiculo;
import model.Vendedor;
import repository.Repository;
import util.Normaliza;

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
				.filter(v -> v.getEmail().equals(Normaliza.normalizaEmail(email)))
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
	
	public void mostrarTodosVendedores() {
		List<Vendedor> vendedores = this.repository.buscarTodos();
		
		vendedores.stream().forEach(vendedor ->
			System.out.println(vendedor.getId() + " - " + vendedor.getNome()));
	}
	
	public void salvarVeiculo(Veiculo veiculo, Integer idVendedor) throws SistemaException {
		Vendedor vendedor = repository.buscarPorId(idVendedor);
		
		if(vendedor == null) {
			throw new SistemaException("Vendedor não encontrado!");
		}
		
		vendedor.getVeiculosAlugados().add(veiculo);		
		repository.salvar(vendedor);
	}
	
	public void mostrarAlugueisVeiculos(Vendedor vendedor) {
		List<Veiculo> veiculosAlugados = vendedor.getVeiculosAlugados();
		
		System.out.println("Estes são os veículos: ");
		veiculosAlugados.stream().forEach(veiculo ->
			System.out.println(veiculo));
	}
	
	public void verSalarioComComissao(Vendedor vendedor) {		
		List<Veiculo> veiculos = vendedor.getVeiculosAlugados();
		
		double totalAlugueis = veiculos.stream().mapToDouble(veiculo -> veiculo.getValorLocacao()).sum();		
		double comissao = totalAlugueis * Vendedor.COMISSAO;
		
		System.out.printf("--------------------------------------------\n"
				+ "Seu salário é R$ %.2f\n"
				+ "Sua comissão é R$ %.2f\n"
				+ "Seu salário mais comissão é R$ %.2f\n"
				, vendedor.getSalario(), comissao, (vendedor.getSalario() + comissao));
	}
	
	public void cadastrarVendedor() {
		System.out.println("Digite seu nome: ");
		String nome = sc.nextLine();
		System.out.println("Digite seu e-mail: ");
		String email = sc.nextLine();
		System.out.println("Digite sua cidade: ");
		String cidade = sc.nextLine();
		System.out.println("Digite uma senha: ");
		String senha = sc.nextLine();
		System.out.println("Digite o salário: ");
		double salario = sc.nextDouble();
		
		Vendedor vendedor = new Vendedor(nome, email, cidade, senha, salario);
		
		repository.salvar(vendedor);
	}
}

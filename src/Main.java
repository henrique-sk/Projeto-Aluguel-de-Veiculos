import java.util.Scanner;

import model.Cliente;
import model.Veiculo;
import model.Vendedor;
import service.AdminService;
import service.ClienteService;
import service.VeiculoService;
import service.VendedorService;
import util.Menu;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		ClienteService clienteService = new ClienteService(sc);
		VeiculoService veiculoService = new VeiculoService(sc);
		VendedorService vendedorService = new VendedorService(sc);
		AdminService adminService = new AdminService(sc, veiculoService);
		
		boolean continua = true;
		do {
			Menu.menu1();
			int opcao1 = sc.nextInt();
			sc.nextLine();
			switch(opcao1) {
				case 1:
					Menu.menu2();
					String email = sc.nextLine();
					Cliente cliente = clienteService.confereEmail(email);
					boolean senhaCorreta = false;
					for (int i = 3; i > 0; i--) {
						System.out.println("Digite a sua senha: ");
						String senha = sc.nextLine();
						senhaCorreta = clienteService.conferirSenha(cliente, senha);
						if (!senhaCorreta) {
							System.out.println("Senha incorreta!!");
						} else {							
							break;
						}
					}
					if(!senhaCorreta) {
						break;
					}					
					Menu.menuCliente2();
					int opcaoCliente = sc.nextInt();
					if (opcaoCliente == 1) {
						Menu.listaVeiculos();
						veiculoService.buscarTodosVeiculosLivres();				
					} else if (opcaoCliente == 2) {
						Menu.listaVeiculos();
						clienteService.buscarVeiculosAlugados(cliente);
						int opcaoVeiculo = sc.nextInt();
						Veiculo veiculoDevolvido = veiculoService.devolverVeiculo(opcaoVeiculo);
						clienteService.removerVeiculo(cliente, veiculoDevolvido);
						break;
					}
					int veiculoID = sc.nextInt();
					Veiculo veiculo = veiculoService.alugarVeiculoPorID(veiculoID);
					clienteService.alugarVeiculo(cliente, veiculo);
					Menu.listaVendedores();
					vendedorService.todosVendedores();
					int vendedorID = sc.nextInt();
					vendedorService.salvarVeiculo(veiculo, vendedorID);
					
					
					break;
				case 2:
					Menu.menu2();
					email = sc.nextLine();
					Vendedor vendedor = vendedorService.confereEmail(email);
					senhaCorreta = false;
					for (int i = 3; i > 0; i--) {
						System.out.println("Digite a sua senha: ");
						String senha = sc.nextLine();
						senhaCorreta = vendedorService.conferirSenha(vendedor, senha);
						if (!senhaCorreta) {
							System.out.println("Senha incorreta!!");
						} else {							
							break;
						}
					}
					if(!senhaCorreta) {
						break;
					}	
					Menu.menuVendedor1();
					int opcao2 = sc.nextInt();
					if (opcao2 == 1) {
						vendedorService.mostrarAlugueisVeiculos(vendedor);
					} else if (opcao2 == 2) {
						vendedorService.verSalario(vendedor);
					} else if (opcao2 == 3) {
						vendedorService.verSalarioComComissao(vendedor);
					}
					break;
				case 3:
					Menu.menuAdministrador();
					opcao2 = sc.nextInt();
					adminService.confereEntrada(opcao2);
					break;
				case 0:
					continua = false;
					break;
				default:
					System.out.println("Alternativa inválida. Tente novamente!!!");
			}			
				
		} while (continua);
				
	}

}

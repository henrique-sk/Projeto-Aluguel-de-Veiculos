import java.util.InputMismatchException;
import java.util.Scanner;

import model.Administrador;
import model.Cliente;
import model.Veiculo;
import model.Vendedor;
import service.AdminService;
import service.ClienteService;
import service.VeiculoService;
import service.VendedorService;
import util.Menu;
import exception.SistemaException;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);

		ClienteService clienteService = new ClienteService(sc);
		VeiculoService veiculoService = new VeiculoService(sc);
		VendedorService vendedorService = new VendedorService(sc);
		AdminService adminService = new AdminService(sc, veiculoService, vendedorService);

		boolean continua = true;
		do {
			try {
				Menu.menu1();
				int opcao1 = sc.nextInt();
				sc.nextLine();
				switch (opcao1) {
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
					if (!senhaCorreta) {
						break;
					}
					Menu.menuCliente2();
					int opcao2 = sc.nextInt();
					if (opcao2 == 1) {
						Menu.listaVeiculos();
						veiculoService.buscarTodosVeiculosLivres();
						int veiculoID = sc.nextInt();
						Veiculo veiculo = veiculoService.alugarVeiculoPorID(veiculoID);
						clienteService.alugarVeiculo(cliente, veiculo);
						Menu.listaVendedores();
						vendedorService.mostrarTodosVendedores();
						int vendedorID = sc.nextInt();
						vendedorService.salvarVeiculo(veiculo, vendedorID);
					} else if (opcao2 == 2) {
						if(cliente.getVeiculos().size() <= 0) {
							throw new SistemaException("Você não possui veículos alugados!");
						}
						Menu.listaVeiculos();
						clienteService.buscarVeiculosAlugados(cliente);
						int opcaoVeiculo = sc.nextInt();
						Veiculo veiculoDevolvido = veiculoService.devolverVeiculo(cliente, opcaoVeiculo);
						clienteService.removerVeiculo(cliente, veiculoDevolvido);
					}

					break;
				case 2:
					Menu.menu2();
					email = sc.nextLine();
					Vendedor vendedor = vendedorService.confereEmail(email);
					if (vendedor == null) {
						throw new SistemaException("Vendedor não encontrado!");
					}
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
					if (!senhaCorreta) {
						break;
					}
					Menu.menuVendedor1();
					opcao2 = sc.nextInt();
					if (opcao2 == 1) {
						vendedorService.mostrarAlugueisVeiculos(vendedor);
					} else if (opcao2 == 2) {
						vendedorService.verSalario(vendedor);
					} else if (opcao2 == 3) {
						vendedorService.verSalarioComComissao(vendedor);
					}
					break;
				case 3:
					Menu.menu2();
					email = sc.nextLine();
					Administrador administrador = adminService.confereEmail(email);
					if (administrador == null) {
						throw new SistemaException("Administrador não encontrado!");
					}
					senhaCorreta = false;
					for (int i = 3; i > 0; i--) {
						System.out.println("Digite a sua senha: ");
						String senha = sc.nextLine();
						senhaCorreta = adminService.conferirSenha(administrador, senha);
						if (!senhaCorreta) {
							System.out.println("Senha incorreta!!");
						} else {
							break;
						}
					}
					if (!senhaCorreta) {
						break;
					}
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
			} catch (SistemaException e) {
				System.out.println(e.getMessage());
			} catch(InputMismatchException e) {
				System.out.println("Opção inválida!!");
				sc.next();
			} finally {
				Thread.sleep(1500l);
			}
		} while (continua);

	}

}

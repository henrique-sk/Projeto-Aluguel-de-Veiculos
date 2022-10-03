import java.util.Scanner;

import model.Cliente;
import model.Veiculo;
import service.AdminService;
import service.ClienteService;
import service.VeiculoService;
import util.Menu;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ClienteService clienteService = new ClienteService(sc);
		VeiculoService veiculoService = new VeiculoService(sc);
		AdminService adminService = new AdminService(sc, veiculoService);
		
		boolean continua = true;
		do {
			Menu.menu1();
			int opcao1 = sc.nextInt();
			sc.nextLine();
			switch(opcao1) {
				case 1:
					Menu.menuCliente1();
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
						Menu.escolherVeiculo();
						veiculoService.buscarTodosVeiculosLivres();
					}
					int veiculoID = sc.nextInt();
					Veiculo veiculo = veiculoService.alugarVeiculoPorID(veiculoID);
					clienteService.alugarVeiculo(cliente, veiculo);
					break;
				case 2:
					Menu.menuVendedor1();
					int opcao2 = sc.nextInt();
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

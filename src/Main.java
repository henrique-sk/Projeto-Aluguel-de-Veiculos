import java.util.Scanner;

import menu.Menu;
import model.Cliente;
import service.AdminService;
import service.ClienteService;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ClienteService clienteService = new ClienteService(sc);
		AdminService adminService = new AdminService(sc);
		
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
					System.out.println("Digite a sua senha: ");
					String senha = sc.nextLine();
					// teste bool pra conferir senha
					System.out.println(clienteService.conferirSenha(cliente, senha));
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

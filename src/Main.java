import java.util.Scanner;

import menu.Menu;
import repository.Repository;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean continua = true;
		
		do {
			Menu.menu1();
			int opcao1 = sc.nextInt();
			switch(opcao1) {
				case 1:
					Menu.menuCliente1();
					int opcao2 = sc.nextInt();
					break;
				case 2:
					Menu.menuVendedor1();
					opcao2 = sc.nextInt();
					break;
				case 3:
					Menu.menuAdministrador();
					opcao2 = sc.nextInt();
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

package util;

public class Menu {

	private static final String cabecalho = ""
			+ "--------------------------------------------\n"
			+ "Digite a opção desejada:\n";
	
	public static void menu1() {
		System.out.println(""
				+ "============================================\n"
				+ "Bem-vindo ao sistema de aluguel de veículos!\n"
				+ cabecalho
				+ "1 - Cliente\n"
				+ "2 - Vendedor\n"
				+ "3 - Administrador\n"
				+ "0 - Para sair do sistema");
	}
	
	public static void menuCliente1() {
		System.out.println(""
				+ "Digite seu e-mail: ");
	}
	
	public static void menuCliente2() {
		System.out.println(""
				+ cabecalho
				+ "1 - Alugar um veículo\n"
				+ "2 - Devolver um veículo");
	}
	
	public static void menuVendedor1() {
		System.out.println(""
				+ cabecalho
				+ "1 - Ver os veículos que você alugou\n"
				+ "2 - Ver seu salário\n"
				+ "3 - Ver seu salário com a comissão atual");
	}
	
	public static void menuAdministrador() {
		System.out.println(""
				+ cabecalho
				+ "1 - Cadastrar um veículo\n"
				+ "2 - Remover um veículo\n"
				+ "3 - Cadastrar um vendedor\n"
				+ "4 - Remover um vendedor");
	}
	
	public static void listaVeiculos() {
		System.out.println(""
				+ "--------------------------------------------\n"
				+ "Digite o número referente ao veívulo desejado:");
	}
}

package menu;

public class Menu {

	private static final String titulo = ""
			+ "--------------------------------------------\n"
			+ "Digite a opção desejada:\n";
	
	public static void menu1() {
		System.out.println(""
				+ "============================================\n"
				+ "Bem-vindo ao sistema de aluguel de veículos!\n"
				+ titulo
				+ "1 - Cliente\n"
				+ "2 - Vendedor\n"
				+ "2 - Administrador\n"
				+ "0 - Para sair do sistema");
	}
	
	public static void menuCliente1() {
		System.out.println(""
				+ "Você já tem cadastro? Digite seu e-mail: \n"
				+ "Digite 2 se você não tem cadastro");
	}
	
	public static void menuCliente2() {
		System.out.println(""
				+ titulo
				+ "1 - Alugar um veículo\n"
				+ "2 - Devolver um veículo");
	}
	
	public static void menuVendedor1() {
		System.out.println(""
				+ titulo
				+ "1 - Ver os veículos que você alugou\n"
				+ "2 - Ver seu salário\n"
				+ "3 - Ver seu salário com a comissão atual");
	}
	
	public static void menuAdministrador() {
		System.out.println(""
				+ titulo
				+ "1 - Cadastrar um veículo\n"
				+ "2 - Remover um veículo\n"
				+ "Cadastrar um vendedor\n"
				+ "Remover um vendedor");
	}
}

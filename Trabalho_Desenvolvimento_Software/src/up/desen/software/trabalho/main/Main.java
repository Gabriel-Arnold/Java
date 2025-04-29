package up.desen.software.trabalho.main;

import java.util.ArrayList;
import java.util.Scanner;

import up.desen.software.trabalho.classes.Estabelecimento;
import up.desen.software.trabalho.classes.Produto;
import up.desen.software.trabalho.classes.Usuario;

public class Main {
	
	private static ArrayList<Estabelecimento> Estabelecimentos = new ArrayList<Estabelecimento>();
	private static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int select = -1;
		
		do {
			System.out.println("\n===============================");
			System.out.println("1 - Acessar painel do cliente.");
			System.out.println("2 - Acessar painel do administrador.");
			System.out.println("0 - Sair do programa.");
			System.out.println("===============================");
			
			
			System.out.println("\nSelecione a opção desejada:");
			System.out.println("\n==========[ CLIENTE ]==========");
			System.out.println("1 - Fazer login/cadastro.");
			System.out.println("2 - Fazer pedido.");
			System.out.println("3 - Vizualizar status do pedido.");
			System.out.println("===============================");
			System.out.println("\n==========[ ADMINISTRADOR ]==========");
			System.out.println("4 - Cadastrar novo Estabelecimento.");
			System.out.println("5 - Excluir Estabelecimento.");
			System.out.println("6 - Gerenciar Estabelecimento.");
			System.out.println("7 - Listar Estabelecimentos.");
			System.out.println("8 - Listar Pedidos.");
			System.out.println("9 - Listar Usuarios.");
			System.out.println("10 - Concluir Entrega.");
			System.out.println("===============================");
			System.out.println("0 - Sair do programa.");
			
			System.out.println("\nDigite a opção que deseja: ");
			select = sc.nextInt();
			
			switch (select) {
			case 1: {
				
			}
			case 2: {
				
			}
			case 3: {
				
			}
			case 4: {
				cadastrasEstabelecimento(sc);
				continue;
			}
			case 5: {
				excluirEstabelecimento(sc);
			}
			case 6: {
				gerenciarEstabelecimento(sc);
				continue;
			}
			case 7: {
				listarEstabelecimentos();
				continue;
			}
			case 8: {
				
			}
			case 9: {
				
			}
			case 19: {
				
			}
			case 0: {
				System.out.println("\nObrigado pela preferência.");
			}
			default:
				System.out.println("\nOpção selecionada invalida.");;
			}
		}while(select != 0);
		
		sc.close();
	}
	
	private static void Login_Cadastro_Usuario(Scanner sc) {
		int select = -1;
		do {
			System.out.println("==================");
			System.out.println("1 - Logar em um usuario");
			System.out.println("2 - Registrar um novo usuario");
			System.out.println("0 - Para voltar.");
			System.out.println("Digite a opção desejada:");
			select = sc.nextInt();
			if(select > 0 && select < 3) {
				break;
			} else {
				System.out.println("\nOpção selecionada invalida.");
			}
		}while(select !=0);
		if(select == 1) {
			String usuario;
			Usuario user = null;
			do {
				System.out.println("Digite o usuario ou digite sair para voltar:");
				usuario = sc.next();
				
				for(Usuario u : usuarios) {
					if(u.getUsuario() == usuario) {
						user = u;
						break;
					}
				}
				System.out.println("Esse usuario não existe.");
			}while(!usuario.equalsIgnoreCase("sair"));
			if(usuario.equalsIgnoreCase("sair")) return;
			if(user != null) {
				String senha;
				do {
					System.out.println("Digite a senha: ");
					senha = sc.next();
					if(user.getSenha() == senha) {
						break;
						
						// Continuar
						
					}
					System.out.println("Senha incorreta.");
				}while(!senha.equalsIgnoreCase("sair"));
			} else {
				System.out.println("ERRO: 1");
				return;
			}
		} else if(select == 2) {
			
		} else {
			System.out.println("ERRO: 1");
		}
	}
	
	private static void cadastrasEstabelecimento(Scanner sc) {
		String nome;
		int id = 0;
		
		for(Estabelecimento estab : Estabelecimentos) {
			if(id <= estab.getID()) id = estab.getID();
		}
		
		id++;
		
		System.out.println("\nDigite o nome do Estabelecimento: ");
		nome = sc.next();
		
		Estabelecimento estabelecimento = new Estabelecimento(id, nome);
		Estabelecimentos.add(estabelecimento);
		
		System.out.println("Estabelecimento cadastrado.");
	}
	
	private static void gerenciarEstabelecimento(Scanner sc) {
		int id = -1;
		Estabelecimento estab = null;
		do {
			System.out.println("\nDigite o id do estabelecimento ou 0 para voltar: ");
			id = Integer.valueOf(sc.next());
			Boolean encontrado = false;
			for(Estabelecimento e : Estabelecimentos) {
				if(e.getID() == id) {
					estab = e;
					encontrado = true;
					break;
				}
			}
			if(encontrado) break;
			System.out.println("Nenhum estabelecimento cadastrado com esse id.");
		}while(id != 0);
		
		if(id == 0) return;
		if(estab == null) {
			System.out.println("ERRO: 1");
		}
		
		int select = -1;
		
		do {
			System.out.println("\nSelecione a opção desejada:");
			System.out.println("\n==========[ " + estab.getNome() + " ]==========");
			System.out.println("1 - Listar produtos.");
			System.out.println("2 - Cadastrar novo produto.");
			System.out.println("3 - Excluir produto.");
			System.out.println("4 - Gerenciar produto.");
			System.out.println("0 - Voltar.");
			System.out.println("===============================");
			
			System.out.println("\nDigite a opção que deseja: ");
			select = sc.nextInt();
			
			switch (select) {
			case 1: {
				estab.ListarProdutos();
				continue;
			}
			case 2: {
				System.out.println("Digite o nome do produto");
				String nome = sc.next();
				System.out.println("Digite o preço do produto");
				Double preco = 0.0;
				do {
					preco = sc.nextDouble();
					if(preco <= 0) {
						System.out.println("O preço deve ser maior que 0");
					}
				}while(preco <= 0);
				estab.addProduto(nome, preco);
				System.out.println("Produto cadastrado.");
				continue;
			}
			case 3: {
				System.out.println("Digite o id do produto que deseja excluir:");
				int id_produto = sc.nextInt();
				estab.removerProduto(id_produto);
			}
			case 4: {
				gerenciarProduto(sc, estab);
			}
			case 0: {
				return;
			}
			default:
				System.out.println("Opção selecionada inválida.");;
			}
		} while(select != 0);
	}
	
	private static void gerenciarProduto(Scanner sc, Estabelecimento estab) {
		int id = -1;
		Produto produto = null;
		do {
			System.out.println("Digite o id do produto que quer gerenciar:");
			id = sc.nextInt();
			if(id > 0) {
				produto = estab.getProduto(id);
				break;
			}
		}while(id != 0);
		if(produto != null) {
			int select = -1;
			do {
				System.out.println("\nSelecione a opção desejada:");
				System.out.println("\n==========[ " + produto.getNome() + " ]==========");
				System.out.println("1 - Alterar nome.");
				System.out.println("2 - Alterar preço.");
				System.out.println("0 - Voltar.");
				System.out.println("===============================");
				
				System.out.println("\nDigite a opção que deseja: ");
				select = sc.nextInt();
				
				switch (select) {
				case 1: {
					System.out.println("Digite o nome do produto: ");
					String nome = sc.next();
					produto.setNome(nome);
					System.out.println("Nome do produto alterado para " + nome);
				}
				case 2: {
					System.out.println("Digite o preço do produto: ");
					Double preco = 0.0;
					do {
						preco = sc.nextDouble();
						if(preco <= 0) {
							System.out.println("O preço deve ser maior que 0");
						}
					}while(preco <= 0);
					produto.setPreco(preco);
					System.out.println("O preço do produto foi alterado para: " + preco);
				}
				case 0: {
					return;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + select);
				}
				
			}while(select != 0);
		} else {
			System.out.println("ERRO: 1");
			return;
		}
	}
	
	private static void listarEstabelecimentos() {
		if(Estabelecimentos.isEmpty()) {
			System.out.println("Não há estabelecimentos cadastrados.");
			return;
		}
		System.out.println("\nEstabelecimentos cadastrados: ");
		System.out.println("ID - Nome");
		for(Estabelecimento e : Estabelecimentos) {
			System.out.println(e.getID() + " - " + e.getNome());
		}
	}
	
	private static void excluirEstabelecimento(Scanner sc) {
		System.out.println("Digite o id do estabelecimento que deseja excluir: ");
		int id = sc.nextInt();
		Estabelecimento estab = null;
		for(Estabelecimento e : Estabelecimentos) {
			if(e.getID() == id) {
				estab = e;
			}
		}
		if(estab != null) {
			System.out.println("Tem certeza que quer excluir o estabeleciomento " + estab.getNome());
			System.out.println("Digite 1 para excluir ou 0 para cancelar:");
			int select = -1;
			do {
				select = sc.nextInt();
				if(select == 1) {
					Estabelecimentos.remove(estab);
					System.out.println("Estabeleciomento excluido.");
					return;
				} else if(select == 0) {
					return;
				}
				System.out.println("Valor digitado inválido.");
			}while (select != 0);
		} else {
			System.out.println("Estabelecimento não encontrado.");
		}
	}

}

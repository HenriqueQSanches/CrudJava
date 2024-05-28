	package escolhas;
	
	import java.sql.SQLException;
	import java.util.Scanner;
	
	import conexao.Conexao;
	
	public class Escolhas {
	
		public void Escolhas() throws ClassNotFoundException, SQLException {
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("O que você deseja fazer?");
			System.out.println("1: Exibir tabela do Banco de Dados");
			System.out.println("2: Inserir usuário no Banco de Dados");
			System.out.println("3: Excluir usuário do Banco de Dados");
			System.out.println("4: Atualizar usuário do Banco de Dados");
			
			while (!scanner.hasNextInt()) {
				System.out.println("Por favor, insira um número válido");
				scanner.next();
				
			}
			
			int userInput = scanner.nextInt();
			
			switch (userInput) {
			
						// Primeiro caso, nós vamos exibir as informações do Banco de Dados \\
				case 1:
					System.out.println("Vamos visualizar a tabela do Banco de Dados");
					
					Conexao.displayDatabaseInfo();
					
					break;
					
				case 2:
					System.out.println("Vamos adicionar um usuário no Banco de Dados");
					
					// AQUI O USUÁRIO INSERE O QUE ELE QUER \\
					
					Scanner scanner1 = new Scanner(System.in);
					
					System.out.println("Qual o nome que você deseja inserir?");
					String nome = scanner1.nextLine();
					
					System.out.println("Qual email que você deseja inserir?");
					String email = scanner1.nextLine();
					
					System.out.println("Qual idade do Usuário?");
					int idade = scanner1.nextInt();
					
						Conexao.inserirTabela(nome, email, idade);
						System.out.println("Usuário adicionado com sucesso!");
					
					
					break;
					
				case 3:
					System.out.println("Vamos excluir um usuário do Banco de Dados");
					System.out.println("Insira a ID do usuário que você deseja EXCLUIR");
					
					int id = scanner.nextInt();
					Conexao.excluirUsuario(id);
					
					System.out.println("Usuário foi excluido com sucesso!");
					
					break;
				
				case 4: 
					System.out.println("Vamos atualizar um usuário do Banco de Dados");
					
					System.out.println("Insira a ID do usuário que você deseja ALTERAR");
					int id1 = scanner.nextInt();
					scanner.nextLine();
					
					System.out.println("Qual nome você deseja colocar?");
					String novoNome = scanner.nextLine();
					
					System.out.println("Qual email que você deseja colocar?");
					String novoEmail = scanner.nextLine();
					
					System.out.println("Qual idade que você deseja colocar?");
					int novoIdade = scanner.nextInt();
					
					Conexao.atualizarUsuario(id1, novoNome, novoEmail, novoIdade);
					System.out.println("Usuário atualizado com sucesso!");
					
					
					break;
					
				default:
					System.out.println("Opção inválida!");
					Escolhas();
			}
			
				
			
		}
		
	}

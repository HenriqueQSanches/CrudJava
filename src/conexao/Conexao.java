package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class Conexao {

	
	private static final String USERNAME = "root";
	
	private static final String PASSWORD = "";
	
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/crud";
	
	public static Connection createConnectionToMySQL() throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = (Connection) DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		return connection;
	}
	
	
	public static void displayDatabaseInfo() throws ClassNotFoundException, SQLException {
		
		Connection con = createConnectionToMySQL();
		
		if (con != null) {
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * from pessoas");
			
		while (rs.next()) {
			int campo1 = rs.getInt(1);
			String campo2 = rs.getString("nome");
			String campo3 = rs.getString("email");
			
			System.out.println("Informações da Tabela:");
			System.out.println("ID do Usuário: " + campo1);
			System.out.println("Nome do Usuário: " + campo2);
			System.out.println("Email do Usuário: " + campo3);
			System.out.println("");
			
		}
		
		con.close();
		
		} else {
			System.out.println("A consulta falhou...");
		}
		
	}
	
	public static void inserirTabela(String nome, String email, int idade) throws ClassNotFoundException, SQLException {
		
		Connection con = createConnectionToMySQL();
		
		if (con != null) {
			
			Statement stmt = con.createStatement();
			
			String sql = "INSERT INTO pessoas (nome, email, idade) VALUES ('" + nome + "', '" + email + "', '" + idade + "')";
			
			stmt.executeUpdate(sql);
			
			con.close();
			
			
		} else {
			System.out.println("Você não conseguiu adicionar");
		}
		
	}
	
	public static void excluirUsuario(int id) throws ClassNotFoundException, SQLException {
		
		Connection con = createConnectionToMySQL();
		
		if (con != null) {
			
			Statement stmt = con.createStatement();
			String sql = "DELETE FROM pessoas WHERE ID = " + id;
			
			stmt.executeUpdate(sql);
			con.close();
			
		} else {
			
			System.out.println("Não foi possível excluir o usuário");
			
		}
		
	}
	
	
	public static void atualizarUsuario(int id, String novoNome, String novoEmail, int novoIdade) throws ClassNotFoundException, SQLException {
		
		Connection con = createConnectionToMySQL();
		
		if (con != null) {
			
			Statement stmt = con.createStatement();
			
			String sql = "UPDATE pessoas SET nome = '" + novoNome + "', email = '" + novoEmail + "', idade =  '" + novoIdade + "' WHERE id = " + id;
			
			stmt.executeUpdate(sql);
			con.close();
			
			
		} else {
			
			System.out.println("Não foi possivel atualizar o usuário");
			
		}
		
	}
	
}

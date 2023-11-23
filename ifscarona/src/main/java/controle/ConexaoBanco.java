package controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {	
	private static Connection conexao;
	private static ConexaoBanco instancia;
	private static final String DATABASE = "bd_ifscarona";
	private static final String USER     = "root";
	private static final String PSW      = "aluno";

	public ConexaoBanco() {}

	public static ConexaoBanco getInstancia() {
		if (instancia == null) { 
			instancia = new ConexaoBanco(); 
		}
		return instancia;	
	}

	public Connection conectar() {
		try {
			conexao = DriverManager.getConnection("jdbc:mysql://localhost/"+ DATABASE + "?serverTimezone=UTC", USER, PSW);
		} catch (Exception e) { 
			e.printStackTrace(); 
		}
		return conexao;		
	}

	public boolean fecharConexao() { 
		try { 
			conexao.close(); 
		} 
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
}
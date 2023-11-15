package controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {
    private static Connection conexao;
    private static ConexaoBanco instancia;
    private static final String DATABASE = "bd_ifscarona";
    private static final String USER = "ifscarona";
    private static final String PASSWORD = "Aluno1234!";
    private static final String SERVER = "ifscarona.mysql.database.azure.com";
    private static final String PORT = "3306";

    private ConexaoBanco() {
    }

    public static ConexaoBanco getInstancia() {
        if (instancia == null) {
            instancia = new ConexaoBanco();
        }
        return instancia;
    }

    public Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://ifscarona.mysql.database.azure.com:3306/bd_ifscarona?useSSL=true";

            conexao = DriverManager.getConnection(url, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conexao;
    }

    public boolean fecharConexao() {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}

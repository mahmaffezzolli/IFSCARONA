package controle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.ITrajetoDAO;
import modelo.Trajeto;

public class TrajetoDAO implements ITrajetoDAO {

	private static TrajetoDAO instancia;

	private TrajetoDAO() {

	}

	public static TrajetoDAO getInstancia() {
		if (instancia == null) {
			instancia = new TrajetoDAO();
		}
		return instancia;
	}

	@Override
	public boolean cadastrarTrajeto(Trajeto trajeto) {
		ConexaoBanco c = ConexaoBanco.getInstancia();

		Connection con = c.conectar();

		String query = "INSERT INTO trajeto " + "(origem, destino) " + "VALUES (?, ?)";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, trajeto.getOrigem());
			ps.setString(2, trajeto.getDestino());

			ps.executeUpdate();

			c.fecharConexao();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean alterarTrajeto(Trajeto trajeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletarTrajeto(Trajeto trajeto) {
		// TODO Auto-generated method stub
		return false;
	}

}
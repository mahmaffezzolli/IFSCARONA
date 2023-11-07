package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
	public Long cadastrarTrajeto(Trajeto trajeto) {
		if (trajeto != null) {
			ConexaoBanco c = ConexaoBanco.getInstancia();
			Connection con = c.conectar();

			String query = "INSERT INTO trajetos (origem, destino) VALUES (?, ?)";

			try {
				PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

				ps.setString(1, trajeto.getOrigem());
				ps.setString(2, trajeto.getDestino());

				ps.executeUpdate();

				try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
					if (generatedKeys.next()) {
						return generatedKeys.getLong(1);
					} else {
						throw new SQLException("Creating user failed, no ID obtained.");
					}
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				c.fecharConexao();
			}
		}
		return 0l;
	}

	@Override
	public boolean alterarTrajeto(Trajeto trajeto) {

		ConexaoBanco c = ConexaoBanco.getInstancia();
		Connection con = c.conectar();

		String query = "UPDATE trajetos SET origem = ?, destino = ? WHERE id_trajeto = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, trajeto.getOrigem());
			ps.setString(2, trajeto.getDestino());
			ps.setLong(3, trajeto.getIdTrajeto());

			int rowsAffected = ps.executeUpdate();

			if (rowsAffected > 0) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			c.fecharConexao();

		}
		return false;
	}

	@Override
	public boolean deletarTrajeto(Trajeto trajeto) {

		if (trajeto != null) {

			ConexaoBanco c = ConexaoBanco.getInstancia();
			Connection con = c.conectar();

			String query = "DELETE FROM trajetos WHERE id_trajeto = ?";

			try {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setLong(1, trajeto.getIdTrajeto());

				int rowsAffected = ps.executeUpdate();

				if (rowsAffected > 0) {
					return true;
				} else {
					return false;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {

				c.fecharConexao();
			}
		}
		return false;
	}

	public ArrayList<Trajeto> listarTrajetos() {

		ConexaoBanco c = ConexaoBanco.getInstancia();

		Connection con = c.conectar();

		ArrayList<Trajeto> trajetos = new ArrayList<>();

		String query = "SELECT * FROM trajetos";

		try {
			PreparedStatement tj = con.prepareStatement(query);

			ResultSet rs = tj.executeQuery();

			while (rs.next()) {

				Long idTrajeto = rs.getLong("id_trajeto");
				String origem = rs.getString("origem");
				String destino = rs.getString("destino");

				Trajeto t = new Trajeto();
				t.setIdTrajeto(idTrajeto);
				t.setOrigem(origem);
				t.setDestino(destino);

				trajetos.add(t);
			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			c.fecharConexao();
		}

		return trajetos;
	}

}
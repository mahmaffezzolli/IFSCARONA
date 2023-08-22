package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	public boolean cadastrarTrajeto(Trajeto trajeto) {

		ConexaoBanco c = ConexaoBanco.getInstancia();
		Connection con = c.conectar();

		String query = "INSERT INTO trajetos " + "(origem, destino) " + "VALUES (?, ?)";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, trajeto.getOrigem());
			ps.setString(2, trajeto.getDestino());

			ps.executeUpdate();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			c.fecharConexao();

		}
		return false;
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
			ps.setInt(3, trajeto.getIdTrajeto());

			ps.executeUpdate();

			return true;

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			c.fecharConexao();
		}

		return false;
	}

	@Override
	public boolean deletarTrajeto(Trajeto trajeto) {
		ConexaoBanco c = ConexaoBanco.getInstancia();

		Connection con = c.conectar();

		String query = "DELETE FROM trajetos WHERE id_trajeto = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, trajeto.getIdTrajeto());
			ps.setString(1, trajeto.getOrigem());
			ps.setString(1, trajeto.getDestino());
			ps.executeUpdate();

			c.fecharConexao();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public ArrayList<Trajeto> listarTrajeto(Trajeto trajeto) {

		ConexaoBanco c = ConexaoBanco.getInstancia();

		Connection con = c.conectar();

		ArrayList<Trajeto> trajetos = new ArrayList<>();

		String query = "SELECT * FROM trajetos";

		try {
			PreparedStatement tj = con.prepareStatement(query);

			ResultSet rs = tj.executeQuery();

			while (rs.next()) {

				Integer idTrajeto = rs.getInt("id_trajeto");
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
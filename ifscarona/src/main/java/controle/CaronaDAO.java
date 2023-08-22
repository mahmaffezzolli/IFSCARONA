package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Carona;
import modelo.ICaronaDAO;

public class CaronaDAO implements ICaronaDAO {

	private static CaronaDAO instancia;

	private CaronaDAO() {

	}

	public static CaronaDAO getInstancia() {
		if (instancia == null) {
			instancia = new CaronaDAO();
		}
		return instancia;
	}

	@Override
	public boolean cadastrarCarona(Carona carona) {
		ConexaoBanco c = ConexaoBanco.getInstancia();

		Connection con = c.conectar();

		String query = "INSERT INTO caronas " + "(trajeto, passageiro, motorista) " + "VALUES (?, ?, ?)";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, carona.getTrajeto().getIdTrajeto());
			// ps.setString(2, carona.getPassageiro());
			ps.setLong(3, carona.getMotorista().getCpf());

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
	public boolean alterarCarona(Carona carona) {
		ConexaoBanco c = ConexaoBanco.getInstancia();

		Connection con = c.conectar();
		
		String query = "UPDATE caronas SET" + "trajeto = ? WHERE id_carona = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, carona.getIdCarona());
			ps.executeUpdate();
			
			c.fecharConexao();
			
			return true;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean deletarCarona(Carona carona) {
		ConexaoBanco c = ConexaoBanco.getInstancia();

		Connection con = c.conectar();
		
		String query = "DELETE FROM caronas WHERE id_carona = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, carona.getIdCarona());
			ps.executeUpdate();
			
			c.fecharConexao();
			
			return true;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public ArrayList<Carona> listarCarona(Carona carona) {

		ConexaoBanco c = ConexaoBanco.getInstancia();

		Connection con = c.conectar();

		ArrayList<Carona> caronas = new ArrayList<>();

		String query = "SELECT * FROM caronas";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

			}

		} catch (SQLException e) {

			e.printStackTrace();
			
		}finally {
			
			c.fecharConexao();
		}

		return caronas;
	}

}

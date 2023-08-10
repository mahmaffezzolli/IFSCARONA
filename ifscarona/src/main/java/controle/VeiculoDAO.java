package controle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.IVeiculoDAO;
import modelo.Veiculo;

public class VeiculoDAO implements IVeiculoDAO {

	private static VeiculoDAO instancia;

	private VeiculoDAO() {

	}

	public static VeiculoDAO getInstancia() {
		if (instancia == null) {
			instancia = new VeiculoDAO();
		}
		return instancia;
	}

	@Override
	public boolean cadastrarVeiculo(Veiculo veiculo) {
		ConexaoBanco c = ConexaoBanco.getInstancia();

		Connection con = c.conectar();

		String query = "INSERT INTO veiculo " + "(placa, cor, marca, modelo) " + "VALUES (?, ?, ?, ?)";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, veiculo.getPlaca());
			ps.setString(2, veiculo.getCor());
			ps.setString(3, veiculo.getMarca());
			ps.setString(5, veiculo.getModelo());

			ps.executeUpdate();

			c.fecharConexao();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean alterarVeiculo(Veiculo veiculo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletarVeiculo(Veiculo veiculo) {
		// TODO Auto-generated method stub
		return false;
	}

}
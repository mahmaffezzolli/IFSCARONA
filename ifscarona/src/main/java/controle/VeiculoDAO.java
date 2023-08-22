package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

		String query = "INSERT INTO veiculos " + "(placa, cor, marca, modelo) " + "VALUES (?, ?, ?, ?)";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, veiculo.getPlaca());
			ps.setString(2, veiculo.getCor());
			ps.setString(3, veiculo.getMarca());
			ps.setString(5, veiculo.getModelo());

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
	public boolean alterarVeiculo(Veiculo veiculo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletarVeiculo(Veiculo veiculo) {
		ConexaoBanco c = ConexaoBanco.getInstancia();

		Connection con = c.conectar();
		
		String query = "DELETE FROM veiculos WHERE id_veiculo = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, veiculo.getIdVeiculo());
			ps.setString(1, veiculo.getPlaca());
			ps.setString(1, veiculo.getCor());
			ps.setString(1, veiculo.getMarca());
			ps.setString(1, veiculo.getModelo());
			ps.executeUpdate();
			
			c.fecharConexao();
			
			return true;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}


	public ArrayList<Veiculo> listarVeiculo(Veiculo veiculo) {

		ConexaoBanco c = ConexaoBanco.getInstancia();

		Connection con = c.conectar();

		ArrayList<Veiculo> veiculos = new ArrayList<>();

		String query = "SELECT * FROM veiculos";

		try {
			PreparedStatement vs = con.prepareStatement(query);

			ResultSet rs = vs.executeQuery();
			
			while (rs.next()) {
				
				Integer idVeiculo = rs.getInt("id_veiculo");
				String placa = rs.getString("placa");
				String cor = rs.getString("cor");
				String marca = rs.getString("marca");
				String modelo = rs.getString("modelo");

				Veiculo v = new Veiculo();

				v.setIdVeiculo(idVeiculo);
				v.setPlaca(placa);
				v.setCor(cor);
				v.setMarca(marca);
				v.setModelo(modelo);

				veiculos.add(v);
			}

		} catch (SQLException e) {

			e.printStackTrace();
			
		}finally {
			
			c.fecharConexao();
		}

		return veiculos;
	}

}
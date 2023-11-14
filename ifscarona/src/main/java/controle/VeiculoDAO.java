package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Carro;
import modelo.IVeiculoDAO;
import modelo.Pessoa;
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
	public Long cadastrarVeiculo(Carro carro) {
		ConexaoBanco c = ConexaoBanco.getInstancia();

		Connection con = c.conectar();

		String query = "INSERT INTO veiculos (placa, cor, marca, modelo, cpf_pessoa) VALUES (?, ?, ?, ?, ?)";

		try {
			PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			;

			ps.setString(1, carro.getPlaca());
			ps.setString(2, carro.getCor());
			ps.setString(3, carro.getMarca());
			ps.setString(4, carro.getModelo());
			ps.setString(5, carro.getMotorista().getCpf());

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

		return 0l;
	}

	@Override
	public boolean alterarVeiculo(Carro carro) {
		ConexaoBanco c = ConexaoBanco.getInstancia();
		Connection con = c.conectar();

		String query = "UPDATE veiculos SET placa = ?, cor = ?, marca = ?, modelo = ? WHERE cpf_pessoa = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, carro.getPlaca());
			ps.setString(2, carro.getCor());
			ps.setString(3, carro.getMarca());
			ps.setString(4, carro.getModelo());
			ps.setString(5, carro.getMotorista().getCpf());

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
	public boolean deletarVeiculo(Carro carro) {
		ConexaoBanco c = ConexaoBanco.getInstancia();

		Connection con = c.conectar();

		String query = "DELETE FROM veiculos WHERE id_veiculo = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setLong(1, carro.getIdVeiculo());

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

	public ArrayList<Carro> listarVeiculos() {

		ConexaoBanco c = ConexaoBanco.getInstancia();

		Connection con = c.conectar();

		ArrayList<Carro> carros = new ArrayList<>();

		String query = "SELECT * FROM veiculos";

		try {
			PreparedStatement vs = con.prepareStatement(query);

			ResultSet rs = vs.executeQuery();

			while (rs.next()) {

				String cpf = rs.getString("cpf_pessoa");
				String placa = rs.getString("placa");
				String cor = rs.getString("cor");
				String marca = rs.getString("marca");
				String modelo = rs.getString("modelo");

				Pessoa p = new Pessoa();
				p.setCpf(cpf);

				Carro carro = new Carro();

				carro.setMotorista(p);
				carro.setPlaca(placa);
				carro.setCor(cor);
				carro.setMarca(marca);
				carro.setModelo(modelo);

				carros.add(carro);
			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			c.fecharConexao();
		}

		return carros;
	}

	public Carro conexaoVeiculoPessoa(Pessoa motorista) {

		ConexaoBanco c = ConexaoBanco.getInstancia();
		Connection con = c.conectar();

		Carro carro = null;

		String query = "SELECT * FROM veiculos WHERE cpf_pessoa = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, motorista.getCpf());

			try (ResultSet rs = ps.executeQuery()) {

				if (rs.next()) {
					String placa = rs.getString("placa");
					String cor = rs.getString("cor");
					String marca = rs.getString("marca");
					String modelo = rs.getString("modelo");
					Long idVeiculo = rs.getLong("id_veiculo");

					carro = new Carro();
					
					carro.setMotorista(motorista);
					carro.setPlaca(placa);
					carro.setCor(cor);
					carro.setMarca(marca);
					carro.setModelo(modelo);
					carro.setIdVeiculo(idVeiculo);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return carro;
	}

}
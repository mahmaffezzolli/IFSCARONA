package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.IVeiculoDAO;
import modelo.Pessoa;
import modelo.Sessao;
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

		String query = "INSERT INTO veiculos (placa, cor, marca, modelo, cpf_pessoa) VALUES (?, ?, ?, ?, ?)";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, veiculo.getPlaca());
			ps.setString(2, veiculo.getCor());
			ps.setString(3, veiculo.getMarca());
			ps.setString(4, veiculo.getModelo()); 
			ps.setString(5, veiculo.getPessoa().getCpf());

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
		ConexaoBanco c = ConexaoBanco.getInstancia();
		Connection con = c.conectar();

		
			String query = "UPDATE veiculos SET placa = ?, cor = ?, marca = ?, modelo = ? WHERE cpf_pessoa = ?";

			try {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, veiculo.getPlaca());
				ps.setString(2, veiculo.getCor());
				ps.setString(3, veiculo.getMarca());
				ps.setString(4, veiculo.getModelo());
				ps.setString(5, veiculo.getPessoa().getCpf());

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
	public boolean deletarVeiculo(Veiculo veiculo) {
		ConexaoBanco c = ConexaoBanco.getInstancia();

		Connection con = c.conectar();

		String query = "DELETE FROM veiculos WHERE cpf_pessoa = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, veiculo.getPessoa().getCpf());

			ps.executeUpdate();

			return true;

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			c.fecharConexao();
		}

		return false;
	}

	public ArrayList<Veiculo> listarVeiculos() {

		ConexaoBanco c = ConexaoBanco.getInstancia();

		Connection con = c.conectar();

		ArrayList<Veiculo> veiculos = new ArrayList<>();

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

				Veiculo v = new Veiculo();
				
				//v.setPessoa();
				v.setPlaca(placa);
				v.setCor(cor);
				v.setMarca(marca);
				v.setModelo(modelo);

				veiculos.add(v);
			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			c.fecharConexao();
		}

		return veiculos;
	}

	public Veiculo conexaoVeiculoPessoa(Pessoa pessoa) {

		ConexaoBanco c = ConexaoBanco.getInstancia();
		Connection con = c.conectar();

		Veiculo veiculo = null;

		String query = "SELECT * FROM veiculos WHERE cpf_pessoa = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, pessoa.getCpf());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				String cpfPessoa = rs.getString("cpf_pessoa");
				String placa = rs.getString("placa");
				String cor = rs.getString("cor");
				String marca = rs.getString("marca");
				String modelo = rs.getString("modelo");

				veiculo = new Veiculo();

				veiculo.setPessoa(pessoa);
				veiculo.setPessoa(pessoa);
				veiculo.setPlaca(placa);
				veiculo.setCor(cor);
				veiculo.setMarca(marca);
				veiculo.setModelo(modelo);

			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			c.fecharConexao();

		}

		return veiculo;
	}

}
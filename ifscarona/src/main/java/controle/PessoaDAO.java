package controle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import modelo.Carro;
import modelo.IPessoaDAO;
import modelo.Pessoa;
import modelo.Veiculo;

public class PessoaDAO implements IPessoaDAO {

	private static PessoaDAO instancia;

	private PessoaDAO() {

	}

	public static PessoaDAO getInstancia() {
		if (instancia == null) {
			instancia = new PessoaDAO();
		}
		return instancia;
	}

	@Override
	public String cadastrarPessoa(Pessoa pessoa) {
		if (pessoa == null || pessoa.getNome() == null || pessoa.getCpf() == null || pessoa.getDataNasc() == null
				|| pessoa.getEmail() == null || pessoa.getSenha() == null) {
			// At least one required attribute is null
			return null;
		}

		ConexaoBanco c = ConexaoBanco.getInstancia();
		Connection con = c.conectar();

		String query = "INSERT INTO pessoas " + "(nome, sobrenome, cpf, data_nasc, senha, email) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, pessoa.getNome());
			ps.setString(2, pessoa.getSobrenome());
			ps.setString(3, pessoa.getCpf());
			ps.setDate(4, Date.valueOf(pessoa.getDataNasc()));
			ps.setString(5, pessoa.getSenha());
			ps.setString(6, pessoa.getEmail());

			ps.executeUpdate();

			return pessoa.getCpf();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}
		return null;
	}

	@Override
	public boolean alterarPessoa(Pessoa pessoa) {

		ConexaoBanco c = ConexaoBanco.getInstancia();
		Connection con = c.conectar();

		String query = "UPDATE pessoas SET nome = ?, sobrenome = ? WHERE cpf = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, pessoa.getNome());
			ps.setString(2, pessoa.getSobrenome());
			ps.setString(3, pessoa.getCpf());

			int rowsAffected = ps.executeUpdate();

			if (rowsAffected > 0) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			c.fecharConexao();
		}
	}

	@Override

	public boolean deletarPessoa(Pessoa pessoa) {

		if (pessoa != null) {

			ConexaoBanco c = ConexaoBanco.getInstancia();
			Connection con = c.conectar();

			String query = "DELETE FROM pessoas WHERE cpf = ?";

			try {
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, pessoa.getCpf());

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

	@Override
	public ArrayList<Pessoa> listarPessoas() {

		ConexaoBanco c = ConexaoBanco.getInstancia();

		Connection con = c.conectar();

		ArrayList<Pessoa> pessoas = new ArrayList<>();

		String query = "SELECT * FROM pessoas";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				String cpf = rs.getString("cpf");
				String nome = rs.getString("nome");
				String sobrenome = rs.getString("sobrenome");
				String email = rs.getString("email");
				LocalDate dataNasc = rs.getDate("data_nasc").toLocalDate();
				String senha = rs.getString("senha");

				Pessoa p = new Pessoa();
				p.setCpf(cpf);
				p.setNome(nome);
				p.setSobrenome(sobrenome);
				p.setEmail(email);
				p.setDataNasc(dataNasc);
				p.setSenha(senha);

				pessoas.add(p);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			c.fecharConexao();
		}

		return pessoas;
	}

	@Override
	public Pessoa login(String email, String senha) {
		ConexaoBanco c = ConexaoBanco.getInstancia();
		Connection con = c.conectar();

		String query = "SELECT * FROM pessoas WHERE pessoas.email = ? AND pessoas.senha = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, senha);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Pessoa pessoa = new Pessoa();
				pessoa.setCpf(rs.getString("cpf"));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setSobrenome(rs.getString("sobrenome"));
				pessoa.setEmail(rs.getString("email"));
				pessoa.setDataNasc(rs.getDate("data_nasc").toLocalDate());

				VeiculoDAO vDAO = VeiculoDAO.getInstancia();
				Carro carro = vDAO.conexaoVeiculoPessoa(pessoa);

				pessoa.setVeiculo(carro);

				return pessoa;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return null;
	}

	public Pessoa pegaPessoa(String cpf) {
		ConexaoBanco c = ConexaoBanco.getInstancia();
		Connection con = c.conectar();

		String query = "SELECT * FROM pessoas WHERE cpf = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, cpf);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Pessoa pessoa = new Pessoa();
				pessoa.setCpf(rs.getString("cpf"));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setSobrenome(rs.getString("sobrenome"));
				pessoa.setEmail(rs.getString("email"));
				pessoa.setDataNasc(rs.getDate("data_nasc").toLocalDate());

				VeiculoDAO vDAO = VeiculoDAO.getInstancia();
				Carro carro = vDAO.conexaoVeiculoPessoa(pessoa);
				pessoa.setVeiculo(carro);

				return pessoa;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return null;
	}

}
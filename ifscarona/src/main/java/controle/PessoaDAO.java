package controle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.IPessoaDAO;
import modelo.Pessoa;

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
	public boolean cadastrarPessoa(Pessoa pessoa) {
		ConexaoBanco c = ConexaoBanco.getInstancia();

		Connection con = c.conectar();

		String query = "INSERT INTO pessoas " + "(nome, sobrenome, cpf, data_nasc, senha, email) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, pessoa.getNome());
			ps.setString(2, pessoa.getSobrenome());
			ps.setLong(3, pessoa.getCpf());
			ps.setDate(4, Date.valueOf(pessoa.getDataNasc()));
			ps.setString(5, pessoa.getSenha());
			ps.setString(6, pessoa.getEmail());

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
	public boolean alterarPessoa(Pessoa pessoa) {

		ConexaoBanco c = ConexaoBanco.getInstancia();
		Connection con = c.conectar();

		String query = "UPDATE pessoas SET nome = ?, sobrenome = ? WHERE cpf = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, pessoa.getNome());
			ps.setString(2, pessoa.getSobrenome());
			ps.setLong(3, pessoa.getCpf());

			int rowsAffected = ps.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Dados pessoais atualizados com sucesso.");
				return true;
			} else {
				System.out.println("Nenhum dado foi atualizado.");
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

		ConexaoBanco c = ConexaoBanco.getInstancia();
		Connection con = c.conectar();

		String query = "DELETE FROM pessoas WHERE cpf = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setLong(1, pessoa.getCpf());

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
	public ArrayList<Pessoa> listarPessoas() {

		ConexaoBanco c = ConexaoBanco.getInstancia();

		Connection con = c.conectar();

		ArrayList<Pessoa> pessoas = new ArrayList<>();

		String query = "SELECT * FROM pessoas";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Long cpf = rs.getLong("cpf");
				String nome = rs.getString("nome");
				String sobrenome = rs.getString("sobrenome");
				String email = rs.getString("email");
				// LocalDate dataNasc = rs.getLocalDate(Date.valueOf(pessoa.getDataNasc()));
				String senha = rs.getString("senha");

				Pessoa p = new Pessoa();
				p.setCpf(cpf);
				p.setNome(nome);
				p.setSobrenome(sobrenome);
				p.setEmail(email);
				// p.setDataNasc(dataNasc);
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

		String query = "SELECT * FROM pessoas WHERE email = ? AND senha = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, senha);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Pessoa pessoa = new Pessoa();
				pessoa.setCpf(rs.getLong("cpf"));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setSobrenome(rs.getString("sobrenome"));
				pessoa.setEmail(rs.getString("email"));

				return pessoa;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return null;
	}
	
	public Pessoa pegaPessoa(Long cpf) {
		ConexaoBanco c = ConexaoBanco.getInstancia();
		Connection con = c.conectar();

		String query = "SELECT * FROM pessoas WHERE cpf = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setLong(1, cpf);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Pessoa pessoa = new Pessoa();
				pessoa.setCpf(rs.getLong("cpf"));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setSobrenome(rs.getString("sobrenome"));
				pessoa.setEmail(rs.getString("email"));

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
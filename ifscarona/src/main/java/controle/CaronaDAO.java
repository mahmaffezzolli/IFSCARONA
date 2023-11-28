package controle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import modelo.Carona;
import modelo.Carro;
import modelo.ICaronaDAO;
import modelo.Pessoa;
import modelo.Sessao;
import modelo.Trajeto;
import modelo.Veiculo;

public class CaronaDAO implements ICaronaDAO {

	private static CaronaDAO instancia;
	private PessoaDAO pDAO = PessoaDAO.getInstancia();
	private VeiculoDAO vDAO = VeiculoDAO.getInstancia();
	private TrajetoDAO tDAO = TrajetoDAO.getInstancia();

	public CaronaDAO() {

	}

	public static CaronaDAO getInstancia() {
		if (instancia == null) {
			instancia = new CaronaDAO();
		}
		return instancia;
	}

	@Override
	public Long cadastrarCarona(Carona carona) {
		ConexaoBanco c = ConexaoBanco.getInstancia();
		Connection con = c.conectar();

		int j = 0;
		if (carona != null) {
			Pessoa motorista = carona.getMotorista();
			Pessoa passageiro = carona.getPassageiro();
			Trajeto trajeto = carona.getTrajeto();
			Veiculo veiculo = carona.getVeiculo();
			Integer qntPassageiro = carona.getQntPassageiro();
			Time horario = carona.getHorario();
			LocalDate data = carona.getData();

			/*
			 * Algoritmo para montar o comando SQL
			 */
			StringBuilder query = new StringBuilder();
			query.append("INSERT INTO caronas (");

			if (carona.getMotorista() != null) {
				query.append("cpf_motorista");
				j++;
			}

			if (passageiro != null) {
				query.append(", cpf_passageiro");
				j++;
			}

			if (trajeto != null) {
				query.append(", id_trajeto");
				j++;
			}

			if (veiculo != null) {
				query.append(", id_veiculo");
				j++;
			}

			if (qntPassageiro > 0) {
				query.append(", qnt_passageiros");
				j++;
			}

			if (horario != null) {
				query.append(", horario");
				j++;
			}

			if (data != null) {
				query.append(", data");
				j++;
			}

			query.append(") VALUES (");

			for (int k = 0; k < j; k++) {
				query.append("?");
				if (k != (j - 1)) {
					query.append(",");
				}
			}

			query.append(")");

			/*
			 * Algoritmo para colocar os parametros no comando SQL
			 */
			int i = 1;
			try {
				PreparedStatement ps = con.prepareStatement(query.toString(), Statement.RETURN_GENERATED_KEYS);

				if (motorista != null) {
					ps.setString(i, motorista.getCpf());
					i++;
				}

				if (passageiro != null) {
					ps.setString(i, passageiro.getCpf());
					i++;
				}

				if (trajeto != null) {
					ps.setLong(i, trajeto.getIdTrajeto());
					i++;
				}

				if (veiculo != null) {
					ps.setLong(i, veiculo.getIdVeiculo());
					i++;
				}

				if (qntPassageiro > 0) {
					ps.setInt(i, qntPassageiro);
					i++;
				}

				if (horario != null) {
					ps.setTime(i, horario);
					i++;
				}

				if (data != null) {
					ps.setDate(i, Date.valueOf(data));
					i++;
				}

				ps.executeUpdate();

				try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
				    if (generatedKeys.next()) {
				        return generatedKeys.getLong(1);
				    } else {
				        throw new SQLException("Creating carona failed, no ID obtained.");
				    }
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				c.fecharConexao();
			}
		}
		return 0l; // l de long
	}

	@Override
	public boolean alterarCarona(Carona carona) {
		ConexaoBanco c = ConexaoBanco.getInstancia();
		Connection con = c.conectar();

		String query = "UPDATE caronas SET ";
		boolean hasSet = false;

		if (carona.getPassageiro() != null) {
			query += "cpf_passageiro = ?, ";
			hasSet = true;
		}

		if (carona.getTrajeto() != null) {
			query += "id_trajeto = ?, ";
			hasSet = true;
		}

		if (carona.getVeiculo() != null) {
			query += "id_veiculo = ?, ";
			hasSet = true;
		}

		if (carona.getQntPassageiro() != null) {
			query += "qnt_passageiros = ?, ";
			hasSet = true;
		}

		if (carona.getHorario() != null) {
			query += "horario = ?, ";
			hasSet = true;
		}

		if (carona.getData() != null) {
			query += "data = ?, ";
			hasSet = true;
		}

		if (hasSet) {

			query = query.substring(0, query.length() - 2);

			query += " WHERE id_carona = ?";

			try {
				PreparedStatement ps = con.prepareStatement(query);

				int i = 1;

				if (carona.getPassageiro() != null) {
					ps.setString(i++, carona.getPassageiro().getCpf());
				}

				if (carona.getTrajeto() != null) {
					ps.setLong(i++, carona.getTrajeto().getIdTrajeto());
				}

				if (carona.getVeiculo() != null) {
					ps.setLong(i++, carona.getVeiculo().getIdVeiculo());
				}

				if (carona.getQntPassageiro() != null) {
					ps.setInt(i++, carona.getQntPassageiro());
				}

				if (carona.getHorario() != null) {
					ps.setTime(i++, carona.getHorario());
				}

				if (carona.getData() != null) {
					ps.setDate(i++, Date.valueOf(carona.getData()));
				}

				ps.setLong(i, carona.getIdCarona());

				int rowsAffected = ps.executeUpdate();

				return rowsAffected > 0;

			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			} finally {
				c.fecharConexao();
			}
		} else {
			return false;
		}
	}

	@Override
	public boolean deletarCarona(Carona carona) {
		ConexaoBanco c = ConexaoBanco.getInstancia();

		Connection con = c.conectar();

		String query = "DELETE FROM caronas WHERE id_carona = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setLong(1, carona.getIdCarona());
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
	public ArrayList<Carona> listarCaronas() {

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

		} finally {

			c.fecharConexao();
		}

		return caronas;
	}

	public Carona conexaoCaronaVeiculo(Veiculo carro) {

		ConexaoBanco c = ConexaoBanco.getInstancia();
		Connection con = c.conectar();

		Carona carona = null;

		String query = "SELECT * FROM caronas WHERE id_veiculo= ?";

		try {
			PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			ps.setLong(1, carro.getIdVeiculo());

			try (ResultSet rs = ps.executeQuery()) {

				if (rs.next()) {

					Long idCarona = rs.getLong("id_carona");
					String cpfPassageiro = rs.getString("cpf_passageiro");
					Long idTrajeto = rs.getLong("id_trajeto");
					Trajeto trajeto = TrajetoDAO.getInstancia().pegaTrajeto(idTrajeto);
					Integer passageiros = rs.getInt("qnt_passageiros");
					Time horario = rs.getTime("horario");
					LocalDate data = rs.getDate("data").toLocalDate();

					Pessoa motorista = Sessao.getPessoaLogada();
					Pessoa passageiro = PessoaDAO.getInstancia().pegaPessoa(cpfPassageiro);

					carona = new Carona();

					carona.setIdCarona(idCarona);
					carona.setMotorista(motorista);
					carona.setHorario(horario);
					carona.setData(data);
					carona.setPassageiro(passageiro);
					carona.setQntPassageiro(passageiros);
					carona.setTrajeto(trajeto);
					carona.setVeiculo(carro);

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return carona;
	}

	public ResultSet listarCaronasResultSet() {
		ConexaoBanco c = ConexaoBanco.getInstancia();
		Connection con = c.conectar();

		String query = "SELECT * FROM caronas";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			return ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public Carona pegaCarona(Long idCarona) {
		ConexaoBanco c = ConexaoBanco.getInstancia();
		Connection con = c.conectar();

		String query = "SELECT * FROM caronas WHERE id_carona = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setLong(1, idCarona);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				Carona carona = new Carona();
				carona.setIdCarona(rs.getLong("id_carona"));

				Pessoa motorista = pDAO.pegaPessoa(rs.getString("cpf_motorista"));
				carona.setMotorista(motorista);

				Pessoa passageiro = pDAO.pegaPessoa(rs.getString("cpf_passageiro"));
				carona.setPassageiro(passageiro);

				Trajeto trajeto = tDAO.pegaTrajeto(rs.getLong("id_trajeto"));
				carona.setTrajeto(trajeto);

				Veiculo veiculo = vDAO.pegaVeiculo(rs.getLong("id_veiculo"));
				carona.setVeiculo(veiculo);

				carona.setData(rs.getDate("data").toLocalDate());
				carona.setHorario(rs.getTime("horario"));
				carona.setQntPassageiro(rs.getInt("qnt_passageiros"));

				return carona;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return null;
	}

	public List<Carona> listarCaronasDisponíveis() {
		ConexaoBanco c = ConexaoBanco.getInstancia();
		Connection con = c.conectar();

		List<Carona> caronas = new ArrayList<>();

		String query = "SELECT caronas.id_carona as id_carona, caronas.horario as horario, "
				+ " mo.cpf as cpf_motorista, mo.nome AS nome_motorista, "
				+ "pa.cpf as cpf_passageiro, pa.nome AS nome_passageiro, "
				+ "veiculos.id_veiculo as id_veiculo, veiculos.placa as placa, "
				+ "trajetos.id_trajeto as id_trajeto, trajetos.origem as origem, "
				+ "trajetos.destino as destino, caronas.qnt_passageiros as qnt_passageiros, "
				+ "DATE_FORMAT(caronas.data, '%d/%m/%Y') as data " 
				+ "FROM caronas "
				+ "JOIN trajetos ON caronas.id_trajeto = trajetos.id_trajeto "
				+ "JOIN pessoas mo ON mo.cpf = caronas.cpf_motorista "
				+ "LEFT JOIN pessoas pa ON pa.cpf = caronas.cpf_passageiro "
				+ "JOIN veiculos ON veiculos.id_veiculo = caronas.id_veiculo;";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Carona carona = new Carona();
				carona.setIdCarona(rs.getLong("id_carona"));

				Pessoa motorista = new Pessoa();
				motorista.setCpf(rs.getString("cpf_motorista"));
				motorista.setNome(rs.getString("nome_motorista"));
				carona.setMotorista(motorista);

				Pessoa passageiro = new Pessoa();
				passageiro.setCpf(rs.getString("cpf_passageiro"));
				carona.setPassageiro(passageiro);

				Trajeto trajeto = new Trajeto();
				trajeto.setIdTrajeto(rs.getLong("id_trajeto"));
				trajeto.setDestino(rs.getString("destino"));
				trajeto.setOrigem(rs.getString("origem"));
				carona.setTrajeto(trajeto);

				Carro carro = new Carro();
				carro.setIdVeiculo(rs.getLong("id_veiculo"));
				carro.setPlaca(rs.getString("placa"));
				carona.setVeiculo(carro);

				carona.setHorario(rs.getTime("horario"));
				String dateStr = rs.getString("data");
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate date = LocalDate.parse(dateStr, formatter);
				carona.setData(date);

				caronas.add(carona);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.fecharConexao();
		}

		return caronas;
	}

	public boolean removerPassageiroDaCarona(long idCarona) {
		ConexaoBanco c = ConexaoBanco.getInstancia();
		Connection con = c.conectar();

		String query = "UPDATE caronas SET cpf_passageiro = NULL WHERE id_carona = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setLong(1, idCarona);

			int rowsAffected = ps.executeUpdate();

			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			c.fecharConexao();
		}
	}

}

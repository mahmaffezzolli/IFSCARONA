package controle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;

import modelo.Carona;
import modelo.ICaronaDAO;
import modelo.Pessoa;
import modelo.Trajeto;
import modelo.Veiculo;

public class CaronaDAO implements ICaronaDAO {

	private static CaronaDAO instancia;

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
						throw new SQLException("Creating user failed, no ID obtained.");
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

		String query = "UPDATE caronas SET cpf_passageiro = ?, id_trajeto = ?, id_veiculo = ?, qnt_passageiros = ?, horario = ?, data = ? WHERE id_carona = ?";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, carona.getPassageiro().getCpf());
			ps.setLong(2, carona.getTrajeto().getIdTrajeto());
			ps.setLong(3, carona.getVeiculo().getIdVeiculo());
			ps.setInt(4, carona.getQntPassageiro());
			ps.setTime(5, carona.getHorario());
			ps.setDate(6, Date.valueOf(carona.getData()));
			ps.setLong(7, carona.getIdCarona());

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


}

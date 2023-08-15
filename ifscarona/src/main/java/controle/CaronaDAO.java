package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Carona;
import modelo.ICaronaDAO;
import modelo.Carona;

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

		String query = "INSERT INTO carona " + "(trajeto, passageiro, motorista) " + "VALUES (?, ?, ?)";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, carona.getTrajeto().getIdTrajeto());
			// ps.setString(2, carona.getPassageiro());
			ps.setLong(3, carona.getMotorista().getCpf());

			ps.executeUpdate();

			c.fecharConexao();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean alterarCarona(Carona carona) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletarCarona(Carona carona) {
		// TODO Auto-generated method stub
		return false;
	}

<<<<<<< Updated upstream
	@Override
	public ArrayList<Carona> listarCarona(Carona carona) {

		
=======
	public ArrayList<Carona> listar() {

>>>>>>> Stashed changes
		ConexaoBanco c = ConexaoBanco.getInstancia();

		Connection con = c.conectar();

		ArrayList<Carona> caronas = new ArrayList<>();
<<<<<<< Updated upstream
		
		String query = "SELECT * FROM carona";
		
		try {
			PreparedStatement cs = con.prepareStatement(query);
			
			ResultSet rs = cs.executeQuery();
			while(rs.next()) {
				int idCarona = rs.getInt("id_carona");
//				String Motorista = rs.getString("Motorista");
//				int Trajeto = rs.getInt("id_trajeto");
//				int idVeiculo = rs.getInt("id_veiculo");
				
				Carona crn = new Carona();
				crn.setIdCarona(idCarona);
//				crn.setMotorista(Motorista);
//				crn.setTrajeto(Trajeto);
			
				caronas.add(crn);
=======

		String query = "SELECT * FROM musica";

		try {
			PreparedStatement ms = con.prepareStatement(query);

			ResultSet rs = ms.executeQuery();
			while (rs.next()) {
				int idMusica = rs.getInt("id_musica");

				String nome = rs.getString("nome_musica");

				Carona crn = new Carona();
				// crn.setIdMusica(idMusica);
				// crn.setNomeMusica();

				// caronas.add(crn);
>>>>>>> Stashed changes
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		c.fecharConexao();
<<<<<<< Updated upstream
		
		return null;
	}

}
=======

		return caronas;

	}

	@Override
	public ArrayList<Carona> listarCarona(Carona carona) {
		// TODO Auto-generated method stub
		return null;
	}
}
>>>>>>> Stashed changes

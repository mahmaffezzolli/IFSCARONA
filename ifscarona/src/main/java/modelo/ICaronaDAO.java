package modelo;

import java.sql.ResultSet;
import java.util.ArrayList;

public interface ICaronaDAO {

	public Long cadastrarCarona(Carona carona);

	public boolean alterarCarona(Carona carona);

	public ArrayList<Carona> listarCaronas();

	public boolean deletarCarona(Carona carona);

	public Carona conexaoCaronaVeiculo(Veiculo carro);

	public ResultSet listarCaronasResultSet();

}
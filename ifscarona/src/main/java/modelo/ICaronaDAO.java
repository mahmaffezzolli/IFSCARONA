package modelo;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public interface ICaronaDAO {

	public Long cadastrarCarona(Carona carona);

	public boolean alterarCarona(Carona carona);

	public ArrayList<Carona> listarCaronas();

	public boolean deletarCarona(Carona carona);

	public Carona conexaoCaronaVeiculo(Veiculo carro);

	public ResultSet listarCaronasResultSet();
	
	public Carona pegaCarona(Long idCarona);
	
	public List<Carona> listarCaronasDisponíveis();
	
	public boolean removerPassageiroDaCarona(long idCarona);
	
	public List<Carona> listarCaronasPorFiltro(LocalDate selectedDate, LocalTime selectedTime, String selectedOrigin, String selectedDestination);

}
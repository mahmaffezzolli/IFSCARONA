package modelo;

import java.util.ArrayList;

public interface ICaronaDAO {

	public Long cadastrarCarona(Carona carona);

	public boolean alterarCarona(Carona carona);

	public ArrayList<Carona> listarCaronas();

	public boolean deletarCarona(Carona carona);

}
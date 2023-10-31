package modelo;

import java.util.ArrayList;

public interface ICaronaDAO {

	public Long cadastrarCarona(Carona carona);

	public long alterarCarona(Carona carona);

	public ArrayList<Carona> listarCaronas();

	public boolean deletarCarona(Carona carona);

}
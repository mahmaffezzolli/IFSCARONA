package modelo;

import java.util.ArrayList;

public interface ICaronaDAO {

	public boolean cadastrarCarona(Carona carona);

	public boolean alterarCarona(Carona carona);

	public ArrayList<Carona> listarCarona(Carona carona);

	public boolean deletarCarona(Carona carona);
	

}
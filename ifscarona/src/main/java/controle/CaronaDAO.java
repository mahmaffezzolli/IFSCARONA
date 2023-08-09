package controle;

import modelo.Carona;
import modelo.ICaronaDAO;

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
		// TODO Auto-generated method stub
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

}
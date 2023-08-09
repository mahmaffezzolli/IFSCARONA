package controle;

import modelo.ITrajetoDAO;
import modelo.Trajeto;

public class TrajetoDAO implements ITrajetoDAO {

	private static TrajetoDAO instancia;

	private TrajetoDAO() {

	}

	public static TrajetoDAO getInstancia() {
		if (instancia == null) {
			instancia = new TrajetoDAO();
		}
		return instancia;
	}

	@Override
	public boolean cadastrarTrajeto(Trajeto trajeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean alterarTrajeto(Trajeto trajeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletarTrajeto(Trajeto trajeto) {
		// TODO Auto-generated method stub
		return false;
	}

}
package controle;

import modelo.IVeiculoDAO;
import modelo.Veiculo;

public class VeiculoDAO implements IVeiculoDAO {

	private static VeiculoDAO instancia;

	private VeiculoDAO() {

	}

	public static VeiculoDAO getInstancia() {
		if (instancia == null) {
			instancia = new VeiculoDAO();
		}
		return instancia;
	}

	@Override
	public boolean cadastrarVeiculo(Veiculo veiculo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean alterarVeiculo(Veiculo veiculo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletarVeiculo(Veiculo veiculo) {
		// TODO Auto-generated method stub
		return false;
	}

}
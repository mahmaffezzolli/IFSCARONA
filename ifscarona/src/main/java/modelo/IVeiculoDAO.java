package modelo;

import java.util.ArrayList;

public interface IVeiculoDAO {

	public Long cadastrarVeiculo(Veiculo veiculo);

	public boolean alterarVeiculo(Veiculo veiculo);

	public ArrayList<Veiculo> listarVeiculos();

	public boolean deletarVeiculo(Veiculo veiculo);

}
package modelo;

public interface IVeiculoDAO {

	public boolean cadastrarVeiculo(Veiculo veiculo);

	public boolean alterarVeiculo(Veiculo veiculo);

	public boolean listarVeiculo(Veiculo veiculo);

	public boolean deletarVeiculo(Veiculo veiculo);

}
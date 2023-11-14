package modelo;

import java.util.ArrayList;

public interface IVeiculoDAO {

	public Long cadastrarVeiculo(Carro carro);

	public boolean alterarVeiculo(Carro carro);

	public ArrayList<Carro> listarVeiculos();

	public boolean deletarVeiculo(Carro carro);
	
	public Carro conexaoVeiculoPessoa(Pessoa motorista);

}
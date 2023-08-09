package modelo;

public interface ICaronaDAO {

	public boolean cadastrarCarona(Carona carona);

	public boolean alterarCarona(Carona carona);

	public boolean deletarCarona(Carona carona);

}
package modelo;

public interface ITrajetoDAO {

	public boolean cadastrarTrajeto(Trajeto trajeto);

	public boolean alterarTrajeto(Trajeto trajeto);

	public boolean deletarTrajeto(Trajeto trajeto);

}
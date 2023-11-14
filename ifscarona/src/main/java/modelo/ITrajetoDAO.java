package modelo;

import java.util.ArrayList;

public interface ITrajetoDAO {

	public Long cadastrarTrajeto(Trajeto trajeto);

	public boolean alterarTrajeto(Trajeto trajeto);

	public ArrayList<Trajeto> listarTrajetos();

	public boolean deletarTrajeto(Trajeto trajeto);
	
	public Trajeto pegaTrajeto(Long idTrajeto);

}
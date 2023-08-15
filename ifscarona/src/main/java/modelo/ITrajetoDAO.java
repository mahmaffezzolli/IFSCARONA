package modelo;

import java.util.ArrayList;

public interface ITrajetoDAO {

	public boolean cadastrarTrajeto(Trajeto trajeto);

	public boolean alterarTrajeto(Trajeto trajeto);

	public ArrayList<Trajeto> listarTrajeto(Trajeto trajeto);

	public boolean deletarTrajeto(Trajeto trajeto);

}
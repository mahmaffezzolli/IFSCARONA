package controle;

import modelo.IPessoaDAO;
import modelo.Pessoa;

public class PessoaDAO implements IPessoaDAO{

	private static PessoaDAO instancia;
	
	private PessoaDAO() {
		
	}
	
	public static PessoaDAO getInstancia() {
		if (instancia == null) {
			instancia = new PessoaDAO();
		}
		return instancia;
	}
	
	@Override
	public boolean cadastrarPessoa(Pessoa pessoa) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean alterarPessoa(Pessoa pessoa) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletarPessoa(Pessoa pessoa) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
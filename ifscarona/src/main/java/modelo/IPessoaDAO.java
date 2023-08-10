package modelo;

public interface IPessoaDAO {

	public boolean cadastrarPessoa(Pessoa pessoa);
	
	public boolean alterarPessoa(Pessoa pessoa);
	
	public boolean listarPessoa(Pessoa pessoa);
	
	public boolean deletarPessoa(Pessoa pessoa);
	
	
	
}
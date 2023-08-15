package modelo;

import java.util.ArrayList;

public interface IPessoaDAO {

	public boolean cadastrarPessoa(Pessoa pessoa);

	public boolean alterarPessoa(Pessoa pessoa);

	public ArrayList<Pessoa> listarPessoa(Pessoa pessoa);

	public boolean deletarPessoa(Pessoa pessoa);

}
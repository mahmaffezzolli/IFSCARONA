package modelo;

import java.util.ArrayList;

public interface IPessoaDAO {

	public String cadastrarPessoa(Pessoa pessoa);

	public boolean alterarPessoa(Pessoa pessoa);

	public ArrayList<Pessoa> listarPessoas();

	public boolean deletarPessoa(Pessoa pessoa);

	public Pessoa login(String email, String senha);

	public Pessoa pegaPessoa(String cpf);

}
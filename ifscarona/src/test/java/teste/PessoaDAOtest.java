package teste;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import controle.PessoaDAO;
import modelo.Pessoa;
import modelo.Veiculo;

public class PessoaDAOtest {

	// TESTE UNITARIO = TESTAR CADA UNIDADE DO CODIGO
	// annotation
	@Test
	public void testCadastrarPessoaSucesso() {

		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Letícia");
		pessoa.setCpf("88881154048");
		pessoa.setDataNasc(LocalDate.of(2006, 2, 18));
		pessoa.setEmail("gabriele@email.com");
		pessoa.setSenha("123456789");
		pessoa.setSobrenome("Bratkhufhjhjh");

		Veiculo veiculo = new Veiculo();
		veiculo.setCor(null);
		veiculo.setPessoa(null);
		veiculo.setMarca(null);
		veiculo.setModelo(null);
		veiculo.setPessoa(pessoa);
		veiculo.setPlaca(null);

		// Setou veiculo da pessoa
		pessoa.setVeiculo(veiculo);

		PessoaDAO pDAO = PessoaDAO.getInstancia();
		Boolean sucesso = pDAO.cadastrarPessoa(pessoa);

		assertEquals(true, sucesso);
	}

//	@Test
//	public void testCadastrarPessoaErro() {
//		Pessoa pessoa = null;
//
//		PessoaDAO pDAO = PessoaDAO.getInstancia();
//		Boolean erro = pDAO.cadastrarPessoa(pessoa);
//
//		assertEquals(false, erro);
//	}

}

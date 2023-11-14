package teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import java.time.LocalDate;
import java.util.Random;

import org.junit.jupiter.api.Test;

import controle.PessoaDAO;
import modelo.Pessoa;
import modelo.Veiculo;

public class PessoaDAOTest {

	public static String geraCpfAleatorio() {

		Random r = new Random();
		long numbers = r.nextInt(1_000_000_000) // Last 9 digits
				+ (r.nextInt(90) + 10) * 1_000_000_000L;

		return String.valueOf(numbers);
	}

	@Test
	public void testCadastrarPessoaSucesso() {

		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Letícia");
		pessoa.setCpf(geraCpfAleatorio());
		pessoa.setDataNasc(LocalDate.of(2006, 2, 18));
		pessoa.setEmail("gabriele@email.com");
		pessoa.setSenha("123456789");
		pessoa.setSobrenome("Bratkhufhjhjh");

		Veiculo veiculo = new Veiculo();
		veiculo.setCor(null);
		veiculo.setMotorista(null);
		veiculo.setMarca(null);
		veiculo.setModelo(null);
		veiculo.setMotorista(null);
		veiculo.setPlaca(null);

		PessoaDAO pDAO = PessoaDAO.getInstancia();
		String sucesso = pDAO.cadastrarPessoa(pessoa);

		assertEquals(pessoa.getCpf(), sucesso);
	}

	@Test
	public void testListarPessoasSucesso() {
		PessoaDAO pDAO = PessoaDAO.getInstancia();

		assertFalse(pDAO.listarPessoas().isEmpty());
	}

	@Test
	public void testDeletarPessoaErroPessoaInexistente() {
		Pessoa pessoa = new Pessoa();
		pessoa.setCpf(geraCpfAleatorio()); 
		PessoaDAO pDAO = PessoaDAO.getInstancia();
		boolean sucesso = pDAO.deletarPessoa(pessoa);

		assertEquals(false, sucesso);
	}

	@Test
	public void testAtualizarPessoaSucesso() {

		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Letícia");
		pessoa.setCpf(geraCpfAleatorio());
		pessoa.setDataNasc(LocalDate.of(2006, 2, 18));
		pessoa.setEmail("lele@email.com");
		pessoa.setSenha("123456789");
		pessoa.setSobrenome("leleeeeee");

		Veiculo veiculo = new Veiculo();
		veiculo.setCor(null);
		veiculo.setMotorista(null);
		veiculo.setMarca(null);
		veiculo.setModelo(null);
		veiculo.setMotorista(null);
		veiculo.setPlaca(null);

		PessoaDAO pDAO = PessoaDAO.getInstancia();
		String sucesso = pDAO.cadastrarPessoa(pessoa);

		assertEquals(pessoa.getCpf(), sucesso);
	}

	@Test
	public void testDeletarPessoaSucesso() {

		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Letícia");
		pessoa.setCpf(geraCpfAleatorio());
		pessoa.setDataNasc(LocalDate.of(2006, 2, 18));
		pessoa.setEmail("lele@email.com");
		pessoa.setSenha("123456789");
		pessoa.setSobrenome("leleeeeee");

		Veiculo veiculo = new Veiculo();
		veiculo.setCor(null);
		veiculo.setMotorista(null);
		veiculo.setMarca(null);
		veiculo.setModelo(null);
		veiculo.setMotorista(null);
		veiculo.setPlaca(null);

		PessoaDAO pDAO = PessoaDAO.getInstancia();
		String sucesso = pDAO.cadastrarPessoa(pessoa);

		assertEquals(pessoa.getCpf(), sucesso);
	}

	@Test
	public void testCadastrarPessoaErro() {
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Letícia");
		pessoa.setCpf(geraCpfAleatorio());
		pessoa.setDataNasc(LocalDate.of(2006, 2, 18));
		pessoa.setEmail(null);
		pessoa.setSenha("123456789");
		pessoa.setSobrenome("leleeeeee");
		
		PessoaDAO pDAO = PessoaDAO.getInstancia();
		String sucesso = pDAO.cadastrarPessoa(pessoa);
		
		assertNotEquals(pessoa.getCpf(), sucesso);
	}

	@Test
	public void testAtualizarPessoaErro() {
		Pessoa pessoa = new Pessoa();
		pessoa.setCpf(geraCpfAleatorio()); 
		pessoa.setNome("Updated Name");

		PessoaDAO pDAO = PessoaDAO.getInstancia();
		boolean sucesso = pDAO.alterarPessoa(pessoa);

		assertEquals(false, sucesso);
	}

}

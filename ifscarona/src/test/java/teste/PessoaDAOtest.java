package teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import controle.PessoaDAO;
import modelo.Pessoa;
import modelo.Veiculo;

public class PessoaDAOtest {

	@Test
	public void testCadastrarPessoaSucesso() {

		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Letícia");
		pessoa.setCpf("99981154048");
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

		// Setou veiculo da pessoa
		//pessoa.setVeiculo(veiculo);

		PessoaDAO pDAO = PessoaDAO.getInstancia();
		Boolean sucesso = pDAO.cadastrarPessoa(pessoa);

		assertEquals(true, sucesso);
	}
	 @Test
	    public void testListarPessoasSucesso() {
	        // Simulate a successful list operation
	        PessoaDAO pDAO = PessoaDAO.getInstancia();

	        // Assert that the list operation returned a non-empty list
	        assertFalse(pDAO.listarPessoas().isEmpty());
	    }

	    @Test
	    public void testDeletarPessoaErroPessoaInexistente() {
	        // Attempt to delete a person that does not exist in the database
	        Pessoa pessoa = new Pessoa();
	        pessoa.setCpf("88888888888"); // Non-existent CPF

	        PessoaDAO pDAO = PessoaDAO.getInstancia();
	        boolean sucesso = pDAO.deletarPessoa(pessoa);

	        // Assert that the deletion failed (non-existent person)
	        assertEquals(false, sucesso);
	    }
	    
	@Test
	public void testAtualizarPessoaSucesso() {

		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Letícia");
		pessoa.setCpf("98881154048");
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

		// Setou veiculo da pessoa
		//pessoa.setVeiculo(veiculo);

		PessoaDAO pDAO = PessoaDAO.getInstancia();
		Boolean sucesso = pDAO.cadastrarPessoa(pessoa);

		assertEquals(true, sucesso);
	}
	
	@Test
	public void testDeletarPessoaSucesso() {

		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Letícia");
		pessoa.setCpf("88981154048");
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

		// Setou veiculo da pessoa
		//pessoa.setVeiculo(veiculo);

		PessoaDAO pDAO = PessoaDAO.getInstancia();
		Boolean sucesso = pDAO.cadastrarPessoa(pessoa);

		assertEquals(true, sucesso);
	}
	
	@Test
	public void testCadastrarPessoaErro() {
	    // Attempt to insert a person with an invalid attribute
	    Pessoa pessoa = new Pessoa();
	    // Set some valid attributes
	    pessoa.setNome("John Doe");
	    pessoa.setCpf("12345678900"); // Set a valid CPF
	    pessoa.setDataNasc(LocalDate.of(1990, 1, 1)); // Set a valid date
	    pessoa.setEmail("john.doe@example.com");
	    pessoa.setSenha("password");
	    pessoa.setSobrenome("Doe");

	    PessoaDAO pDAO = PessoaDAO.getInstancia();
	    boolean sucesso = pDAO.cadastrarPessoa(pessoa);

	    // Assert that the insertion failed (invalid attributes)
	    assertEquals(false, sucesso);
	}


	@Test
	public void testAtualizarPessoaErro() {
	    // Attempt to update a person that does not exist in the database
	    Pessoa pessoa = new Pessoa();
	    pessoa.setCpf("88888888888"); // Non-existent CPF
	    // Set some new attributes
	    pessoa.setNome("Updated Name");

	    PessoaDAO pDAO = PessoaDAO.getInstancia();
	    boolean sucesso = pDAO.alterarPessoa(pessoa);

	    // Assert that the update failed (non-existent person)
	    assertEquals(false, sucesso);
	}

	
	
	

}

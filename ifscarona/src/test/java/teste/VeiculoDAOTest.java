package teste;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

import controle.VeiculoDAO;
import modelo.Pessoa;
import modelo.Veiculo;

public class VeiculoDAOTest {

	@Test
	public void testMetodoInserirVeiculo() {

		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Letícia");
		pessoa.setCpf("88881154048");
		pessoa.setDataNasc(LocalDate.of(2006, 2, 18));
		pessoa.setEmail("gabriele@email.com");
		pessoa.setSenha("123456789");
		pessoa.setSobrenome("Bratkhufhjhjh");

		Veiculo veiculo = new Veiculo();
		veiculo.setCor("Vermelho");
		//veiculo.setPessoa(pessoa.getCpf());
		veiculo.setMarca("Audi");
		veiculo.setModelo("Volvo");
		veiculo.setPessoa(pessoa);
		veiculo.setPlaca("1234abc");

		VeiculoDAO vDAO = VeiculoDAO.getInstancia();
		Boolean sucesso = vDAO.cadastrarVeiculo(veiculo);
		assertEquals(true, sucesso);

	}

	@Test
	public void testMetodoUpdateVeiculo() {

		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Letícia");
		pessoa.setCpf("88881154048");
		pessoa.setDataNasc(LocalDate.of(2006, 2, 18));
		pessoa.setEmail("gabriele@email.com");
		pessoa.setSenha("123456789");
		pessoa.setSobrenome("Bratkhufhjhjh");

		Veiculo veiculo = new Veiculo();
		veiculo.setCor("Vermelho");
		//veiculo.setCpf_pessoa(pessoa.getCpf());
		veiculo.setMarca("Audi");
		veiculo.setModelo("Volvo");
		veiculo.setPessoa(pessoa);
		veiculo.setPlaca("5678def");

		VeiculoDAO vDAO = VeiculoDAO.getInstancia();
		Boolean sucesso = vDAO.alterarVeiculo(veiculo);
		assertEquals(true, sucesso);

	}

	@Test
	public void testMetodoDeleteVeiculo() {

		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Letícia");
		pessoa.setCpf("88881154048");
		pessoa.setDataNasc(LocalDate.of(2006, 2, 18));
		pessoa.setEmail("gabriele@email.com");
		pessoa.setSenha("123456789");
		pessoa.setSobrenome("Bratkhufhjhjh");

		Veiculo veiculo = new Veiculo();
		veiculo.setCor("Vermelho");
		//veiculo.setCpf_pessoa(pessoa.getCpf());
		veiculo.setMarca("Audi");
		veiculo.setModelo("Volvo");
		veiculo.setPessoa(pessoa);
		veiculo.setPlaca("5678def");

		VeiculoDAO vDAO = VeiculoDAO.getInstancia();
		Boolean sucesso = vDAO.deletarVeiculo(veiculo);
		assertEquals(true, sucesso);

	}

}

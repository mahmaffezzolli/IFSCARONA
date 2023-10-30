package teste;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import controle.PessoaDAO;
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
		veiculo.setMarca("Audi");
		veiculo.setModelo("Volvo");
		veiculo.setMotorista(pessoa);
		veiculo.setPlaca("1234abc");

		VeiculoDAO vDAO = VeiculoDAO.getInstancia();
		Long sucesso = vDAO.cadastrarVeiculo(veiculo);
		assertEquals(true, sucesso > 0);

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
		veiculo.setMarca("Audi");
		veiculo.setModelo("Volvo");
		veiculo.setMotorista(pessoa);
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
		veiculo.setMotorista(pessoa);
		veiculo.setMarca("Audi");
		veiculo.setModelo("Volvo");
		veiculo.setMotorista(pessoa);
		veiculo.setPlaca("5678def");

		VeiculoDAO vDAO = VeiculoDAO.getInstancia();
		Boolean sucesso = vDAO.deletarVeiculo(veiculo);
		assertEquals(true, sucesso);

	}
	
	@Test
	public void testMetodoReadVeiculo() {
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Letícia");
		pessoa.setCpf("89081154048");
		pessoa.setDataNasc(LocalDate.of(2006, 2, 18));
		pessoa.setEmail("gabriele@email.com");
		pessoa.setSenha("123456789");
		pessoa.setSobrenome("Bratkhufhjhjh");

		Veiculo veiculo = new Veiculo();
		veiculo.setCor("Vermelho");
		veiculo.setMotorista(pessoa);
		veiculo.setMarca("Audi");
		veiculo.setModelo("Volvo");
		veiculo.setMotorista(pessoa);
		veiculo.setPlaca("5678def");

		VeiculoDAO vDAO = VeiculoDAO.getInstancia();
		vDAO.cadastrarVeiculo(veiculo);
        ArrayList<Veiculo> veiculos = vDAO.listarVeiculos();
        
        assertEquals(false, veiculos.isEmpty());

	}

	@Test
	public void testMetodoConexaoVeiculoPessoa() {

		Pessoa motorista = new Pessoa();
		motorista.setNome("Letícia");
		motorista.setCpf("88881154048");
		motorista.setDataNasc(LocalDate.of(2006, 2, 18));
		motorista.setEmail("gabriele@email.com");
		motorista.setSenha("123456789");
		motorista.setSobrenome("Bratkhufhjhjh");
		PessoaDAO pDAO = PessoaDAO.getInstancia();
		pDAO.cadastrarPessoa(motorista);

		Veiculo veiculo = new Veiculo();
		veiculo.setCor("Vermelho");
		veiculo.setMotorista(motorista);
		veiculo.setMarca("Audi");
		veiculo.setModelo("Volvo");
		veiculo.setPlaca("5678def");

		VeiculoDAO vDAO = VeiculoDAO.getInstancia();
		vDAO.cadastrarVeiculo(veiculo);

		Veiculo v = vDAO.conexaoVeiculoPessoa(motorista);
		String cpf = v.getMotorista().getCpf();

		assertEquals("88881154048", cpf);
	}

}

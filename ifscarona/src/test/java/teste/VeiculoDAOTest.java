package teste;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

import org.junit.jupiter.api.Test;

import controle.PessoaDAO;
import controle.VeiculoDAO;
import modelo.Carro;
import modelo.Pessoa;

public class VeiculoDAOTest {

	public static String geraCpfAleatorio() {

		Random r = new Random();
		long numbers = r.nextInt(1_000_000_000) // Last 9 digits
				+ (r.nextInt(90) + 10) * 1_000_000_000L;

		return String.valueOf(numbers);
	}

	@Test
	public void testMetodoInserirVeiculo() {

		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Letícia");
		pessoa.setCpf(geraCpfAleatorio());
		pessoa.setDataNasc(LocalDate.of(2006, 2, 18));
		pessoa.setEmail("gabriele@email.com");
		pessoa.setSenha("123456789");
		pessoa.setSobrenome("Bratkhufhjhjh");

		Carro carro = new Carro();
		carro.setCor("Vermelho");
		carro.setMarca("Audi");
		carro.setModelo("Volvo");
		carro.setMotorista(pessoa);
		carro.setPlaca("1234abc");

		VeiculoDAO vDAO = VeiculoDAO.getInstancia();
		Long sucesso = vDAO.cadastrarVeiculo(carro);
		assertEquals(true, sucesso > 0);

	}

	@Test
	public void testMetodoUpdateVeiculo() {

		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Letícia");
		String geraCpfAleatorio = geraCpfAleatorio();
		pessoa.setCpf(geraCpfAleatorio);
		pessoa.setDataNasc(LocalDate.of(2006, 2, 18));
		pessoa.setEmail("gabriele@email.com");
		pessoa.setSenha("123456789");
		pessoa.setSobrenome("Bratkhufhjhjh");

		PessoaDAO pDAO = PessoaDAO.getInstancia();
		pDAO.cadastrarPessoa(pessoa);

		Carro carro = new Carro();
		carro.setCor("Vermelho");
		carro.setMarca("Audi");
		carro.setModelo("Volvo");
		carro.setMotorista(pessoa);
		carro.setPlaca("5678def");

		VeiculoDAO vDAO = VeiculoDAO.getInstancia();
		Long idVeiculo = vDAO.cadastrarVeiculo(carro);
		carro.setIdVeiculo(idVeiculo);

		Boolean sucesso = vDAO.alterarVeiculo(carro);
		assertEquals(true, sucesso);

	}

	@Test
	public void testMetodoDeleteVeiculo() {

		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Letícia");
		pessoa.setCpf(geraCpfAleatorio());
		pessoa.setDataNasc(LocalDate.of(2006, 2, 18));
		pessoa.setEmail("gabriele@email.com");
		pessoa.setSenha("123456789");
		pessoa.setSobrenome("Bratkhufhjhjh");

		Carro carro = new Carro();
		carro.setCor("Vermelho");
		carro.setMotorista(pessoa);
		carro.setMarca("Audi");
		carro.setModelo("Volvo");
		carro.setMotorista(pessoa);
		carro.setPlaca("5678def");

		VeiculoDAO vDAO = VeiculoDAO.getInstancia();
		Long idVeiculo = vDAO.cadastrarVeiculo(carro);
		carro.setIdVeiculo(idVeiculo);

		Boolean sucesso = vDAO.deletarVeiculo(carro);
		assertEquals(true, sucesso);

	}

	@Test
	public void testMetodoReadVeiculo() {

		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Letícia");
		pessoa.setCpf(geraCpfAleatorio());
		pessoa.setDataNasc(LocalDate.of(2006, 2, 18));
		pessoa.setEmail("gabriele@email.com");
		pessoa.setSenha("123456789");
		pessoa.setSobrenome("Bratkhufhjhjh");

		Carro carro = new Carro();
		carro.setCor("Vermelho");
		carro.setMotorista(pessoa);
		carro.setMarca("Audi");
		carro.setModelo("Volvo");
		carro.setMotorista(pessoa);
		carro.setPlaca("5678def");

		VeiculoDAO vDAO = VeiculoDAO.getInstancia();
		vDAO.cadastrarVeiculo(carro);
		ArrayList<Carro> veiculos = vDAO.listarVeiculos();

		assertEquals(false, veiculos.isEmpty());

	}

	@Test
	public void testMetodoConexaoVeiculoPessoa() {

		Pessoa motorista = new Pessoa();
		motorista.setNome("Letícia");
		String geraCpfAleatorio = geraCpfAleatorio();
		motorista.setCpf(geraCpfAleatorio);
		motorista.setDataNasc(LocalDate.of(2006, 2, 18));
		motorista.setEmail("gabriele@email.com");
		motorista.setSenha("123456789");
		motorista.setSobrenome("Bratkhufhjhjh");
		PessoaDAO pDAO = PessoaDAO.getInstancia();
		pDAO.cadastrarPessoa(motorista);

		Carro carro = new Carro();
		carro.setCor("Vermelho");
		carro.setMotorista(motorista);
		carro.setMarca("Audi");
		carro.setModelo("Volvo");
		carro.setPlaca("5678def");

		VeiculoDAO vDAO = VeiculoDAO.getInstancia();
		vDAO.cadastrarVeiculo(carro);

		Carro v = vDAO.conexaoVeiculoPessoa(motorista);
		String cpf = v.getMotorista().getCpf();

		assertEquals(geraCpfAleatorio, cpf);
	}

}

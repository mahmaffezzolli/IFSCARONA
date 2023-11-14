package teste;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.Random;

import org.junit.jupiter.api.Test;

import controle.CaronaDAO;
import controle.PessoaDAO;
import controle.TrajetoDAO;
import controle.VeiculoDAO;
import modelo.Carona;
import modelo.Carro;
import modelo.Pessoa;
import modelo.Trajeto;

public class CaronaDAOTest {

	public static String geraCpfAleatorio() {

		Random r = new Random();
		long numbers = r.nextInt(1_000_000_000) // Last 9 digits
				+ (r.nextInt(90) + 10) * 1_000_000_000L;

		return String.valueOf(numbers);
	}

	@Test
	public void testCadastrarCarona() {

		Pessoa motorista = new Pessoa();
		motorista.setNome("Letícia");
		motorista.setSobrenome("Lima");
		motorista.setCpf(geraCpfAleatorio());
		motorista.setDataNasc(LocalDate.of(2005, 12, 10));
		motorista.setEmail("leticia.lc2005@gmail.com");
		motorista.setSenha("legal321");

		PessoaDAO pDAO = PessoaDAO.getInstancia();
		pDAO.cadastrarPessoa(motorista);

		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Ash");
		pessoa.setSobrenome("Ze");
		pessoa.setCpf(geraCpfAleatorio());
		pessoa.setDataNasc(LocalDate.of(2005, 12, 10));
		pessoa.setEmail("leticia.lc2005@gmail.com");
		pessoa.setSenha("legal321");

		pDAO.cadastrarPessoa(pessoa);

		Trajeto trajeto = new Trajeto();
		trajeto.setDestino("IFSC");
		trajeto.setOrigem("Blumenau");

		Carro carro = new Carro();
		carro.setCor("Preto");
		carro.setMarca("Cherry");
		carro.setModelo("SUV");
		carro.setMotorista(pessoa);
		carro.setPlaca("12345678");

		TrajetoDAO tDAO = TrajetoDAO.getInstancia();
		Long id = tDAO.cadastrarTrajeto(trajeto);
		trajeto.setIdTrajeto(id);

		VeiculoDAO vDAO = VeiculoDAO.getInstancia();
		Long idVeiculo = vDAO.cadastrarVeiculo(carro);
		carro.setIdVeiculo(idVeiculo);

		Carona carona = new Carona();
		carona.setMotorista(motorista);
		carona.setPassageiro(null);
		carona.setTrajeto(trajeto);
		carona.setQntPassageiro(2);
		carona.setVeiculo(carro);
		carona.setData(LocalDate.of(2023, 12, 8));
		carona.setHorario(null);

		CaronaDAO cDAO = CaronaDAO.getInstancia();
		Long idCarona = cDAO.cadastrarCarona(carona);
		carona.setIdCarona(idCarona);

		assertEquals(true, idCarona > 0);

	}

	@Test
	public void testCadastrarCaronaErro() {
		Carona carona = null;

		CaronaDAO cDAO = CaronaDAO.getInstancia();
		Long erro = cDAO.cadastrarCarona(carona);

		assertEquals(false, erro >= 1);
	}

	@Test
	public void testAtualizarCarona() {

		Pessoa motorista = new Pessoa();
		motorista.setNome("Letícia");
		motorista.setSobrenome("Lima");
		motorista.setCpf(geraCpfAleatorio());
		motorista.setDataNasc(LocalDate.of(2005, 12, 10));
		motorista.setEmail("leticia.lc2005@gmail.com");
		motorista.setSenha("legal321");

		PessoaDAO pDAO = PessoaDAO.getInstancia();
		pDAO.cadastrarPessoa(motorista);

		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Ash");
		pessoa.setSobrenome("Ze");
		pessoa.setCpf(geraCpfAleatorio());
		pessoa.setDataNasc(LocalDate.of(2005, 12, 10));
		pessoa.setEmail("leticia.lc2005@gmail.com");
		pessoa.setSenha("legal321");

		pDAO.cadastrarPessoa(pessoa);
		Trajeto trajeto = new Trajeto();
		trajeto.setOrigem("Gaspar");
		trajeto.setDestino("Blumenau");

		TrajetoDAO tDAO = TrajetoDAO.getInstancia();
		Long id = tDAO.cadastrarTrajeto(trajeto);
		trajeto.setIdTrajeto(id);

		Carro carro = new Carro();
		carro.setCor("Preto");
		carro.setMarca("Cherry");
		carro.setModelo("SUV");
		carro.setMotorista(pessoa);
		carro.setPlaca("12345678");

		VeiculoDAO vDAO = VeiculoDAO.getInstancia();
		Long idVeiculo = vDAO.cadastrarVeiculo(carro);
		carro.setIdVeiculo(idVeiculo);

		Carona carona = new Carona();
		carona.setMotorista(motorista);
		carona.setPassageiro(pessoa);
		carona.setTrajeto(trajeto);
		carona.setVeiculo(carro);
		carona.setQntPassageiro(2);
		carona.setData(LocalDate.of(2023, 12, 9));
		carona.setHorario(null);
		carona.setPassageiro(pessoa);

		CaronaDAO cDAO = CaronaDAO.getInstancia();
		Long idCarona = cDAO.cadastrarCarona(carona);
		carona.setIdCarona(idCarona);

		Boolean sucesso = tDAO.alterarTrajeto(trajeto);

		assertEquals(true, sucesso);
	}

	@Test
	public void testDeletarCarona() {

		Pessoa motorista = new Pessoa();
		motorista.setNome("Letícia");
		motorista.setSobrenome("Lima");
		motorista.setCpf(geraCpfAleatorio());
		motorista.setDataNasc(LocalDate.of(2005, 12, 10));
		motorista.setEmail("leticia.lc2005@gmail.com");
		motorista.setSenha("legal321");

		PessoaDAO pDAO = PessoaDAO.getInstancia();
		pDAO.cadastrarPessoa(motorista);

		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Ash");
		pessoa.setSobrenome("Ze");
		pessoa.setCpf(geraCpfAleatorio());
		pessoa.setDataNasc(LocalDate.of(2005, 12, 10));
		pessoa.setEmail("leticia.lc2005@gmail.com");
		pessoa.setSenha("legal321");

		pDAO.cadastrarPessoa(pessoa);
		Trajeto trajeto = new Trajeto();
		trajeto.setOrigem("Gaspar");
		trajeto.setDestino("Blumenau");

		TrajetoDAO tDAO = TrajetoDAO.getInstancia();
		Long id = tDAO.cadastrarTrajeto(trajeto);
		trajeto.setIdTrajeto(id);

		Carro carro = new Carro();
		carro.setCor("Preto");
		carro.setMarca("Cherry");
		carro.setModelo("SUV");
		carro.setMotorista(pessoa);
		carro.setPlaca("12345678");

		VeiculoDAO vDAO = VeiculoDAO.getInstancia();
		Long idVeiculo = vDAO.cadastrarVeiculo(carro);
		carro.setIdVeiculo(idVeiculo);

		Carona carona = new Carona();
		carona.setMotorista(motorista);
		carona.setPassageiro(pessoa);
		carona.setTrajeto(trajeto);
		carona.setVeiculo(carro);
		carona.setQntPassageiro(2);
		carona.setData(LocalDate.of(2023, 12, 9));
		carona.setHorario(null);
		carona.setPassageiro(pessoa);

		CaronaDAO cDAO = CaronaDAO.getInstancia();
		Long idCarona = cDAO.cadastrarCarona(carona);
		carona.setIdCarona(idCarona);

		Boolean sucesso = cDAO.deletarCarona(carona);
		assertEquals(true, sucesso);

	}

	@Test
	public void testeDeletarCaronaSucesso() {

		Pessoa motorista = new Pessoa();
		motorista.setNome("Letícia");
		motorista.setSobrenome("Lima");
		motorista.setCpf(geraCpfAleatorio());
		motorista.setDataNasc(LocalDate.of(2005, 12, 10));
		motorista.setEmail("leticia.lc2005@gmail.com");
		motorista.setSenha("legal321");

		PessoaDAO pDAO = PessoaDAO.getInstancia();
		pDAO.cadastrarPessoa(motorista);

		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Ash");
		pessoa.setSobrenome("Ze");
		pessoa.setCpf(geraCpfAleatorio());
		pessoa.setDataNasc(LocalDate.of(2005, 12, 10));
		pessoa.setEmail("leticia.lc2005@gmail.com");
		pessoa.setSenha("legal321");

		pDAO.cadastrarPessoa(pessoa);
		Trajeto trajeto = new Trajeto();
		trajeto.setOrigem("Gaspar");
		trajeto.setDestino("Blumenau");

		TrajetoDAO tDAO = TrajetoDAO.getInstancia();
		Long id = tDAO.cadastrarTrajeto(trajeto);
		trajeto.setIdTrajeto(id);

		Carro carro = new Carro();
		carro.setCor("Preto");
		carro.setMarca("Cherry");
		carro.setModelo("SUV");
		carro.setMotorista(pessoa);
		carro.setPlaca("12345678");

		VeiculoDAO vDAO = VeiculoDAO.getInstancia();
		Long idVeiculo = vDAO.cadastrarVeiculo(carro);
		carro.setIdVeiculo(idVeiculo);

		Carona carona = new Carona();
		carona.setMotorista(motorista);
		carona.setPassageiro(pessoa);
		carona.setTrajeto(trajeto);
		carona.setVeiculo(carro);
		carona.setQntPassageiro(2);
		carona.setData(LocalDate.of(2023, 12, 9));
		carona.setHorario(null);
		carona.setPassageiro(pessoa);

		CaronaDAO cDAO = CaronaDAO.getInstancia();
		Long idCarona = cDAO.cadastrarCarona(carona);
		carona.setIdCarona(idCarona);

		Boolean sucesso = cDAO.deletarCarona(carona);

		assertEquals(true, sucesso);

	}

}

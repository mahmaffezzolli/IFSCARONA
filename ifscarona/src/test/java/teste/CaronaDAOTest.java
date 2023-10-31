package teste;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import controle.CaronaDAO;
import controle.PessoaDAO;
import controle.TrajetoDAO;
import controle.VeiculoDAO;
import modelo.Carona;
import modelo.Pessoa;
import modelo.Trajeto;
import modelo.Veiculo;

public class CaronaDAOTest {

	@Test
	public void testCadastrarCarona() {

		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Letícia");
		pessoa.setSobrenome("Lima");
		pessoa.setCpf("23345309811");
		pessoa.setDataNasc(LocalDate.of(2005, 12, 10));
		pessoa.setEmail("leticia.lc2005@gmail.com");
		pessoa.setSenha("legal321");

		PessoaDAO pDAO = PessoaDAO.getInstancia();
		pDAO.cadastrarPessoa(pessoa);

		Trajeto trajeto = new Trajeto();
		trajeto.setDestino("IFSC");
		trajeto.setOrigem("Blumenau");

		Veiculo veiculo = new Veiculo();
		veiculo.setCor("Preto");
		veiculo.setMarca("Cherry");
		veiculo.setModelo("SUV");
		veiculo.setMotorista(pessoa);
		veiculo.setPlaca("12345678");

		TrajetoDAO tDAO = TrajetoDAO.getInstancia();
		Long id = tDAO.cadastrarTrajeto(trajeto);
		trajeto.setIdTrajeto(id);

		VeiculoDAO vDAO = VeiculoDAO.getInstancia();
		Long idVeiculo = vDAO.cadastrarVeiculo(veiculo);
		veiculo.setIdVeiculo(idVeiculo);

		Carona carona = new Carona();
		carona.setMotorista(pessoa);
		carona.setPassageiro(null);
		carona.setTrajeto(trajeto);
		carona.setQntPassageiro(2);
		carona.setVeiculo(veiculo);
		carona.setData(LocalDate.of(2023, 12, 8));
		carona.setHorario(null);

		CaronaDAO cDAO = CaronaDAO.getInstancia();
		Long sucesso = cDAO.cadastrarCarona(carona);
		assertEquals(true, sucesso > 0);

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

		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Letícia");
		pessoa.setSobrenome("Lima");
		pessoa.setCpf("23345309811");
		pessoa.setDataNasc(LocalDate.of(2005, 12, 11));
		pessoa.setEmail("leticia.lc2005@gamil.com");
		pessoa.setSenha("legal321");

		Trajeto trajeto = new Trajeto();
		trajeto.setOrigem("Gaspar");
		trajeto.setDestino("Blumenau");

		Veiculo veiculo = new Veiculo();
		veiculo.setCor("Preto");
		veiculo.setMarca("Cherry");
		veiculo.setModelo("SUV");
		veiculo.setMotorista(pessoa);
		veiculo.setPlaca("12345678");

		Carona carona = new Carona();
		carona.setMotorista(pessoa);
		carona.setPassageiro(pessoa);
		carona.setTrajeto(trajeto);
		carona.setVeiculo(veiculo);
		carona.setData(LocalDate.of(2023, 12, 9));
		carona.setHorario(null);
		carona.setPassageiro(pessoa);

		CaronaDAO cDAO = CaronaDAO.getInstancia();
		long sucesso = cDAO.alterarCarona(carona);
		assertEquals(true, sucesso);
	}
	

	public void testDeletarCarona() {

		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Letícia");
		pessoa.setSobrenome("Lima");
		pessoa.setCpf("23345309811");
		pessoa.setDataNasc(LocalDate.of(2005, 12, 11));
		pessoa.setEmail("leticia.lc2005@gamil.com");
		pessoa.setSenha("legal321");

		Trajeto trajeto = new Trajeto();
		trajeto.setOrigem("Gaspar");
		trajeto.setDestino("Blumenau");

		Veiculo veiculo = new Veiculo();
		veiculo.setCor("Preto");
		veiculo.setMarca("Cherry");
		veiculo.setModelo("SUV");
		veiculo.setMotorista(pessoa);
		veiculo.setPlaca("12345678");

		Carona carona = new Carona();
		carona.setMotorista(pessoa);
		carona.setPassageiro(pessoa);
		carona.setTrajeto(trajeto);
		carona.setVeiculo(veiculo);
		carona.setData(LocalDate.of(2023, 12, 9));
		carona.setHorario(null);
		carona.setPassageiro(pessoa);

		// setou pessoa da carona
		carona.setPassageiro(pessoa);
		CaronaDAO cDAO = CaronaDAO.getInstancia();
		Boolean sucesso = cDAO.deletarCarona(carona);

		assertEquals(true, sucesso);

	}
	
	public void testeDeletarCaronaSucesso() {
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Letícia");
		pessoa.setSobrenome("Lima");
		pessoa.setCpf("78912309811");
		pessoa.setDataNasc(LocalDate.of(2005, 12, 11));
		pessoa.setEmail("leticia.lc2005@gamil.com");
		pessoa.setSenha("legal321");

		Trajeto trajeto = new Trajeto();
		trajeto.setOrigem("Gaspar");
		trajeto.setDestino("Blumenau");

		Veiculo veiculo = new Veiculo();
		veiculo.setCor("Preto");
		veiculo.setMarca("Cherry");
		veiculo.setModelo("SUV");
		veiculo.setMotorista(pessoa);
		veiculo.setPlaca("12345678");

		Carona carona = new Carona();
		carona.setMotorista(pessoa);
		carona.setPassageiro(pessoa);
		carona.setTrajeto(trajeto);
		carona.setVeiculo(veiculo);
		carona.setData(LocalDate.of(2023, 12, 9));
		carona.setHorario(null);
		carona.setPassageiro(pessoa);

		CaronaDAO cDAO = CaronaDAO.getInstancia();
		long sucesso = cDAO.alterarCarona(carona);
		assertEquals(true, sucesso);
		
	}

}

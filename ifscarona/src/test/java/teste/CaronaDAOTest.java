package teste;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import controle.CaronaDAO;
import controle.PessoaDAO;
import modelo.Carona;
import modelo.Pessoa;
import modelo.Trajeto;
import modelo.Veiculo;

public class CaronaDAOTest {
	
	// TESTE UNITARIO = TESTAR CADA UNIDADE DO CODIGO
	// annotation
	@Test
	public void testCaastrarCarona() {
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Letícia");
		pessoa.setSobrenome("Lima");
		pessoa.setCpf("78912309811");
		pessoa.setDataNasc(LocalDate.of(2005, 12, 28));
		pessoa.setEmail("leticia.lc2005@gamil.com");
		pessoa.setSenha("legal321");
		
		Trajeto trajeto = new Trajeto();
		trajeto.setIdTrajeto(null);
		trajeto.setOrigem("Gaspar");
		trajeto.setDestino("Blumenau");
		
		Veiculo veiculo = new Veiculo();
		veiculo.setIdVeiculo(null);
		veiculo.setCor("Preto");
		veiculo.setMarca("Cherry");
		veiculo.setModelo("SUV");
		veiculo.setMotorista(pessoa);
		veiculo.setPlaca("12345678");
		
		Carona carona = new Carona();
		carona.setIdCarona(null);
		carona.setMotorista(pessoa);
		carona.setPassageiro(pessoa);
		carona.setTrajeto(trajeto);
		carona.setVeiculo(veiculo);
		carona.setData(LocalDate.of(2023, 24, 10));
		carona.setHorario(null);
		carona.setPassageiro(pessoa);
		
		//setou pessoa da carona
		carona.setPassageiro(pessoa);
		CaronaDAO cDAO = CaronaDAO.getInstancia();
		Boolean sucesso = cDAO.cadastrarCarona(carona);
		
		assertEquals(true, sucesso);
	
	}
	
	@Test
	public void testCadastrarCaronaErro() {
		Pessoa pessoa = null;

	    PessoaDAO pDAO = PessoaDAO.getInstancia();
		Boolean erro = pDAO.cadastrarPessoa(pessoa);

		assertEquals(false, erro);
	}
}

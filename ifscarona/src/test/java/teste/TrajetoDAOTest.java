package teste;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import controle.PessoaDAO;
import controle.TrajetoDAO;
import modelo.Pessoa;
import modelo.Trajeto;
import modelo.Veiculo;

public class TrajetoDAOTest {
	@Test
	public void testCadastrarTrajetoSucesso() {

		Trajeto trajeto = new Trajeto();
		trajeto.setDestino("blumenau");
		trajeto.setIdTrajeto(123);
		trajeto.setOrigem("Ifsc");
		
		Veiculo veiculo = new Veiculo();
		veiculo.setCor(null);
		veiculo.setMotorista(null);
		veiculo.setMarca(null);
		veiculo.setModelo(null);
		veiculo.setMotorista(null);
		veiculo.setPlaca(null);
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Letícia");
		pessoa.setCpf("88881154048");
		pessoa.setDataNasc(LocalDate.of(2006, 2, 18));
		pessoa.setEmail("gabriele@email.com");
		pessoa.setSenha("123456789");
		pessoa.setSobrenome("Bratkhufhjhjh");
		
		

		TrajetoDAO tDAO = TrajetoDAO.getInstancia();
		Boolean sucesso = tDAO.cadastrarTrajeto(trajeto);

		assertEquals(true, sucesso);
	}

	@Test
	public void testCadastrarTrajetoErro() {
	Trajeto trajeto = null;

	TrajetoDAO tDAO = TrajetoDAO.getInstancia();
	Boolean erro = tDAO.cadastrarTrajeto(trajeto);
		assertEquals(false, erro);	}
	
}


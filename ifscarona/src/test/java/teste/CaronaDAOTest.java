package teste;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import controle.CaronaDAO;
import modelo.Carona;
import modelo.Pessoa;

public class CaronaDAOTest {
	
	// TESTE UNITARIO = TESTAR CADA UNIDADE DO CODIGO
	// annotation
	@Test
	public void testCaastrarCarona() {
		
		Carona carona = new Carona();
		carona.setIdCarona(null);
		carona.setMotorista(null);
		carona.setPassageiro(null);
		carona.setTrajeto(null);
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(null);
		pessoa.setCpf(null);
		pessoa.setDataNasc(null);
		pessoa.setEmail(null);
		pessoa.setSenha(null);
		pessoa.setSobrenome(null);
		
		carona.setPassageiro(pessoa);
		
		CaronaDAO cDAO = CaronaDAO.getInstancia();
		Boolean sucesso = cDAO.cadastrarCarona(carona);
		
		assertEquals(true, sucesso);
		
	
	}

}

package teste;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import controle.VeiculoDAO;
import modelo.Veiculo;

public class VeiculoDAOTest {

	@Test
	public void testMetodoInserirVeiculo() {
		
		Veiculo v = new Veiculo();
		v.setCor("Vermelho");
		
		VeiculoDAO vDAO = VeiculoDAO.getInstancia();
		Boolean sucesso = vDAO.cadastrarVeiculo(v);
		assertEquals(true,sucesso);
		
	}
}

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
		assertEquals(true, sucesso);

	}

	@Test
	public void testMetodoAlterarVeiculoWithNullPessoa() {

		Veiculo v = new Veiculo();
		v.setCor("Vermelho");
		v.setPessoa(null);

		VeiculoDAO vDAO = VeiculoDAO.getInstancia();
		Boolean sucesso = vDAO.alterarVeiculo(v);
		assertEquals(false, sucesso);
	}
}

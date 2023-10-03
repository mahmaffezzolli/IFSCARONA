package teste;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import controle.PessoaDAO;
import modelo.Pessoa;

public class PessoaDAOtest {

	//annotation
	@Test
	public void testMetodoListarPesoa() {
		
		Pessoa p = new Pessoa();
		p.setNome("Letícia");
		
		PessoaDAO pDAO = PessoaDAO.getInstancia();
		Boolean sucesso = pDAO.cadastrarPessoa(p);
		assertEquals(true, sucesso);
		
	}
	

}

package teste;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import controle.TrajetoDAO;
import modelo.Trajeto;

public class TrajetoDAOTest {
	@Test
	public void testCadastrarTrajetoSucesso() {

		Trajeto trajeto = new Trajeto();
		trajeto.setDestino("blumenau");
		trajeto.setOrigem("Ifsc");
		trajeto.setIdTrajeto(123);

		TrajetoDAO tDAO = TrajetoDAO.getInstancia();
		Boolean sucesso = tDAO.cadastrarTrajeto(trajeto);

		assertEquals(true, sucesso);
	}

	@Test
	public void testCadastrarTrajetoErro() {
		Trajeto trajeto = null;

		TrajetoDAO tDAO = TrajetoDAO.getInstancia();
		Boolean erro = tDAO.cadastrarTrajeto(trajeto);
		assertEquals(false, erro);
	}

	@Test
	public void testAlterarTrajetoSucesso() {

		Trajeto trajeto = new Trajeto();
		trajeto.setDestino("Gaspar");
		trajeto.setOrigem("IFSC");
		trajeto.setIdTrajeto(123);

		TrajetoDAO tDAO = TrajetoDAO.getInstancia();
		Boolean sucesso = tDAO.alterarTrajeto(trajeto);
		assertEquals(true, sucesso);

	}

	@Test
	public void testAlterarTrajetoErro() {
		Trajeto trajeto = null;

		TrajetoDAO tDAO = TrajetoDAO.getInstancia();
		Boolean erro = tDAO.alterarTrajeto(trajeto);
		assertEquals(false, erro);
	}
	@Test
	public void testDeleteTrajetoSucesso() {
		Trajeto trajeto = new Trajeto();
		trajeto.setDestino("Blumenau");
		trajeto.setOrigem("IFSC");

		TrajetoDAO tDAO = TrajetoDAO.getInstancia();
		Boolean sucesso = tDAO.deletarTrajeto(trajeto);
		assertEquals(true, sucesso);

	}
	
	
	@Test
	public void testDeletarTrajetoErro() {
		Trajeto trajeto = null;

		TrajetoDAO tDAO = TrajetoDAO.getInstancia();
		Boolean erro = tDAO.deletarTrajeto(trajeto);
		assertEquals(false, erro);
	}
	
	
}

package teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

		TrajetoDAO tDAO = TrajetoDAO.getInstancia();
		Long sucesso = tDAO.cadastrarTrajeto(trajeto);
		trajeto.setIdTrajeto(sucesso);

		assertTrue(sucesso > 0);
	}

	@Test
	public void testCadastrarTrajetoErro() {

		Trajeto trajeto = new Trajeto();
		trajeto.setDestino("gaspar");
		trajeto.setOrigem("Ifsc");
		trajeto.setDestino(null);

		TrajetoDAO tDAO = TrajetoDAO.getInstancia();
		Long newTrajetoID = tDAO.cadastrarTrajeto(trajeto);
		trajeto.setIdTrajeto(newTrajetoID);

		Boolean erro = tDAO.alterarTrajeto(trajeto);
		assertEquals(false, erro);
	}

	@Test
	public void testAlterarTrajetoSucesso() {

		Trajeto trajeto = new Trajeto();
		trajeto.setDestino("Gaspar");
		trajeto.setOrigem("IFSC");

		TrajetoDAO tDAO = TrajetoDAO.getInstancia();

		Long newTrajetoID = tDAO.cadastrarTrajeto(trajeto);
		trajeto.setIdTrajeto(newTrajetoID);

		Boolean sucesso = tDAO.alterarTrajeto(trajeto);
		assertEquals(true, sucesso);

	}

	@Test
	public void testAlterarTrajetoErro() {
		Trajeto trajeto = new Trajeto();
		trajeto.setDestino(null);
		trajeto.setOrigem("Ifsc");

		TrajetoDAO tDAO = TrajetoDAO.getInstancia();

		Long newTrajetoID = tDAO.cadastrarTrajeto(trajeto);
		trajeto.setIdTrajeto(newTrajetoID);

		Boolean erro = tDAO.alterarTrajeto(trajeto);
		assertEquals(false, erro);
	}

	@Test
	public void testDeleteTrajetoSucesso() {
		Trajeto trajeto = new Trajeto();
		trajeto.setDestino("blumenau");
		trajeto.setOrigem("IFSC");

		TrajetoDAO tDAO = TrajetoDAO.getInstancia();

		Long newTrajetoID = tDAO.cadastrarTrajeto(trajeto);
		trajeto.setIdTrajeto(newTrajetoID);

		Boolean sucesso = tDAO.deletarTrajeto(trajeto);
		assertEquals(true, sucesso);

	}

	@Test
	public void testDeletarTrajetoErro() {
		Trajeto trajeto = new Trajeto();
		trajeto.setDestino(null);
		trajeto.setOrigem("Ifsc");

		TrajetoDAO tDAO = TrajetoDAO.getInstancia();

		Long newTrajetoID = tDAO.cadastrarTrajeto(trajeto);
		trajeto.setIdTrajeto(newTrajetoID);

		Boolean erro = tDAO.deletarTrajeto(trajeto);
		assertEquals(false, erro);
	}

	@Test
	public void testListarTrajetoSucesso() {
		Trajeto trajeto = new Trajeto();
		trajeto.setDestino("blumenau");
		trajeto.setOrigem("IFSC");

		TrajetoDAO tDAO = TrajetoDAO.getInstancia();

		Long newTrajetoID = tDAO.cadastrarTrajeto(trajeto);
		trajeto.setIdTrajeto(newTrajetoID);

		ArrayList<Trajeto> trajetos = tDAO.listarTrajetos();

		assertEquals(false, trajetos.isEmpty());

	}
}

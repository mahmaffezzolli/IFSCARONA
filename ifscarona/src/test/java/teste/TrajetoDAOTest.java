package teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import controle.CaronaDAO;
import controle.TrajetoDAO;
import controle.VeiculoDAO;
import modelo.Trajeto;

public class TrajetoDAOTest {
	@Test
	public void testCadastrarTrajetoSucesso() {

		Trajeto trajeto = new Trajeto();
		trajeto.setDestino("blumenau");
		trajeto.setOrigem("Ifsc");
		
		TrajetoDAO tDAO = TrajetoDAO.getInstancia();
		Long sucesso = tDAO.cadastrarTrajeto(trajeto);
		assertEquals(true, sucesso > 0);
		
	}

	 @Test
		public void testCadastrarTrajetoErro() {
		Trajeto trajeto = null;

		 TrajetoDAO tDAO = TrajetoDAO.getInstancia();
		 Long erro = tDAO.cadastrarTrajeto(trajeto);

		assertEquals(false, erro>=1);
		 }
	@Test
	public void testAlterarTrajetoSucesso() {

		Trajeto trajeto = new Trajeto();
		trajeto.setDestino("Gaspar");
		trajeto.setOrigem("IFSC");
		trajeto.setIdTrajeto(123l);

		TrajetoDAO tDAO = TrajetoDAO.getInstancia();
		tDAO.cadastrarTrajeto(trajeto);
		Boolean sucesso = tDAO.alterarTrajeto(trajeto);
		assertEquals(true, sucesso);


	}

	@Test
	public void testAlterarTrajetoErro() {
		Trajeto trajeto = null;

		TrajetoDAO tDAO = TrajetoDAO.getInstancia();
		tDAO.cadastrarTrajeto(trajeto);
		Boolean erro = tDAO.alterarTrajeto(trajeto);
		assertEquals(false, erro);
	}
	
	@Test
	public void testDeleteTrajetoSucesso() {
		Trajeto trajeto = new Trajeto();
		trajeto.setDestino("blumenau");
		trajeto.setOrigem("IFSC");
		trajeto.setIdTrajeto(12l);

		TrajetoDAO tDAO = TrajetoDAO.getInstancia();
		tDAO.cadastrarTrajeto(trajeto);
		Boolean sucesso = tDAO.deletarTrajeto(trajeto);
		assertEquals(true, sucesso);

	}
	
	
	@Test
	public void testDeletarTrajetoErro() {
		Trajeto trajeto = null;

		TrajetoDAO tDAO = TrajetoDAO.getInstancia();
		tDAO.cadastrarTrajeto(trajeto);
		Boolean erro = tDAO.deletarTrajeto(trajeto);
		assertEquals(false, erro);
	}
	
	
	@Test
	public void testListarTrajetoSucesso() {
		Trajeto trajeto = new Trajeto();
		trajeto.setDestino("blumenau");
		trajeto.setOrigem("IFSC");
		trajeto.setIdTrajeto(12l);

		TrajetoDAO tDAO = TrajetoDAO.getInstancia();
		tDAO.cadastrarTrajeto(trajeto);
		ArrayList<Trajeto>trajetos=tDAO.listarTrajetos();
		

		assertEquals(false, trajetos.isEmpty ());

	}
}
	
	
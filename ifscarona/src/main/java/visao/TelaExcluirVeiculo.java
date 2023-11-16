package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.CaronaDAO;
import controle.VeiculoDAO;
import modelo.Carona;
import modelo.Carro;
import modelo.Sessao;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class TelaExcluirVeiculo extends JFrame {

	private JPanel contentPane;
	private VeiculoDAO vDAO = VeiculoDAO.getInstancia();
	private CaronaDAO cDAO = CaronaDAO.getInstancia();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaExcluirVeiculo frame = new TelaExcluirVeiculo();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					//Centralizar
					frame.setBounds(40, 40, 451, 234);
					frame.setLocationRelativeTo(null);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaExcluirVeiculo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 234);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(159, 203, 154));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTexto = new JLabel("Tem certeza que deseja");
		lblTexto.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		lblTexto.setBounds(128, 48, 162, 18);
		contentPane.add(lblTexto);

		JLabel lblTexto2 = new JLabel("excluir o veículo?");
		lblTexto2.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		lblTexto2.setBounds(157, 77, 121, 14);
		contentPane.add(lblTexto2);

		JButton btnSim = new JButton("SIM");
		btnSim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Carro veiculoLogado = vDAO.conexaoVeiculoPessoa(Sessao.getPessoaLogada());
				
				Carona caronaCadastrada = cDAO.conexaoCaronaVeiculo(veiculoLogado);
				
				if (caronaCadastrada != null) {
					cDAO.deletarCarona(caronaCadastrada);
				}

				boolean success = vDAO.deletarVeiculo(veiculoLogado);
				

				dispose();
			}
		});
		
		btnSim.setForeground(new Color(255, 255, 255));
		btnSim.setBorder(null);
		btnSim.setFont(new Font("Nirmala UI", Font.BOLD, 16));
		btnSim.setBackground(new Color(174, 57, 57));
		btnSim.setBounds(108, 127, 84, 31);
		contentPane.add(btnSim);

		JButton btnNo = new JButton("NÃO");
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
			
		btnNo.setForeground(Color.WHITE);
		btnNo.setFont(new Font("Nirmala UI", Font.BOLD, 16));
		btnNo.setBorder(null);
		btnNo.setBackground(new Color(0, 0, 0));
		btnNo.setBounds(227, 127, 84, 31);
		contentPane.add(btnNo);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaExcluirVeiculo.class.getResource("/assets/alerta.png")));
		lblNewLabel.setBounds(45, 48, 46, 39);
		contentPane.add(lblNewLabel);

	}
}

package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.PessoaDAO;
import modelo.Pessoa;
import modelo.Sessao;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaExcluirConta extends JFrame {

	private JPanel contentPane;
	private PessoaDAO pDAO = PessoaDAO.getInstancia();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaExcluirConta frame = new TelaExcluirConta();
					frame.setVisible(true);
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
	public TelaExcluirConta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 234);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTexto = new JLabel("TEM CERTEZA QUE DESEJA");
		lblTexto.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		lblTexto.setBounds(126, 43, 185, 18);
		contentPane.add(lblTexto);

		JLabel lblTexto2 = new JLabel("EXCLUIR A CONTA?");
		lblTexto2.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		lblTexto2.setBounds(146, 73, 135, 14);
		contentPane.add(lblTexto2);

		JButton btnSim = new JButton("SIM");
		btnSim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Pessoa pessoaLogada = Sessao.getPessoaLogada();
				
				boolean success = pDAO.deletarPessoa(pessoaLogada);
				
				if (success) {
					JOptionPane.showMessageDialog(null, "foi");

				} else {
					JOptionPane.showMessageDialog(null, "nao");

				}

			}
		});
		btnSim.setForeground(new Color(255, 255, 255));
		btnSim.setBorder(null);
		btnSim.setFont(new Font("Nirmala UI", Font.BOLD, 16));
		btnSim.setBackground(new Color(174, 57, 57));
		btnSim.setBounds(108, 127, 84, 31);
		contentPane.add(btnSim);

		JButton btnNo = new JButton("NÃO");
		btnNo.setForeground(Color.WHITE);
		btnNo.setFont(new Font("Nirmala UI", Font.BOLD, 16));
		btnNo.setBorder(null);
		btnNo.setBackground(new Color(0, 0, 0));
		btnNo.setBounds(227, 127, 84, 31);
		contentPane.add(btnNo);

	}
}

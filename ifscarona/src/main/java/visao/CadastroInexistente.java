package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroInexistente extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroInexistente frame = new CadastroInexistente();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					// Centralizar
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
	public CadastroInexistente() {
		setResizable(false);

		java.net.URL caminhoIcone = getClass().getResource("/assets/janelaIcon.png");
		Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminhoIcone);
		this.setIconImage(iconeTitulo);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 451, 234);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(159, 203, 154));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAviso = new JLabel("");
		lblAviso.setIcon(new ImageIcon(CadastroInexistente.class.getResource("/assets/alerta.png")));
		lblAviso.setBounds(45, 43, 48, 48);
		contentPane.add(lblAviso);

		JLabel lblCadastroInexistente = new JLabel("Cadastro Inexistente!");
		lblCadastroInexistente.setFont(new Font("Nirmala UI", Font.BOLD, 17));
		lblCadastroInexistente.setBounds(153, 60, 218, 14);
		contentPane.add(lblCadastroInexistente);

		JButton btnNewButton = new JButton("OK");
		btnNewButton.setFont(new Font("Nirmala UI", Font.PLAIN, 13));
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(255, 251, 233));
		btnNewButton.setBounds(208, 120, 84, 31);
		contentPane.add(btnNewButton);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}

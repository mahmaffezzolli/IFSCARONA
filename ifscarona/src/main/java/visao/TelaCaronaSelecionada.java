package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TelaCaronaSelecionada extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCaronaSelecionada frame = new TelaCaronaSelecionada();
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
	public TelaCaronaSelecionada() {
		setResizable(false);

		java.net.URL caminhoIcone = getClass().getResource("/assets/janelaIcon.png");
		Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminhoIcone);
		this.setIconImage(iconeTitulo);
		setBounds(100, 100, 451, 234);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(159, 203, 154));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAviso = new JLabel("");
		lblAviso.setIcon(new ImageIcon(TelaCaronaSelecionada.class.getResource("/assets/alerta.png")));
		lblAviso.setBounds(39, 70, 48, 48);
		contentPane.add(lblAviso);

		JLabel lblCadastroInexistente = new JLabel("Carona selecionada com sucesso!");
		lblCadastroInexistente.setFont(new Font("Nirmala UI", Font.BOLD, 17));
		lblCadastroInexistente.setBounds(107, 82, 261, 24);
		contentPane.add(lblCadastroInexistente);
	}


	}



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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SenhaIncorreta extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SenhaIncorreta frame = new SenhaIncorreta();
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
	public SenhaIncorreta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 234);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(159, 203, 154));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAviso = new JLabel("");
		lblAviso.setIcon(new ImageIcon(SenhaIncorreta.class.getResource("/assets/alerta.png")));
		lblAviso.setBounds(45, 43, 48, 48);
		contentPane.add(lblAviso);

		JLabel lblSenhaIncorreta = new JLabel("Senha Incorreta!");
		lblSenhaIncorreta.setFont(new Font("Arial", Font.PLAIN, 15));
		lblSenhaIncorreta.setBounds(153, 60, 138, 14);
		contentPane.add(lblSenhaIncorreta);

		JButton btnNewButton = new JButton("OK");
		btnNewButton.setFont(new Font("Nirmala UI", Font.PLAIN, 13));
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(255, 251, 233));
		btnNewButton.setBounds(177, 123, 84, 31);
		contentPane.add(btnNewButton);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Fecha a janela atual
				dispose();
			}
		});
	}
}

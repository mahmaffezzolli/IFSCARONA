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

public class EmaiInvalido extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmaiInvalido frame = new EmaiInvalido();
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
	public EmaiInvalido() {
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
		lblAviso.setIcon(new ImageIcon(EmaiInvalido.class.getResource("/assets/alerta.png")));
		lblAviso.setBounds(45, 49, 54, 48);
		contentPane.add(lblAviso);

		JLabel lblEmailInvalido = new JLabel("Email Inválido!");
		lblEmailInvalido.setFont(new Font("Dialog", Font.BOLD, 17));
		lblEmailInvalido.setBounds(154, 61, 211, 18);
		contentPane.add(lblEmailInvalido);

		JButton btnOk = new JButton("OK");
		btnOk.setFont(new Font("Dialog", Font.PLAIN, 13));
		btnOk.setBorder(null);
		btnOk.setBackground(new Color(255, 251, 233));
		btnOk.setBounds(177, 123, 84, 31);
		contentPane.add(btnOk);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
			}
		});
	}

}

package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class CadastroRealizado extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroRealizado frame = new CadastroRealizado();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastroRealizado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 234);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(159, 203, 154));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAviso = new JLabel("");
		lblAviso.setIcon(new ImageIcon("C:\\Users\\Aluno\\Downloads\\Aviso.png"));
		lblAviso.setBounds(33, 28, 60, 66);
		contentPane.add(lblAviso);
		
		JLabel lblCadastroRealizado = new JLabel("Cadastro realizado com secesso!");
		lblCadastroRealizado.setFont(new Font("Arial", Font.PLAIN, 15));
		lblCadastroRealizado.setBounds(110, 55, 221, 18);
		contentPane.add(lblCadastroRealizado);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBackground(new Color(255, 251, 233));
		btnNewButton.setBounds(177, 123, 84, 23);
		contentPane.add(btnNewButton);
	}

}

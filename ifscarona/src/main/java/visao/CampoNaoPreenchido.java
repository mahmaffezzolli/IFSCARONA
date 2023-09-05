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

public class CampoNaoPreenchido extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CampoNaoPreenchido frame = new CampoNaoPreenchido();
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
	public CampoNaoPreenchido() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 234);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(159, 203, 154));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAviso = new JLabel("");
		lblAviso.setIcon(new ImageIcon(CampoNaoPreenchido.class.getResource("/assets/Aviso.png")));
		lblAviso.setBounds(36, 33, 68, 66);
		contentPane.add(lblAviso);
		
		JLabel lblCampoNaoPreenchido = new JLabel("Campo não preenchido!");
		lblCampoNaoPreenchido.setFont(new Font("Arial", Font.PLAIN, 15));
		lblCampoNaoPreenchido.setBounds(139, 56, 162, 18);
		contentPane.add(lblCampoNaoPreenchido);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBackground(new Color(255, 251, 233));
		btnOk.setBounds(177, 123, 84, 23);
		contentPane.add(btnOk);
	}

}

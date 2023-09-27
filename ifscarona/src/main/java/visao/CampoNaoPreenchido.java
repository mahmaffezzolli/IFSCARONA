package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	public CampoNaoPreenchido() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 234);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(159, 203, 154));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAviso = new JLabel("");
		lblAviso.setIcon(new ImageIcon(CampoNaoPreenchido.class.getResource("/assets/alerta.png")));
		lblAviso.setBounds(45, 49, 54, 48);
		contentPane.add(lblAviso);
		
		JLabel lblCampoNaoPreenchido = new JLabel("Campo não preenchido!");
		lblCampoNaoPreenchido.setFont(new Font("Arial", Font.PLAIN, 15));
		lblCampoNaoPreenchido.setBounds(139, 56, 235, 18);
		contentPane.add(lblCampoNaoPreenchido);
		
		JButton btnOk = new JButton("OK");
		btnOk.setFont(new Font("Nirmala UI", Font.PLAIN, 13));
		btnOk.setBorder(null);
		btnOk.setBackground(new Color(255, 251, 233));
		btnOk.setBounds(177, 123, 84, 31);
		contentPane.add(btnOk);
		 btnOk.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // Fecha a janela atual
	                dispose();
	            }
	        });
	}

}

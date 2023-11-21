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

public class CaracteresVeiculo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CaracteresVeiculo frame = new CaracteresVeiculo();
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
	public CaracteresVeiculo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 234);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(159, 203, 154));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAviso = new JLabel("");
		lblAviso.setIcon(new ImageIcon(CaracteresVeiculo.class.getResource("/assets/alerta.png")));
		lblAviso.setBounds(45, 45, 48, 48);
		contentPane.add(lblAviso);
		
		JLabel lblCadastroErro = new JLabel("A placa deve ter 7 caracteres!");
		lblCadastroErro.setFont(new Font("Arial", Font.PLAIN, 15));
		lblCadastroErro.setBounds(118, 45, 245, 18);
		contentPane.add(lblCadastroErro);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBorder(null);
		btnNewButton.setFont(new Font("Nirmala UI", Font.PLAIN, 13));
		btnNewButton.setBackground(new Color(255, 251, 233));
		btnNewButton.setBounds(177, 123, 84, 31);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                dispose();
	            }
	        });
	}

}

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

public class TelaExcluirConta extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaExcluirConta frame = new TelaExcluirConta();
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
		
		JButton btnSim = new JButton("SIM");
		btnSim.setForeground(new Color(255, 255, 255));
		btnSim.setBorder(null);
		btnSim.setFont(new Font("Nirmala UI", Font.BOLD, 16));
		btnSim.setBackground(new Color(174, 57, 57));
		btnSim.setBounds(108, 127, 84, 31);
		contentPane.add(btnSim);
		
		JLabel lblNewLabel = new JLabel("EXCLUIR A CONTA?");
		lblNewLabel.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		lblNewLabel.setBounds(146, 73, 135, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNo = new JButton("NÃO");
		btnNo.setForeground(Color.WHITE);
		btnNo.setFont(new Font("Nirmala UI", Font.BOLD, 16));
		btnNo.setBorder(null);
		btnNo.setBackground(new Color(0, 0, 0));
		btnNo.setBounds(227, 127, 84, 31);
		contentPane.add(btnNo);
		
		btnSim.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // Fecha a janela atual
	                dispose();
	            }
	        });
	}
}

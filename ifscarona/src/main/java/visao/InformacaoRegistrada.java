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

public class InformacaoRegistrada extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InformacaoRegistrada frame = new InformacaoRegistrada();
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
	public InformacaoRegistrada() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 234);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(159, 203, 154));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAviso = new JLabel("");
		lblAviso.setIcon(new ImageIcon(InformacaoRegistrada.class.getResource("/assets/Aviso.png")));
		lblAviso.setBounds(33, 28, 68, 66);
		contentPane.add(lblAviso);
		
		JLabel lblInformacaoRegistrada = new JLabel("Informação já registrada!");
		lblInformacaoRegistrada.setFont(new Font("Arial", Font.PLAIN, 15));
		lblInformacaoRegistrada.setBounds(137, 55, 169, 18);
		contentPane.add(lblInformacaoRegistrada);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBackground(new Color(255, 251, 233));
		btnNewButton.setBounds(177, 123, 84, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Fecha a janela atual
                dispose();
            }
        });
	}

}

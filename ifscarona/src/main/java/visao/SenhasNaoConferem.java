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

public class SenhasNaoConferem extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SenhasNaoConferem frame = new SenhasNaoConferem();
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
	public SenhasNaoConferem() {
		
		java.net.URL caminhoIcone = getClass().getResource("/assets/janelaIcon.png");
		Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminhoIcone);
		this.setIconImage(iconeTitulo);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 234);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(159, 203, 154));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAviso = new JLabel("");
		lblAviso.setIcon(new ImageIcon(SenhasNaoConferem.class.getResource("/assets/alerta.png")));
		lblAviso.setBounds(45, 48, 56, 56);
		contentPane.add(lblAviso);
		
		JLabel lblSenhaNaoConfere = new JLabel("As senhas não conferem!");
		lblSenhaNaoConfere.setFont(new Font("Arial", Font.PLAIN, 15));
		lblSenhaNaoConfere.setBounds(137, 55, 222, 18);
		contentPane.add(lblSenhaNaoConfere);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setFont(new Font("Nirmala UI", Font.PLAIN, 13));
		btnNewButton.setBorder(null);
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 251, 233));
		btnNewButton.setBounds(179, 109, 84, 31);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Fecha a janela atual
                dispose();
            }
        });
	}

}

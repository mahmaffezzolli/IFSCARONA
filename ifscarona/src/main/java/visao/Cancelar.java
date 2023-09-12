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

public class Cancelar extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cancelar frame = new Cancelar();
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
	public Cancelar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 234);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(159, 203, 154));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAviso = new JLabel("");
		lblAviso.setIcon(new ImageIcon(Cancelar.class.getResource("/assets/Aviso.png")));
		lblAviso.setBounds(36, 33, 68, 66);
		contentPane.add(lblAviso);
		
		JLabel lblCancelar = new JLabel("Deseja cancelar?");
		lblCancelar.setFont(new Font("Arial", Font.PLAIN, 15));
		lblCancelar.setBounds(157, 56, 162, 18);
		contentPane.add(lblCancelar);
		
		JButton btnSim = new JButton("SIM");
		btnSim.setBackground(new Color(255, 251, 233));
		btnSim.setBounds(131, 123, 84, 23);
		contentPane.add(btnSim);
		
		btnSim.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Abre a tela de perfil 
                Perfil Perfil = new Perfil();
                Perfil.setVisible(true);

                // Fecha a janela atual (Cancelar)
                dispose();
            }
        });
		
		
		JButton btnNao = new JButton("NÃO");
		btnNao.setBackground(new Color(255, 251, 233));
		btnNao.setBounds(235, 123, 84, 23);
		contentPane.add(btnNao);
		
		btnNao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Fecha a janela atual
                dispose();
            }
        });
	}

}

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

public class ErroAoAtualizar extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ErroAoAtualizar frame = new ErroAoAtualizar();
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
	public ErroAoAtualizar() {
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
		
		JLabel lblDadosPessoaisAtualizados = new JLabel("Erro ao atualizar os dados");
		lblDadosPessoaisAtualizados.setFont(new Font("Arial", Font.PLAIN, 15));
		lblDadosPessoaisAtualizados.setBounds(130, 54, 179, 18);
		contentPane.add(lblDadosPessoaisAtualizados);
		
		JButton btnOk = new JButton("OK");
		btnOk.setFont(new Font("Nirmala UI", Font.PLAIN, 13));
		btnOk.setBorder(null);
		btnOk.setBackground(new Color(255, 251, 233));
		btnOk.setBounds(177, 123, 84, 31);
		contentPane.add(btnOk);
		
		JLabel lblSucesso = new JLabel("pessoais.");
		lblSucesso.setFont(new Font("Arial", Font.PLAIN, 15));
		lblSucesso.setBounds(188, 83, 63, 14);
		contentPane.add(lblSucesso);
		 btnOk.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // Fecha a janela atual
	                dispose();
	            }
	        });
	}
}
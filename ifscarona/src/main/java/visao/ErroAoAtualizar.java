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
	public ErroAoAtualizar() {
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
		lblAviso.setIcon(new ImageIcon(CampoNaoPreenchido.class.getResource("/assets/alerta.png")));
		lblAviso.setBounds(45, 49, 54, 48);
		contentPane.add(lblAviso);

		JLabel lblDadosPessoaisAtualizados = new JLabel("Erro ao atualizar os dados");
		lblDadosPessoaisAtualizados.setFont(new Font("Nirmala UI", Font.BOLD, 17));
		lblDadosPessoaisAtualizados.setBounds(130, 54, 246, 18);
		contentPane.add(lblDadosPessoaisAtualizados);

		JButton btnOk = new JButton("OK");
		btnOk.setFont(new Font("Nirmala UI", Font.PLAIN, 13));
		btnOk.setBorder(null);
		btnOk.setBackground(new Color(255, 251, 233));
		btnOk.setBounds(212, 122, 84, 31);
		contentPane.add(btnOk);

		JLabel lblSucesso = new JLabel("pessoais.");
		lblSucesso.setFont(new Font("Nirmala UI", Font.BOLD, 17));
		lblSucesso.setBounds(210, 79, 99, 18);
		contentPane.add(lblSucesso);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Fecha a janela atual
				dispose();
			}
		});
	}
}

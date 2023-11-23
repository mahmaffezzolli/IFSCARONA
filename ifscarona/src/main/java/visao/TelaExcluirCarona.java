package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.CaronaDAO;
import controle.VeiculoDAO;
import modelo.Carona;
import modelo.Carro;
import modelo.Sessao;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class TelaExcluirCarona extends JFrame {

	private JPanel contentPane;
	private CaronaDAO cDAO = CaronaDAO.getInstancia();
	private Long idCarona;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Long idCarona = null;
					TelaExcluirCarona frame = new TelaExcluirCarona(idCarona);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
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
	public TelaExcluirCarona(Long idCarona) throws ParseException {
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

		JLabel lblTexto = new JLabel("Tem certeza que deseja");
		lblTexto.setFont(new Font("Nirmala UI", Font.BOLD, 17));
		lblTexto.setBounds(128, 48, 198, 18);
		contentPane.add(lblTexto);

		JLabel lblTexto2 = new JLabel("excluir a carona?");
		lblTexto2.setFont(new Font("Nirmala UI", Font.BOLD, 17));
		lblTexto2.setBounds(157, 77, 154, 14);
		contentPane.add(lblTexto2);

		JButton btnSim = new JButton("SIM");
		btnSim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Carona carona = cDAO.pegaCarona(idCarona);

				if (carona != null) {
					cDAO.deletarCarona(carona);
				}

				ListagemCaronas listagem = new ListagemCaronas();
				listagem.setVisible(true);
				
				dispose();
			}
		});

		btnSim.setForeground(new Color(255, 255, 255));
		btnSim.setBorder(null);
		btnSim.setFont(new Font("Nirmala UI", Font.BOLD, 16));
		btnSim.setBackground(new Color(174, 57, 57));
		btnSim.setBounds(108, 127, 84, 31);
		contentPane.add(btnSim);

		JButton btnNo = new JButton("NÃO");
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		btnNo.setForeground(Color.WHITE);
		btnNo.setFont(new Font("Nirmala UI", Font.BOLD, 16));
		btnNo.setBorder(null);
		btnNo.setBackground(new Color(0, 0, 0));
		btnNo.setBounds(227, 127, 84, 31);
		contentPane.add(btnNo);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaExcluirCarona.class.getResource("/assets/alerta.png")));
		lblNewLabel.setBounds(45, 48, 46, 39);
		contentPane.add(lblNewLabel);

	}
}

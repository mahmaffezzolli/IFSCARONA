package visao;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.TimePicker;

import controle.VeiculoDAO;
import modelo.Pessoa;
import modelo.Sessao;
import modelo.Veiculo;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Principal extends JFrame {

	private JPanel contentPane;
	private VeiculoDAO vDAO = VeiculoDAO.getInstancia();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
	public Principal() {

		java.net.URL caminhoIcone = getClass().getResource("/assets/janelaIcon.png");
		Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminhoIcone);
		this.setIconImage(iconeTitulo);

		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, screen.width, screen.height - 30);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(154, 203, 159));
		contentPane.setBorder(new LineBorder(new Color(255, 251, 233), 2, true));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnLogOut = new JButton("");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Sessao.setPessoaLogada(null);
				dispose();
				Inicio inicio = new Inicio();
				inicio.setVisible(true);
			}
		});

		btnLogOut.setIcon(new ImageIcon(Principal.class.getResource("/assets/Log-out.png")));
		btnLogOut.setBorder(null);
		btnLogOut.setBackground(new Color(244, 234, 213));
		btnLogOut.setBounds(150, 750, 75, 65);
		contentPane.add(btnLogOut);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(1123, 232, 11, 534);
		contentPane.add(separator);

		JButton btnLogar = new JButton("Requisitar");
		btnLogar.setIcon(new ImageIcon(Principal.class.getResource("/assets/icons8-caronas-50.png")));
		btnLogar.setFont(new Font("Dialog", Font.BOLD, 20));
		btnLogar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				new ListagemCaronas().setVisible(true);
				Principal.this.dispose();

			}
		});
		btnLogar.setBackground(new Color(211, 215, 207));
		btnLogar.setBounds(665, 492, 227, 61);
		contentPane.add(btnLogar);

		JLabel lblCarro = new JLabel("");
		lblCarro.setIcon(new ImageIcon(Principal.class.getResource("/assets/car.png")));
		lblCarro.setBounds(106, 302, 385, 151);
		contentPane.add(lblCarro);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Principal.class.getResource("/assets/b1340120-e126-4821-b15c-e3627d2a38a6.png")));
		lblLogo.setBounds(-5, 426, 590, 172);
		contentPane.add(lblLogo);

		JLabel lblFundo = new JLabel("");
		lblFundo.setIcon(new ImageIcon(Principal.class.getResource("/assets/fundoClaro.png")));
		lblFundo.setBounds(-11, -235, 525, 1650);
		contentPane.add(lblFundo);

		JLabel lblTitulo1 = new JLabel("Topa uma ");
		lblTitulo1.setFont(new Font("Dialog", Font.BOLD, 50));
		lblTitulo1.setBounds(610, 329, 599, 70);
		contentPane.add(lblTitulo1);

		JLabel lblTitulo2 = new JLabel(" carona? ");
		lblTitulo2.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 38));
		lblTitulo2.setBounds(695, 387, 619, 70);
		contentPane.add(lblTitulo2);

		JButton btnPerfil = new JButton("Perfil ");
		btnPerfil.setFont(new Font("Dialog", Font.BOLD, 15));
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					new Perfil().setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Principal.this.dispose();
			}

		});
		btnPerfil.setBackground(new Color(244, 234, 213));
		btnPerfil.setBorder(new LineBorder(new Color(232, 218, 188), 4, true));
		btnPerfil.setBounds(1329, 485, 169, 59);
		contentPane.add(btnPerfil);

		JButton btnNewButton_1 = new JButton("Oferecer");
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 15));

		Pessoa pessoaLogada = Sessao.getPessoaLogada();

		Veiculo veiculoLogado = vDAO.conexaoVeiculoPessoa(pessoaLogada);

		if (veiculoLogado == null) {
			btnNewButton_1.setEnabled(false);
		}

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new OferecerCarona().setVisible(true);
				Principal.this.dispose();

			}
		});
		btnNewButton_1.setBorder(new LineBorder(new Color(232, 218, 188), 4));
		btnNewButton_1.setBackground(new Color(244, 234, 213));
		btnNewButton_1.setBounds(1329, 662, 169, 59);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton = new JButton("Histórico");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Historico().setVisible(true);
				Principal.this.dispose();
			}
		});
		btnNewButton.setBackground(new Color(244, 234, 213));
		btnNewButton.setBorder(new LineBorder(new Color(232, 218, 188), 4, true));
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 15));
		btnNewButton.setBounds(1329, 302, 169, 59);
		contentPane.add(btnNewButton);

		DatePickerSettings dateSettings = new DatePickerSettings();
		dateSettings.setFormatForDatesCommonEra("dd/MM/yyyy");
		dateSettings.setFormatForDatesBeforeCommonEra("dd/MM/yyyy");
		dateSettings.setLocale(determineLocale("pt", "BR"));

	}

	private Locale determineLocale(String language, String country) {
		return new Locale(language, country);
	}
}

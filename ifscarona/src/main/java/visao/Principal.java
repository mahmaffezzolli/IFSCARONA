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
	private DatePicker datePicker;
	private TimePicker timePicker;

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
		separator.setBounds(1403, 240, 11, 534);
		contentPane.add(separator);

		JComboBox cmbLugar = new JComboBox<>();
		cmbLugar.setFont(new Font("Dialog", Font.BOLD, 12));
		cmbLugar.setModel(new DefaultComboBoxModel<>(new String[] { "SELECIONE OS LUGARES", "1", "2", "3", "4" }));
		cmbLugar.setBounds(806, 391, 170, 23);
		cmbLugar.setBackground(new Color(255, 251, 233));
		contentPane.add(cmbLugar);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(RequisitarCarona.class.getResource("/assets/MODELO.png")));
		lblNewLabel.setBounds(740, 363, 62, 62);
		contentPane.add(lblNewLabel);
		JButton btnLogar = new JButton("Requisitar");
		btnLogar.setIcon(new ImageIcon(Principal.class.getResource("/assets/icons8-caronas-50.png")));
		btnLogar.setFont(new Font("Dialog", Font.BOLD, 15));
		btnLogar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if (datePicker.getDate() != null || timePicker.getTime() != null) {
					
				    new ListagemCaronas().setVisible(true);
				    Principal.this.dispose();
				    
				} else {
				    CampoNaoPreenchido campoNaoPreenchido = new CampoNaoPreenchido();
				    campoNaoPreenchido.setBounds(40, 40, 451, 234);
				    campoNaoPreenchido.setLocationRelativeTo(null);
				    campoNaoPreenchido.setVisible(true);
				}

			}
		});
		
		btnLogar.setBorder(new LineBorder(new Color(249, 239, 197), 4, true));
		btnLogar.setBackground(new Color(255, 251, 233));
		btnLogar.setBounds(821, 790, 179, 65);
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
		lblFundo.setBounds(-11, -235, 468, 1650);
		contentPane.add(lblFundo);

		JLabel lblFiltro = new JLabel("Filtrar viagens");
		lblFiltro.setFont(new Font("Dialog", Font.BOLD, 40));
		lblFiltro.setBounds(716, 147, 281, 107);
		contentPane.add(lblFiltro);

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
		btnPerfil.setBounds(1578, 462, 169, 59);
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
		btnNewButton_1.setBounds(1578, 650, 169, 59);
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
		btnNewButton.setBounds(1578, 302, 169, 59);
		contentPane.add(btnNewButton);

		DatePickerSettings dateSettings = new DatePickerSettings();
		dateSettings.setFormatForDatesCommonEra("dd/MM/yyyy");
		dateSettings.setFormatForDatesBeforeCommonEra("dd/MM/yyyy");
		dateSettings.setLocale(determineLocale("pt", "BR"));
		datePicker = new DatePicker(dateSettings);
		datePicker.getComponentDateTextField().setFont(new Font("Nirmala UI", Font.PLAIN, 13));
		datePicker.setBounds(752, 492, 220, 30);
		contentPane.add(datePicker);

		timePicker = new TimePicker();
		timePicker.getComponentTimeTextField().setFont(new Font("Nirmala UI", Font.PLAIN, 13));
		timePicker.setBounds(752, 587, 220, 30);
		contentPane.add(timePicker);

		JLabel lblFundoFiltro_1 = new JLabel("");
		lblFundoFiltro_1.setIcon(new ImageIcon(Principal.class.getResource("/assets/FUndo CLaroP.png")));
		lblFundoFiltro_1.setBounds(697, 220, 532, 560);
		contentPane.add(lblFundoFiltro_1);

	}

	private Locale determineLocale(String language, String country) {
		return new Locale(language, country);
	}
}

package visao;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.TimePicker;

import controle.TrajetoDAO;
import modelo.Trajeto;

import javax.swing.JComboBox;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;

public class RequisitarCarona extends JFrame {

	protected static final AbstractButton comboBox2 = null;
	protected static final AbstractButton comboBox1 = null;
	private JPanel contentPane;
	private JComboBox<String> cmbGaspar;
	private JComboBox<String> cmbBlumenau;
	private JComboBox<String> cmbLugar;
	private JRadioButton rdbtnIfsc;
	private JRadioButton rdbtnGaspar;
	private JRadioButton rdbtnBlumenau;
	private DatePicker datePicker;
	private TimePicker timePicker;

	private TrajetoDAO tDAO = TrajetoDAO.getInstancia();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RequisitarCarona frame = new RequisitarCarona();
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
	public RequisitarCarona() {

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

		JButton btnHome = new JButton("");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal principal = new Principal();
				principal.setVisible(true);

				dispose();

			}
		});

		DatePickerSettings dateSettings = new DatePickerSettings();
		dateSettings.setFormatForDatesCommonEra("dd/MM/yyyy");
		dateSettings.setFormatForDatesBeforeCommonEra("dd/MM/yyyy");
		dateSettings.setLocale(determineLocale("pt", "BR"));
		datePicker = new DatePicker(dateSettings);
		datePicker.getComponentDateTextField().setFont(new Font("Nirmala UI", Font.PLAIN, 13));
		datePicker.setBounds(1463, 565, 220, 30);
		contentPane.add(datePicker);

		timePicker = new TimePicker();
		timePicker.getComponentTimeTextField().setFont(new Font("Nirmala UI", Font.PLAIN, 13));
		timePicker.setBounds(1463, 665, 220, 30);
		contentPane.add(timePicker);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(Color.BLACK);
		separator_1_1.setBounds(1425, 511, 283, 23);
		contentPane.add(separator_1_1);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 0, 0));
		separator_1.setBounds(765, 525, 283, 23);
		contentPane.add(separator_1);

		rdbtnIfsc = new JRadioButton("IFSC");
		rdbtnIfsc.setFont(new Font("Nirmala UI", Font.PLAIN, 13));
		rdbtnIfsc.setBounds(860, 450, 130, 25);
		contentPane.add(rdbtnIfsc);

		rdbtnGaspar = new JRadioButton("Gaspar");
		rdbtnGaspar.setFont(new Font("Nirmala UI", Font.PLAIN, 13));
		rdbtnGaspar.setBounds(860, 400, 130, 25);
		contentPane.add(rdbtnGaspar);

		rdbtnBlumenau = new JRadioButton("Blumenau");
		rdbtnBlumenau.setFont(new Font("Nirmala UI", Font.PLAIN, 13));
		rdbtnBlumenau.setBounds(860, 350, 130, 25);
		contentPane.add(rdbtnBlumenau);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(RequisitarCarona.class.getResource("/assets/icons8-localização-50.png")));
		lblNewLabel_3.setBounds(775, 400, 50, 50);
		contentPane.add(lblNewLabel_3);

		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(rdbtnGaspar);
		radioGroup.add(rdbtnBlumenau);
		radioGroup.add(rdbtnIfsc);

		btnHome.setBorder(null);
		btnHome.setForeground(new Color(0, 0, 0));
		btnHome.setBackground(new Color(244, 234, 214));
		btnHome.setIcon(new ImageIcon(Perfil.class.getResource("/assets/home.png")));
		btnHome.setBounds(149, 790, 75, 65);
		contentPane.add(btnHome);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(RequisitarCarona.class.getResource("/assets/icons8-localização-50.png")));
		lblNewLabel_2.setBounds(775, 585, 50, 50);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(RequisitarCarona.class.getResource("/assets/MODELO.png")));
		lblNewLabel.setBounds(1437, 385, 62, 62);
		contentPane.add(lblNewLabel);

		cmbLugar = new JComboBox<>();
		cmbLugar.setFont(new Font("Nirmala UI", Font.PLAIN, 13));
		cmbLugar.setModel(new DefaultComboBoxModel<>(new String[] { "SELECIONE OS LUGARES", "1", "2", "3", "4" }));
		cmbLugar.setBounds(1514, 400, 170, 35);
		cmbLugar.setBackground(new Color(255, 251, 233));
		contentPane.add(cmbLugar);

		cmbGaspar = new JComboBox<>();
		cmbGaspar.setFont(new Font("Nirmala UI", Font.PLAIN, 13));
		cmbGaspar.setModel(new DefaultComboBoxModel<>(new String[] { "GASPAR", "Alto Gasparinho", "Arraial D’Ouro",
				"Barracão", "Bateias", "Bela Vista", "Belchior Alto", "Belchior Baixo", "Belchior Central", "Centro",
				"Coloninha", "Figueira", "Gaspar Alto", "Gaspar Grande", "Gasparinho", "Gaspar Mirim", "Lagoa",
				"Macucos", "Margem Esquerda", "Poço Grande", "Santa Terezinha", "Sete de Setembro" }));
		cmbGaspar.setBounds(850, 630, 170, 25);
		cmbGaspar.setBackground(new Color(255, 251, 233));
		contentPane.add(cmbGaspar);

		cmbBlumenau = new JComboBox<>();
		cmbBlumenau.setFont(new Font("Nirmala UI", Font.PLAIN, 13));
		cmbBlumenau.setModel(new DefaultComboBoxModel<>(new String[] { "BLUMENAU", "Badenfurt", "Fidélis",
				"Itoupava Central", "Itoupavazinha", "Salto do Norte", "Testo Salto", "Vila Itoupava", "Fortaleza",
				"Fortaleza Alta", "Itoupava Norte", "Nova Esperança", "Ponta Aguda", "Tribess", "Vorstadt", "Da Glória",
				"Garcia", "Progresso", "Ribeirão Fresco", "Valparaíso", "Vila Formosa", "Água Verde", "Do Salto",
				"Escola Agrícola", "Passo Manso", "Salto Weissbach", "Velha", "Velha Central", "Velha Grande",
				"Boa Vista", "Bom Retiro", "Centro", "Itoupava Seca", "Jardim Blumenau", "Victor Konder",
				"Vila Nova" }));
		cmbBlumenau.setBounds(850, 570, 170, 25);
		cmbBlumenau.setBackground(new Color(255, 251, 233));
		contentPane.add(cmbBlumenau);

		rdbtnGaspar.addItemListener(e -> {
			cmbBlumenau.setEnabled(!rdbtnGaspar.isSelected());
			cmbGaspar.setEnabled(rdbtnGaspar.isSelected());
		});

		rdbtnBlumenau.addItemListener(e -> {
			cmbGaspar.setEnabled(!rdbtnBlumenau.isSelected());
			cmbBlumenau.setEnabled(rdbtnBlumenau.isSelected());
		});
		rdbtnIfsc.addItemListener(e -> {
			cmbGaspar.setEnabled(false);
			cmbBlumenau.setEnabled(false);
		});
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(1160, 278, 11, 416);
		contentPane.add(separator);

		JLabel lblCarro = new JLabel("");
		lblCarro.setIcon(new ImageIcon(Principal.class.getResource("/assets/car.png")));
		lblCarro.setBounds(81, 304, 385, 151);
		contentPane.add(lblCarro);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Principal.class.getResource("/assets/b1340120-e126-4821-b15c-e3627d2a38a6.png")));
		lblLogo.setBounds(-5, 426, 590, 172);
		contentPane.add(lblLogo);

		JLabel lblFundoLugar = new JLabel("");
		lblFundoLugar.setIcon(new ImageIcon(RequisitarCarona.class.getResource("/assets/FUndo CLaroP.png")));
		lblFundoLugar.setBounds(1399, 302, 385, 462);
		contentPane.add(lblFundoLugar);

		JLabel lblFundo = new JLabel("");
		lblFundo.setIcon(new ImageIcon(Principal.class.getResource("/assets/fundoClaro.png")));
		lblFundo.setBounds(-5, -239, 468, 1650);
		contentPane.add(lblFundo);

		JLabel lblFundoFiltro1 = new JLabel("");
		lblFundoFiltro1.setIcon(new ImageIcon(RequisitarCarona.class.getResource("/assets/FUndo CLaroP.png")));
		lblFundoFiltro1.setBounds(744, 302, 385, 442);
		contentPane.add(lblFundoFiltro1);

		JLabel lblNewLabel_1 = new JLabel("Para onde você vai?");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 31));
		lblNewLabel_1.setBounds(731, 220, 530, 107);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Quantos lugares necessários?");
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.BOLD, 31));
		lblNewLabel_1_1.setBounds(1273, 220, 530, 107);
		contentPane.add(lblNewLabel_1_1);

		JButton btnNewButton = new JButton("   Requisitar");
		btnNewButton.setFont(new Font("Nirmala UI", Font.PLAIN, 16));
		btnNewButton
				.setIcon(new ImageIcon(RequisitarCarona.class.getResource("/assets/icons8-viajar-de-carona-50.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (rdbtnGaspar.isSelected() || rdbtnBlumenau.isSelected() || rdbtnIfsc.isSelected()) {

					definirTrajeto();

					new ListagemCaronas().setVisible(true);
					RequisitarCarona.this.dispose();
				} else {
					CampoNaoPreenchido campoNaoPreenchido = new CampoNaoPreenchido();
					campoNaoPreenchido.setVisible(true);
				}
			}
		});
		btnNewButton.setBackground(new Color(251, 251, 233));
		btnNewButton.setBounds(1081, 809, 189, 60);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_1_2 = new JLabel("Requisitar Carona");
		lblNewLabel_1_2.setFont(new Font("Dialog", Font.BOLD, 40));
		lblNewLabel_1_2.setBounds(965, 59, 552, 107);
		contentPane.add(lblNewLabel_1_2);
	}

	public Trajeto definirTrajeto() {
		Trajeto t = new Trajeto();

		if (rdbtnGaspar.isSelected()) {
			String bairro = (String) cmbGaspar.getSelectedItem();

			if (bairroSelecionado(bairro, cmbGaspar)) {
				t.setDestino("Gaspar, " + bairro);
				t.setOrigem("IFSC");

			} else {
				showCampoNaoPreenchido();
				return null;
			}

		} else if (rdbtnBlumenau.isSelected()) {
			String bairro = (String) cmbBlumenau.getSelectedItem();

			if (bairroSelecionado(bairro, cmbBlumenau)) {
				t.setDestino("Blumenau, " + bairro);
				t.setOrigem("IFSC");

			} else {
				showCampoNaoPreenchido();
				return null;
			}

		} else if (rdbtnIfsc.isSelected()) {
			t.setDestino("IFSC");

		} else {
			showCampoNaoPreenchido();
			return null;
		}

		Long success = tDAO.cadastrarTrajeto(t);
		t.setIdTrajeto(success);

		return t;
	}

	private boolean bairroSelecionado(String bairro, JComboBox<String> comboBox) {
		return comboBox.getSelectedIndex() > 0 && bairro != null && !bairro.isEmpty();
	}

	private void showCampoNaoPreenchido() {
		CampoNaoPreenchido campoNaoPreenchido = new CampoNaoPreenchido();
		campoNaoPreenchido.setVisible(true);
	}

	private Locale determineLocale(String language, String country) {
		return new Locale(language, country);
	}
}

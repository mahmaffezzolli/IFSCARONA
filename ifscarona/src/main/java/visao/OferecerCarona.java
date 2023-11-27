package visao;

import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import controle.CaronaDAO;
import controle.TrajetoDAO;
import modelo.Carona;
import modelo.Sessao;
import modelo.Trajeto;
import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.TimePicker;

public class OferecerCarona extends JFrame {

	private JPanel contentPane;
	private JComboBox<String> cmbGaspar;
	private JComboBox<String> cmbBlumenau;
	private JComboBox<String> cmbLugar;
	private JRadioButton rdbtnGaspar;
	private JRadioButton rdbtnBlumenau;
	private JRadioButton rdbtnIfsc;
	private DatePicker datePicker;
	private TimePicker timePicker;

	private CaronaDAO cDAO = CaronaDAO.getInstancia();
	private TrajetoDAO tDAO = TrajetoDAO.getInstancia();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OferecerCarona frame = new OferecerCarona();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public OferecerCarona() {

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
		datePicker.setBounds(1400, 600, 220, 30);
		contentPane.add(datePicker);

		timePicker = new TimePicker();
		timePicker.setBounds(1400, 700, 220, 30);
		contentPane.add(timePicker);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(Color.BLACK);
		separator_1_1.setBounds(1364, 571, 295, 12);
		contentPane.add(separator_1_1);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 0, 0));
		separator_1.setBounds(725, 571, 295, 12);
		contentPane.add(separator_1);

		rdbtnIfsc = new JRadioButton("IFSC");
		rdbtnIfsc.setBounds(845, 484, 129, 23);
		contentPane.add(rdbtnIfsc);

		rdbtnGaspar = new JRadioButton("Gaspar");
		rdbtnGaspar.setBounds(845, 442, 129, 23);
		contentPane.add(rdbtnGaspar);

		rdbtnBlumenau = new JRadioButton("Blumenau");
		rdbtnBlumenau.setBounds(845, 396, 129, 23);
		contentPane.add(rdbtnBlumenau);

		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(rdbtnGaspar);
		radioGroup.add(rdbtnBlumenau);
		radioGroup.add(rdbtnIfsc);

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

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(OferecerCarona.class.getResource("/assets/icons8-localização-50.png")));
		lblNewLabel_3.setBounds(744, 421, 50, 50);
		contentPane.add(lblNewLabel_3);

		btnHome.setBorder(null);
		btnHome.setForeground(new Color(0, 0, 0));
		btnHome.setBackground(new Color(244, 234, 214));
		btnHome.setIcon(new ImageIcon(Perfil.class.getResource("/assets/home.png")));
		btnHome.setBounds(149, 790, 75, 65);
		contentPane.add(btnHome);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(OferecerCarona.class.getResource("/assets/icons8-localização-50.png")));
		lblNewLabel_2.setBounds(744, 639, 50, 50);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(OferecerCarona.class.getResource("/assets/MODELO.png")));
		lblNewLabel.setBounds(1379, 442, 67, 65);
		contentPane.add(lblNewLabel);

		cmbLugar = new JComboBox();
		cmbLugar.setModel(new DefaultComboBoxModel(new String[] { "SELECIONE OS LUGARES", "1", "2", "3", "4" }));
		cmbLugar.setBounds(1469, 460, 169, 22);
		cmbLugar.setBackground(new Color(255, 251, 233));
		contentPane.add(cmbLugar);

		cmbGaspar = new JComboBox<>();
		cmbGaspar.setModel(new DefaultComboBoxModel<>(new String[] { "GASPAR", "Alto Gasparinho", "Arraial D’Ouro",
				"Barracão", "Bateias", "Bela Vista", "Belchior Alto", "Belchior Baixo", "Belchior Central", "Centro",
				"Coloninha", "Figueira", "Gaspar Alto", "Gaspar Grande", "Gasparinho", "Gaspar Mirim", "Lagoa",
				"Macucos", "Margem Esquerda", "Poço Grande", "Santa Terezinha", "Sete de Setembro" }));
		cmbGaspar.setBounds(829, 710, 169, 22);
		cmbGaspar.setBackground(new Color(255, 251, 233));
		contentPane.add(cmbGaspar);

		cmbBlumenau = new JComboBox<>();
		cmbBlumenau.setModel(new DefaultComboBoxModel<>(new String[] { "BLUMENAU", "Badenfurt", "Fidélis",
				"Itoupava Central", "Itoupavazinha", "Salto do Norte", "Testo Salto", "Vila Itoupava", "Fortaleza",
				"Fortaleza Alta", "Itoupava Norte", "Nova Esperança", "Ponta Aguda", "Tribess", "Vorstadt", "Da Glória",
				"Garcia", "Progresso", "Ribeirão Fresco", "Valparaíso", "Vila Formosa", "Água Verde", "Do Salto",
				"Escola Agrícola", "Passo Manso", "Salto Weissbach", "Velha", "Velha Central", "Velha Grande",
				"Boa Vista", "Bom Retiro", "Centro", "Itoupava Seca", "Jardim Blumenau", "Victor Konder",
				"Vila Nova" }));
		cmbBlumenau.setBounds(829, 628, 169, 22);
		cmbBlumenau.setBackground(new Color(255, 251, 233));
		contentPane.add(cmbBlumenau);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(1182, 304, 11, 489);
		contentPane.add(separator);

		JLabel lblCarro = new JLabel("");
		lblCarro.setIcon(new ImageIcon(Principal.class.getResource("/assets/car.png")));
		lblCarro.setBounds(81, 304, 184, 151);
		contentPane.add(lblCarro);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Principal.class.getResource("/assets/b1340120-e126-4821-b15c-e3627d2a38a6.png")));
		lblLogo.setBounds(-5, 426, 395, 172);
		contentPane.add(lblLogo);

		JLabel lblFundo = new JLabel("");
		lblFundo.setIcon(new ImageIcon(Principal.class.getResource("/assets/fundoClaro.png")));
		lblFundo.setBounds(-5, -239, 407, 1650);
		contentPane.add(lblFundo);

		JLabel lblFundoFiltro1 = new JLabel("");
		lblFundoFiltro1.setIcon(new ImageIcon(OferecerCarona.class.getResource("/assets/FUndo CLaroP.png")));
		lblFundoFiltro1.setBounds(709, 357, 327, 448);
		contentPane.add(lblFundoFiltro1);

		JLabel lblNewLabel_1 = new JLabel("Para onde você vai hoje?");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 31));
		lblNewLabel_1.setBounds(695, 273, 375, 60);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Quantos lugares disponíveis?");
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.BOLD, 31));
		lblNewLabel_1_1.setBounds(1305, 250, 530, 107);
		contentPane.add(lblNewLabel_1_1);

		JButton btnNewButton = new JButton("   Oferecer");
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 15));
		btnNewButton.setIcon(new ImageIcon(OferecerCarona.class.getResource("/assets/icons8-caronas-50.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (cmbLugar.getSelectedIndex() <= 0) {

					showCampoNaoPreenchido();

				} else if ((rdbtnGaspar.isSelected() || rdbtnIfsc.isSelected() || rdbtnBlumenau.isSelected())
						&& cmbLugar.getSelectedIndex() > 0) {

					Trajeto t = definirTrajeto();
					oferecerCarona(t);
					new ListagemCaronas().setVisible(true);
					OferecerCarona.this.dispose();
				}
			}
		});

		btnNewButton.setBackground(new Color(211, 215, 207));
		btnNewButton.setBounds(1096, 867, 184, 65);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_1_2 = new JLabel("Oferecer Carona");
		lblNewLabel_1_2.setFont(new Font("Dialog", Font.BOLD, 40));
		lblNewLabel_1_2.setBounds(999, 54, 552, 107);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(OferecerCarona.class.getResource("/assets/FUndo CLaroP.png")));
		lblNewLabel_4.setBounds(1344, 333, 327, 472);
		contentPane.add(lblNewLabel_4);

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

	public void oferecerCarona(Trajeto t) {

		Carona c = new Carona();

		String qntLugar;
		qntLugar = (String) cmbLugar.getSelectedItem();

		LocalDate localDate = datePicker.getDate();

		Time localTime = Time.valueOf(timePicker.getTime());

		c.setData(localDate);
		c.setHorario(localTime);
		c.setQntPassageiro(Integer.valueOf(qntLugar));
		c.setMotorista(Sessao.getPessoaLogada());
		c.setVeiculo(Sessao.getPessoaLogada().getVeiculo());
		c.setTrajeto(t);

		Long success = cDAO.cadastrarCarona(c);

		if (success > 0) {
			System.out.println("foi");

		} else {
			System.out.println("não foi");

		}

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

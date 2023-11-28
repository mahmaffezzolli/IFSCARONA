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
	private JComboBox<String> cmbGasparD;
	private JComboBox<String> cmbBlumenauD;
	private JComboBox<String> cmbGasparO;
	private JComboBox<String> cmbBlumenauO;
	private JComboBox<String> cmbLugar;
	private JRadioButton rdbtnGasparD;
	private JRadioButton rdbtnBlumenauD;
	private JRadioButton rdbtnIfscD;
	private JRadioButton rdbtnGasparO;
	private JRadioButton rdbtnBlumenauO;
	private JRadioButton rdbtnIfscO;
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
		datePicker.getComponentDateTextField().setFont(new Font("Dialog", Font.PLAIN, 12));
		datePicker.setBounds(1400, 600, 220, 30);
		contentPane.add(datePicker);

		timePicker = new TimePicker();
		timePicker.getComponentTimeTextField().setFont(new Font("Dialog", Font.PLAIN, 12));
		timePicker.setBounds(1400, 700, 220, 30);
		contentPane.add(timePicker);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(Color.BLACK);
		separator_1_1.setBounds(1364, 571, 295, 12);
		contentPane.add(separator_1_1);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 0, 0));
		separator_1.setBounds(443, 575, 295, 12);
		contentPane.add(separator_1);

		// Destino

		rdbtnIfscD = new JRadioButton("IFSC");
		rdbtnIfscD.setFont(new Font("Dialog", Font.PLAIN, 12));
		rdbtnIfscD.setBounds(563, 488, 129, 23);
		contentPane.add(rdbtnIfscD);

		rdbtnGasparD = new JRadioButton("Gaspar");
		rdbtnGasparD.setFont(new Font("Dialog", Font.PLAIN, 12));
		rdbtnGasparD.setBounds(563, 446, 129, 23);
		contentPane.add(rdbtnGasparD);

		rdbtnBlumenauD = new JRadioButton("Blumenau");
		rdbtnBlumenauD.setFont(new Font("Dialog", Font.PLAIN, 12));
		rdbtnBlumenauD.setBounds(563, 400, 129, 23);
		contentPane.add(rdbtnBlumenauD);

		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(rdbtnGasparD);
		radioGroup.add(rdbtnBlumenauD);
		radioGroup.add(rdbtnIfscD);

		rdbtnGasparD.addItemListener(e -> {
			cmbBlumenauD.setEnabled(!rdbtnGasparD.isSelected());
			cmbGasparD.setEnabled(rdbtnGasparD.isSelected());
		});

		rdbtnBlumenauD.addItemListener(e -> {
			cmbGasparD.setEnabled(!rdbtnBlumenauD.isSelected());
			cmbBlumenauD.setEnabled(rdbtnBlumenauD.isSelected());
		});
		rdbtnIfscD.addItemListener(e -> {
			cmbGasparD.setEnabled(false);
			cmbBlumenauD.setEnabled(false);
		});

		cmbGasparD = new JComboBox<String>();
		cmbGasparD.setFont(new Font("Dialog", Font.PLAIN, 12));
		cmbGasparD
				.setModel(new DefaultComboBoxModel<String>(new String[] { "GASPAR", "Alto Gasparinho", "Arraial D’Ouro",
						"Barracão", "Bateias", "Bela Vista", "Belchior Alto", "Belchior Baixo", "Belchior Central",
						"Centro", "Coloninha", "Figueira", "Gaspar Alto", "Gaspar Grande", "Gasparinho", "Gaspar Mirim",
						"Lagoa", "Macucos", "Margem Esquerda", "Poço Grande", "Santa Terezinha", "Sete de Setembro" }));
		cmbGasparD.setBounds(547, 714, 169, 22);
		cmbGasparD.setBackground(new Color(255, 251, 233));
		contentPane.add(cmbGasparD);

		cmbBlumenauD = new JComboBox<String>();
		cmbBlumenauD.setFont(new Font("Dialog", Font.PLAIN, 12));
		cmbBlumenauD.setModel(new DefaultComboBoxModel<String>(new String[] { "BLUMENAU", "Badenfurt", "Fidélis",
				"Itoupava Central", "Itoupavazinha", "Salto do Norte", "Testo Salto", "Vila Itoupava", "Fortaleza",
				"Fortaleza Alta", "Itoupava Norte", "Nova Esperança", "Ponta Aguda", "Tribess", "Vorstadt", "Da Glória",
				"Garcia", "Progresso", "Ribeirão Fresco", "Valparaíso", "Vila Formosa", "Água Verde", "Do Salto",
				"Escola Agrícola", "Passo Manso", "Salto Weissbach", "Velha", "Velha Central", "Velha Grande",
				"Boa Vista", "Bom Retiro", "Centro", "Itoupava Seca", "Jardim Blumenau", "Victor Konder",
				"Vila Nova" }));
		cmbBlumenauD.setBounds(547, 632, 169, 22);
		cmbBlumenauD.setBackground(new Color(255, 251, 233));
		contentPane.add(cmbBlumenauD);

		// Origem

		cmbGasparO = new JComboBox<String>();
		cmbGasparO.setFont(new Font("Dialog", Font.PLAIN, 12));
		cmbGasparO
				.setModel(new DefaultComboBoxModel<String>(new String[] { "GASPAR", "Alto Gasparinho", "Arraial D’Ouro",
						"Barracão", "Bateias", "Bela Vista", "Belchior Alto", "Belchior Baixo", "Belchior Central",
						"Centro", "Coloninha", "Figueira", "Gaspar Alto", "Gaspar Grande", "Gasparinho", "Gaspar Mirim",
						"Lagoa", "Macucos", "Margem Esquerda", "Poço Grande", "Santa Terezinha", "Sete de Setembro" }));
		cmbGasparO.setBackground(new Color(255, 251, 233));
		cmbGasparO.setBounds(912, 714, 169, 22);
		contentPane.add(cmbGasparO);

		cmbBlumenauO = new JComboBox<String>();
		cmbBlumenauO.setFont(new Font("Dialog", Font.PLAIN, 12));
		cmbBlumenauO.setModel(new DefaultComboBoxModel<String>(new String[] { "BLUMENAU", "Badenfurt", "Fidélis",
				"Itoupava Central", "Itoupavazinha", "Salto do Norte", "Testo Salto", "Vila Itoupava", "Fortaleza",
				"Fortaleza Alta", "Itoupava Norte", "Nova Esperança", "Ponta Aguda", "Tribess", "Vorstadt", "Da Glória",
				"Garcia", "Progresso", "Ribeirão Fresco", "Valparaíso", "Vila Formosa", "Água Verde", "Do Salto",
				"Escola Agrícola", "Passo Manso", "Salto Weissbach", "Velha", "Velha Central", "Velha Grande",
				"Boa Vista", "Bom Retiro", "Centro", "Itoupava Seca", "Jardim Blumenau", "Victor Konder",
				"Vila Nova" }));
		cmbBlumenauO.setBackground(new Color(255, 251, 233));
		cmbBlumenauO.setBounds(912, 632, 169, 22);
		contentPane.add(cmbBlumenauO);

		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(Color.BLACK);
		separator_1_2.setBounds(808, 575, 295, 12);
		contentPane.add(separator_1_2);

		rdbtnIfscO = new JRadioButton("IFSC");
		rdbtnIfscO.setFont(new Font("Dialog", Font.PLAIN, 12));
		rdbtnIfscO.setBounds(928, 488, 129, 23);
		contentPane.add(rdbtnIfscO);

		rdbtnGasparO = new JRadioButton("Gaspar");
		rdbtnGasparO.setFont(new Font("Dialog", Font.PLAIN, 12));
		rdbtnGasparO.setBounds(928, 446, 129, 23);
		contentPane.add(rdbtnGasparO);

		rdbtnBlumenauO = new JRadioButton("Blumenau");
		rdbtnBlumenauO.setFont(new Font("Dialog", Font.PLAIN, 12));
		rdbtnBlumenauO.setBounds(928, 400, 129, 23);
		contentPane.add(rdbtnBlumenauO);

		ButtonGroup radioGroup2 = new ButtonGroup();
		radioGroup2.add(rdbtnGasparO);
		radioGroup2.add(rdbtnBlumenauO);
		radioGroup2.add(rdbtnIfscO);

		rdbtnGasparO.addItemListener(e -> {
			cmbBlumenauO.setEnabled(!rdbtnGasparO.isSelected());
			cmbGasparO.setEnabled(rdbtnGasparO.isSelected());
		});

		rdbtnBlumenauO.addItemListener(e -> {
			cmbGasparO.setEnabled(!rdbtnBlumenauO.isSelected());
			cmbBlumenauO.setEnabled(rdbtnBlumenauO.isSelected());
		});
		rdbtnIfscO.addItemListener(e -> {
			cmbGasparO.setEnabled(false);
			cmbBlumenauO.setEnabled(false);
		});

		//

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(OferecerCarona.class.getResource("/assets/icons8-localização-50.png")));
		lblNewLabel_3.setBounds(462, 425, 50, 50);
		contentPane.add(lblNewLabel_3);

		btnHome.setBorder(null);
		btnHome.setForeground(new Color(0, 0, 0));
		btnHome.setBackground(new Color(244, 234, 214));
		btnHome.setIcon(new ImageIcon(Perfil.class.getResource("/assets/home.png")));
		btnHome.setBounds(149, 790, 75, 65);
		contentPane.add(btnHome);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(OferecerCarona.class.getResource("/assets/icons8-localização-50.png")));
		lblNewLabel_2.setBounds(462, 643, 50, 50);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(OferecerCarona.class.getResource("/assets/MODELO.png")));
		lblNewLabel.setBounds(1379, 442, 67, 65);
		contentPane.add(lblNewLabel);

		cmbLugar = new JComboBox<String>();
		cmbLugar.setFont(new Font("Dialog", Font.PLAIN, 12));
		cmbLugar.setModel(
				new DefaultComboBoxModel<String>(new String[] { "SELECIONE OS LUGARES", "1", "2", "3", "4" }));
		cmbLugar.setBounds(1469, 460, 184, 22);
		cmbLugar.setBackground(new Color(255, 251, 233));
		contentPane.add(cmbLugar);

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
		lblFundoFiltro1.setBounds(427, 361, 327, 448);
		contentPane.add(lblFundoFiltro1);

		JLabel lblNewLabel_1 = new JLabel("Destino");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 31));
		lblNewLabel_1.setBounds(547, 273, 121, 60);
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

				} else if ((rdbtnGasparD.isSelected() || rdbtnIfscD.isSelected() || rdbtnBlumenauD.isSelected())
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

		JLabel lblNewLabel_1_3 = new JLabel("Origem");
		lblNewLabel_1_3.setFont(new Font("Dialog", Font.BOLD, 31));
		lblNewLabel_1_3.setBounds(936, 273, 121, 60);
		contentPane.add(lblNewLabel_1_3);

	}

	public Trajeto definirTrajeto() {
		Trajeto t = new Trajeto();

		// Destino
		if (rdbtnGasparD.isSelected()) {
			String bairro = (String) cmbGasparD.getSelectedItem();

			if (bairroSelecionado(bairro, cmbGasparD)) {
				t.setDestino("Gaspar, " + bairro);

			} else {
				showCampoNaoPreenchido();
				return null;
			}

		} else if (rdbtnBlumenauD.isSelected()) {
			String bairro = (String) cmbBlumenauD.getSelectedItem();

			if (bairroSelecionado(bairro, cmbBlumenauD)) {
				t.setDestino("Blumenau, " + bairro);

			} else {
				showCampoNaoPreenchido();
				return null;
			}

		} else if (rdbtnIfscD.isSelected()) {
			t.setDestino("IFSC");

		} else {
			showCampoNaoPreenchido();
			return null;
		}

		// Origem
		if (rdbtnGasparO.isSelected()) {
			String bairro = (String) cmbGasparO.getSelectedItem();

			if (bairroSelecionado(bairro, cmbGasparO)) {
				t.setOrigem("Gaspar, " + bairro);

			} else {
				showCampoNaoPreenchido();
				return null;
			}

		} else if (rdbtnBlumenauO.isSelected()) {
			String bairro = (String) cmbBlumenauO.getSelectedItem();

			if (bairroSelecionado(bairro, cmbBlumenauO)) {
				t.setOrigem("Blumenau, " + bairro);

			} else {
				showCampoNaoPreenchido();
				return null;
			}

		} else if (rdbtnIfscO.isSelected()) {
			t.setOrigem("IFSC");

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
			
			CadastroRealizado CadastroRealizado = new CadastroRealizado();
			CadastroRealizado.setBounds(40, 40, 451, 234);
			CadastroRealizado.setLocationRelativeTo(null);
			CadastroRealizado.setVisible(true);

		} else {
			CadastroErro CadastroErro = new CadastroErro();
			CadastroErro.setBounds(40, 40, 451, 234);
			CadastroErro.setLocationRelativeTo(null);
			CadastroErro.setVisible(true);

		}

	}

	private boolean bairroSelecionado(String bairro, JComboBox<String> comboBox) {
		return comboBox.getSelectedIndex() > 0 && bairro != null && !bairro.isEmpty();
	}

	private void showCampoNaoPreenchido() {
		CampoNaoPreenchido campoNaoPreenchido = new CampoNaoPreenchido();
		campoNaoPreenchido.setBounds(40, 40, 451, 234);
		campoNaoPreenchido.setLocationRelativeTo(null);
		campoNaoPreenchido.setVisible(true);
	}
	

	private Locale determineLocale(String language, String country) {
		return new Locale(language, country);
	}
}

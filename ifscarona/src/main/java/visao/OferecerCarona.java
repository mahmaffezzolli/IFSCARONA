package visao;

import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

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

import org.jdatepicker.JDatePicker;
import controle.CaronaDAO;
import controle.TrajetoDAO;
import modelo.Carona;
import modelo.Sessao;
import modelo.Trajeto;

public class OferecerCarona extends JFrame {

	private JPanel contentPane;
	private JComboBox<String> cmbGaspar;
	private JComboBox<String> cmbBlumenau;
	private JComboBox<String> cmbLugar;
	private JRadioButton rdbtnGaspar;
	private JRadioButton rdbtnBlumenau;
	private JRadioButton rdbtnIfsc;

	private CaronaDAO cDAO = CaronaDAO.getInstancia();
	private TrajetoDAO tDAO = TrajetoDAO.getInstancia();
	private JDatePicker datePicker;

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

//    	 UtilDateModel dateModel = new UtilDateModel();
//
//         // Crie o JDatePicker com o modelo de data
//         JDatePickerImpl datePickerImpl = new JDatePickerImpl(dateModel);
//
//         // Defina a posição e tamanho do JDatePicker
//         datePickerImpl.setBounds(1100, 500, 150, 30);
//
//         // Obtenha o componente JDatePicker a partir do JDatePickerImpl
//         datePicker = datePickerImpl.getJDatePicker();
//
//         // Adicione o JDatePicker ao painel de conteúdo
//         contentPane.add(datePickerImpl);

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

		rdbtnIfsc = new JRadioButton("IFSC");
		rdbtnIfsc.setBounds(845, 469, 129, 23);
		contentPane.add(rdbtnIfsc);

		rdbtnGaspar = new JRadioButton("Gaspar");
		rdbtnGaspar.setBounds(845, 432, 129, 23);
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
		lblNewLabel_3.setBounds(744, 410, 87, 58);
		contentPane.add(lblNewLabel_3);

		btnHome.setBorder(null);
		btnHome.setForeground(new Color(0, 0, 0));
		btnHome.setBackground(new Color(244, 234, 214));
		btnHome.setIcon(new ImageIcon(Perfil.class.getResource("/assets/home.png")));
		btnHome.setBounds(149, 790, 75, 65);
		contentPane.add(btnHome);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(OferecerCarona.class.getResource("/assets/icons8-localização-50.png")));
		lblNewLabel_2.setBounds(744, 556, 87, 71);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(OferecerCarona.class.getResource("/assets/MODELO.png")));
		lblNewLabel.setBounds(1357, 414, 67, 65);
		contentPane.add(lblNewLabel);

		cmbLugar = new JComboBox();
		cmbLugar.setModel(new DefaultComboBoxModel(new String[] { "SELECIONE OS LUGARES", "1", "2", "3", "4" }));
		cmbLugar.setBounds(1435, 432, 169, 22);
		cmbLugar.setBackground(new Color(255, 251, 233));
		contentPane.add(cmbLugar);

		cmbGaspar = new JComboBox<>();
		cmbGaspar.setModel(new DefaultComboBoxModel<>(new String[] { "GASPAR", "Alto Gasparinho", "Arraial D’Ouro",
				"Barracão", "Bateias", "Bela Vista", "Belchior Alto", "Belchior Baixo", "Belchior Central", "Centro",
				"Coloninha", "Figueira", "Gaspar Alto", "Gaspar Grande", "Gasparinho", "Gaspar Mirim", "Lagoa",
				"Macucos", "Margem Esquerda", "Poço Grande", "Santa Terezinha", "Sete de Setembro" }));
		cmbGaspar.setBounds(829, 605, 169, 22);
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
		cmbBlumenau.setBounds(829, 546, 169, 22);
		cmbBlumenau.setBackground(new Color(255, 251, 233));
		contentPane.add(cmbBlumenau);

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
		lblFundoLugar.setIcon(new ImageIcon(Principal.class.getResource("/assets/tela inicio fundo botoes.png")));
		lblFundoLugar.setBounds(1313, 374, 320, 133);
		contentPane.add(lblFundoLugar);

		JLabel lblFundo = new JLabel("");
		lblFundo.setIcon(new ImageIcon(Principal.class.getResource("/assets/fundoClaro.png")));
		lblFundo.setBounds(-5, -239, 468, 1650);
		contentPane.add(lblFundo);

		JLabel lblFundoFiltro = new JLabel("");
		lblFundoFiltro.setIcon(new ImageIcon(Principal.class.getResource("/assets/tela inicio fundo botoes.png")));
		lblFundoFiltro.setBounds(723, 360, 320, 151);
		contentPane.add(lblFundoFiltro);

		JLabel lblFundoFiltro1 = new JLabel("");
		lblFundoFiltro1.setIcon(new ImageIcon(Principal.class.getResource("/assets/tela inicio fundo botoes.png")));
		lblFundoFiltro1.setBounds(723, 518, 320, 151);
		contentPane.add(lblFundoFiltro1);

		JLabel lblNewLabel_1 = new JLabel("Para onde você vai hoje?");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 31));
		lblNewLabel_1.setBounds(676, 278, 530, 107);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Quantos lugares disponíveis?");
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.BOLD, 31));
		lblNewLabel_1_1.setBounds(1249, 278, 530, 107);
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

		btnNewButton.setBackground(new Color(251, 251, 233));
		btnNewButton.setBounds(1090, 820, 184, 65);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_1_2 = new JLabel("Oferecer Carona");
		lblNewLabel_1_2.setFont(new Font("Dialog", Font.BOLD, 40));
		lblNewLabel_1_2.setBounds(965, 59, 552, 107);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon(OferecerCarona.class.getResource("/assets/tela inicio fundo botoes.png")));
		lblNewLabel_4.setBounds(1313, 519, 320, 133);
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

		c.setData(null);
		c.setHorario(null);
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
}

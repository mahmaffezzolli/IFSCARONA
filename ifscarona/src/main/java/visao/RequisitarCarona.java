package visao;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controle.TrajetoDAO;
import modelo.Trajeto;

import javax.swing.JComboBox;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class RequisitarCarona extends JFrame {

	protected static final AbstractButton comboBox2 = null;
	protected static final AbstractButton comboBox1 = null;
	private JPanel contentPane;
	private JComboBox<String> cmbGaspar;
	private JComboBox<String> cmbBlumenau;
	private JRadioButton rdbtnIfsc;
	private JRadioButton rdbtnGaspar;
	private JRadioButton rdbtnBlumenau;
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
		

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(Color.BLACK);
		separator_1_1.setBounds(1425, 511, 283, 23);
		contentPane.add(separator_1_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 0, 0));
		separator_1.setBounds(776, 511, 283, 23);
		contentPane.add(separator_1);

		JRadioButton rdbtnIfsc = new JRadioButton("IFSC");
		rdbtnIfsc.setBounds(837, 453, 129, 23);
		contentPane.add(rdbtnIfsc);
		
		JRadioButton rdbtnGaspar = new JRadioButton("Gaspar");
		rdbtnGaspar.setBounds(837, 414, 129, 23);
		contentPane.add(rdbtnGaspar);
		
		JRadioButton rdbtnBlumenau = new JRadioButton("Blumenau");
		rdbtnBlumenau.setBounds(837, 377, 129, 23);
		contentPane.add(rdbtnBlumenau);


	        

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(RequisitarCarona.class.getResource("/assets/icons8-localização-50.png")));
		lblNewLabel_3.setBounds(776, 378, 87, 58);
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
		lblNewLabel_2.setBounds(776, 565, 87, 71);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(RequisitarCarona.class.getResource("/assets/MODELO.png")));
		lblNewLabel.setBounds(1437, 339, 67, 65);
		contentPane.add(lblNewLabel);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "SELECIONE OS LUGARES", "1", "2", "3", "4" }));
		comboBox_2.setBounds(1528, 361, 169, 22);
		comboBox_2.setBackground(new Color(255, 251, 233));
		contentPane.add(comboBox_2);

		cmbGaspar = new JComboBox<>();
		cmbGaspar.setModel(new DefaultComboBoxModel<>(new String[] { "GASPAR", "Alto Gasparinho", "Arraial D’Ouro",
				"Barracão", "Bateias", "Bela Vista", "Belchior Alto", "Belchior Baixo", "Belchior Central", "Centro",
				"Coloninha", "Figueira", "Gaspar Alto", "Gaspar Grande", "Gasparinho", "Gaspar Mirim", "Lagoa",
				"Macucos", "Margem Esquerda", "Poço Grande", "Santa Terezinha", "Sete de Setembro" }));
		cmbGaspar.setBounds(849, 631, 169, 22);
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
		cmbBlumenau.setBounds(849, 565, 169, 22);
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
		btnNewButton.setIcon(new ImageIcon(RequisitarCarona.class.getResource("/assets/icons8-viajar-de-carona-50.png")));
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
		btnNewButton.setBounds(1081, 809, 189, 54);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_1_2 = new JLabel("Requisitar Carona");
		lblNewLabel_1_2.setFont(new Font("Dialog", Font.BOLD, 40));
		lblNewLabel_1_2.setBounds(965, 59, 552, 107);
		contentPane.add(lblNewLabel_1_2);
	}

	public void definirTrajeto() {

		Trajeto t = new Trajeto();
		String bairro;

		t.setOrigem("IFSC");

		if (rdbtnGaspar.isSelected()) {

			bairro = (String) cmbGaspar.getSelectedItem();
			t.setDestino("Gaspar, " + bairro);

		} else if (rdbtnBlumenau.isSelected()) {

			bairro = (String) cmbBlumenau.getSelectedItem();
			t.setDestino("Blumenau, " + bairro);
		}

		Long success = tDAO.cadastrarTrajeto(t);

	}
}

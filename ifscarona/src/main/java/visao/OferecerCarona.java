package visao;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
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
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;

public class OferecerCarona extends JFrame {
	
	    private JPanel contentPane;
	    private JComboBox<String> comboBox1;
	    private JComboBox<String> comboBox2;
	    private JCheckBox chckbxGaspar;
	    private JCheckBox chckbxBlumenau;


	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public OferecerCarona() {
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
		
		 chckbxGaspar = new JCheckBox("Gaspar");
	        chckbxGaspar.setBounds(845, 432, 129, 23);
	        contentPane.add(chckbxGaspar);

	        chckbxBlumenau = new JCheckBox("Blumenau");
	        chckbxBlumenau.setBounds(845, 387, 129, 23);
	        contentPane.add(chckbxBlumenau);
		
	        chckbxGaspar.addItemListener(new ItemListener() {
	            @Override
	            public void itemStateChanged(ItemEvent e) {
	                comboBox2.setEnabled(!chckbxGaspar.isSelected());
	                comboBox1.setEnabled(chckbxGaspar.isSelected());
	            }
	        });

	        chckbxBlumenau.addItemListener(new ItemListener() {
	            @Override
	            public void itemStateChanged(ItemEvent e) {
	                comboBox1.setEnabled(!chckbxBlumenau.isSelected());
	                comboBox2.setEnabled(chckbxBlumenau.isSelected());
	            }
	        });
	        
	        

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(OferecerCarona.class.getResource("/assets/icons8-localização-50.png")));
		lblNewLabel_3.setBounds(744, 397, 87, 58);
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
		lblNewLabel.setBounds(1358, 443, 67, 65);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"SELECIONE OS LUGARES", "1", "2", "3", "4"}));
		comboBox_2.setBounds(1443, 461, 169, 22);
		comboBox_2.setBackground(new Color(255, 251, 233));
		contentPane.add(comboBox_2);
		
		 comboBox1 = new JComboBox<>();
	        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "GASPAR", "Alto Gasparinho", "Arraial D’Ouro",
	                "Barracão", "Bateias", "Bela Vista", "Belchior Alto", "Belchior Baixo", "Belchior Central", "Centro",
	                "Coloninha", "Figueira", "Gaspar Alto", "Gaspar Grande", "Gasparinho", "Gaspar Mirim", "Lagoa",
	                "Macucos", "Margem Esquerda", "Poço Grande", "Santa Terezinha", "Sete de Setembro" }));
	        comboBox1.setBounds(829, 605, 169, 22);
	        comboBox1.setBackground(new Color(255, 251, 233));
	        contentPane.add(comboBox1);

	        comboBox2 = new JComboBox<>();
	        comboBox2.setModel(new DefaultComboBoxModel<>(new String[] { "BLUMENAU", "Badenfurt", "Fidélis",
	                "Itoupava Central", "Itoupavazinha", "Salto do Norte", "Testo Salto", "Vila Itoupava", "Fortaleza",
	                "Fortaleza Alta", "Itoupava Norte", "Nova Esperança", "Ponta Aguda", "Tribess", "Vorstadt", "Da Glória",
	                "Garcia", "Progresso", "Ribeirão Fresco", "Valparaíso", "Vila Formosa", "Água Verde", "Do Salto",
	                "Escola Agrícola", "Passo Manso", "Salto Weissbach", "Velha", "Velha Central", "Velha Grande",
	                "Boa Vista", "Bom Retiro", "Centro", "Itoupava Seca", "Jardim Blumenau", "Victor Konder",
	                "Vila Nova" }));
	        comboBox2.setBounds(829, 546, 169, 22);
	        comboBox2.setBackground(new Color(255, 251, 233));
	        contentPane.add(comboBox2);
	        
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
		lblFundoLugar.setBounds(1344, 411, 320, 133);
		contentPane.add(lblFundoLugar);
		
		JLabel lblFundo = new JLabel("");
		lblFundo.setIcon(new ImageIcon(Principal.class.getResource("/assets/fundoClaro.png")));
		lblFundo.setBounds(-5, -239, 468, 1650);
		contentPane.add(lblFundo);
		
		JLabel lblFundoFiltro = new JLabel("");
		lblFundoFiltro.setIcon(new ImageIcon(Principal.class.getResource("/assets/tela inicio fundo botoes.png")));
		lblFundoFiltro.setBounds(723, 360, 320, 133);
		contentPane.add(lblFundoFiltro);
		

		JLabel lblFundoFiltro1 = new JLabel("");
		lblFundoFiltro1.setIcon(new ImageIcon(Principal.class.getResource("/assets/tela inicio fundo botoes.png")));
		lblFundoFiltro1.setBounds(723, 518, 320, 133);
		contentPane.add(lblFundoFiltro1);
		
		JLabel lblNewLabel_1 = new JLabel("Para onde você vai hoje?");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 31));
		lblNewLabel_1.setBounds(676, 278, 530, 107);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Quantos lugares disponíveis?");
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.BOLD, 31));
		lblNewLabel_1_1.setBounds(1274, 293, 530, 107);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("Oferecer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (chckbxGaspar.isSelected() || chckbxBlumenau.isSelected()) {
					new ListagemCaronas().setVisible(true);
					 OferecerCarona.this.dispose();
		        } else {
		        	CampoNaoPreenchido campoNaoPreenchido = new CampoNaoPreenchido();
					campoNaoPreenchido.setVisible(true);
		        }
			}
		});
		btnNewButton.setBackground(new Color(251, 251, 233));
		btnNewButton.setBounds(1090, 801, 169, 54);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1_2 = new JLabel("Oferecer Carona");
		lblNewLabel_1_2.setFont(new Font("Dialog", Font.BOLD, 40));
		lblNewLabel_1_2.setBounds(965, 59, 552, 107);
		contentPane.add(lblNewLabel_1_2);
		

		


	}
}

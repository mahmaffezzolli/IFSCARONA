package visao;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class RequisitarCarona extends JFrame {

	private JPanel contentPane;

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

		btnHome.setBorder(null);
		btnHome.setForeground(new Color(0, 0, 0));
		btnHome.setBackground(new Color(244, 234, 214));
		btnHome.setIcon(new ImageIcon(Perfil.class.getResource("/assets/home.png")));
		btnHome.setBounds(149, 790, 75, 65);
		contentPane.add(btnHome);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(RequisitarCarona.class.getResource("/assets/icons8-localização-50.png")));
		lblNewLabel_2.setBounds(749, 437, 87, 71);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(RequisitarCarona.class.getResource("/assets/MODELO.png")));
		lblNewLabel.setBounds(1358, 443, 67, 65);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"SELECIONE OS LUGARES", "1", "2", "3", "4"}));
		comboBox_2.setBounds(1443, 461, 169, 22);
		comboBox_2.setBackground(new Color(255, 251, 233));
		contentPane.add(comboBox_2);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"GASPAR", "Alto Gasparinho", "Arraial D’Ouro", "Barracão", "Bateias", "Bela Vista", "Belchior Alto", "Belchior Baixo", "Belchior Central", "Centro", "Coloninha", "Figueira", "Gaspar Alto", "Gaspar Grande", "Gasparinho", "Gaspar Mirim", "Lagoa", "Macucos", "Margem Esquerda", "Poço Grande", "Santa Terezinha", "Sete de Setembro"}));
		comboBox_1.setBounds(829, 486, 169, 22);
		comboBox_1.setBackground(new Color(255, 251, 233));

		contentPane.add(comboBox_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"BLUMENAU", "Badenfurt", "Fidélis", "Itoupava Central", "Itoupavazinha", "Salto do Norte", "Testo Salto", "Vila Itoupava", "Fortaleza", "Fortaleza Alta", "Itoupava Norte", "Nova Esperança", "Ponta Aguda", "Tribess", "Vorstadt", "Da Glória", "Garcia", "Progresso", "Ribeirão Fresco", "Valparaíso", "Vila Formosa", "Água Verde", "Do Salto", "Escola Agrícola", "Passo Manso", "Salto Weissbach", "Velha", "Velha Central", "Velha Grande", "Boa Vista", "Bom Retiro", "Centro", "Itoupava Seca", "Jardim Blumenau", "Victor Konder", "Vila Nova"}));
		comboBox.setBounds(829, 433, 169, 22);
		comboBox.setBackground(new Color(255, 251, 233));
		contentPane.add(comboBox);
		
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
		lblFundoFiltro.setBounds(721, 411, 320, 133);
		contentPane.add(lblFundoFiltro);
		

		
		JLabel lblNewLabel_1 = new JLabel("Para onde você vai hoje?");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 31));
		lblNewLabel_1.setBounds(690, 293, 385, 107);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Quantos lugares necessários?");
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.BOLD, 31));
		lblNewLabel_1_1.setBounds(1274, 293, 530, 107);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("Requisiar");
		btnNewButton.setBackground(new Color(251, 251, 233));
		btnNewButton.setBounds(1090, 801, 169, 54);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1_2 = new JLabel("Requisitar Carona");
		lblNewLabel_1_2.setFont(new Font("Dialog", Font.BOLD, 40));
		lblNewLabel_1_2.setBounds(990, 64, 385, 107);
		contentPane.add(lblNewLabel_1_2);
		

		


	}
}

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

public class OferecerCarona extends JFrame {

	private JPanel contentPane;

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

		btnHome.setBorder(null);
		btnHome.setForeground(new Color(0, 0, 0));
		btnHome.setBackground(new Color(244, 234, 214));
		btnHome.setIcon(new ImageIcon(Perfil.class.getResource("/assets/home.png")));
		btnHome.setBounds(149, 790, 75, 65);
		contentPane.add(btnHome);
		
		JLabel lblIconeOnde = new JLabel("");
		lblIconeOnde.setIcon(new ImageIcon(RequisitarCarona.class.getResource("/assets/icons8-localização-50.png")));
		lblIconeOnde.setBounds(749, 437, 87, 71);
		contentPane.add(lblIconeOnde);
		
		JLabel lblIconeLugar = new JLabel("");
		lblIconeLugar.setIcon(new ImageIcon(RequisitarCarona.class.getResource("/assets/MODELO.png")));
		lblIconeLugar.setBounds(1358, 443, 67, 65);
		contentPane.add(lblIconeLugar);
		
		JComboBox BoxLugares = new JComboBox();
		BoxLugares.setModel(new DefaultComboBoxModel(new String[] {"SELECIONE OS LUGARES", "1", "2", "3", "4"}));
		BoxLugares.setBounds(1443, 461, 169, 22);
		BoxLugares.setBackground(new Color(255, 251, 233));
		contentPane.add(BoxLugares);
		
		JComboBox BoxGaspar = new JComboBox();
		BoxGaspar.setModel(new DefaultComboBoxModel(new String[] {"GASPAR", "Alto Gasparinho", "Arraial D’Ouro", "Barracão", "Bateias", "Bela Vista", "Belchior Alto", "Belchior Baixo", "Belchior Central", "Centro", "Coloninha", "Figueira", "Gaspar Alto", "Gaspar Grande", "Gasparinho", "Gaspar Mirim", "Lagoa", "Macucos", "Margem Esquerda", "Poço Grande", "Santa Terezinha", "Sete de Setembro"}));
		BoxGaspar.setBounds(829, 486, 169, 22);
		BoxGaspar.setBackground(new Color(255, 251, 233));

		contentPane.add(BoxGaspar);
		
		JComboBox BoxBlumenau = new JComboBox();
		BoxBlumenau.setModel(new DefaultComboBoxModel(new String[] {"BLUMENAU", "Badenfurt", "Fidélis", "Itoupava Central", "Itoupavazinha", "Salto do Norte", "Testo Salto", "Vila Itoupava", "Fortaleza", "Fortaleza Alta", "Itoupava Norte", "Nova Esperança", "Ponta Aguda", "Tribess", "Vorstadt", "Da Glória", "Garcia", "Progresso", "Ribeirão Fresco", "Valparaíso", "Vila Formosa", "Água Verde", "Do Salto", "Escola Agrícola", "Passo Manso", "Salto Weissbach", "Velha", "Velha Central", "Velha Grande", "Boa Vista", "Bom Retiro", "Centro", "Itoupava Seca", "Jardim Blumenau", "Victor Konder", "Vila Nova"}));
		BoxBlumenau.setBounds(829, 433, 169, 22);
		BoxBlumenau.setBackground(new Color(255, 251, 233));
		contentPane.add(BoxBlumenau);
		
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
		
		JLabel lblFundoOnde = new JLabel("");
		lblFundoOnde.setIcon(new ImageIcon(Principal.class.getResource("/assets/tela inicio fundo botoes.png")));
		lblFundoOnde.setBounds(721, 411, 320, 133);
		contentPane.add(lblFundoOnde);
		

		
		JLabel lblParaOnde = new JLabel("Para onde você vai hoje?");
		lblParaOnde.setFont(new Font("Dialog", Font.BOLD, 31));
		lblParaOnde.setBounds(690, 293, 385, 107);
		contentPane.add(lblParaOnde);
		
		JLabel lblLugaresDisponiveis = new JLabel("Quantos lugares disponíveis?");
		lblLugaresDisponiveis.setFont(new Font("Dialog", Font.BOLD, 31));
		lblLugaresDisponiveis.setBounds(1274, 293, 530, 107);
		contentPane.add(lblLugaresDisponiveis);
		
		JButton btnOferecer = new JButton("Oferecer");
		btnOferecer.setBackground(new Color(251, 251, 233));
		btnOferecer.setBounds(1090, 801, 169, 54);
		contentPane.add(btnOferecer);
		
		JLabel lblOferecerCarona = new JLabel("Oferecer Carona");
		lblOferecerCarona.setFont(new Font("Dialog", Font.BOLD, 40));
		lblOferecerCarona.setBounds(990, 64, 385, 107);
		contentPane.add(lblOferecerCarona);
		

		


	}
}



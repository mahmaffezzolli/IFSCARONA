package visao;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;

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
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, screen.width, screen.height - 30);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(154, 203, 159));
		contentPane.setBorder(new LineBorder(new Color(255, 251, 233), 2, true));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(1122, 241, 11, 534);
		contentPane.add(separator);

		JButton btnLogar = new JButton("Requisitar");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogar.setBorder(new LineBorder(new Color(249, 239, 197), 4, true));
		btnLogar.setBackground(new Color(255, 251, 233));
		btnLogar.setBounds(695, 615, 162, 33);
		contentPane.add(btnLogar);

		JRadioButton rdbtnHoraPrimeira = new JRadioButton("06:00 - 12:00");
		rdbtnHoraPrimeira.setBackground(new Color(240, 240, 240));
		rdbtnHoraPrimeira.setBounds(705, 338, 139, 43);
		contentPane.add(rdbtnHoraPrimeira);

		JRadioButton rdbtnHoraTerceira = new JRadioButton("18h em diante");
		rdbtnHoraTerceira.setBounds(705, 520, 139, 43);
		contentPane.add(rdbtnHoraTerceira);

		JRadioButton rdbtnHoraSegunda = new JRadioButton("12:01 - 18:00");
		rdbtnHoraSegunda.setBounds(705, 424, 139, 43);
		contentPane.add(rdbtnHoraSegunda);

		JLabel lblFundoFiltro = new JLabel("");
		lblFundoFiltro.setIcon(new ImageIcon(Principal.class.getResource("/assets/tela inicio fundo botoes.png")));
		lblFundoFiltro.setBounds(616, 291, 320, 420);
		contentPane.add(lblFundoFiltro);

		JLabel lblCarro = new JLabel("");
		lblCarro.setIcon(new ImageIcon(Principal.class.getResource("/assets/car.png")));
		lblCarro.setBounds(81, 304, 385, 151);
		contentPane.add(lblCarro);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Principal.class.getResource("/assets/b1340120-e126-4821-b15c-e3627d2a38a6.png")));
		lblLogo.setBounds(-5, 426, 590, 172);
		contentPane.add(lblLogo);

		JLabel lblFundo = new JLabel("");
		lblFundo.setIcon(new ImageIcon(Principal.class.getResource("/assets/fundoClaro.png")));
		lblFundo.setBounds(-5, -239, 468, 1650);
		contentPane.add(lblFundo);

		JLabel lblNewLabel_1 = new JLabel("Filtrar viagens");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 40));
		lblNewLabel_1.setBounds(621, 180, 385, 107);
		contentPane.add(lblNewLabel_1);

		JButton btnPerfil = new JButton("Perfil ");
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new Perfil().setVisible(true);
				Principal.this.dispose();
			}

		});
		btnPerfil.setBackground(new Color(244, 234, 213));
		btnPerfil.setBorder(new LineBorder(new Color(232, 218, 188), 4, true));
		btnPerfil.setBounds(1317, 338, 169, 43);
		contentPane.add(btnPerfil);

		JButton btnNewButton_1 = new JButton("Oferecer");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnNewButton_1.setBorder(new LineBorder(new Color(232, 218, 188), 4));
		btnNewButton_1.setBackground(new Color(244, 234, 213));
		btnNewButton_1.setBounds(1317, 520, 169, 43);
		contentPane.add(btnNewButton_1);

	}
}

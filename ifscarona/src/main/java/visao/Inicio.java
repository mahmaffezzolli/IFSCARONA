package visao;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class Inicio extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblImage;
	private JButton btnCadastrar;
	private JLabel lblBemvindoAo;
	private JLabel lblFundoClaro;
	private JLabel lblCanto2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
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
	public Inicio() {
		Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, 1935, 1049);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 251, 233));
		contentPane.setBorder(new LineBorder(new Color(255, 251, 233), 2, true));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogar = new JButton("Logar");
		btnLogar.setBorder(new LineBorder(new Color(232, 218, 188), 4, true));
		btnLogar.setFont(new Font("Dialog", Font.BOLD, 15));
		btnLogar.setBackground(new Color(255, 251, 233));
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new Login().setVisible(true);
				 Inicio.this.dispose();
			}

		});

		JLabel lblCanto1 = new JLabel("New label");
		lblCanto1.setIcon(new ImageIcon(Inicio.class.getResource("/assets/tela inicio canto.png")));
		lblCanto1.setBounds(1508, -14, 416, 483);
		contentPane.add(lblCanto1);

		lblCanto2 = new JLabel("");
		lblCanto2.setIcon(
				new ImageIcon(Inicio.class.getResource("/assets/dunso.png")));
		lblCanto2.setBounds(0, -108, 800, 1169);
		contentPane.add(lblCanto2);
		btnLogar.setBounds(810, 574, 146, 51);
		contentPane.add(btnLogar);

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBorder(new LineBorder(new Color(232, 218, 188), 4, true));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					new CadastroUsuario().setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 Inicio.this.dispose();
			}

		});
		btnCadastrar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnCadastrar.setBackground(new Color(255, 251, 233));
		btnCadastrar.setBounds(981, 574, 154, 51);
		contentPane.add(btnCadastrar);

		JLabel lblLogo = new JLabel("IFSCarona");
		lblLogo.setFont(new Font("Dialog", Font.BOLD, 49));
		lblLogo.setBounds(839, 393, 311, 112);
		contentPane.add(lblLogo);

		lblBemvindoAo = new JLabel("Bem-Vindo ao");
		lblBemvindoAo.setFont(new Font("Dialog", Font.BOLD, 20));
		lblBemvindoAo.setBounds(947, 393, 217, 51);
		contentPane.add(lblBemvindoAo);

		lblImage = new JLabel("");
		lblImage.setIcon(
				new ImageIcon(Inicio.class.getResource("/assets/car.png")));
		lblImage.setBounds(875, 81, 337, 260);
		contentPane.add(lblImage);

		lblFundoClaro = new JLabel("");
		lblFundoClaro.setIcon(new ImageIcon(Inicio.class.getResource("/assets/tela inicio fundo botoes.png")));
		lblFundoClaro.setBounds(748, 203, 559, 600);
		contentPane.add(lblFundoClaro);

		textField = new JTextField();
		textField.setFont(new Font("TlwgTypewriter", Font.BOLD, 22));
		textField.setBackground(new Color(159, 203, 154));
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setBounds(0, -14, 1949, 1075);
		contentPane.add(textField);
		textField.setColumns(10);

	}
}

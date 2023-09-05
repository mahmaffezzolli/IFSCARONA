package visao;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
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
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1940, 1119);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

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

			private void dispose() {
				setVisible(false);

			}

		});
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(Inicio.class.getResource("/assets/tela inicio canto.png")));
		lblNewLabel_2.setBounds(1508, -14, 416, 483);
		contentPane.add(lblNewLabel_2);

		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(
				new ImageIcon(Inicio.class.getResource("/assets/dunso.png")));
		lblNewLabel_4.setBounds(0, -108, 800, 1169);
		contentPane.add(lblNewLabel_4);
		btnLogar.setBounds(815, 574, 141, 40);
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

			private void dispose() {
				setVisible(false);

			}

		});
		btnCadastrar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnCadastrar.setBackground(new Color(255, 251, 233));
		btnCadastrar.setBounds(981, 574, 129, 40);
		contentPane.add(btnCadastrar);

		JLabel lblNewLabel = new JLabel("IFSCarona");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 49));
		lblNewLabel.setBounds(824, 385, 311, 112);
		contentPane.add(lblNewLabel);

		lblBemvindoAo = new JLabel("Bem-Vindo ao");
		lblBemvindoAo.setFont(new Font("Dialog", Font.BOLD, 20));
		lblBemvindoAo.setBounds(944, 376, 217, 51);
		contentPane.add(lblBemvindoAo);

		lblImage = new JLabel("");
		lblImage.setIcon(
				new ImageIcon(Inicio.class.getResource("/assets/car.png")));
		lblImage.setBounds(875, 81, 337, 260);
		contentPane.add(lblImage);

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Inicio.class.getResource("/assets/tela inicio fundo botoes.png")));
		lblNewLabel_1.setBounds(748, 203, 559, 600);
		contentPane.add(lblNewLabel_1);

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

package visao;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import controle.JavaMail;
import controle.PessoaDAO;
import modelo.Pessoa;
import modelo.Sessao;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail;
	private JPasswordField txtSenha;
	private PessoaDAO pDAO = PessoaDAO.getInstancia();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, screen.width, screen.height - 30);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(154, 203, 159));
		contentPane.setBorder(new LineBorder(new Color(255, 251, 233), 2, true));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(Login.class.getResource("/assets/car.png")));
		lblNewLabel_5.setBounds(81, 304, 385, 151);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setFont(new Font("Nirmala UI", Font.BOLD, 65));
		lblNewLabel_1.setBounds(951, 115, 363, 110);
		contentPane.add(lblNewLabel_1);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Login.class.getResource("/assets/b1340120-e126-4821-b15c-e3627d2a38a6.png")));
		lblLogo.setBounds(-15, 417, 590, 172);
		contentPane.add(lblLogo);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Login.class.getResource("/assets/fundoClaro.png")));
		lblNewLabel_3.setBounds(0, -238, 398, 1650);
		contentPane.add(lblNewLabel_3);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Nirmala UI", Font.PLAIN, 16));
		lblEmail.setBounds(900, 360, 191, 15);
		contentPane.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEmail.setBackground(new Color(255, 251, 233));
		txtEmail.setToolTipText("");
		txtEmail.setBounds(900, 390, 330, 45);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		JCheckBox showPasswordCheckBox = new JCheckBox("Mostrar senha");
		showPasswordCheckBox.setBackground(new Color(238, 238, 238));
		showPasswordCheckBox.setFont(new Font("Nirmala UI", Font.PLAIN, 13));
		showPasswordCheckBox.setBounds(1113, 610, 120, 15);
		contentPane.add(showPasswordCheckBox);

		showPasswordCheckBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (showPasswordCheckBox.isSelected()) {
					txtSenha.setEchoChar((char) 0);
				} else {
					txtSenha.setEchoChar('\u2022');
				}
			}
		});

		JButton btnLogar = new JButton("LOGAR");
		btnLogar.setFont(new Font("Nirmala UI", Font.PLAIN, 18));
		btnLogar.setBorder(new LineBorder(new Color(244, 234, 213), 4, true));
		btnLogar.setBackground(new Color(255, 251, 233));
		btnLogar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String email = txtEmail.getText();

				String senha = String.valueOf(txtSenha.getPassword());

				if (txtEmail.getText().isEmpty() || senha.isEmpty()) {

					CampoNaoPreenchido campoNaoPreenchido = new CampoNaoPreenchido();

					campoNaoPreenchido.setVisible(true);

				} else if (isValidEmailAddress(email) == false) {

					EmaiInvalido Emailnvalido = new EmaiInvalido();

					Emailnvalido.setVisible(true);

				} else {

					Pessoa pessoaLogada = pDAO.login(email, senha);

					if (pessoaLogada != null) {
						
						try {
							JavaMail.sendEmail("assh.armanini@gmal.com");
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						Sessao.setPessoaLogada(pessoaLogada);

						Principal principal = new Principal();

						principal.setVisible(true);

						dispose();

					} else {

						SenhaIncorreta senhaincorreta = new SenhaIncorreta();

						senhaincorreta.setVisible(true);

					}

				}

			}

			private void dispose() {

				setVisible(false);

			}

		});
		btnLogar.setBounds(952, 740, 220, 45);
		contentPane.add(btnLogar);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Nirmala UI", Font.PLAIN, 16));
		lblSenha.setBounds(900, 530, 50, 15);
		contentPane.add(lblSenha);

		txtSenha = new JPasswordField();
		txtSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSenha.setToolTipText("");
		txtSenha.setColumns(10);
		txtSenha.setBackground(new Color(255, 251, 233));
		txtSenha.setBounds(900, 560, 330, 45);
		contentPane.add(txtSenha);

		JLabel lblCad = new JLabel("Não possui cadastro?");
		lblCad.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblCad.setBounds(951, 797, 140, 14);
		contentPane.add(lblCad);

		JLabel lblLinkAqui = new JLabel("Clique aqui");
		lblLinkAqui.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblLinkAqui.setBounds(1095, 797, 77, 14);
		lblLinkAqui.setForeground(Color.BLUE);
		lblLinkAqui.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(lblLinkAqui);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/assets/icons8-nova-mensagem-60.png")));
		lblNewLabel.setBounds(808, 390, 99, 45);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/assets/senha.png")));
		lblNewLabel_2.setBounds(816, 545, 120, 60);
		contentPane.add(lblNewLabel_2);

		lblLinkAqui.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CadastroUsuario CadastroFrame = null;
				try {
					CadastroFrame = new CadastroUsuario();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				CadastroFrame.setVisible(true);
				Login.this.dispose();
			}

		});

	}

	public static boolean isValidEmailAddress(String email) {

		boolean result = true;

		try {

			InternetAddress emailAddr = new InternetAddress(email);

			emailAddr.validate();

		} catch (AddressException ex) {

			result = false;

		}

		return result;

	}
}

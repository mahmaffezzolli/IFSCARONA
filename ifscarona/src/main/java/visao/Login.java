package visao;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
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
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.border.LineBorder;
import controle.PessoaDAO;
import controle.VeiculoDAO;
import modelo.Pessoa;
import modelo.Sessao;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail;
	private JPasswordField txtSenha;
	private PessoaDAO pDAO = PessoaDAO.getInstancia();
	private JProgressBar progressBar;

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

	public Login() {

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

		JLabel lblCarro = new JLabel("");
		lblCarro.setIcon(new ImageIcon(Login.class.getResource("/assets/car.png")));
		lblCarro.setBounds(97, 300, 385, 151);
		contentPane.add(lblCarro);

		JLabel lblTitulo = new JLabel("Login");
		lblTitulo.setFont(new Font("Nirmala UI", Font.BOLD, 65));
		lblTitulo.setBounds(951, 115, 363, 110);
		contentPane.add(lblTitulo);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Login.class.getResource("/assets/b1340120-e126-4821-b15c-e3627d2a38a6.png")));
		lblLogo.setBounds(-15, 417, 590, 172);
		contentPane.add(lblLogo);

		JLabel lblFundoClaro = new JLabel("");
		lblFundoClaro.setIcon(new ImageIcon(Login.class.getResource("/assets/fundoClaro.png")));
		lblFundoClaro.setBounds(0, -238, 398, 1650);
		contentPane.add(lblFundoClaro);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Dialog", Font.PLAIN, 15));
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
		showPasswordCheckBox.setBounds(1113, 610, 117, 15);
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
		btnLogar.setFont(new Font("Dialog", Font.BOLD, 15));
		btnLogar.setBorder(new LineBorder(new Color(244, 234, 213), 4, true));
		btnLogar.setBackground(new Color(255, 251, 233));
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = txtEmail.getText();
				String senha = String.valueOf(txtSenha.getPassword());

				if (txtEmail.getText().isEmpty() || senha.isEmpty()) {
					CampoNaoPreenchido campoNaoPreenchido = new CampoNaoPreenchido();
					campoNaoPreenchido.setBounds(40, 40, 451, 234);
					campoNaoPreenchido.setLocationRelativeTo(null);
					campoNaoPreenchido.setVisible(true);
				} else if (!isValidEmailAddress(email)) {
					EmaiInvalido emailInvalido = new EmaiInvalido();
					emailInvalido.setBounds(40, 40, 451, 234);
					emailInvalido.setLocationRelativeTo(null);
					emailInvalido.setVisible(true);
				} else {
					showProgressBar(true);

					SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
						@Override
						protected Void doInBackground() throws Exception {
							Pessoa pessoaLogada = pDAO.login(email, senha);

							if (pessoaLogada != null) {
								VeiculoDAO vDAO = VeiculoDAO.getInstancia();
								vDAO.conexaoVeiculoPessoa(pessoaLogada);
								Sessao.setPessoaLogada(pessoaLogada);

								Principal principal = new Principal();
								principal.setVisible(true);
								dispose();
								// JavaMail.enviarEmail(email);
							} else {
								EmaiInvalido emailinvalido = new EmaiInvalido();
								emailinvalido.setBounds(40, 40, 451, 234);
								emailinvalido.setLocationRelativeTo(null);
								emailinvalido.setVisible(true);
							}
							return null;
						}

						@Override
						protected void done() {
							showProgressBar(false);
						}
					};

					worker.execute();
				}
			}
		});
		btnLogar.setBounds(952, 741, 220, 45);
		contentPane.add(btnLogar);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblSenha.setBounds(900, 530, 99, 15);
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
		lblLinkAqui.setBounds(1095, 798, 77, 14);
		lblLinkAqui.setForeground(Color.BLUE);
		lblLinkAqui.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(lblLinkAqui);

		JLabel lblIconeEmail = new JLabel("");
		lblIconeEmail.setIcon(new ImageIcon(Login.class.getResource("/assets/icons8-nova-mensagem-60.png")));
		lblIconeEmail.setBounds(808, 390, 99, 45);
		contentPane.add(lblIconeEmail);

		JLabel lblIconeSenha = new JLabel("");
		lblIconeSenha.setIcon(new ImageIcon(Login.class.getResource("/assets/senha.png")));
		lblIconeSenha.setBounds(816, 545, 120, 60);
		contentPane.add(lblIconeSenha);

		lblLinkAqui.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CadastroUsuario CadastroFrame = null;
				try {
					CadastroFrame = new CadastroUsuario();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				CadastroFrame.setVisible(true);
				Login.this.dispose();
			}
		});

		progressBar = new JProgressBar();
		progressBar.setForeground(new Color(78, 154, 6));
		progressBar.setBackground(new Color(215, 235, 175));
		progressBar.setIndeterminate(true);
		progressBar.setBounds(952, 700, 220, 20);
		contentPane.add(progressBar);
		progressBar.setVisible(false);
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

	private void showProgressBar(boolean show) {
		progressBar.setVisible(show);
	}
}

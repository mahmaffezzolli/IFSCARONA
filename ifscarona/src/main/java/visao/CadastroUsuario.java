package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;
import org.mindrot.jbcrypt.BCrypt;
import controle.PessoaDAO;
import modelo.Pessoa;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

public class CadastroUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtfundoBege;
	private JTextField txtfundoVerde;
	private JLabel lblCadastro;
	private JLabel lblCPF;
	private JTextField txtCPF;
	private JTextField txtCPF_1;
	private JLabel lblEmail;
	private JTextField txtEmail;
	private JLabel lblDataNascimento;
	private JTextField txtDataNascimento;
	private JTextField txtDataNascimento_1;
	private JLabel lblSenha;
	private JLabel lblConfirmacaoSenha;
	private JButton btnCadastrar;
	private JLabel lblIconeSobrenome;
	private JLabel lblIconeEmail;
	private JLabel lblIconeDataNascimento;
	private JLabel lblIconeSenha;
	private JLabel lblIconeConfiormacaoSenha;
	private JLabel lblPossuiCadastro;
	private JLabel lblLinkAqui;
	private JTextField txtSobrenome;
	private JLabel lblSobrenome;
	private JLabel lblIconeCPF;
	private PessoaDAO pDAO = PessoaDAO.getInstancia();
	private JTextField txtNome;
	private JLabel lblIconeNome;
	private JPasswordField txtSenha;
	private JPasswordField txtConfirmacaoSenha;
	private JLabel lblLogo;
	private JLabel lblCarro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroUsuario frame = new CadastroUsuario();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws ParseException
	 */
	public CadastroUsuario() throws ParseException {

		java.net.URL caminhoIcone = getClass().getResource("/assets/janelaIcon.png");
		Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminhoIcone);
		this.setIconImage(iconeTitulo);

		setTitle("Cadastro");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1940, 1119);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblCarro = new JLabel("New label");
		lblCarro.setIcon(new ImageIcon(CadastroUsuario.class.getResource("/assets/car.png")));
		lblCarro.setBounds(101, 297, 170, 151);
		contentPane.add(lblCarro);

		lblLogo = new JLabel("New label");
		lblLogo.setIcon(
				new ImageIcon(CadastroUsuario.class.getResource("/assets/b1340120-e126-4821-b15c-e3627d2a38a6.png")));
		lblLogo.setBounds(0, 471, 380, 70);
		contentPane.add(lblLogo);

		JCheckBox CheckSenha = new JCheckBox("Mostrar senha");
		CheckSenha.setFont(new Font("Dialog", Font.PLAIN, 13));
		CheckSenha.setBackground(new Color(255, 251, 233));
		CheckSenha.setBounds(1475, 444, 127, 14);
		contentPane.add(CheckSenha);
		CheckSenha.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (CheckSenha.isSelected()) {
					txtSenha.setEchoChar((char) 0);
				} else {
					txtSenha.setEchoChar('\u2022');
				}
			}
		});

		JCheckBox CheckConfirmacao = new JCheckBox("Mostrar senha");
		CheckConfirmacao.setFont(new Font("Dialog", Font.PLAIN, 13));
		CheckConfirmacao.setBackground(new Color(255, 251, 233));
		CheckConfirmacao.setBounds(1475, 556, 127, 14);
		contentPane.add(CheckConfirmacao);

		CheckConfirmacao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (CheckConfirmacao.isSelected()) {
					txtConfirmacaoSenha.setEchoChar((char) 0);
				} else {
					txtConfirmacaoSenha.setEchoChar('\u2022');
				}
			}
		});
		txtConfirmacaoSenha = new JPasswordField();
		txtConfirmacaoSenha.setFont(new Font("Nirmala UI", Font.PLAIN, 17));
		txtConfirmacaoSenha.setBackground(new Color(255, 251, 233));
		txtConfirmacaoSenha.setBounds(1266, 499, 336, 46);
		contentPane.add(txtConfirmacaoSenha);

		txtSenha = new JPasswordField();
		txtSenha.setFont(new Font("Nirmala UI", Font.PLAIN, 17));
		txtSenha.setBackground(new Color(255, 251, 233));
		txtSenha.setBounds(1266, 396, 336, 46);
		contentPane.add(txtSenha);

		lblIconeNome = new JLabel("New label");
		lblIconeNome.setIcon(new ImageIcon(CadastroUsuario.class.getResource("/assets/icons8-nome-60.png")));
		lblIconeNome.setBounds(676, 297, 59, 45);
		contentPane.add(lblIconeNome);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Nirmala UI", Font.PLAIN, 18));
		lblNome.setBounds(745, 272, 122, 25);
		contentPane.add(lblNome);

		txtNome = new JTextField();
		txtNome.setFont(new Font("Nirmala UI", Font.PLAIN, 17));
		txtNome.setToolTipText("");
		txtNome.setColumns(10);
		txtNome.setBackground(new Color(255, 251, 233));
		txtNome.setBounds(745, 297, 336, 45);
		contentPane.add(txtNome);

		lblIconeCPF = new JLabel("New label");
		lblIconeCPF.setIcon(new ImageIcon(CadastroUsuario.class.getResource("/assets/cpf.png")));
		lblIconeCPF.setBounds(676, 487, 59, 71);
		contentPane.add(lblIconeCPF);

		lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setFont(new Font("Nirmala UI", Font.PLAIN, 18));
		lblSobrenome.setBounds(745, 366, 122, 25);
		contentPane.add(lblSobrenome);

		txtSobrenome = new JTextField();
		txtSobrenome.setFont(new Font("Nirmala UI", Font.PLAIN, 17));
		txtSobrenome.setToolTipText("");
		txtSobrenome.setColumns(10);
		txtSobrenome.setBackground(new Color(255, 251, 233));
		txtSobrenome.setBounds(745, 397, 336, 45);
		contentPane.add(txtSobrenome);

		lblLinkAqui = new JLabel("Clique aqui");
		lblLinkAqui.setForeground(Color.BLUE);
		lblLinkAqui.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblLinkAqui.setBounds(1379, 556, 178, 14);
		contentPane.add(lblLinkAqui);
		lblLinkAqui.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();

				Login loginFrame = new Login();
				loginFrame.setVisible(true);

			}
		});
		lblPossuiCadastro = new JLabel("Possui cadastro?");
		lblPossuiCadastro.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblPossuiCadastro.setBounds(1266, 556, 178, 14);
		contentPane.add(lblPossuiCadastro);

		lblIconeConfiormacaoSenha = new JLabel("New label");
		lblIconeConfiormacaoSenha.setIcon(new ImageIcon(CadastroUsuario.class.getResource("/assets/senha.png")));
		lblIconeConfiormacaoSenha.setBounds(1197, 495, 59, 55);

		contentPane.add(lblIconeConfiormacaoSenha);
		lblIconeSenha = new JLabel("New label");
		lblIconeSenha.setIcon(new ImageIcon(CadastroUsuario.class.getResource("/assets/senha.png")));
		lblIconeSenha.setBounds(1197, 387, 59, 55);
		contentPane.add(lblIconeSenha);

		lblIconeDataNascimento = new JLabel("New label");
		lblIconeDataNascimento
				.setIcon(new ImageIcon(CadastroUsuario.class.getResource("/assets/icons8-data-de-nascimento-60.png")));
		lblIconeDataNascimento.setBounds(1197, 289, 59, 60);
		contentPane.add(lblIconeDataNascimento);

		lblIconeEmail = new JLabel("New label");
		lblIconeEmail.setIcon(new ImageIcon(CadastroUsuario.class.getResource("/assets/icons8-nova-mensagem-60.png")));
		lblIconeEmail.setBounds(676, 599, 59, 52);
		contentPane.add(lblIconeEmail);

		lblIconeSobrenome = new JLabel("New label");
		lblIconeSobrenome.setIcon(new ImageIcon(CadastroUsuario.class.getResource("/assets/icons8-nome-60.png")));
		lblIconeSobrenome.setBounds(676, 397, 59, 45);
		contentPane.add(lblIconeSobrenome);

		lblConfirmacaoSenha = new JLabel("Confirmação de Senha:");
		lblConfirmacaoSenha.setFont(new Font("Nirmala UI", Font.PLAIN, 18));
		lblConfirmacaoSenha.setBounds(1266, 474, 200, 25);
		contentPane.add(lblConfirmacaoSenha);

		lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Nirmala UI", Font.PLAIN, 18));
		lblSenha.setBounds(1266, 367, 122, 25);
		contentPane.add(lblSenha);

		txtDataNascimento = new JTextField();

		/*****************/
		MaskFormatter mascaraData = null;
		mascaraData = new MaskFormatter("##/##/####");
		txtDataNascimento_1 = new JFormattedTextField(mascaraData);
		txtDataNascimento_1.setFont(new Font("Nirmala UI", Font.PLAIN, 17));
		/*****************/

		txtDataNascimento_1.setColumns(10);
		txtDataNascimento_1.setBackground(new Color(255, 251, 233));
		txtDataNascimento_1.setBounds(1266, 297, 336, 45);
		contentPane.add(txtDataNascimento_1);

		lblDataNascimento = new JLabel("Data de Nascimento:");
		lblDataNascimento.setFont(new Font("Nirmala UI", Font.PLAIN, 18));
		lblDataNascimento.setBounds(1266, 273, 178, 25);
		contentPane.add(lblDataNascimento);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Nirmala UI", Font.PLAIN, 17));
		txtEmail.setToolTipText("");
		txtEmail.setColumns(10);
		txtEmail.setBackground(new Color(255, 251, 233));
		txtEmail.setBounds(745, 606, 336, 45);
		contentPane.add(txtEmail);

		lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Nirmala UI", Font.PLAIN, 18));
		lblEmail.setBounds(745, 577, 147, 25);
		contentPane.add(lblEmail);

		txtCPF = new JTextField();

		/*****************/
		MaskFormatter mascaraCPF = null;
		mascaraCPF = new MaskFormatter("###.###.###-##");
		txtCPF_1 = new JFormattedTextField(mascaraCPF);
		txtCPF_1.setFont(new Font("Nirmala UI", Font.PLAIN, 17));
		/*****************/

		txtCPF_1.setToolTipText("");
		txtCPF_1.setColumns(10);
		txtCPF_1.setBackground(new Color(255, 251, 233));
		txtCPF_1.setBounds(745, 500, 336, 45);
		contentPane.add(txtCPF_1);

		lblCPF = new JLabel("CPF:");
		lblCPF.setFont(new Font("Nirmala UI", Font.PLAIN, 18));
		lblCPF.setBounds(745, 472, 122, 25);
		contentPane.add(lblCPF);

		lblCadastro = new JLabel("Cadastro");
		lblCadastro.setFont(new Font("Dialog", Font.BOLD, 53));
		lblCadastro.setBounds(959, 55, 327, 107);
		contentPane.add(lblCadastro);

		btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnCadastrar.setBorder(new LineBorder(new Color(244, 234, 213), 4, true));
		btnCadastrar.setBackground(new Color(255, 251, 233));
		btnCadastrar.setBounds(1342, 606, 178, 54);
		contentPane.add(btnCadastrar);

		btnCadastrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// instacia da classe pessoa
				Pessoa p = new Pessoa();

				// instancia tela de erro
				CampoNaoPreenchido campoNaoPreenchido = new CampoNaoPreenchido();

				// armazenando os valores dentro das variáveis
				String nome = txtNome.getText();
				String sobrenome = txtSobrenome.getText();

				String cpfS = txtCPF.getText();

				String email = txtEmail.getText();

				String senha = String.valueOf(txtSenha.getPassword());
				String confSenha = String.valueOf(txtConfirmacaoSenha.getPassword());
				String senhaCriptografada = BCrypt.hashpw(senha, BCrypt.gensalt());

				// validação se o campo é vazio, se for, abre a tela de erro
				if (nome.isEmpty()) {
					campoNaoPreenchido.setBounds(40, 40, 451, 234);
					campoNaoPreenchido.setLocationRelativeTo(null);
					campoNaoPreenchido.setVisible(true);

				} else if (sobrenome.isEmpty()) {
					campoNaoPreenchido.setBounds(40, 40, 451, 234);
					campoNaoPreenchido.setLocationRelativeTo(null);
					campoNaoPreenchido.setVisible(true);

				} else if (txtCPF.getText().isEmpty()) {
					campoNaoPreenchido.setBounds(40, 40, 451, 234);
					campoNaoPreenchido.setLocationRelativeTo(null);
					campoNaoPreenchido.setVisible(true);

				} else if (txtEmail.getText().isEmpty()) {
					campoNaoPreenchido.setBounds(40, 40, 451, 234);
					campoNaoPreenchido.setLocationRelativeTo(null);
					campoNaoPreenchido.setVisible(true);
				} else if (isValidEmailAddress(email) == false) {

					EmaiInvalido Emailnvalido = new EmaiInvalido();
					Emailnvalido.setBounds(40, 40, 451, 234);
					Emailnvalido.setLocationRelativeTo(null);
					Emailnvalido.setVisible(true);

				} else if (senha.isEmpty()) {
					campoNaoPreenchido.setBounds(40, 40, 451, 234);
					campoNaoPreenchido.setLocationRelativeTo(null);
					campoNaoPreenchido.setVisible(true);

				} else if (!senha.equals(confSenha)) {
					SenhasNaoConferem senhasNaoConferem = new SenhasNaoConferem();
					senhasNaoConferem.setBounds(40, 40, 451, 234);
					senhasNaoConferem.setLocationRelativeTo(null);
					senhasNaoConferem.setVisible(true);

				} else {

					// tranformando em fotmato de data
					LocalDate dataNascimento = LocalDate.parse(txtDataNascimento.getText(),
							DateTimeFormatter.ofPattern("dd/MM/yyy"));

					// removendo a máscara
					cpfS = cpfS.replaceAll("[.-]", "").trim();

					int cpfLength = cpfS.length();
					if (cpfLength < 11) {

						cpfS = "0".repeat(11 - cpfLength) + cpfS;
					}

					p.setCpf(cpfS);
					p.setNome(nome);
					p.setSobrenome(sobrenome);
					p.setEmail(email);
					p.setSenha(senhaCriptografada);
					p.setDataNasc(dataNascimento);

					String success = pDAO.cadastrarPessoa(p);

					if (success == cpfS) {

						Login login = new Login();
						login.setVisible(true);

						CadastroRealizado cadastroRealizado = new CadastroRealizado();
						cadastroRealizado.setBounds(40, 40, 451, 234);
						cadastroRealizado.setLocationRelativeTo(null);
						cadastroRealizado.setVisible(true);

						dispose();

					} else {
						CadastroErro cadastroErro = new CadastroErro();
						cadastroErro.setBounds(40, 40, 451, 234);
						cadastroErro.setLocationRelativeTo(null);
						cadastroErro.setVisible(true);
					}

				}
			}

		});

		txtfundoBege = new JTextField();
		txtfundoBege.setEnabled(false);
		txtfundoBege.setEditable(false);
		txtfundoBege.setColumns(10);
		txtfundoBege.setBackground(new Color(244, 234, 213));
		txtfundoBege.setBounds(0, 0, 390, 1061);
		contentPane.add(txtfundoBege);

		txtfundoVerde = new JTextField();
		txtfundoVerde.setFont(new Font("Dialog", Font.BOLD, 22));
		txtfundoVerde.setEnabled(false);
		txtfundoVerde.setEditable(false);
		txtfundoVerde.setColumns(10);
		txtfundoVerde.setBackground(new Color(159, 203, 154));
		txtfundoVerde.setBounds(124, 0, 1939, 1106);
		contentPane.add(txtfundoVerde);
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

package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
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
	private JLabel lblEmail;
	private JTextField txtEmail;
	private JLabel lblDataNascimento;
	private JTextField txtDataNascimento;
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
		CheckSenha.setBounds(1475, 374, 127, 14);
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
		CheckConfirmacao.setBounds(1475, 486, 127, 14);
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
		txtConfirmacaoSenha.setBackground(new Color(255, 251, 233));
		txtConfirmacaoSenha.setBounds(1266, 429, 336, 46);
		contentPane.add(txtConfirmacaoSenha);

		txtSenha = new JPasswordField();
		txtSenha.setBackground(new Color(255, 251, 233));
		txtSenha.setBounds(1266, 321, 336, 46);
		contentPane.add(txtSenha);

		lblIconeNome = new JLabel("New label");
		lblIconeNome.setIcon(new ImageIcon(CadastroUsuario.class.getResource("/assets/icons8-nome-60.png")));
		lblIconeNome.setBounds(676, 227, 59, 45);
		contentPane.add(lblIconeNome);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNome.setBounds(745, 202, 122, 14);
		contentPane.add(lblNome);

		txtNome = new JTextField();
		txtNome.setToolTipText("");
		txtNome.setColumns(10);
		txtNome.setBackground(new Color(255, 251, 233));
		txtNome.setBounds(745, 227, 336, 45);
		contentPane.add(txtNome);

		lblIconeCPF = new JLabel("New label");
		lblIconeCPF.setIcon(new ImageIcon(CadastroUsuario.class.getResource("/assets/cpf.png")));
		lblIconeCPF.setBounds(676, 417, 59, 71);
		contentPane.add(lblIconeCPF);

		lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setFont(new Font("Arial", Font.PLAIN, 15));
		lblSobrenome.setBounds(745, 296, 122, 14);
		contentPane.add(lblSobrenome);

		txtSobrenome = new JTextField();
		txtSobrenome.setToolTipText("");
		txtSobrenome.setColumns(10);
		txtSobrenome.setBackground(new Color(255, 251, 233));
		txtSobrenome.setBounds(745, 327, 336, 45);
		contentPane.add(txtSobrenome);

		lblLinkAqui = new JLabel("Clique aqui");
		lblLinkAqui.setForeground(Color.BLUE);
		lblLinkAqui.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblLinkAqui.setBounds(1369, 486, 178, 14);
		contentPane.add(lblLinkAqui);
		lblLinkAqui.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login loginFrame = new Login();
				loginFrame.setVisible(true);
				CadastroUsuario.this.dispose();
			}
		});
		lblPossuiCadastro = new JLabel("Possui cadastro?");
		lblPossuiCadastro.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblPossuiCadastro.setBounds(1266, 486, 178, 14);
		contentPane.add(lblPossuiCadastro);

		lblIconeConfiormacaoSenha = new JLabel("New label");
		lblIconeConfiormacaoSenha.setIcon(new ImageIcon(CadastroUsuario.class.getResource("/assets/senha.png")));
		lblIconeConfiormacaoSenha.setBounds(1197, 425, 59, 55);

		contentPane.add(lblIconeConfiormacaoSenha);
		lblIconeSenha = new JLabel("New label");
		lblIconeSenha.setIcon(new ImageIcon(CadastroUsuario.class.getResource("/assets/senha.png")));
		lblIconeSenha.setBounds(1197, 317, 59, 55);
		contentPane.add(lblIconeSenha);

		lblIconeDataNascimento = new JLabel("New label");
		lblIconeDataNascimento
				.setIcon(new ImageIcon(CadastroUsuario.class.getResource("/assets/icons8-data-de-nascimento-60.png")));
		lblIconeDataNascimento.setBounds(1197, 219, 59, 60);
		contentPane.add(lblIconeDataNascimento);

		lblIconeEmail = new JLabel("New label");
		lblIconeEmail.setIcon(new ImageIcon(CadastroUsuario.class.getResource("/assets/icons8-nova-mensagem-60.png")));
		lblIconeEmail.setBounds(676, 529, 59, 52);
		contentPane.add(lblIconeEmail);

		lblIconeSobrenome = new JLabel("New label");
		lblIconeSobrenome.setIcon(new ImageIcon(CadastroUsuario.class.getResource("/assets/icons8-nome-60.png")));
		lblIconeSobrenome.setBounds(676, 327, 59, 45);
		contentPane.add(lblIconeSobrenome);

		btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.setBorder(new LineBorder(new Color(244, 234, 213), 4, true));
		btnCadastrar.setBackground(new Color(255, 251, 233));
		btnCadastrar.setBounds(1342, 536, 178, 54);
		contentPane.add(btnCadastrar);

		btnCadastrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Pessoa p = new Pessoa();

				String nome = txtNome.getText();
				String sobrenome = txtSobrenome.getText();
				String cpfS = String.valueOf(txtCPF.getText());
				String email = txtEmail.getText();
				LocalDate dataNascimento = LocalDate.parse(txtDataNascimento.getText(),
						DateTimeFormatter.ofPattern("dd/MM/yyy"));
				String senha = String.valueOf(txtSenha.getPassword());
				String confSenha = String.valueOf(txtConfirmacaoSenha.getPassword());

				if (nome.isEmpty()) {
					JOptionPane.showMessageDialog(null, "O nome deve ser inserido!");

				} else if (sobrenome.isEmpty()) {
					JOptionPane.showMessageDialog(null, "O sobrenome deve ser inserido!");

				} else if (cpfS.isEmpty()) {
					JOptionPane.showMessageDialog(null, "O cpf deve ser inserido!");

				} else if (email.isEmpty()) {
					JOptionPane.showMessageDialog(null, "O email deve ser inserido!");

				} else if (dataNascimento != null) {
					JOptionPane.showMessageDialog(null, "A data de nascimento deve ser inserida!");

				} else if (senha.isEmpty()) {

					JOptionPane.showMessageDialog(null, "A senha deve ser inserida!");

				} else if (!senha.equals(confSenha)) {
					JOptionPane.showMessageDialog(null, "As senhas não conferem");

				} else {

					cpfS = cpfS.replace(".", "");
					cpfS = cpfS.replace("-", "");
					cpfS = cpfS.trim();
					Long cpf = Long.parseLong(cpfS);

					p.setCpf(cpf);
					p.setNome(nome);
					p.setSobrenome(sobrenome);
					p.setEmail(email);
					p.setSenha(senha);
					p.setDataNasc(dataNascimento);

					boolean success = pDAO.cadastrarPessoa(p);
					if (success) {
						JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
						// Optionally, clear input fields or navigate to another screen
					} else {
						JOptionPane.showMessageDialog(null, "Erro ao cadastrar pessoa.");
					}
				}
			}
		});
		lblConfirmacaoSenha = new JLabel("Confirmação de Senha:");
		lblConfirmacaoSenha.setFont(new Font("Arial", Font.PLAIN, 15));
		lblConfirmacaoSenha.setBounds(1266, 404, 178, 14);
		contentPane.add(lblConfirmacaoSenha);

		lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 15));
		lblSenha.setBounds(1266, 297, 122, 14);
		contentPane.add(lblSenha);

		txtDataNascimento = new JTextField();
		/*****************/
		MaskFormatter mascaraData = null;
		mascaraData = new MaskFormatter("##/##/####");
		txtDataNascimento = new JFormattedTextField(mascaraData);
		/*****************/
		txtDataNascimento.setColumns(10);
		txtDataNascimento.setBackground(new Color(255, 251, 233));
		txtDataNascimento.setBounds(1266, 227, 336, 45);
		contentPane.add(txtDataNascimento);

		lblDataNascimento = new JLabel("Data de Nascimento:");
		lblDataNascimento.setFont(new Font("Arial", Font.PLAIN, 15));
		lblDataNascimento.setBounds(1266, 203, 147, 14);
		contentPane.add(lblDataNascimento);

		txtEmail = new JTextField();
		txtEmail.setToolTipText("");
		txtEmail.setColumns(10);
		txtEmail.setBackground(new Color(255, 251, 233));
		txtEmail.setBounds(745, 536, 336, 45);
		contentPane.add(txtEmail);

		lblEmail = new JLabel("E-mail institucional:");
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 15));
		lblEmail.setBounds(745, 507, 147, 14);
		contentPane.add(lblEmail);

		txtCPF = new JTextField();
		/*****************/
		MaskFormatter mascaraCPF = null;
		mascaraCPF = new MaskFormatter("###.###.###-##");
		txtCPF = new JFormattedTextField(mascaraCPF);
		/*****************/
		txtCPF.setToolTipText("");
		txtCPF.setColumns(10);
		txtCPF.setBackground(new Color(255, 251, 233));
		txtCPF.setBounds(745, 430, 336, 45);
		contentPane.add(txtCPF);

		lblCPF = new JLabel("CPF:");
		lblCPF.setFont(new Font("Arial", Font.PLAIN, 15));
		lblCPF.setBounds(745, 402, 122, 14);
		contentPane.add(lblCPF);

		lblCadastro = new JLabel("Cadastro");
		lblCadastro.setFont(new Font("Dialog", Font.BOLD, 53));
		lblCadastro.setBounds(1009, 65, 327, 107);
		contentPane.add(lblCadastro);

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
}

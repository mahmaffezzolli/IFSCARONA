package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controle.PessoaDAO;
import modelo.Pessoa;

public class CadastroUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtfundoBege;
	private JTextField txtfundoVerde;
	private JLabel ifacarona;
	private JLabel lblCadastro;
	private JLabel lblCPF;
	private JTextField txtCPF;
	private JLabel lblEmail;
	private JTextField txtEmail;
	private JLabel lblDataNascimento;
	private JTextField txtDataNascimento;
	private JLabel lblSenha;
	private JTextField txtSenha;
	private JLabel lblConfirmacaoSenha;
	private JTextField txtConfirmacaoSenha;
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
	private final JPanel panel = new JPanel();
	private PessoaDAO pDAO = PessoaDAO.getInstancia();
	private JTextField txtNome;
	private JLabel lblIconeNome;

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
	 */
	public CadastroUsuario() {
		setTitle("Cadastro");
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1940, 1119);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblIconeNome = new JLabel("New label");
		lblIconeNome.setIcon(new ImageIcon(CadastroUsuario.class.getResource("/assets/icons8-nome-60.png")));
		lblIconeNome.setBounds(944, 199, 59, 45);
		contentPane.add(lblIconeNome);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNome.setBounds(1013, 181, 122, 14);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setToolTipText("");
		txtNome.setColumns(10);
		txtNome.setBackground(new Color(255, 251, 233));
		txtNome.setBounds(1013, 199, 336, 45);
		contentPane.add(txtNome);

		lblIconeCPF = new JLabel("New label");
		lblIconeCPF.setIcon(new ImageIcon(CadastroUsuario.class.getResource("/assets/cpf.png")));
		lblIconeCPF.setBounds(944, 354, 59, 71);
		contentPane.add(lblIconeCPF);

		lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setFont(new Font("Arial", Font.PLAIN, 13));
		lblSobrenome.setBounds(1013, 255, 122, 14);
		contentPane.add(lblSobrenome);

		txtSobrenome = new JTextField();
		txtSobrenome.setToolTipText("");
		txtSobrenome.setColumns(10);
		txtSobrenome.setBackground(new Color(255, 251, 233));
		txtSobrenome.setBounds(1013, 280, 336, 45);
		contentPane.add(txtSobrenome);

		lblLinkAqui = new JLabel("Clique aqui");
		lblLinkAqui.setForeground(Color.BLUE);
		lblLinkAqui.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblLinkAqui.setBounds(1120, 734, 178, 14);
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
		lblPossuiCadastro.setBounds(1013, 734, 178, 14);
		contentPane.add(lblPossuiCadastro);

		lblIconeConfiormacaoSenha = new JLabel("New label");
		lblIconeConfiormacaoSenha.setIcon(new ImageIcon(CadastroUsuario.class.getResource("/assets/senha.png")));
		lblIconeConfiormacaoSenha.setBounds(944, 668, 59, 55);
		contentPane.add(lblIconeConfiormacaoSenha);

		lblIconeSenha = new JLabel("New label");
		lblIconeSenha.setIcon(new ImageIcon(CadastroUsuario.class.getResource("/assets/senha.png")));
		lblIconeSenha.setBounds(944, 592, 59, 55);
		contentPane.add(lblIconeSenha);

		lblIconeDataNascimento = new JLabel("New label");
		lblIconeDataNascimento
				.setIcon(new ImageIcon(CadastroUsuario.class.getResource("/assets/icons8-data-de-nascimento-60.png")));
		lblIconeDataNascimento.setBounds(944, 512, 59, 60);
		contentPane.add(lblIconeDataNascimento);

		lblIconeEmail = new JLabel("New label");
		lblIconeEmail.setIcon(new ImageIcon(CadastroUsuario.class.getResource("/assets/icons8-nova-mensagem-60.png")));
		lblIconeEmail.setBounds(944, 436, 59, 52);
		contentPane.add(lblIconeEmail);

		lblIconeSobrenome = new JLabel("New label");
		lblIconeSobrenome.setIcon(new ImageIcon(CadastroUsuario.class.getResource("/assets/icons8-nome-60.png")));
		lblIconeSobrenome.setBounds(944, 280, 59, 45);
		contentPane.add(lblIconeSobrenome);

		btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.setBorder(new LineBorder(new Color(244, 234, 213), 4, true));
		btnCadastrar.setBackground(new Color(255, 251, 233));
		btnCadastrar.setBounds(1093, 783, 162, 45);
		contentPane.add(btnCadastrar);

		 
		btnCadastrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Pessoa p = new Pessoa();

				String nome = txtCPF.getText();
				String sobrenome = txtSobrenome.getText();
				String cpfS = String.valueOf(txtSobrenome.getText());
				String email = txtEmail.getText();
				String senha = txtSenha.getText();
				String confSenha = txtConfirmacaoSenha.getText();

				if (txtNome.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "O nome deve ser inserido!");

				} else if (txtSobrenome.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "O sobrenome deve ser inserido!");

				} else if (txtCPF.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "O cpf deve ser inserido!");

				} else if (txtEmail.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "O email deve ser inserido!");

				} else if (txtSenha.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "A senha deve ser inserida!");

				} else if (!senha.equals(confSenha)) {
					JOptionPane.showMessageDialog(null, "As senhas não conferem");

				} else {

					LocalDate dataNascimento = LocalDate.parse(txtDataNascimento.getText(),
							DateTimeFormatter.ofPattern("dd/MM/yyy"));

					p.setCpf(Long.parseLong(cpfS));
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

		txtConfirmacaoSenha = new JTextField();
		txtConfirmacaoSenha.setToolTipText("");
		txtConfirmacaoSenha.setColumns(10);
		txtConfirmacaoSenha.setBackground(new Color(255, 251, 233));
		txtConfirmacaoSenha.setBounds(1013, 678, 336, 45);
		contentPane.add(txtConfirmacaoSenha);

		lblConfirmacaoSenha = new JLabel("Confirmação de Senha:");
		lblConfirmacaoSenha.setFont(new Font("Arial", Font.PLAIN, 13));
		lblConfirmacaoSenha.setBounds(1013, 653, 147, 14);
		contentPane.add(lblConfirmacaoSenha);

		txtSenha = new JTextField();
		txtSenha.setToolTipText("");
		txtSenha.setColumns(10);
		txtSenha.setBackground(new Color(255, 251, 233));
		txtSenha.setBounds(1013, 597, 336, 45);
		contentPane.add(txtSenha);

		lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 13));
		lblSenha.setBounds(1013, 576, 122, 14);
		contentPane.add(lblSenha);

		txtDataNascimento = new JTextField();
		txtDataNascimento.setToolTipText("");
		txtDataNascimento.setColumns(10);
		txtDataNascimento.setBackground(new Color(255, 251, 233));
		txtDataNascimento.setBounds(1013, 520, 336, 45);
		contentPane.add(txtDataNascimento);

		lblDataNascimento = new JLabel("Data de Nascimento:");
		lblDataNascimento.setFont(new Font("Arial", Font.PLAIN, 13));
		lblDataNascimento.setBounds(1013, 496, 122, 14);
		contentPane.add(lblDataNascimento);

		txtEmail = new JTextField();
		txtEmail.setToolTipText("");
		txtEmail.setColumns(10);
		txtEmail.setBackground(new Color(255, 251, 233));
		txtEmail.setBounds(1013, 440, 336, 45);
		contentPane.add(txtEmail);

		lblEmail = new JLabel("E-mail institucional:");
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 13));
		lblEmail.setBounds(1013, 418, 122, 14);
		contentPane.add(lblEmail);

		txtCPF = new JTextField();
		txtCPF.setToolTipText("");
		txtCPF.setColumns(10);
		txtCPF.setBackground(new Color(255, 251, 233));
		txtCPF.setBounds(1013, 362, 336, 45);
		contentPane.add(txtCPF);

		lblCPF = new JLabel("CPF:");
		lblCPF.setFont(new Font("Arial", Font.PLAIN, 13));
		lblCPF.setBounds(1013, 337, 122, 14);
		contentPane.add(lblCPF);

		lblCadastro = new JLabel("Cadastro");
		lblCadastro.setFont(new Font("Dialog", Font.BOLD, 53));
		lblCadastro.setBounds(1026, 46, 327, 107);
		contentPane.add(lblCadastro);

		ifacarona = new JLabel("IFSCarona");
		ifacarona.setFont(new Font("Dialog", Font.BOLD, 53));
		ifacarona.setBounds(10, 206, 327, 107);
		contentPane.add(ifacarona);

		txtfundoBege = new JTextField();
		txtfundoBege.setEnabled(false);
		txtfundoBege.setEditable(false);
		txtfundoBege.setColumns(10);
		txtfundoBege.setBackground(new Color(244, 234, 213));
		txtfundoBege.setBounds(0, 0, 346, 1061);
		contentPane.add(txtfundoBege);

		txtfundoVerde = new JTextField();
		txtfundoVerde.setFont(new Font("Dialog", Font.BOLD, 22));
		txtfundoVerde.setEnabled(false);
		txtfundoVerde.setEditable(false);
		txtfundoVerde.setColumns(10);
		txtfundoVerde.setBackground(new Color(159, 203, 154));
		txtfundoVerde.setBounds(150, 0, 1939, 1075);
		contentPane.add(txtfundoVerde);
		panel.setBackground(new Color(244, 234, 213));
		panel.setBounds(0, 0, 346, 1050);
		contentPane.add(panel);

	}
}

package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class CadastroUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtfundoBege;
	private JTextField txtfundoVerde;
	private JLabel lblNewLabel_1;
	private JLabel lbltituloCadastro;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel;
	private JLabel lblCadastro;
	private JTextField textField;
	private JTextField txtNome;
	private JLabel lblNome;
	private JTextField txtEmail;
	private JLabel lblEmail;
	private JTextField txtNascimento;
	private JLabel lblDataNascimento;
	private JTextField txtSenha;
	private JLabel lblSenha;
	private JTextField txtConfirmacaoSenha;
	private JLabel lblConfirmacaoSenha;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1940, 1119);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastrarUsuario = new JButton("Cadastrar");
		btnCadastrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		lblConfirmacaoSenha = new JLabel("Confirmação de Senha");
		lblConfirmacaoSenha.setVerticalAlignment(SwingConstants.TOP);
		lblConfirmacaoSenha.setBounds(888, 490, 113, 14);
		contentPane.add(lblConfirmacaoSenha);
		
		txtConfirmacaoSenha = new JTextField();
		txtConfirmacaoSenha.setColumns(10);
		txtConfirmacaoSenha.setBounds(878, 487, 135, 20);
		contentPane.add(txtConfirmacaoSenha);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setBounds(888, 455, 46, 14);
		contentPane.add(lblSenha);
		
		txtSenha = new JTextField();
		txtSenha.setColumns(10);
		txtSenha.setBounds(878, 452, 135, 20);
		contentPane.add(txtSenha);
		
		lblDataNascimento = new JLabel("Data de Nascimento");
		lblDataNascimento.setBounds(888, 424, 96, 14);
		contentPane.add(lblDataNascimento);
		
		txtNascimento = new JTextField();
		txtNascimento.setBounds(878, 421, 135, 20);
		contentPane.add(txtNascimento);
		txtNascimento.setColumns(10);
		
		lblEmail = new JLabel("Email Institucional");
		lblEmail.setBounds(888, 393, 96, 14);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(878, 390, 135, 20);
		contentPane.add(txtEmail);
		
		lblNome = new JLabel("Nome");
		lblNome.setVerticalAlignment(SwingConstants.TOP);
		lblNome.setBounds(888, 362, 46, 14);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(878, 359, 135, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		lblCadastro = new JLabel("Cadastro ");
		lblCadastro.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastro.setFont(new Font("Dialog", Font.BOLD, 20));
		lblCadastro.setBounds(837, 276, 217, 51);
		contentPane.add(lblCadastro);
		btnCadastrarUsuario.setBackground(new Color(255, 251, 233));
		btnCadastrarUsuario.setBounds(863, 581, 172, 53);
		contentPane.add(btnCadastrarUsuario);
		
		txtfundoBege = new JTextField();
		txtfundoBege.setEnabled(false);
		txtfundoBege.setEditable(false);
		txtfundoBege.setColumns(10);
		txtfundoBege.setBackground(new Color(244, 234, 213));
		txtfundoBege.setBounds(784, 236, 346, 433);
		contentPane.add(txtfundoBege);
	
		
		txtfundoVerde = new JTextField();
		txtfundoVerde.setFont(new Font("Dialog", Font.BOLD, 22));
		txtfundoVerde.setEnabled(false);
		txtfundoVerde.setEditable(false);
		txtfundoVerde.setColumns(10);
		txtfundoVerde.setBackground(new Color(159, 203, 154));
		txtfundoVerde.setBounds(-15, 0, 1939, 1075);
		contentPane.add(txtfundoVerde);
		

		
		
	}
}

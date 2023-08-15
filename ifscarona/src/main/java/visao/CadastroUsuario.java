package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import com.google.protobuf.TextFormat.ParseException;

import javax.swing.ImageIcon;

public class CadastroUsuario extends JFrame {
	
	
	

	private JPanel contentPane;
	private JTextField txtfundoBege;
	private JTextField txtfundoVerde;
	private JLabel lblNewLabel_1;
	private JLabel lbltituloCadastro;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JLabel ifacarona;
	private JLabel lblCadastro;
	private JLabel lblNome;
	private JTextField txtNome;
	private JLabel lblEmail;
	private JTextField txtEmail;
	private JLabel lblDataNascimento;
	private JTextField txtDataNascimento;
	private JLabel lblSenha;
	private JTextField txtSenha;
	private JLabel lblConfirmacaoSenha;
	private JTextField txtConfirmacaoSenha;
	private JButton btnCadastrar;
	private JLabel lblIconeNome;
	private JLabel lblIconeEmail;
	private JLabel lblIconeDataNascimento;
	private JLabel lblIconeSenha;
	private JLabel lblIconeConfiormacaoSenha;
	private JLabel lblPossuiCadastro;
	private JLabel lblLinkAqui;
	private JTextField txtCPF;
	private JLabel lblCPF;
	private JLabel lblIconeCPF;

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
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1940, 1119);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblIconeCPF = new JLabel("New label");
		lblIconeCPF.setIcon(new ImageIcon(CadastroUsuario.class.getResource("/assets/cpf.png")));
		lblIconeCPF.setBounds(944, 267, 59, 71);
		contentPane.add(lblIconeCPF);
		
		lblCPF = new JLabel("CPF:");
		lblCPF.setFont(new Font("Arial", Font.PLAIN, 13));
		lblCPF.setBounds(1013, 255, 122, 14);
		contentPane.add(lblCPF);
		
		txtCPF = new JTextField();
		txtCPF.setToolTipText("");
		txtCPF.setColumns(10);
		txtCPF.setBackground(new Color(255, 251, 233));
		txtCPF.setBounds(1013, 280, 336, 45);
		contentPane.add(txtCPF);
		
		
		lblLinkAqui = new JLabel("Clique aqui");
		lblLinkAqui.setForeground(Color.BLUE);
		lblLinkAqui.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblLinkAqui.setBounds(1120, 734, 178, 14);
		contentPane.add(lblLinkAqui);
		lblLinkAqui.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		      
		        Login  loginFrame = new Login();
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
		lblIconeDataNascimento.setIcon(new ImageIcon(CadastroUsuario.class.getResource("/assets/icons8-data-de-nascimento-60.png")));
		lblIconeDataNascimento.setBounds(944, 512, 59, 60);
		contentPane.add(lblIconeDataNascimento);
		
		lblIconeEmail = new JLabel("New label");
		lblIconeEmail.setIcon(new ImageIcon(CadastroUsuario.class.getResource("/assets/icons8-nova-mensagem-60.png")));
		lblIconeEmail.setBounds(944, 436, 59, 52);
		contentPane.add(lblIconeEmail);
		
		lblIconeNome = new JLabel("New label");
		lblIconeNome.setIcon(new ImageIcon(CadastroUsuario.class.getResource("/assets/icons8-nome-60.png")));
		lblIconeNome.setBounds(944, 362, 59, 45);
		contentPane.add(lblIconeNome);
		
		btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.setBorder(new LineBorder(new Color(244, 234, 213), 4, true));
		btnCadastrar.setBackground(new Color(255, 251, 233));
		btnCadastrar.setBounds(1093, 783, 162, 45);
		contentPane.add(btnCadastrar);
		
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
		
		txtNome = new JTextField();
		txtNome.setToolTipText("");
		txtNome.setColumns(10);
		txtNome.setBackground(new Color(255, 251, 233));
		txtNome.setBounds(1013, 362, 336, 45);
		contentPane.add(txtNome);
		
		lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNome.setBounds(1013, 337, 122, 14);
		contentPane.add(lblNome);
		
		lblCadastro = new JLabel("Cadastro");
		lblCadastro.setFont(new Font("Dialog", Font.BOLD, 53));
		lblCadastro.setBounds(1031, 133, 327, 107);
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
		
	
	    
		

		
		
	}
}

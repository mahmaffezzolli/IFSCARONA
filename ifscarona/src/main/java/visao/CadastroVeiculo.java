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
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class CadastroVeiculo extends JFrame {
	private JPanel contentPane;
	private JTextField txtfundoBege;
	private JTextField txtfundoVerde;
	private JLabel lblCadastroVeiculo;
	private JLabel lblMarca;
	private JTextField txtCPF;
	private JLabel lblModelo;
	private JTextField txtModelo;
	private JTextField txtDataNascimento;
	private JButton btnCadastrar;
	private JLabel lblIconeCor;
	private JLabel lblIconeModelo;
	private JTextField txtCor;
	private JLabel lblCor;
	private JLabel lblIconeMarca;
	private PessoaDAO pDAO = PessoaDAO.getInstancia();
	private JTextField txtPlaca;
	private JLabel lblIconePlaca;
	private JLabel lblLogo;
	private JLabel lblCarro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroVeiculo frame = new CadastroVeiculo();
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
	public CadastroVeiculo() throws ParseException {
		setTitle("Cadastro");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1940, 1119);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox BoxMarca = new JComboBox();
		BoxMarca.setBackground(new Color(255, 251, 233));
		BoxMarca.setModel(new DefaultComboBoxModel(new String[] {"SELECIONE A MARCA ", "AUDI", "BMW", "CAOA CHERRY", "CHEVROLET", "CITROEN", "FIAT", "FORD", "HONDA", "HYUNDAI", "JEEP", "KIA", "LAND ROVER", "MERCEDES-BENZ", "MITSUBISHI", "NISSAN", "PEUGEOT", "PORSCHE", "RENAULT", "TOYOTA", "VOLKSWAGEN", "VOLVO"}));
		BoxMarca.setToolTipText("");
		BoxMarca.setBounds(999, 430, 336, 45);
		contentPane.add(BoxMarca);

		lblCarro = new JLabel("New label");
		lblCarro.setIcon(new ImageIcon(CadastroVeiculo.class.getResource("/assets/car.png")));
		lblCarro.setBounds(101, 297, 170, 151);
		contentPane.add(lblCarro);

		lblLogo = new JLabel("New label");
		lblLogo.setIcon(
				new ImageIcon(CadastroVeiculo.class.getResource("/assets/b1340120-e126-4821-b15c-e3627d2a38a6.png")));
		lblLogo.setBounds(0, 471, 380, 70);
		contentPane.add(lblLogo);

		lblIconePlaca = new JLabel("New label");
		lblIconePlaca.setIcon(new ImageIcon(CadastroVeiculo.class.getResource("/assets/icons8-placa-do-automóvel-60.png")));
		lblIconePlaca.setBounds(930, 227, 59, 45);
		contentPane.add(lblIconePlaca);

		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPlaca.setBounds(999, 202, 122, 14);
		contentPane.add(lblPlaca);

		txtPlaca = new JTextField();
		txtPlaca.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPlaca.setToolTipText("");
		txtPlaca.setColumns(10);
		txtPlaca.setBackground(new Color(255, 251, 233));
		txtPlaca.setBounds(999, 225, 336, 45);
		contentPane.add(txtPlaca);

		lblIconeMarca = new JLabel("New label");
		lblIconeMarca.setIcon(new ImageIcon(CadastroVeiculo.class.getResource("/assets/marca.png")));
		lblIconeMarca.setBounds(930, 417, 51, 71);
		contentPane.add(lblIconeMarca);

		lblCor = new JLabel("Cor:");
		lblCor.setFont(new Font("Arial", Font.PLAIN, 15));
		lblCor.setBounds(999, 297, 122, 14);
		contentPane.add(lblCor);

		txtCor = new JTextField();
		txtCor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCor.setToolTipText("");
		txtCor.setColumns(10);
		txtCor.setBackground(new Color(255, 251, 233));
		txtCor.setBounds(999, 322, 336, 45);
		contentPane.add(txtCor);

		lblIconeModelo = new JLabel("New label");
		lblIconeModelo.setIcon(new ImageIcon(CadastroVeiculo.class.getResource("/assets/MODELO.png")));
		lblIconeModelo.setBounds(930, 529, 59, 52);
		contentPane.add(lblIconeModelo);

		lblIconeCor = new JLabel("New label");
		lblIconeCor.setIcon(new ImageIcon(CadastroVeiculo.class.getResource("/assets/cor.png")));
		lblIconeCor.setBounds(930, 324, 59, 45);
		contentPane.add(lblIconeCor);

		btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.setBorder(new LineBorder(new Color(244, 234, 213), 4, true));
		btnCadastrar.setBackground(new Color(255, 251, 233));
		btnCadastrar.setBounds(1066, 647, 178, 54);
		contentPane.add(btnCadastrar);

		btnCadastrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Pessoa p = new Pessoa();

				String nome = txtPlaca.getText();
				String sobrenome = txtCor.getText();
				String cpfS = String.valueOf(txtCPF.getText());
				String email = txtModelo.getText();
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

				} else if (dataNascimento == null) {
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

		txtDataNascimento = new JTextField();
		/*****************/
		MaskFormatter mascaraData = null;
		mascaraData = new MaskFormatter("##/##/####");

		txtModelo = new JTextField();
		txtModelo.setToolTipText("");
		txtModelo.setColumns(10);
		txtModelo.setBackground(new Color(255, 251, 233));
		txtModelo.setBounds(999, 533, 336, 45);
		contentPane.add(txtModelo);

		lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Arial", Font.PLAIN, 15));
		lblModelo.setBounds(999, 509, 147, 14);
		contentPane.add(lblModelo);

		txtCPF = new JTextField();
		/*****************/
		MaskFormatter mascaraCPF = null;
		mascaraCPF = new MaskFormatter("###.###.###-##");

		lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Arial", Font.PLAIN, 15));
		lblMarca.setBounds(999, 397, 122, 14);
		contentPane.add(lblMarca);

		lblCadastroVeiculo = new JLabel("Cadastro Veículo");
		lblCadastroVeiculo.setFont(new Font("Dialog", Font.BOLD, 53));
		lblCadastroVeiculo.setBounds(951, 65, 461, 107);
		contentPane.add(lblCadastroVeiculo);

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
		txtfundoVerde.setBounds(111, -2, 1939, 1106);
		contentPane.add(txtfundoVerde);
	}
}

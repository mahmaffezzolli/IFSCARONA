package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import controle.VeiculoDAO;
import modelo.Sessao;
import modelo.Veiculo;

public class CadastroVeiculo extends JFrame {

	private JPanel contentPane;
	private JTextField txtfundoBege;
	private JTextField txtfundoVerde;
	private JLabel lblCadastroVeiculo;
	private JLabel lblMarca;
	private JLabel lblModelo;
	private JTextField txtModelo;
	private JButton btnCadastrarVeiculo;
	private JLabel lblIconeCor;
	private JLabel lblIconeModelo;
	private JLabel lblCor;
	private VeiculoDAO vDAO = VeiculoDAO.getInstancia();
	private JLabel lblIconeMarca;
	private JTextField txtPlaca;
	private JLabel lblIconePlaca;
	private JLabel lblLogo;
	private JLabel lblCarro;
	private JButton btnCancelarVeiculo;
	private JComboBox<String> BoxCor;
	private JTextField textCpf;

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

		JLabel lblIconeCPF = new JLabel("");
		lblIconeCPF.setIcon(new ImageIcon(CadastroVeiculo.class.getResource("/assets/cpf.png")));
		lblIconeCPF.setBounds(930, 608, 59, 65);
		contentPane.add(lblIconeCPF);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Arial", Font.PLAIN, 15));
		lblCpf.setBounds(999, 589, 147, 14);
		contentPane.add(lblCpf);

		textCpf = new JTextField();
		textCpf.setColumns(10);
		textCpf.setBackground(new Color(255, 251, 233));
		textCpf.setBounds(999, 616, 336, 45);
		contentPane.add(textCpf);

		BoxCor = new JComboBox<String>();
		BoxCor.setModel(new DefaultComboBoxModel(new String[] { "SELECIONE A COR", "Branco\t", "Cinza\t", "Preto\t",
				"Prata\t", "Azul\t", "Vermelho", "Marrom/Bege", "Verde\t", "Amarelo\t" }));
		BoxCor.setToolTipText("");
		BoxCor.setBackground(new Color(255, 251, 233));
		BoxCor.setBounds(999, 322, 336, 45);
		contentPane.add(BoxCor);

		btnCancelarVeiculo = new JButton("CANCELAR");
		btnCancelarVeiculo.setBorder(new LineBorder(new Color(255, 128, 128), 4, true));
		btnCancelarVeiculo.setFont(new Font("Arial", Font.PLAIN, 13));
		btnCancelarVeiculo.setForeground(new Color(0, 0, 0));
		btnCancelarVeiculo.setBackground(new Color(255, 251, 233));
		btnCancelarVeiculo.setBounds(1179, 706, 178, 54);
		contentPane.add(btnCancelarVeiculo);
		btnCancelarVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Crie uma instância da tela de Cancelar e a torne visível
				Cancelar telaCancelar = new Cancelar();
				telaCancelar.setVisible(true);
			}
		});

		JComboBox<String> BoxMarca = new JComboBox<String>();
		BoxMarca.setBackground(new Color(255, 251, 233));
		BoxMarca.setModel(
				new DefaultComboBoxModel(new String[] { "SELECIONE A MARCA ", "AUDI", "BMW", "CAOA CHERRY", "CHEVROLET",
						"CITROEN", "FIAT", "FORD", "HONDA", "HYUNDAI", "JEEP", "KIA", "LAND ROVER", "MERCEDES-BENZ",
						"MITSUBISHI", "NISSAN", "PEUGEOT", "PORSCHE", "RENAULT", "TOYOTA", "VOLKSWAGEN", "VOLVO" }));
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
		lblIconePlaca
				.setIcon(new ImageIcon(CadastroVeiculo.class.getResource("/assets/icons8-placa-do-automóvel-60.png")));
		lblIconePlaca.setBounds(930, 227, 59, 45);
		contentPane.add(lblIconePlaca);

		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPlaca.setBounds(999, 202, 122, 14);
		contentPane.add(lblPlaca);

		txtPlaca = new JTextField();
		/*****************/
		MaskFormatter mascaraPlaca = null;
		mascaraPlaca = new MaskFormatter("*******");
		txtPlaca = new JFormattedTextField(mascaraPlaca);
		/*****************/
		txtPlaca.setFont(new Font("Nirmala UI", Font.PLAIN, 16));
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

		lblIconeModelo = new JLabel("New label");
		lblIconeModelo.setIcon(new ImageIcon(CadastroVeiculo.class.getResource("/assets/MODELO.png")));
		lblIconeModelo.setBounds(930, 529, 59, 52);
		contentPane.add(lblIconeModelo);

		lblIconeCor = new JLabel("New label");
		lblIconeCor.setIcon(new ImageIcon(CadastroVeiculo.class.getResource("/assets/cor.png")));
		lblIconeCor.setBounds(930, 315, 59, 54);
		contentPane.add(lblIconeCor);

		btnCadastrarVeiculo = new JButton("CADASTRAR");
		btnCadastrarVeiculo.setForeground(new Color(0, 0, 0));
		btnCadastrarVeiculo.setFont(new Font("Arial", Font.PLAIN, 13));
		btnCadastrarVeiculo.setBorder(new LineBorder(new Color(244, 234, 213), 4, true));
		btnCadastrarVeiculo.setBackground(new Color(255, 251, 233));
		btnCadastrarVeiculo.setBounds(950, 706, 178, 54);
		contentPane.add(btnCadastrarVeiculo);

		btnCadastrarVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Veiculo v = new Veiculo();

				CampoNaoPreenchido campoNaoPreenchido = new CampoNaoPreenchido();

				String cpf = String.valueOf(textCpf.getText());
				String placa = txtPlaca.getText();
				String modelo = txtModelo.getText();
				String cor = (String) BoxCor.getSelectedItem();
				String marca = (String) BoxMarca.getSelectedItem();

				if (placa.isEmpty()) {
					campoNaoPreenchido.setVisible(true);

				} else if (modelo.isEmpty()) {
					campoNaoPreenchido.setVisible(true);
					
				} else if (marca.isEmpty()) {
					campoNaoPreenchido.setVisible(true);	
					
				} else if (cor.isEmpty()) {
					campoNaoPreenchido.setVisible(true);
					
				} else if (cpf.isEmpty()) {
					campoNaoPreenchido.setVisible(true);
					
				} else {

					v.setMotorista(Sessao.getPessoaLogada());

					v.setCor(cor);
					v.setModelo(modelo);
					v.setPlaca(placa);
					v.setMarca(marca);

					Long success = vDAO.cadastrarVeiculo(v);
					v.setIdVeiculo(success);

					if (success > 0) {
						CadastroRealizado cadastroRealizado = new CadastroRealizado();
						cadastroRealizado.setVisible(true);

					} else {
						CadastroErroVeiculo cadastroErroVeiculo = new CadastroErroVeiculo();
						cadastroErroVeiculo.setVisible(true);
					}
				}
			}
		});

		txtModelo = new JTextField();
		txtModelo.setColumns(10);
		txtModelo.setBackground(new Color(255, 251, 233));
		txtModelo.setBounds(999, 533, 336, 45);
		contentPane.add(txtModelo);

		lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Arial", Font.PLAIN, 15));
		lblModelo.setBounds(999, 509, 147, 14);
		contentPane.add(lblModelo);

		lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Arial", Font.PLAIN, 15));
		lblMarca.setBounds(999, 397, 122, 14);
		contentPane.add(lblMarca);

		lblCadastroVeiculo = new JLabel("Cadastro de Veículo");
		lblCadastroVeiculo.setFont(new Font("Dialog", Font.BOLD, 53));
		lblCadastroVeiculo.setBounds(930, 58, 514, 107);
		contentPane.add(lblCadastroVeiculo);

		JButton btnHome = new JButton("");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal principal = new Principal();
				principal.setVisible(true);

				dispose();

			}
		});

		btnHome.setBorder(null);
		btnHome.setForeground(new Color(0, 0, 0));
		btnHome.setBackground(new Color(244, 234, 214));
		btnHome.setIcon(new ImageIcon(Perfil.class.getResource("/assets/home.png")));
		btnHome.setBounds(165, 773, 75, 65);
		contentPane.add(btnHome);

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
		txtfundoVerde.setBounds(-25, -2, 1939, 1106);
		contentPane.add(txtfundoVerde);

		textCpf.setText(Sessao.getPessoaLogada().getCpf().toString());
		textCpf.setEditable(false);
		textCpf.setBackground(Color.gray);
	}
}

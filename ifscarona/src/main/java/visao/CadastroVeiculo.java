package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
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
import controle.PessoaDAO;
import controle.VeiculoDAO;
import modelo.Carro;
import modelo.Pessoa;
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
	private PessoaDAO pDAO = PessoaDAO.getInstancia();
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

		JLabel lblIconeCPF = new JLabel("");
		lblIconeCPF.setIcon(new ImageIcon(CadastroVeiculo.class.getResource("/assets/cpf.png")));
		lblIconeCPF.setBounds(929, 669, 59, 65);
		contentPane.add(lblIconeCPF);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Nirmala UI", Font.PLAIN, 18));
		lblCpf.setBounds(998, 650, 147, 25);
		contentPane.add(lblCpf);

		textCpf = new JTextField();
		textCpf.setFont(new Font("Dialog", Font.PLAIN, 15));
		textCpf.setBackground(new Color(244, 234, 213));
		textCpf.setColumns(10);
		textCpf.setBounds(998, 686, 336, 45);
		contentPane.add(textCpf);

		BoxCor = new JComboBox<String>();
		BoxCor.setFont(new Font("Dialog", Font.PLAIN, 15));
		BoxCor.setModel(new DefaultComboBoxModel(new String[] { "SELECIONE A COR", "Branco\t", "Cinza\t", "Preto\t",
				"Prata\t", "Azul\t", "Vermelho", "Marrom/Bege", "Verde\t", "Amarelo\t" }));
		BoxCor.setToolTipText("");
		BoxCor.setBackground(new Color(255, 251, 233));
		BoxCor.setBounds(998, 383, 336, 45);
		contentPane.add(BoxCor);

		btnCancelarVeiculo = new JButton("CANCELAR");
		btnCancelarVeiculo.setBorder(new LineBorder(new Color(255, 128, 128), 4, true));
		btnCancelarVeiculo.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnCancelarVeiculo.setForeground(new Color(0, 0, 0));
		btnCancelarVeiculo.setBackground(new Color(255, 251, 233));
		btnCancelarVeiculo.setBounds(1177, 784, 178, 54);
		contentPane.add(btnCancelarVeiculo);
		btnCancelarVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Crie uma instância da tela de Cancelar e a torne visível
				Cancelar telaCancelar = new Cancelar();
				telaCancelar.setBounds(40, 40, 451, 234);
				telaCancelar.setLocationRelativeTo(null);
				telaCancelar.setVisible(true);
			}
		});

		JComboBox<String> BoxMarca = new JComboBox<String>();
		BoxMarca.setFont(new Font("Dialog", Font.PLAIN, 15));
		BoxMarca.setBackground(new Color(255, 251, 233));
		BoxMarca.setModel(
				new DefaultComboBoxModel(new String[] { "SELECIONE A MARCA ", "AUDI", "BMW", "CAOA CHERRY", "CHEVROLET",
						"CITROEN", "FIAT", "FORD", "HONDA", "HYUNDAI", "JEEP", "KIA", "LAND ROVER", "MERCEDES-BENZ",
						"MITSUBISHI", "NISSAN", "PEUGEOT", "PORSCHE", "RENAULT", "TOYOTA", "VOLKSWAGEN", "VOLVO" }));
		BoxMarca.setToolTipText("");
		BoxMarca.setBounds(998, 486, 336, 45);
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
		lblIconePlaca.setBounds(930, 286, 59, 45);
		contentPane.add(lblIconePlaca);

		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setFont(new Font("Nirmala UI", Font.PLAIN, 18));
		lblPlaca.setBounds(1000, 250, 60, 25);
		contentPane.add(lblPlaca);

		txtPlaca = new JTextField();
		/*****************/
		MaskFormatter mascaraPlaca = null;
		mascaraPlaca = new MaskFormatter("*******");
		txtPlaca = new JFormattedTextField(mascaraPlaca);
		/*****************/

		txtPlaca.setFont(new Font("Dialog", Font.PLAIN, 15));
		txtPlaca.setToolTipText("");
		txtPlaca.setColumns(10);
		txtPlaca.setBackground(new Color(255, 251, 233));
		txtPlaca.setBounds(1000, 290, 336, 45);
		contentPane.add(txtPlaca);

		lblIconeMarca = new JLabel("New label");
		lblIconeMarca.setIcon(new ImageIcon(CadastroVeiculo.class.getResource("/assets/marca.png")));
		lblIconeMarca.setBounds(937, 479, 51, 65);
		contentPane.add(lblIconeMarca);

		lblCor = new JLabel("Cor:");
		lblCor.setFont(new Font("Nirmala UI", Font.PLAIN, 18));
		lblCor.setBounds(1000, 350, 122, 25);
		contentPane.add(lblCor);

		lblIconeModelo = new JLabel("New label");
		lblIconeModelo.setIcon(new ImageIcon(CadastroVeiculo.class.getResource("/assets/MODELO.png")));
		lblIconeModelo.setBounds(929, 582, 59, 52);
		contentPane.add(lblIconeModelo);

		lblIconeCor = new JLabel("New label");
		lblIconeCor.setIcon(new ImageIcon(CadastroVeiculo.class.getResource("/assets/cor.png")));
		lblIconeCor.setBounds(929, 378, 59, 54);
		contentPane.add(lblIconeCor);

		btnCadastrarVeiculo = new JButton("CADASTRAR");
		btnCadastrarVeiculo.setForeground(new Color(0, 0, 0));
		btnCadastrarVeiculo.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnCadastrarVeiculo.setBorder(new LineBorder(new Color(244, 234, 213), 4, true));
		btnCadastrarVeiculo.setBackground(new Color(255, 251, 233));
		btnCadastrarVeiculo.setBounds(950, 784, 178, 54);
		contentPane.add(btnCadastrarVeiculo);

		btnCadastrarVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Carro v = new Carro();

				CampoNaoPreenchido campoNaoPreenchido = new CampoNaoPreenchido();

				String cpf = String.valueOf(textCpf.getText());
				String placa = txtPlaca.getText().replaceAll("[^a-zA-Z0-9]", "");
				String modelo = txtModelo.getText();
				String cor = (String) BoxCor.getSelectedItem();
				String marca = (String) BoxMarca.getSelectedItem();

				if (placa.length() != 7) {
					CaracteresVeiculo caracteresVeiculo = new CaracteresVeiculo();
					caracteresVeiculo.setVisible(true);
					return;
				}

				if (placa.isEmpty()) {
					campoNaoPreenchido.setBounds(40, 40, 451, 234);
					campoNaoPreenchido.setLocationRelativeTo(null);
					campoNaoPreenchido.setVisible(true);

				} else if (modelo.isEmpty()) {
					campoNaoPreenchido.setBounds(40, 40, 451, 234);
					campoNaoPreenchido.setLocationRelativeTo(null);
					campoNaoPreenchido.setVisible(true);

				} else if (marca.isEmpty()) {
					campoNaoPreenchido.setBounds(40, 40, 451, 234);
					campoNaoPreenchido.setLocationRelativeTo(null);
					campoNaoPreenchido.setVisible(true);

				} else if (cor.isEmpty()) {
					campoNaoPreenchido.setBounds(40, 40, 451, 234);
					campoNaoPreenchido.setLocationRelativeTo(null);
					campoNaoPreenchido.setVisible(true);

				} else if (cpf.isEmpty()) {
					campoNaoPreenchido.setBounds(40, 40, 451, 234);
					campoNaoPreenchido.setLocationRelativeTo(null);
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

						Pessoa motorista = Sessao.getPessoaLogada();

						motorista.setVeiculo(v);
						pDAO.alterarPessoa(motorista);

						txtPlaca.setText("");
						txtModelo.setText("");
						BoxCor.setSelectedIndex(0);
						BoxMarca.setSelectedIndex(0);

						CadastroVeiculo.this.dispose();
						try {
							new Perfil().setVisible(true);
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						CadastroRealizado cadastroRealizado = new CadastroRealizado();
						cadastroRealizado.setBounds(40, 40, 451, 234);
						cadastroRealizado.setLocationRelativeTo(null);
						cadastroRealizado.setVisible(true);

					} else {
						CadastroErroVeiculo cadastroErroVeiculo = new CadastroErroVeiculo();
						cadastroErroVeiculo.setBounds(40, 40, 451, 234);
						cadastroErroVeiculo.setLocationRelativeTo(null);
						cadastroErroVeiculo.setVisible(true);
					}
				}
			}
		});

		txtModelo = new JTextField();
		txtModelo.setFont(new Font("Dialog", Font.PLAIN, 15));
		txtModelo.setColumns(10);
		txtModelo.setBackground(new Color(255, 251, 233));
		txtModelo.setBounds(998, 586, 336, 45);
		contentPane.add(txtModelo);

		lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Nirmala UI", Font.PLAIN, 18));
		lblModelo.setBounds(998, 550, 147, 25);
		contentPane.add(lblModelo);

		lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Nirmala UI", Font.PLAIN, 18));
		lblMarca.setBounds(998, 450, 122, 25);
		contentPane.add(lblMarca);

		lblCadastroVeiculo = new JLabel("Cadastro de Veículo");
		lblCadastroVeiculo.setFont(new Font("Dialog", Font.BOLD, 53));
		lblCadastroVeiculo.setBounds(868, 58, 698, 107);
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
	}
}

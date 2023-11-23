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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import controle.PessoaDAO;
import controle.VeiculoDAO;
import modelo.Carro;
import modelo.Pessoa;
import modelo.Sessao;

public class Perfil extends JFrame {

	private JPanel contentPane;
	private JTextField txtSobrenome;
	private JTextField txtEmail;
	private JTextField txtCPF;
	private JTextField txtNome;
	private JTextField txtData;
	private PessoaDAO pDAO = PessoaDAO.getInstancia();
	private VeiculoDAO vDAO = VeiculoDAO.getInstancia();
	private JTextField textField;
	private JTextField txtPlaca;
	private JTextField txtModelo;
	private JTextField txtCor;
	private JTextField txtMarca;
	private JTextField txtCPF2;
	private JButton btnSalvar, btnExcluir, btnSalvarV;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Perfil frame = new Perfil();
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
	 * 
	 * @throws ParseException
	 */
	public Perfil() throws ParseException {
		
		java.net.URL caminhoIcone = getClass().getResource("/assets/janelaIcon.png");
		Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminhoIcone);
		this.setIconImage(iconeTitulo);
		
		Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, 1935, 1049);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 251, 233));
		contentPane.setBorder(new LineBorder(new Color(255, 251, 233), 2, true));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnHome = new JButton("");
		btnHome.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        Principal principal = new Principal();
		        principal.setVisible(true);
		        dispose();
		    }
		});
		btnHome.setBorderPainted(false);
		btnHome.setContentAreaFilled(false);
		btnHome.setFocusPainted(false);
		btnHome.setIcon(new ImageIcon(Perfil.class.getResource("/assets/home.png")));
		btnHome.setBounds(128, 758, 75, 65);
		contentPane.add(btnHome);

		JButton btnLogOut = new JButton("");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Sessao.setPessoaLogada(null);
				dispose();
				Inicio inicio = new Inicio();
				inicio.setVisible(true);
			}
		});

		btnLogOut.setBorder(null);
		btnLogOut.setBackground(new Color(159, 203, 153));
		btnLogOut.setIcon(new ImageIcon(Perfil.class.getResource("/assets/Log-out.png")));
		btnLogOut.setBounds(140, 859, 75, 65);
		contentPane.add(btnLogOut);

		txtSobrenome = new JTextField();
		txtSobrenome.setEnabled(false);
		txtSobrenome.setEditable(false);
		txtSobrenome.setBounds(695, 299, 300, 40);
		txtSobrenome.setFont(new Font("Nirmala UI", Font.PLAIN, 13));
		contentPane.add(txtSobrenome);
		txtSobrenome.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(530, 238, 101, 20);
		lblNome.setFont(new Font("Nirmala UI", Font.PLAIN, 25));
		contentPane.add(lblNome);

		JLabel lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setBounds(530, 304, 204, 20);
		lblSobrenome.setFont(new Font("Nirmala UI", Font.PLAIN, 25));
		contentPane.add(lblSobrenome);

		txtEmail = new JTextField();
		txtEmail.setEnabled(false);
		txtEmail.setEditable(false);
		txtEmail.setBounds(695, 368, 300, 40);
		txtEmail.setFont(new Font("Nirmala UI", Font.PLAIN, 13));
		txtEmail.setColumns(10);
		contentPane.add(txtEmail);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(530, 373, 84, 20);
		lblEmail.setFont(new Font("Nirmala UI", Font.PLAIN, 25));
		contentPane.add(lblEmail);

		txtCPF = new JTextField();
		/*****************/
		MaskFormatter mascaraCPF = null;
		mascaraCPF = new MaskFormatter("###.###.###-##");
		txtCPF = new JFormattedTextField(mascaraCPF);
		/*****************/
		txtCPF.setEnabled(false);
		txtCPF.setEditable(false);
		txtCPF.setBounds(695, 441, 300, 40);
		txtCPF.setFont(new Font("Nirmala UI", Font.PLAIN, 13));
		txtCPF.setColumns(10);
		contentPane.add(txtCPF);

		txtNome = new JTextField();
		txtNome.setEnabled(false);
		txtNome.setEditable(false);
		txtNome.setBounds(695, 233, 300, 40);
		txtNome.setFont(new Font("Nirmala UI", Font.PLAIN, 13));
		txtNome.setColumns(10);
		contentPane.add(txtNome);

		txtData = new JTextField();
		txtData.setEditable(false);
		txtData.setEnabled(false);
		txtData.setBounds(695, 512, 300, 40);
		txtData.setFont(new Font("Nirmala UI", Font.PLAIN, 13));
		txtData.setColumns(10);
		contentPane.add(txtData);

		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setBounds(530, 446, 59, 20);
		lblCPF.setFont(new Font("Nirmala UI", Font.PLAIN, 25));
		contentPane.add(lblCPF);

		JLabel lblData = new JLabel("Nascimento:");
		lblData.setBounds(530, 513, 194, 29);
		lblData.setFont(new Font("Nirmala UI", Font.PLAIN, 25));
		contentPane.add(lblData);

		JLabel lblIcon = new JLabel("");
		lblIcon.setIcon(new ImageIcon(Perfil.class.getResource("/assets/perfil.png")));
		lblIcon.setBounds(55, 80, 300, 273);
		contentPane.add(lblIcon);

		textField = new JTextField();
		textField.setBorder(null);
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(new Color(159, 203, 154));
		textField.setBounds(0, -31, 410, 1061);
		contentPane.add(textField);

		JLabel lblDados = new JLabel("Dados Pessoais");
		lblDados.setFont(new Font("Dialog", Font.BOLD, 40));
		lblDados.setBounds(619, 77, 376, 81);
		contentPane.add(lblDados);

		JLabel lblVeiculo = new JLabel("Veículo");
		lblVeiculo.setFont(new Font("Dialog", Font.BOLD, 40));
		lblVeiculo.setBounds(1437, 87, 239, 61);
		contentPane.add(lblVeiculo);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(1117, 108, 9, 778);
		contentPane.add(separator);

		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setFont(new Font("Nirmala UI", Font.PLAIN, 25));
		lblPlaca.setBounds(1271, 238, 77, 20);
		contentPane.add(lblPlaca);

		txtPlaca = new JTextField();
		txtPlaca.setEnabled(false);
		txtPlaca.setEditable(false);
		txtPlaca.setFont(new Font("Nirmala UI", Font.PLAIN, 13));
		txtPlaca.setColumns(10);
		txtPlaca.setBounds(1411, 233, 294, 40);
		contentPane.add(txtPlaca);

		JLabel lblCor = new JLabel("Cor:");
		lblCor.setFont(new Font("Nirmala UI", Font.PLAIN, 25));
		lblCor.setBounds(1271, 304, 108, 20);
		contentPane.add(lblCor);

		txtModelo = new JTextField();
		txtModelo.setEnabled(false);
		txtModelo.setEditable(false);
		txtModelo.setFont(new Font("Nirmala UI", Font.PLAIN, 13));
		txtModelo.setColumns(10);
		txtModelo.setBounds(1411, 441, 300, 40);
		contentPane.add(txtModelo);

		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Nirmala UI", Font.PLAIN, 25));
		lblMarca.setBounds(1271, 373, 132, 20);
		contentPane.add(lblMarca);

		txtCor = new JTextField();
		txtCor.setEnabled(false);
		txtCor.setEditable(false);
		txtCor.setFont(new Font("Nirmala UI", Font.PLAIN, 13));
		txtCor.setColumns(10);
		txtCor.setBounds(1411, 299, 300, 40);
		contentPane.add(txtCor);

		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Nirmala UI", Font.PLAIN, 25));
		lblModelo.setBounds(1271, 446, 132, 20);
		contentPane.add(lblModelo);

		txtMarca = new JTextField();
		txtMarca.setEnabled(false);
		txtMarca.setEditable(false);
		txtMarca.setFont(new Font("Nirmala UI", Font.PLAIN, 13));
		txtMarca.setColumns(10);
		txtMarca.setBounds(1411, 368, 300, 40);
		contentPane.add(txtMarca);

		btnSalvar = new JButton("Editar");
		btnSalvar.setIcon(new ImageIcon(Perfil.class.getResource("/assets/icons8-editar-50.png")));
		btnSalvar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				editarPessoa();

			}
		});

		btnSalvar.setBackground(new Color(192, 192, 192));
		btnSalvar.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		btnSalvar.setBounds(579, 665, 145, 53);
		contentPane.add(btnSalvar);

		btnExcluir = new JButton("Excluir");
		btnExcluir.setIcon(new ImageIcon(Perfil.class.getResource("/assets/icons8-excluir-60.png")));
		btnExcluir.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				TelaExcluirVeiculo TelaExcluirVeiculo = new TelaExcluirVeiculo();
				TelaExcluirVeiculo.setVisible(true);

			}
		});

		btnExcluir.setBackground(new Color(255, 182, 193));
		btnExcluir.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnExcluir.setBounds(1666, 665, 145, 53);
		contentPane.add(btnExcluir);

		btnSalvarV = new JButton("Editar");
		btnSalvarV.setIcon(new ImageIcon(Perfil.class.getResource("/assets/icons8-editar-50.png")));
		btnSalvarV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				editarVeiculo();
			}
		});

		btnSalvarV.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		btnSalvarV.setBackground(new Color(186, 189, 182));
		btnSalvarV.setBounds(1314, 665, 151, 53);
		contentPane.add(btnSalvarV);

		JButton btnExcluirV = new JButton("Excluir");
		btnExcluirV.setIcon(new ImageIcon(Perfil.class.getResource("/assets/icons8-excluir-60.png")));
		btnExcluirV.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				TelaExcluirConta TelaExcluirConta = new TelaExcluirConta();
				TelaExcluirConta.setVisible(true);

				dispose();
			
			}
		});
		btnExcluirV.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnExcluirV.setBackground(new Color(255, 182, 193));
		btnExcluirV.setBounds(850, 665, 145, 53);
		contentPane.add(btnExcluirV);

		JButton btnAddVeiculo = new JButton("Adicionar");
		btnAddVeiculo.setIcon(new ImageIcon(Perfil.class.getResource("/assets/icons8-add-car-48.png")));
		btnAddVeiculo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					new CadastroVeiculo().setVisible(true);

					dispose();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});

		btnAddVeiculo.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		btnAddVeiculo.setBackground(new Color(181, 239, 126));
		btnAddVeiculo.setBounds(1519, 785, 157, 53);
		contentPane.add(btnAddVeiculo);

		JLabel lbCPF = new JLabel("CPF:");
		lbCPF.setFont(new Font("Nirmala UI", Font.PLAIN, 25));
		lbCPF.setBounds(1271, 512, 94, 20);
		contentPane.add(lbCPF);

		txtCPF2 = new JTextField();
		/*****************/
		MaskFormatter mascaraCPF2 = null;
		mascaraCPF2 = new MaskFormatter("###.###.###-##");
		txtCPF2 = new JFormattedTextField(mascaraCPF2);
		/*****************/
		txtCPF2.setFont(new Font("Nirmala UI", Font.PLAIN, 13));
		txtCPF2.setEnabled(false);
		txtCPF2.setEditable(false);
		txtCPF2.setColumns(10);
		txtCPF2.setBounds(1411, 512, 300, 40);
		contentPane.add(txtCPF2);

		Pessoa pessoaLogada = Sessao.getPessoaLogada();

		if (pessoaLogada != null) {
			txtSobrenome.setText(pessoaLogada.getSobrenome());
			txtEmail.setText(pessoaLogada.getEmail());
			txtNome.setText(pessoaLogada.getNome());
			txtCPF.setText(String.valueOf(pessoaLogada.getCpf()));
			txtData.setText(String.valueOf(pessoaLogada.getDataNasc()));

		}

		Carro veiculoLogado = vDAO.conexaoVeiculoPessoa(pessoaLogada);

		if (veiculoLogado != null) {
			txtPlaca.setText(veiculoLogado.getPlaca());
			txtCor.setText(veiculoLogado.getCor());
			txtMarca.setText(veiculoLogado.getMarca());
			txtModelo.setText(veiculoLogado.getModelo());
			txtCPF2.setText(String.valueOf(Sessao.getPessoaLogada().getCpf()));

			btnAddVeiculo.setEnabled(false);
		}

	}

	public void editarPessoa() {
		if (btnSalvar.getText().equals("Editar")) {

			txtNome.setEnabled(true);
			txtNome.setEditable(true);
			txtSobrenome.setEnabled(true);
			txtSobrenome.setEditable(true);
			btnSalvar.setText("Salvar");

		} else if (btnSalvar.getText().equals("Salvar")) {

			Pessoa pessoaLogada = Sessao.getPessoaLogada();

			pessoaLogada.setNome(txtNome.getText());
			pessoaLogada.setSobrenome(txtSobrenome.getText());

			boolean success = pDAO.alterarPessoa(pessoaLogada);

			if (success) {
				DadosAtualizados dadosAtualizados = new DadosAtualizados();
				dadosAtualizados.setVisible(true);
			} else {
				ErroAoAtualizar erroAoAtualizar = new ErroAoAtualizar();
				erroAoAtualizar.setVisible(true);
			}

			txtNome.setEnabled(false);
			txtNome.setEditable(false);
			txtSobrenome.setEnabled(false);
			txtSobrenome.setEditable(false);

			btnSalvar.setText("Editar");
		}
	}

	public void editarVeiculo() {

		if (btnSalvarV.getText().equals("Editar")) {

			txtPlaca.setEnabled(true);
			txtPlaca.setEditable(true);
			txtCor.setEditable(true);
			txtCor.setEnabled(true);
			txtMarca.setEditable(true);
			txtMarca.setEnabled(true);
			txtModelo.setEditable(true);
			txtModelo.setEnabled(true);

			btnSalvarV.setText("Salvar");

		} else if (btnSalvarV.getText().equals("Salvar")) {

			Carro veiculoLogado = vDAO.conexaoVeiculoPessoa(Sessao.getPessoaLogada());

			if (veiculoLogado != null && veiculoLogado.getMotorista() != null) {

				veiculoLogado.setPlaca(txtPlaca.getText());
				veiculoLogado.setCor(txtCor.getText());
				veiculoLogado.setMarca(txtMarca.getText());
				veiculoLogado.setModelo(txtModelo.getText());

				boolean success = vDAO.alterarVeiculo(veiculoLogado);

				if (success) {
					DadosAtualizados dadosAtualizados = new DadosAtualizados();
					dadosAtualizados.setVisible(true);
				} else {
					ErroAoAtualizar erroAoAtualizar = new ErroAoAtualizar();
					erroAoAtualizar.setVisible(true);
				}

			} else {
				System.out.println("Pessoa é null");
			}

			txtPlaca.setEnabled(false);
			txtPlaca.setEditable(false);
			txtCor.setEnabled(false);
			txtCor.setEditable(false);
			txtMarca.setEditable(false);
			txtMarca.setEnabled(false);
			txtModelo.setEditable(false);
			txtModelo.setEnabled(false);
			txtCPF2.setEditable(false);
			txtCPF2.setEnabled(false);
			btnSalvarV.setText("Editar");
		}
	}

}

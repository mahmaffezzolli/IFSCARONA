package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controle.PessoaDAO;
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
	private JTextField textField;
	private JTextField txtPlaca;
	private JTextField txtModelo;
	private JTextField txtCor;
	private JTextField txtMarca;

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
	 */
	public Perfil() {
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
				dispose();
				Principal principal = new Principal();
				principal.setVisible(true);
			}
		});

		btnHome.setBorder(null);
		btnHome.setForeground(new Color(0, 0, 0));
		btnHome.setBackground(new Color(159, 203, 153));
		btnHome.setIcon(new ImageIcon(Perfil.class.getResource("/assets/home.png")));
		btnHome.setBounds(165, 640, 75, 65);
		contentPane.add(btnHome);

		JButton btnLogOut = new JButton("");

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
		btnLogOut.setBounds(165, 858, 75, 65);
		contentPane.add(btnLogOut);

		txtSobrenome = new JTextField();
		txtSobrenome.setEnabled(false);
		txtSobrenome.setEditable(false);
		txtSobrenome.setBounds(695, 299, 300, 40);
		txtSobrenome.setFont(new Font("Nirmala UI", Font.PLAIN, 13));
		contentPane.add(txtSobrenome);
		txtSobrenome.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(547, 238, 77, 20);
		lblNome.setFont(new Font("Nirmala UI", Font.PLAIN, 25));
		contentPane.add(lblNome);

		JLabel lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setBounds(547, 304, 138, 20);
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
		lblEmail.setBounds(547, 373, 84, 20);
		lblEmail.setFont(new Font("Nirmala UI", Font.PLAIN, 25));
		contentPane.add(lblEmail);

		txtCPF = new JTextField();
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
		lblCPF.setBounds(547, 446, 59, 20);
		lblCPF.setFont(new Font("Nirmala UI", Font.PLAIN, 25));
		contentPane.add(lblCPF);

		JLabel lblData = new JLabel("Nascimento:");
		lblData.setBounds(547, 513, 138, 29);
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
		lblDados.setBounds(619, 77, 317, 81);
		contentPane.add(lblDados);

		JLabel lblVeiculo = new JLabel("Veículo");
		lblVeiculo.setFont(new Font("Dialog", Font.BOLD, 40));
		lblVeiculo.setBounds(1437, 87, 145, 61);
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
		txtPlaca.setFont(new Font("Nirmala UI", Font.PLAIN, 13));
		txtPlaca.setColumns(10);
		txtPlaca.setBounds(1411, 233, 294, 40);
		contentPane.add(txtPlaca);

		JLabel lblCor = new JLabel("Cor:");
		lblCor.setFont(new Font("Nirmala UI", Font.PLAIN, 25));
		lblCor.setBounds(1271, 304, 108, 20);
		contentPane.add(lblCor);

		txtModelo = new JTextField();
		txtModelo.setFont(new Font("Nirmala UI", Font.PLAIN, 13));
		txtModelo.setColumns(10);
		txtModelo.setBounds(1411, 441, 300, 40);
		contentPane.add(txtModelo);

		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Nirmala UI", Font.PLAIN, 25));
		lblMarca.setBounds(1271, 373, 75, 20);
		contentPane.add(lblMarca);

		txtCor = new JTextField();
		txtCor.setFont(new Font("Nirmala UI", Font.PLAIN, 13));
		txtCor.setColumns(10);
		txtCor.setBounds(1411, 299, 300, 40);
		contentPane.add(txtCor);

		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Nirmala UI", Font.PLAIN, 25));
		lblModelo.setBounds(1271, 446, 94, 20);
		contentPane.add(lblModelo);

		txtMarca = new JTextField();
		txtMarca.setFont(new Font("Nirmala UI", Font.PLAIN, 13));
		txtMarca.setColumns(10);
		txtMarca.setBounds(1411, 368, 300, 40);
		contentPane.add(txtMarca);

		if (txtPlaca.getText().isEmpty() && txtMarca.getText().isEmpty() && txtCor.getText().isEmpty()
				&& txtModelo.getText().isEmpty()) {

			txtPlaca.setEditable(false);
			txtPlaca.setEnabled(false);
			//
			txtCor.setEditable(false);
			txtCor.setEnabled(false);
			//
			txtModelo.setEditable(false);
			txtModelo.setEnabled(false);
			//
			txtMarca.setEditable(false);
			txtMarca.setEnabled(false);
		}

		JButton btnSalvar = new JButton("Editar");
		btnSalvar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if (btnSalvar.getText().equals("Editar")) {

					txtNome.setEnabled(true);
					txtNome.setEditable(true);
					txtSobrenome.setEnabled(true);
					txtSobrenome.setEditable(true);
					btnSalvar.setText("Salvar");
					
				} else if (btnSalvar.getText().equals("Salvar")) {

					Pessoa pessoaLogada = Sessao.getPessoaLogada();
					
					boolean success = pDAO.alterarPessoa(pessoaLogada);

					if (success) {
						JOptionPane.showMessageDialog(null, "Dados pessoais atualizados com sucesso.");
					} else {
						JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados pessoais.");
					}


					txtNome.setEnabled(false);
					txtNome.setEditable(false);
					txtSobrenome.setEnabled(false);
					txtSobrenome.setEditable(false);
					
					btnSalvar.setText("Editar");
				}
			}
		});

		btnSalvar.setBackground(new Color(255, 255, 255));
		btnSalvar.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		btnSalvar.setBounds(579, 665, 138, 40);
		contentPane.add(btnSalvar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				TelaExcluirConta TelaExcluirConta = new TelaExcluirConta();
				TelaExcluirConta.setVisible(true);

			}
		});

		btnExcluir.setBackground(new Color(255, 182, 193));
		btnExcluir.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		btnExcluir.setBounds(827, 665, 138, 40);
		contentPane.add(btnExcluir);

		JButton btnNewButton_2 = new JButton("Salvar");
		btnNewButton_2.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setBounds(1314, 665, 138, 40);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Excluir");
		btnNewButton_3.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		btnNewButton_3.setBackground(new Color(255, 182, 193));
		btnNewButton_3.setBounds(1546, 665, 138, 40);
		contentPane.add(btnNewButton_3);

		JButton btnAddVeiculo = new JButton("Adicionar Veículo");
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
		btnAddVeiculo.setBackground(Color.WHITE);
		btnAddVeiculo.setBounds(1420, 767, 165, 40);
		contentPane.add(btnAddVeiculo);

		Pessoa pessoaLogada = Sessao.getPessoaLogada();

		if (pessoaLogada != null) {
			txtSobrenome.setText(pessoaLogada.getSobrenome());
			txtEmail.setText(pessoaLogada.getEmail());
			txtNome.setText(pessoaLogada.getNome());
			txtCPF.setText(String.valueOf(pessoaLogada.getCpf()));
		}

	}
}

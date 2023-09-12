package visao;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controle.PessoaDAO;
import modelo.Pessoa;
import modelo.Sessao;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class Perfil extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JTextField txtEmail;
	private JTextField txtCPF;
	private JTextField txtData;
	private PessoaDAO pDAO = PessoaDAO.getInstancia();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

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
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, 1935, 1049);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 251, 233));
		contentPane.setBorder(new LineBorder(new Color(255, 251, 233), 2, true));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnHome = new JButton("");
		btnHome.setBorder(null);
		btnHome.setForeground(new Color(0, 0, 0));
		btnHome.setBackground(new Color(159, 203, 153));
		btnHome.setIcon(new ImageIcon(Perfil.class.getResource("/assets/home.png")));
		btnHome.setBounds(150, 773, 75, 65);
		contentPane.add(btnHome);
		
		JButton btnLogOut = new JButton("");
		btnLogOut.setBorder(null);
		btnLogOut.setBackground(new Color(159, 203, 153));
		btnLogOut.setIcon(new ImageIcon(Perfil.class.getResource("/assets/Log-out.png")));
		btnLogOut.setBounds(150, 858, 75, 65);
		contentPane.add(btnLogOut);

		txtNome = new JTextField();
		txtNome.setBounds(695, 299, 300, 40);
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(547, 238, 77, 20);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(lblNome);

		JLabel lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setBounds(547, 304, 138, 20);
		lblSobrenome.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(lblSobrenome);

		txtSobrenome = new JTextField();
		txtSobrenome.setBounds(695, 368, 300, 40);
		txtSobrenome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtSobrenome.setColumns(10);
		contentPane.add(txtSobrenome);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(547, 373, 84, 20);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(695, 441, 300, 40);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtEmail.setColumns(10);
		contentPane.add(txtEmail);

		txtCPF = new JTextField();
		txtCPF.setBounds(695, 233, 300, 40);
		txtCPF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCPF.setColumns(10);
		contentPane.add(txtCPF);

		txtData = new JTextField();
		txtData.setBounds(695, 512, 300, 40);
		txtData.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtData.setColumns(10);
		contentPane.add(txtData);

		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setBounds(547, 446, 59, 20);
		lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(lblCPF);

		JLabel lblData = new JLabel("Nascimento:");
		lblData.setBounds(547, 513, 138, 29);
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(lblData);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Perfil.class.getResource("/assets/perfil.png")));
		lblNewLabel.setBounds(42, 77, 300, 273);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBorder(null);
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(new Color(159, 203, 154));
		textField.setBounds(0, -31, 390, 1061);
		contentPane.add(textField);
		
		JLabel lblNewLabel_1 = new JLabel("Dados Pessoais");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 40));
		lblNewLabel_1.setBounds(586, 77, 317, 81);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Veículo");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 40));
		lblNewLabel_2.setBounds(1411, 87, 151, 61);
		contentPane.add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(1117, 108, 9, 778);
		contentPane.add(separator);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPlaca.setBounds(1271, 238, 77, 20);
		contentPane.add(lblPlaca);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_1.setColumns(10);
		textField_1.setBounds(1411, 233, 294, 40);
		contentPane.add(textField_1);
		
		JLabel lblCor = new JLabel("Cor:");
		lblCor.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCor.setBounds(1271, 304, 108, 20);
		contentPane.add(lblCor);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_2.setColumns(10);
		textField_2.setBounds(1411, 441, 300, 40);
		contentPane.add(textField_2);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblMarca.setBounds(1271, 373, 75, 20);
		contentPane.add(lblMarca);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_3.setColumns(10);
		textField_3.setBounds(1411, 299, 300, 40);
		contentPane.add(textField_3);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblModelo.setBounds(1271, 446, 94, 20);
		contentPane.add(lblModelo);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_4.setColumns(10);
		textField_4.setBounds(1411, 368, 300, 40);
		contentPane.add(textField_4);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(579, 665, 138, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Excluir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(827, 665, 138, 40);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Salvar");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setBounds(1314, 665, 138, 40);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Excluir");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3.setBackground(new Color(255, 255, 255));
		btnNewButton_3.setBounds(1546, 665, 138, 40);
		contentPane.add(btnNewButton_3);

		Pessoa pessoaLogada = Sessao.getPessoaLogada();
		if (pessoaLogada != null) {
			txtNome.setText(pessoaLogada.getNome());
			txtSobrenome.setText(pessoaLogada.getSobrenome());
			txtEmail.setText(pessoaLogada.getEmail());
			txtCPF.setText(String.valueOf(pessoaLogada.getCpf()));
		}

	}
}

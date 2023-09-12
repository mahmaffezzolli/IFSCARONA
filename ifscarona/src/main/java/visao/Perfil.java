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

public class Perfil extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JTextField txtEmail;
	private JTextField txtCPF;
	private JTextField txtData;
	private PessoaDAO pDAO = PessoaDAO.getInstancia();
	private JTextField textField;

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

		txtNome = new JTextField();
		txtNome.setEnabled(false);
		txtNome.setEditable(false);
		txtNome.setBounds(135, 430, 207, 29);
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(77, 433, 48, 20);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblNome);

		JLabel lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setBounds(38, 473, 87, 20);
		lblSobrenome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblSobrenome);

		txtSobrenome = new JTextField();
		txtSobrenome.setEnabled(false);
		txtSobrenome.setEditable(false);
		txtSobrenome.setBounds(135, 470, 207, 29);
		txtSobrenome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtSobrenome.setColumns(10);
		contentPane.add(txtSobrenome);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(80, 517, 45, 20);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(135, 604, 207, 29);
		txtEmail.setEnabled(false);
		txtEmail.setEditable(false);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtEmail.setColumns(10);
		contentPane.add(txtEmail);

		txtCPF = new JTextField();
		txtCPF.setBounds(135, 514, 207, 29);
		txtCPF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCPF.setEnabled(false);
		txtCPF.setEditable(false);
		txtCPF.setColumns(10);
		contentPane.add(txtCPF);

		txtData = new JTextField();
		txtData.setBounds(135, 555, 207, 29);
		txtData.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtData.setEnabled(false);
		txtData.setEditable(false);
		txtData.setColumns(10);
		contentPane.add(txtData);

		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setBounds(92, 558, 33, 20);
		lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblCPF);

		JLabel lblData = new JLabel("Data nasc.");
		lblData.setBounds(52, 603, 73, 29);
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblData);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Perfil.class.getResource("/assets/perfil.png")));
		lblNewLabel.setBounds(42, 77, 300, 273);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(new Color(159, 203, 154));
		textField.setBounds(0, -31, 390, 1061);
		contentPane.add(textField);
		
		JLabel lblNewLabel_1 = new JLabel("Dados Pessoais");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 40));
		lblNewLabel_1.setBounds(712, 77, 317, 81);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Veículo");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 40));
		lblNewLabel_2.setBounds(1401, 87, 151, 61);
		contentPane.add(lblNewLabel_2);

		Pessoa pessoaLogada = Sessao.getPessoaLogada();
		if (pessoaLogada != null) {
			txtNome.setText(pessoaLogada.getNome());
			txtSobrenome.setText(pessoaLogada.getSobrenome());
			txtEmail.setText(pessoaLogada.getEmail());
			txtCPF.setText(String.valueOf(pessoaLogada.getCpf()));
		}

	}
}

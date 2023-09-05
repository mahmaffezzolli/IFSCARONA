package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Perfil frame = new Perfil();
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 988, 603);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(159, 203, 154));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNome.setBounds(412, 124, 126, 29);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNome.setBounds(338, 127, 64, 20);
		contentPane.add(lblNome);

		JLabel lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSobrenome.setBounds(298, 184, 101, 20);
		contentPane.add(lblSobrenome);

		txtSobrenome = new JTextField();
		txtSobrenome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtSobrenome.setColumns(10);
		txtSobrenome.setBounds(409, 181, 129, 29);
		contentPane.add(txtSobrenome);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(332, 246, 56, 20);
		contentPane.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setEnabled(false);
		txtEmail.setEditable(false);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtEmail.setColumns(10);
		txtEmail.setBounds(412, 243, 129, 29);
		contentPane.add(txtEmail);

		txtCPF = new JTextField();
		txtCPF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCPF.setEnabled(false);
		txtCPF.setEditable(false);
		txtCPF.setColumns(10);
		txtCPF.setBounds(410, 298, 129, 29);
		contentPane.add(txtCPF);

		txtData = new JTextField();
		txtData.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtData.setEnabled(false);
		txtData.setEditable(false);
		txtData.setColumns(10);
		txtData.setBounds(409, 348, 129, 29);
		contentPane.add(txtData);

		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCPF.setBounds(337, 300, 56, 20);
		contentPane.add(lblCPF);

		JLabel lblData = new JLabel("Data de nascimento:");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblData.setBounds(241, 357, 153, 20);
		contentPane.add(lblData);

		Pessoa pessoaLogada = Sessao.getPessoaLogada();
		if (pessoaLogada != null) {
			txtNome.setText(pessoaLogada.getNome());
			txtSobrenome.setText(pessoaLogada.getSobrenome());
			txtEmail.setText(pessoaLogada.getEmail());
			txtCPF.setText(String.valueOf(pessoaLogada.getCpf()));
		}

	}
}

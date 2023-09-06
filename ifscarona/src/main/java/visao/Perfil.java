package visao;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Perfil.class.getResource("/assets/icon-profile.png")));
		lblNewLabel.setBounds(111, 103, 263, 280);
		contentPane.add(lblNewLabel);

		txtNome = new JTextField();
		txtNome.setBounds(169, 464, 126, 29);
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(95, 633, 64, 20);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblNome);

		JLabel lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setBounds(54, 687, 101, 20);
		lblSobrenome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblSobrenome);

		txtSobrenome = new JTextField();
		txtSobrenome.setBounds(169, 522, 126, 29);
		txtSobrenome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtSobrenome.setColumns(10);
		contentPane.add(txtSobrenome);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(103, 525, 56, 20);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(169, 684, 126, 29);
		txtEmail.setEnabled(false);
		txtEmail.setEditable(false);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtEmail.setColumns(10);
		contentPane.add(txtEmail);

		txtCPF = new JTextField();
		txtCPF.setBounds(169, 577, 126, 29);
		txtCPF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCPF.setEnabled(false);
		txtCPF.setEditable(false);
		txtCPF.setColumns(10);
		contentPane.add(txtCPF);

		txtData = new JTextField();
		txtData.setBounds(169, 630, 126, 29);
		txtData.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtData.setEnabled(false);
		txtData.setEditable(false);
		txtData.setColumns(10);
		contentPane.add(txtData);

		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setBounds(103, 467, 56, 20);
		lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblCPF);

		JLabel lblData = new JLabel("Data de nascimento:");
		lblData.setBounds(6, 580, 153, 20);
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 16));
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

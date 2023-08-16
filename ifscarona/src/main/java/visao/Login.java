package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail;
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, screen.width, screen.height - 30);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(154, 203, 159));
		contentPane.setBorder(new LineBorder(new Color(255, 251, 233), 2, true));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel ifacarona = new JLabel("IFSCarona");
		ifacarona.setFont(new Font("Dialog", Font.BOLD, 53));
		ifacarona.setBounds(26, 372, 327, 107);
		contentPane.add(ifacarona);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(
				"/home/maria/Área de Trabalho/IFSCARONA/ifscarona/src/main/java/assets/icons8-senha-60.png"));
		lblNewLabel_4.setBounds(876, 575, 60, 60);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(
				"/home/maria/Área de Trabalho/IFSCARONA/ifscarona/src/main/java/assets/icons8-nova-mensagem-60.png"));
		lblNewLabel.setBounds(876, 417, 60, 45);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(
				new ImageIcon("/home/maria/Área de Trabalho/IFSCARONA/ifscarona/src/main/java/assets/fundoClaro.png"));
		lblNewLabel_3.setBounds(0, -239, 413, 1650);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_2 = new JLabel("E-mail institucional");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(950, 392, 122, 14);
		contentPane.add(lblNewLabel_2);

		txtEmail = new JTextField();
		txtEmail.setBackground(new Color(255, 251, 233));
		txtEmail.setToolTipText("");
		txtEmail.setBounds(946, 417, 336, 45);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 53));
		lblNewLabel_1.setBounds(1012, 154, 327, 107);
		contentPane.add(lblNewLabel_1);

		JButton btnLogar = new JButton("LOGAR");
		btnLogar.setBorder(new LineBorder(new Color(244, 234, 213), 4, true));
		btnLogar.setBackground(new Color(255, 251, 233));
		btnLogar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String senha = String.valueOf(txtSenha.getPassword());

				if (txtEmail.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "O email deve ser inserido!");
				} else if (senha.isEmpty()) {
					JOptionPane.showMessageDialog(null, "A senha deve ser inserida!");

				}

			}

			private void dispose() {
				setVisible(false);
			}
		});
		btnLogar.setBounds(1012, 796, 162, 45);
		contentPane.add(btnLogar);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblSenha.setBounds(950, 561, 122, 14);
		contentPane.add(lblSenha);

		txtSenha = new JPasswordField();
		txtSenha.setToolTipText("");
		txtSenha.setColumns(10);
		txtSenha.setBackground(new Color(255, 251, 233));
		txtSenha.setBounds(954, 587, 336, 45);
		contentPane.add(txtSenha);

		JLabel lblCad = new JLabel("Não possui cadastro?");
		lblCad.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblCad.setBounds(964, 653, 178, 14);
		contentPane.add(lblCad);

		JLabel lblLinkAqui = new JLabel("Clique aqui");
		lblLinkAqui.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblLinkAqui.setBounds(1116, 653, 178, 14);
		lblLinkAqui.setForeground(Color.BLUE);
		lblLinkAqui.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(lblLinkAqui);

		lblLinkAqui.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				CadastroUsuario cadastroFrame = new CadastroUsuario();
				cadastroFrame.setVisible(true);
				Login.this.dispose();
			}
		});

	}
}

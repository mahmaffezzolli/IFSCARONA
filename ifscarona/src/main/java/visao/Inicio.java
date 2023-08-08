package visao;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class Inicio extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblImage;
	private JButton btnCadastrar;
	private JLabel lblBemvindoAo;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
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
	public Inicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1940, 1119);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogar = new JButton("Logar");
		btnLogar.setBackground(new Color(255, 251, 233));
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\IFSCARONA\\ifscarona\\src\\main\\java\\assets\\decoracao2.1.png"));
		lblNewLabel_3.setBounds(-48, 669, 403, 517);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\IFSCARONA\\ifscarona\\src\\main\\java\\assets\\decoracao.png"));
		lblNewLabel_2.setBounds(1667, -139, 403, 517);
		contentPane.add(lblNewLabel_2);
		btnLogar.setBounds(807, 550, 110, 23);
		contentPane.add(btnLogar);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBackground(new Color(255, 251, 233));
		btnCadastrar.setBounds(993, 550, 110, 23);
		contentPane.add(btnCadastrar);
		
		JLabel lblNewLabel = new JLabel("IFSCarona");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 49));
		lblNewLabel.setBounds(831, 340, 311, 112);
		contentPane.add(lblNewLabel);
		

		lblBemvindoAo = new JLabel("Bem-Vindo ao");
		lblBemvindoAo.setFont(new Font("Dialog", Font.BOLD, 20));
		lblBemvindoAo.setBounds(944, 335, 217, 51);
		contentPane.add(lblBemvindoAo);
		
		lblImage = new JLabel("");
		lblImage.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\IFSCARONA\\ifscarona\\src\\main\\java\\assets\\car.png"));
		lblImage.setBounds(862, 102, 337, 260);
		contentPane.add(lblImage);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\IFSCARONA\\ifscarona\\src\\main\\java\\assets\\trás-removebg-preview.png"));
		lblNewLabel_1.setBounds(777, 210, 384, 454);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("TlwgTypewriter", Font.BOLD, 22));
		textField.setBackground(new Color(159, 203, 154));
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setBounds(0, -14, 1949, 1075);
		contentPane.add(textField);
		textField.setColumns(10);
		
	
	}


}
    
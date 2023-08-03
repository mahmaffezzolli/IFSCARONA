
package visao;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Shape;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inicio extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblNewLabel_1;
	private JButton btnCadastrar;
	private JLabel lblBemvindoAo;

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
		
		JButton btnNewButton = new JButton("Logar");
		btnNewButton.setBackground(new Color(255, 251, 233));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		lblBemvindoAo = new JLabel("Bem-Vindo ao");
		lblBemvindoAo.setFont(new Font("Dialog", Font.BOLD, 20));
		lblBemvindoAo.setBounds(944, 335, 217, 51);
		contentPane.add(lblBemvindoAo);
		
		JLabel lblNewLabel = new JLabel("IFSCarona");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 49));
		lblNewLabel.setBounds(831, 340, 311, 112);
		contentPane.add(lblNewLabel);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBackground(new Color(255, 251, 233));
		btnCadastrar.setBounds(993, 550, 110, 23);
		contentPane.add(btnCadastrar);
		btnNewButton.setBounds(807, 550, 110, 23);
		contentPane.add(btnNewButton);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Aluno\\Pictures\\var.jpg"));
		lblNewLabel_1.setBounds(884, 136, 158, 162);
		contentPane.add(lblNewLabel_1);

		
		textField_3 = new JTextField();
		textField_3.setBackground(new Color(244, 234, 213));
		textField_3.setBorder(new LineBorder(new Color(192, 192, 192), 2, true));
		textField_3.setEnabled(false);
		textField_3.setEditable(false);
		textField_3.setBounds(784, 236, 346, 433);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBackground(new Color(223, 238, 221));
		textField_2.setBounds(1592, -57, 472, 330);
		contentPane.add(textField_2);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setEditable(false);
		textField_1.setBackground(new Color(223, 238, 221));
		textField_1.setBounds(0, 742, 346, 319);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField = new JTextField();
		textField.setFont(new Font("TlwgTypewriter", Font.BOLD, 22));
		textField.setBackground(new Color(159, 203, 154));
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setBounds(0, -14, 1939, 1075);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		
		
	
	}
}
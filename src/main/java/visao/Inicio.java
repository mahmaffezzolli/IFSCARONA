package visao;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;

public class Inicio extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtQuadradoBaixo;
	private JTextField txtQuadradoCima;
	private JTextField txtMeio;
	private JLabel lblImage;
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
		
		JButton btnLogar = new JButton("Logar");
		btnLogar.setBackground(new Color(255, 251, 233));
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		lblImage = new JLabel("");
		lblImage.setBounds(849, 135, 219, 153);
		contentPane.add(lblImage);
		
        ImageIcon imageIcon = new ImageIcon("/home/maria/Área de Trabalho/IFSCARONA/ifscarona/src/main/java/assets/var.jpg");
        Image image = imageIcon.getImage();

        BufferedImage roundedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = roundedImage.createGraphics();
        g2d.setClip(new Ellipse2D.Float(0, 0, image.getWidth(null), image.getHeight(null)));
        g2d.drawImage(image, 0, 0, null);
        g2d.dispose();

        Image resizedImage = roundedImage.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);

        lblImage.setIcon(new ImageIcon(resizedImage));
		
		
		
		
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
		btnLogar.setBounds(807, 550, 110, 23);
		contentPane.add(btnLogar);

		
		txtMeio = new JTextField();
        txtMeio.setBackground(new Color(244, 234, 213));
        txtMeio.setEnabled(false);
        txtMeio.setEditable(false);
        txtMeio.setBounds(784, 236, 346, 433);
        contentPane.add(txtMeio);
        txtMeio.setColumns(10);
        
		
		txtQuadradoCima = new JTextField();
		txtQuadradoCima.setEnabled(false);
		txtQuadradoCima.setEditable(false);
		txtQuadradoCima.setColumns(10);
		txtQuadradoCima.setBackground(new Color(223, 238, 221));
		txtQuadradoCima.setBounds(1592, -57, 472, 330);
		contentPane.add(txtQuadradoCima);
		
		txtQuadradoBaixo = new JTextField();
		txtQuadradoBaixo.setEnabled(false);
		txtQuadradoBaixo.setEditable(false);
		txtQuadradoBaixo.setBackground(new Color(223, 238, 221));
		txtQuadradoBaixo.setBounds(0, 742, 346, 319);
		contentPane.add(txtQuadradoBaixo);
		txtQuadradoBaixo.setColumns(10);
		
		textField = new JTextField();
		textField.setFont(new Font("TlwgTypewriter", Font.BOLD, 22));
		textField.setBackground(new Color(159, 203, 154));
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setBounds(-15, 0, 1939, 1075);
		contentPane.add(textField);
		textField.setColumns(10);
		
	
	}


}
    
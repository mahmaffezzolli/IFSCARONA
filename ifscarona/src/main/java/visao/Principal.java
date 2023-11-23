package visao;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import controle.VeiculoDAO;
import modelo.Pessoa;
import modelo.Sessao;
import modelo.Veiculo;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class Principal extends JFrame {

	private JPanel contentPane;
	private VeiculoDAO vDAO = VeiculoDAO.getInstancia();
	private JRadioButton rdbtn6ao12;
	private JRadioButton rdbtn12ao18;
	private JRadioButton rdbtn18emDiante;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		
		java.net.URL caminhoIcone = getClass().getResource("/assets/janelaIcon.png");
		Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminhoIcone);
		this.setIconImage(iconeTitulo);
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, screen.width, screen.height - 30);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(154, 203, 159));
		contentPane.setBorder(new LineBorder(new Color(255, 251, 233), 2, true));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		JRadioButton rdbtn6ao12 = new JRadioButton("06:00 - 12:00");
		rdbtn6ao12.setBounds(705, 338, 152, 45);
		contentPane.add(rdbtn6ao12);
		
		JRadioButton rdbtn12ao18 = new JRadioButton("12:01 - 18:00");
		rdbtn12ao18.setBounds(705, 422, 152, 43);
		contentPane.add(rdbtn12ao18);
		
		
		JRadioButton rdbtn18emDiante = new JRadioButton("18:00 em diante");
		rdbtn18emDiante.setBounds(705, 505, 155, 43);
		contentPane.add(rdbtn18emDiante);
		
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(rdbtn6ao12);
		radioGroup.add(rdbtn12ao18);
		radioGroup.add(rdbtn18emDiante);
		
		btnLogOut.setIcon(new ImageIcon(Principal.class.getResource("/assets/Log-out.png")));
		btnLogOut.setBorder(null);
		btnLogOut.setBackground(new Color(244, 234, 213));
		btnLogOut.setBounds(150, 750, 75, 65);
		contentPane.add(btnLogOut);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(1122, 241, 11, 534);
		contentPane.add(separator);

		JButton btnLogar = new JButton("Requisitar");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (rdbtn18emDiante.isSelected() ||rdbtn12ao18.isSelected() || rdbtn6ao12.isSelected()) {
						new RequisitarCarona().setVisible(true);
						 Principal.this.dispose();
			        } else {
			        	CampoNaoPreenchido campoNaoPreenchido = new CampoNaoPreenchido();
						campoNaoPreenchido.setVisible(true);
			        }
			    }
			});
		btnLogar.setBorder(new LineBorder(new Color(249, 239, 197), 4, true));
		btnLogar.setBackground(new Color(255, 251, 233));
		btnLogar.setBounds(695, 615, 162, 43);
		contentPane.add(btnLogar);

		JLabel lblFundoFiltro = new JLabel("");
		lblFundoFiltro.setIcon(new ImageIcon(Principal.class.getResource("/assets/FUndo CLaroP.png")));
		lblFundoFiltro.setBounds(617, 228, 532, 560);
		contentPane.add(lblFundoFiltro);

		JLabel lblCarro = new JLabel("");
		lblCarro.setIcon(new ImageIcon(Principal.class.getResource("/assets/car.png")));
		lblCarro.setBounds(106, 302, 385, 151);
		contentPane.add(lblCarro);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Principal.class.getResource("/assets/b1340120-e126-4821-b15c-e3627d2a38a6.png")));
		lblLogo.setBounds(-5, 426, 590, 172);
		contentPane.add(lblLogo);

		JLabel lblFundo = new JLabel("");
		lblFundo.setIcon(new ImageIcon(Principal.class.getResource("/assets/fundoClaro.png")));
		lblFundo.setBounds(-11, -235, 468, 1650);
		contentPane.add(lblFundo);

		JLabel lblFiltro = new JLabel("Filtrar viagens");
		lblFiltro.setFont(new Font("Dialog", Font.BOLD, 40));
		lblFiltro.setBounds(634, 176, 385, 107);
		contentPane.add(lblFiltro);

		JButton btnPerfil = new JButton("Perfil ");
		btnPerfil.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					new Perfil().setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Principal.this.dispose();
			}

		});
		btnPerfil.setBackground(new Color(244, 234, 213));
		btnPerfil.setBorder(new LineBorder(new Color(232, 218, 188), 4, true));
		btnPerfil.setBounds(1317, 478, 169, 59);
		contentPane.add(btnPerfil);

		JButton btnNewButton_1 = new JButton("Oferecer");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		Pessoa pessoaLogada = Sessao.getPessoaLogada();
		
		Veiculo veiculoLogado = vDAO.conexaoVeiculoPessoa(pessoaLogada);
		
		if(veiculoLogado == null) {
			btnNewButton_1.setEnabled(false);
		}
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new OferecerCarona().setVisible(true);
				Principal.this.dispose();
				

			}
			});
		btnNewButton_1.setBorder(new LineBorder(new Color(232, 218, 188), 4));
		btnNewButton_1.setBackground(new Color(244, 234, 213));
		btnNewButton_1.setBounds(1317, 666, 169, 59);
		contentPane.add(btnNewButton_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		chckbxNewCheckBox.setBounds(705, 338, 129, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JButton btnNewButton = new JButton("Histórico");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Historico().setVisible(true);
				Principal.this.dispose();
			}
		});
		btnNewButton.setBackground(new Color(244, 234, 213));
		btnNewButton.setBorder(new LineBorder(new Color(232, 218, 188), 4, true));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(1317, 318, 169, 59);
		contentPane.add(btnNewButton);

	}
}

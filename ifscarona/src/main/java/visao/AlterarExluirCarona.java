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
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import controle.PessoaDAO;
import controle.VeiculoDAO;
import modelo.Carro;
import modelo.Pessoa;
import modelo.Sessao;
import modelo.Veiculo;

public class AlterarExluirCarona extends JFrame {

	private JPanel contentPane;
	private JTextField txtDestino;
	private JTextField txtHorário;
	private JTextField txtCPF;
	private JTextField txtData;
	private JTextField txtOrigem;
	private PessoaDAO pDAO = PessoaDAO.getInstancia();
	private VeiculoDAO vDAO = VeiculoDAO.getInstancia();
	private JTextField textField;
	private JTextField txtCPF2;
	private JButton btnSalvar, btnExcluir, btnSalvarV;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterarExluirCarona frame = new AlterarExluirCarona();
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
	 * 
	 * @throws ParseException
	 */
	public AlterarExluirCarona() throws ParseException {
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
		        Principal principal = new Principal();
		        principal.setVisible(true);
		        dispose();
		    }
		});
		btnHome.setBorderPainted(false);
		btnHome.setContentAreaFilled(false);
		btnHome.setFocusPainted(false);
		btnHome.setIcon(new ImageIcon(AlterarExluirCarona.class.getResource("/assets/home.png")));
		btnHome.setBounds(128, 758, 75, 65);
		contentPane.add(btnHome);

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

		btnLogOut.setBorder(null);
		btnLogOut.setBackground(new Color(159, 203, 153));
		btnLogOut.setIcon(new ImageIcon(AlterarExluirCarona.class.getResource("/assets/Log-out.png")));
		btnLogOut.setBounds(140, 859, 75, 65);
		contentPane.add(btnLogOut);

		txtDestino = new JTextField();
		txtDestino.setEnabled(false);
		txtDestino.setEditable(false);
		txtDestino.setBounds(1178, 299, 300, 40);
		txtDestino.setFont(new Font("Nirmala UI", Font.PLAIN, 13));
		contentPane.add(txtDestino);
		txtDestino.setColumns(10);

		JLabel lblOrigem = new JLabel("Origem:");
		lblOrigem.setBounds(1067, 245, 101, 35);
		lblOrigem.setFont(new Font("Nirmala UI", Font.PLAIN, 25));
		contentPane.add(lblOrigem);

		JLabel lblDestino = new JLabel("Destino:");
		lblDestino.setBounds(1067, 304, 204, 20);
		lblDestino.setFont(new Font("Nirmala UI", Font.PLAIN, 25));
		contentPane.add(lblDestino);

		txtHorário = new JTextField();
		txtHorário.setEnabled(false);
		txtHorário.setEditable(false);
		txtHorário.setBounds(1178, 368, 300, 40);
		txtHorário.setFont(new Font("Nirmala UI", Font.PLAIN, 13));
		txtHorário.setColumns(10);
		contentPane.add(txtHorário);

		JLabel lblHorário = new JLabel("Horário");
		lblHorário.setBounds(1067, 373, 101, 20);
		lblHorário.setFont(new Font("Nirmala UI", Font.PLAIN, 25));
		contentPane.add(lblHorário);

		txtData = new JTextField();
		/*****************/
		MaskFormatter mascaraData = null;
		mascaraData = new MaskFormatter("##/##/####");
		txtData = new JFormattedTextField(mascaraData);
		/*****************/
		txtData.setEnabled(false);
		txtData.setEditable(false);
		txtData.setBounds(1178, 441, 300, 40);
		txtData.setFont(new Font("Nirmala UI", Font.PLAIN, 13));
		txtData.setColumns(10);
		contentPane.add(txtData);

		txtOrigem = new JTextField();
		txtOrigem.setEnabled(false);
		txtOrigem.setEditable(false);
		txtOrigem.setBounds(1178, 240, 300, 40);
		txtOrigem.setFont(new Font("Nirmala UI", Font.PLAIN, 13));
		txtOrigem.setColumns(10);
		contentPane.add(txtOrigem);

		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(1067, 446, 59, 20);
		lblData.setFont(new Font("Nirmala UI", Font.PLAIN, 25));
		contentPane.add(lblData);

		JLabel lblIcon = new JLabel("");
		lblIcon.setIcon(new ImageIcon(AlterarExluirCarona.class.getResource("/assets/perfil.png")));
		lblIcon.setBounds(55, 80, 300, 273);
		contentPane.add(lblIcon);

		textField = new JTextField();
		textField.setBorder(null);
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(new Color(159, 203, 154));
		textField.setBounds(10, -31, 410, 1061);
		contentPane.add(textField);

		JLabel lblDados = new JLabel("Dados Carona");
		lblDados.setFont(new Font("Dialog", Font.BOLD, 40));
		lblDados.setBounds(1174, 80, 376, 81);
		contentPane.add(lblDados);

		btnSalvar = new JButton("Editar");
		btnSalvar.setIcon(new ImageIcon(AlterarExluirCarona.class.getResource("/assets/icons8-editar-50.png")));
		btnSalvar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				
			}
		});

		btnSalvar.setBackground(new Color(192, 192, 192));
		btnSalvar.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		btnSalvar.setBounds(1103, 624, 145, 53);
		contentPane.add(btnSalvar);


		JButton btnExcluirV = new JButton("Excluir");
		btnExcluirV.setIcon(new ImageIcon(AlterarExluirCarona.class.getResource("/assets/icons8-excluir-60.png")));
		btnExcluirV.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				TelaExcluirConta TelaExcluirConta = new TelaExcluirConta();
				TelaExcluirConta.setVisible(true);

				dispose();
			
				

			}
		});
		btnExcluirV.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnExcluirV.setBackground(new Color(255, 182, 193));
		btnExcluirV.setBounds(1333, 626, 145, 53);
		contentPane.add(btnExcluirV);


		

		Pessoa pessoaLogada = Sessao.getPessoaLogada();

		if (pessoaLogada != null) {
			txtDestino.setText(pessoaLogada.getSobrenome());
			txtHorário.setText(pessoaLogada.getEmail());
			txtOrigem.setText(pessoaLogada.getNome());
			txtCPF.setText(String.valueOf(pessoaLogada.getCpf()));
			txtData.setText(String.valueOf(pessoaLogada.getDataNasc()));

		}

		
		}
	}



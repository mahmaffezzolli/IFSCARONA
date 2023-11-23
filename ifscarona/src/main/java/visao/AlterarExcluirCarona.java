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
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import controle.CaronaDAO;
import modelo.Carona;
import modelo.Carro;
import modelo.Sessao;

public class AlterarExcluirCarona extends JFrame {

	private JPanel contentPane;
	private JTextField txtDestino;
	private JTextField txtHorario;
	private JTextField txtData;
	private JTextField txtOrigem;
	private CaronaDAO cDAO = CaronaDAO.getInstancia();
	private JTextField textField;
	private JButton btnSalvar;
	private Long idCarona;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Long idCarona = null;
					AlterarExcluirCarona frame = new AlterarExcluirCarona(idCarona);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AlterarExcluirCarona(Long idCarona) throws ParseException {

		this.idCarona = idCarona;

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
		btnHome.setIcon(new ImageIcon(AlterarExcluirCarona.class.getResource("/assets/home.png")));
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
		btnLogOut.setIcon(new ImageIcon(AlterarExcluirCarona.class.getResource("/assets/Log-out.png")));
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

		txtHorario = new JTextField();
		txtHorario.setEnabled(false);
		txtHorario.setEditable(false);
		txtHorario.setBounds(1178, 368, 300, 40);
		txtHorario.setFont(new Font("Nirmala UI", Font.PLAIN, 13));
		txtHorario.setColumns(10);
		contentPane.add(txtHorario);

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
		lblIcon.setIcon(new ImageIcon(AlterarExcluirCarona.class.getResource("/assets/perfil.png")));
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
		btnSalvar.setIcon(new ImageIcon(AlterarExcluirCarona.class.getResource("/assets/icons8-editar-50.png")));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarCarona();
			}
		});

		btnSalvar.setBackground(new Color(192, 192, 192));
		btnSalvar.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
		btnSalvar.setBounds(1103, 624, 145, 53);
		contentPane.add(btnSalvar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setIcon(new ImageIcon(AlterarExcluirCarona.class.getResource("/assets/icons8-excluir-60.png")));
		btnExcluir.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				TelaExcluirCarona TelaExcluirCarona = null;
				try {
					TelaExcluirCarona = new TelaExcluirCarona(idCarona);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				TelaExcluirCarona.setBounds(40, 40, 451, 234);
				TelaExcluirCarona.setLocationRelativeTo(null);
				TelaExcluirCarona.setVisible(true);

			}
		});
		btnExcluir.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnExcluir.setBackground(new Color(255, 182, 193));
		btnExcluir.setBounds(1333, 626, 145, 53);
		contentPane.add(btnExcluir);

		Carona carona = cDAO.pegaCarona(idCarona);

		if (carona != null) {
			txtDestino.setText(carona.getTrajeto().getDestino());
			txtHorario.setText(String.valueOf(carona.getHorario()));
			txtOrigem.setText(carona.getTrajeto().getOrigem());
			txtData.setText(String.valueOf(carona.getData()));

		}

	}

	public void editarCarona() {
		if (btnSalvar.getText().equals("Editar")) {

			txtDestino.setEnabled(true);
			txtDestino.setEditable(true);
			txtHorario.setEnabled(true);
			txtHorario.setEditable(true);
			txtOrigem.setEnabled(true);
			txtOrigem.setEditable(true);
			txtData.setEnabled(true);
			txtData.setEditable(true);

			btnSalvar.setText("Salvar");

		} else if (btnSalvar.getText().equals("Salvar")) {

			Carona carona = cDAO.pegaCarona(idCarona);

			boolean success = cDAO.alterarCarona(carona);

			if (success) {
				DadosAtualizados dadosAtualizados = new DadosAtualizados();
				dadosAtualizados.setVisible(true);
			} else {
				ErroAoAtualizar erroAoAtualizar = new ErroAoAtualizar();

				erroAoAtualizar.setVisible(true);
			}

			txtDestino.setEnabled(false);
			txtDestino.setEditable(false);
			txtHorario.setEnabled(false);
			txtHorario.setEditable(false);
			txtOrigem.setEnabled(false);
			txtOrigem.setEditable(false);
			txtData.setEnabled(false);
			txtData.setEditable(false);

			btnSalvar.setText("Editar");
		}

	}

}

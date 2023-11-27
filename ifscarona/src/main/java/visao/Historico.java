package visao;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import controle.CaronaDAO;
import controle.PessoaDAO;
import controle.VeiculoDAO;
import modelo.Carona;
import modelo.Carro;
import modelo.Pessoa;
import modelo.Sessao;

import javax.swing.JTable;

public class Historico extends JFrame {

	private DefaultTableModel tableModel;
	private JTable table;
	private JPanel contentPane;
	private CaronaDAO cDAO = CaronaDAO.getInstancia();
	private VeiculoDAO vDAO = VeiculoDAO.getInstancia();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Historico frame = new Historico();
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
	public Historico() {

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

		JButton btnHome = new JButton("");
		btnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Principal principal = new Principal();
				principal.setVisible(true);
			}
		});

		btnHome.setBorder(null);
		btnHome.setForeground(new Color(0, 0, 0));
		btnHome.setBackground(new Color(244, 234, 213));
		btnHome.setIcon(new ImageIcon(Perfil.class.getResource("/assets/home.png")));
		btnHome.setBounds(140, 762, 75, 65);
		contentPane.add(btnHome);

		JLabel lblCarro = new JLabel("");
		lblCarro.setIcon(new ImageIcon(Principal.class.getResource("/assets/car.png")));
		lblCarro.setBounds(81, 304, 385, 151);
		contentPane.add(lblCarro);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Principal.class.getResource("/assets/b1340120-e126-4821-b15c-e3627d2a38a6.png")));
		lblLogo.setBounds(-5, 426, 590, 172);
		contentPane.add(lblLogo);

		JLabel lblFundo = new JLabel("");
		lblFundo.setIcon(new ImageIcon(Principal.class.getResource("/assets/fundoClaro.png")));
		lblFundo.setBounds(-2, -224, 468, 1650);
		contentPane.add(lblFundo);

		JLabel lblTitulo = new JLabel("Histórico");
		lblTitulo.setFont(new Font("Dialog", Font.BOLD, 40));
		lblTitulo.setBounds(1045, 64, 552, 107);
		contentPane.add(lblTitulo);

		tableModel = new DefaultTableModel();
		tableModel.addColumn("ID Carona");
		tableModel.addColumn("Nome do Motorista");
		tableModel.addColumn("Hora de Saída");
		tableModel.addColumn("Data de Saída");
		tableModel.addColumn("Placa do Carro");

		table = new JTable(tableModel);

		table = new JTable(tableModel) {
			@Override
			public boolean isCellEditable(int row, int cell) {
				return false;
			}
		};

		int rowHeight = 25;
		table.setRowHeight(rowHeight);

		table.getTableHeader().setReorderingAllowed(false);

		JTableHeader tableHeader = table.getTableHeader();
		int headerRowHeight = 30;
		tableHeader.setPreferredSize(new Dimension(tableHeader.getWidth(), headerRowHeight));

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(616, 170, 1060, 651);
		contentPane.add(scrollPane);

		JButton btnExcluir = new JButton("Cancelar carona");
		btnExcluir.setBounds(1586, 865, 133, 33);
		btnExcluir.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				int selectedRowIndex = table.getSelectedRow();

				if (selectedRowIndex != -1) {
					Long idCarona = Long.parseLong(table.getValueAt(selectedRowIndex, 0).toString());

					boolean sucesso = cDAO.removerPassageiroDaCarona(idCarona);

					if (sucesso) {
						Principal principal = new Principal();
						principal.setVisible(true);
						dispose();
					}

				}
			}

		});
		contentPane.add(btnExcluir);

		List<Carona> caronas = cDAO.listarCaronasDisponíveis();

		try {

			for (Carona carona : caronas) {
				if (Sessao.getPessoaLogada().getCpf().equals(carona.getPassageiro().getCpf())) {
					Carro carro = vDAO.pegaVeiculo(carona.getVeiculo().getIdVeiculo());

					DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

					String data = carona.getData().format(dateFormatter);
					String horario = carona.getHorario().toLocalTime().format(timeFormatter);

					Object[] rowData = { carona.getIdCarona(), carona.getMotorista().getNome(), data, horario,
							carro.getPlaca() };
					tableModel.addRow(rowData);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

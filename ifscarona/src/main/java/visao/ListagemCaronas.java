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
import java.time.LocalDate;
import java.time.LocalTime;
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
import javax.swing.JTextField;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.TimePicker;

public class ListagemCaronas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel tableModel;
	private CaronaDAO cDAO = CaronaDAO.getInstancia();
	private VeiculoDAO vDAO = VeiculoDAO.getInstancia();
	private JTable table;
	private JPanel contentPane;
	private JButton btnSelecionar;
	private DatePicker datePicker;
	private TimePicker timePicker;
	private JTextField originFilter;
	private JTextField destinationFilter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListagemCaronas frame = new ListagemCaronas();
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
	public ListagemCaronas() {

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
				Principal principal = new Principal();
				principal.setVisible(true);
				dispose();
			}
		});
		btnHome.setBorderPainted(false);
		btnHome.setContentAreaFilled(false);
		btnHome.setFocusPainted(false);
		btnHome.setIcon(new ImageIcon(Perfil.class.getResource("/assets/home.png")));
		btnHome.setBounds(140, 762, 75, 65);
		contentPane.add(btnHome);

		JLabel lblFiltro = new JLabel("Filtrar viagens");
		lblFiltro.setFont(new Font("Nirmala UI", Font.BOLD, 24));
		lblFiltro.setBounds(1705, 100, 170, 60);
		contentPane.add(lblFiltro);

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

		btnSelecionar = new JButton("Selecionar");
		btnSelecionar.setFont(new Font("Nirmala UI", Font.BOLD, 16));
		btnSelecionar.setIcon(new ImageIcon(OferecerCarona.class.getResource("/assets/icons8-caronas-50.png")));
		btnSelecionar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRowIndex = table.getSelectedRow();

				if (selectedRowIndex != -1) {
					Long idCarona = Long.parseLong(table.getValueAt(selectedRowIndex, 0).toString());

					String cpfMotorista = cDAO.pegaCarona(idCarona).getMotorista().getCpf();

					if (Sessao.getPessoaLogada().getCpf().equals(cpfMotorista)) {

						btnSelecionar.setEnabled(true);

						AlterarExcluirCarona telaEditar = null;
						try {
							telaEditar = new AlterarExcluirCarona(idCarona);
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
						telaEditar.setVisible(true);

						dispose();
					} else {

						String cpfPassageiro = Sessao.getPessoaLogada().getCpf();
						Carona carona = cDAO.pegaCarona(idCarona);
						Pessoa passageiro = PessoaDAO.getInstancia().pegaPessoa(cpfPassageiro);
						carona.setPassageiro(passageiro);

						cDAO.alterarCarona(carona);

					}

				}
			}
		});

		btnSelecionar.setBackground(new Color(251, 251, 233));
		btnSelecionar.setBounds(1690, 760, 185, 65);
		contentPane.add(btnSelecionar);

		Font tableFont = new Font("Dialog", Font.PLAIN, 14);

		tableModel = new DefaultTableModel();
		tableModel.addColumn("ID Carona");
		tableModel.addColumn("Nome do Motorista");
		tableModel.addColumn("Data");
		tableModel.addColumn("Hora de Saída");
		tableModel.addColumn("Veículo");
		tableModel.addColumn("Origem");
		tableModel.addColumn("Destino");

		table = new JTable(tableModel) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int cell) {
				return false;
			}
		};

		table.setFont(tableFont);
		int rowHeight = 25;
		table.setRowHeight(rowHeight);

		table.getTableHeader().setReorderingAllowed(false);

		JTableHeader tableHeader = table.getTableHeader();
		int headerRowHeight = 30;
		tableHeader.setPreferredSize(new Dimension(tableHeader.getWidth(), headerRowHeight));
		tableHeader.setFont(tableFont.deriveFont(Font.BOLD));

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(595, 170, 1060, 650);
		contentPane.add(scrollPane);

		datePicker = new DatePicker();
		datePicker.setBounds(1720, 200, 150, 30);
		contentPane.add(datePicker);

		timePicker = new TimePicker();
		timePicker.setBounds(1720, 260, 150, 30);
		contentPane.add(timePicker);

		originFilter = new JTextField();
		originFilter.setToolTipText("Origem");
		originFilter.setBounds(1720, 320, 150, 30);
		contentPane.add(originFilter);

		destinationFilter = new JTextField();
		destinationFilter.setToolTipText("Destino");
		destinationFilter.setBounds(1720, 380, 150, 30);
		contentPane.add(destinationFilter);

		JButton filterButton = new JButton("Filtrar");
		filterButton.setBackground(new Color(251, 251, 233));
		filterButton.setFont(new Font("Nirmala UI", Font.BOLD, 16));
		filterButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				filterCaronas();
			}
		});
		filterButton.setBounds(1720, 430, 150, 50);
		contentPane.add(filterButton);
		
		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.setFont(new Font("Nirmala UI", Font.BOLD, 16));
		btnLimpar.setBackground(new Color(251, 251, 233));
		btnLimpar.setBounds(1720, 496, 150, 50);
		btnLimpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				filterCaronas();
			}
		});
		contentPane.add(btnLimpar);

		List<Carona> caronas = cDAO.listarCaronasDisponíveis();

		System.out.println(caronas.size());

		try {

			for (Carona carona : caronas) {
				String origem = carona.getTrajeto().getOrigem();
				String destino = carona.getTrajeto().getDestino();

				Carro carro = vDAO.pegaVeiculo(carona.getVeiculo().getIdVeiculo());

				DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

				String data = carona.getData().format(dateFormatter);
				String horario = carona.getHorario().toLocalTime().format(timeFormatter);

				Object[] rowData = { carona.getIdCarona(), carona.getMotorista().getNome(), data, horario,
						carro.getPlaca(), origem, destino };
				tableModel.addRow(rowData);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void filterCaronas() {
		tableModel.setRowCount(0);

		LocalDate selectedDate = datePicker.getDate();
		LocalTime selectedTime = timePicker.getTime();
		String selectedOrigin = originFilter.getText();
		String selectedDestination = destinationFilter.getText();

		List<Carona> filteredCaronas = cDAO.listarCaronasPorFiltro(selectedDate, selectedTime, selectedOrigin,
				selectedDestination);

		for (Carona carona : filteredCaronas) {
			String origem = carona.getTrajeto().getOrigem();
			String destino = carona.getTrajeto().getDestino();

			Carro carro = vDAO.pegaVeiculo(carona.getVeiculo().getIdVeiculo());

			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

			String data = carona.getData().format(dateFormatter);
			String horario = carona.getHorario().toLocalTime().format(timeFormatter);

			String motoristaNome = carona.getMotorista().getNome();

			Object[] rowData = { carona.getIdCarona(), motoristaNome, data, horario, carro.getPlaca(), origem,
					destino };

			tableModel.addRow(rowData);
		}
	}

	private void limpar() {

		datePicker.setDate(null);
		timePicker.setTime(null);
		originFilter.setText("");
		destinationFilter.setText("");

		filterCaronas();
	}
}
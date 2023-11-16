package visao;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controle.CaronaDAO;
import controle.PessoaDAO;
import controle.TrajetoDAO;
import controle.VeiculoDAO;
import modelo.Carona;
import modelo.Carro;
import modelo.Pessoa;
import modelo.Trajeto;
import modelo.Veiculo;

import javax.swing.JTable;

public class ListagemCaronas extends JFrame {
	private DefaultTableModel tableModel;
	private PessoaDAO pDAO = PessoaDAO.getInstancia();
	private CaronaDAO cDAO = CaronaDAO.getInstancia();
	private VeiculoDAO vDAO = VeiculoDAO.getInstancia();
	private TrajetoDAO tDAO = TrajetoDAO.getInstancia();

	private JTable table;

	private JPanel contentPane;

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

		tableModel = new DefaultTableModel();
		tableModel.addColumn("Nome do Motorista");
		tableModel.addColumn("Hora de Saída");
		tableModel.addColumn("Veículo");
		tableModel.addColumn("Origem");
		tableModel.addColumn("Destino");


		// Inicialize a tabela com o modelo de tabela
		table = new JTable(tableModel);

		// Adicione a tabela a um JScrollPane para rolagem
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(616, 170, 1060, 651);
		contentPane.add(scrollPane);

		ResultSet resultSet = CaronaDAO.getInstancia().listarCaronasResultSet();

		try {
			while (resultSet.next()) {
				Long idCarona = resultSet.getLong("id_carona");
				String cpfMotorista = resultSet.getString("cpf_motorista");
				String cpfPassageiro = resultSet.getString("cpf_passageiro");
				Long idVeiculo = resultSet.getLong("id_veiculo");
				Integer qntpassageiros = resultSet.getInt("qnt_passageiros");
				Time horario = resultSet.getTime("horario");
				Long idTrajeto = resultSet.getLong("id_trajeto");

				// pegando no banco
				Pessoa motorista = pDAO.pegaPessoa(cpfMotorista);
				Pessoa passageiro = pDAO.pegaPessoa(cpfPassageiro);

				String nomeMotorista = motorista.getNome();

				if (passageiro != null) {
					String nomePassageiro = passageiro.getNome();
				}

				Carona carona = cDAO.pegaCarona(idCarona);
				Veiculo veiculo = carona.getVeiculo();

				Trajeto trajeto = tDAO.pegaTrajeto(idTrajeto);
				String origem = trajeto.getOrigem();
				String destino = trajeto.getDestino();

				Carro carro = vDAO.pegaVeiculo(idVeiculo);

				Object[] rowData = { nomeMotorista, horario, carro.getPlaca(), origem, destino };
				tableModel.addRow(rowData);

			}
		} catch (

		SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}

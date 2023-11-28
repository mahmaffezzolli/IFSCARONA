package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Time;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import controle.CaronaDAO;
import controle.TrajetoDAO;
import modelo.Carona;
import modelo.Sessao;
import modelo.Trajeto;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.TimePicker;

public class AlterarExcluirCarona extends JFrame {

	private JPanel contentPane;
	private JTextField txtDestino;
	private JTextField txtOrigem;
	private CaronaDAO cDAO = CaronaDAO.getInstancia();
	private JTextField textField;
	private JButton btnSalvar;
	private Long idCarona;

	private DatePicker datePicker;
	private TimePicker timePicker;

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
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
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
		btnHome.setBounds(164, 714, 75, 65);
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
		btnLogOut.setBounds(169, 828, 75, 65);
		contentPane.add(btnLogOut);

		txtDestino = new JTextField();
		txtDestino.setEnabled(false);
		txtDestino.setEditable(false);
		txtDestino.setBounds(1030, 380, 300, 40);
		txtDestino.setFont(new Font("Dialog", Font.PLAIN, 15));
		contentPane.add(txtDestino);
		txtDestino.setColumns(10);

		JLabel lblOrigem = new JLabel("Origem:");
		lblOrigem.setBounds(865, 300, 145, 35);
		lblOrigem.setFont(new Font("Dialog", Font.PLAIN, 25));
		contentPane.add(lblOrigem);

		JLabel lblDestino = new JLabel("Destino:");
		lblDestino.setBounds(865, 380, 150, 35);
		lblDestino.setFont(new Font("Dialog", Font.PLAIN, 25));
		contentPane.add(lblDestino);

		timePicker = new TimePicker();
		timePicker.getComponentTimeTextField().setFont(new Font("Dialog", Font.PLAIN, 15));
		timePicker.setEnabled(false); // Disable initially
		timePicker.setBounds(1030, 460, 300, 40);
		contentPane.add(timePicker);

		JLabel lblHorário = new JLabel("Horário:");
		lblHorário.setBounds(865, 460, 150, 35);
		lblHorário.setFont(new Font("Dialog", Font.PLAIN, 25));
		contentPane.add(lblHorário);

		DatePickerSettings dateSettings = new DatePickerSettings();
		dateSettings.setFormatForDatesCommonEra("dd/MM/yyyy");
		dateSettings.setFormatForDatesBeforeCommonEra("dd/MM/yyyy");
		dateSettings.setLocale(determineLocale("pt", "BR"));
		datePicker = new DatePicker(dateSettings);
		datePicker.setEnabled(false); 
		datePicker.setBounds(1030, 540, 300, 40);
		contentPane.add(datePicker);

		txtOrigem = new JTextField();
		txtOrigem.setEnabled(false);
		txtOrigem.setEditable(false);
		txtOrigem.setBounds(1030, 300, 300, 40);
		txtOrigem.setFont(new Font("Dialog", Font.PLAIN, 15));
		txtOrigem.setColumns(10);
		contentPane.add(txtOrigem);

		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(865, 540, 144, 35);
		lblData.setFont(new Font("Nirmala UI", Font.PLAIN, 25));
		contentPane.add(lblData);

		JLabel lblIcon = new JLabel("");
		lblIcon.setIcon(new ImageIcon(AlterarExcluirCarona.class.getResource("/assets/perfil.png")));
		lblIcon.setBounds(56, 80, 300, 273);
		contentPane.add(lblIcon);

		textField = new JTextField();
		textField.setBorder(null);
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(new Color(159, 203, 154));
		textField.setBounds(-72, -31, 492, 1061);
		contentPane.add(textField);

		JLabel lblDados = new JLabel("Dados Carona");
		lblDados.setFont(new Font("Dialog", Font.BOLD, 40));
		lblDados.setBounds(1012, 146, 376, 81);
		contentPane.add(lblDados);

		btnSalvar = new JButton("Editar");
		btnSalvar.setIcon(new ImageIcon(AlterarExcluirCarona.class.getResource("/assets/icons8-editar-50.png")));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarCarona();
			}
		});

		btnSalvar.setBackground(new Color(192, 192, 192));
		btnSalvar.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnSalvar.setBounds(1006, 668, 145, 55);
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

		btnExcluir.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnExcluir.setBackground(new Color(255, 182, 193));
		btnExcluir.setBounds(1185, 668, 145, 55);
		contentPane.add(btnExcluir);

		Carona carona = cDAO.pegaCarona(idCarona);

		if (carona != null) {
			txtDestino.setText(carona.getTrajeto().getDestino());
			txtOrigem.setText(carona.getTrajeto().getOrigem());
			datePicker.setDate(carona.getData());
			timePicker.setTime(carona.getHorario().toLocalTime());

		}

	}

	public void editarCarona() {
		if (btnSalvar.getText().equals("Editar")) {

			txtDestino.setEnabled(true);
			txtDestino.setEditable(true);

			txtOrigem.setEnabled(true);
			txtOrigem.setEditable(true);
			datePicker.setEnabled(true);
			timePicker.setEnabled(true);

			btnSalvar.setText("Salvar");

		} else if (btnSalvar.getText().equals("Salvar")) {
			Carona carona = cDAO.pegaCarona(idCarona);

			if (carona != null) {
				
				Trajeto trajeto = TrajetoDAO.getInstancia().pegaTrajeto(carona.getTrajeto().getIdTrajeto());
				
				String destino = txtDestino.getText();
				String origem = txtOrigem.getText();
				
				trajeto.setDestino(destino);
				trajeto.setOrigem(origem);
				
				TrajetoDAO.getInstancia().alterarTrajeto(trajeto);
				
				carona.setTrajeto(trajeto);

				LocalDate modifiedDate = datePicker.getDate();
				LocalTime modifiedTime = timePicker.getTime();
				LocalDateTime modifiedDateTime = LocalDateTime.of(modifiedDate, modifiedTime);

				carona.setData(modifiedDate);
				carona.setHorario(Time.valueOf(modifiedDateTime.toLocalTime()));

				boolean success = cDAO.alterarCarona(carona);

				if (success) {
					DadosAtualizados dadosAtualizados = new DadosAtualizados();
					dadosAtualizados.setVisible(true);
				} else {
					ErroAoAtualizar erroAoAtualizar = new ErroAoAtualizar();
					erroAoAtualizar.setVisible(true);
				}

				disableEditing();
			}
		}
	}

	private void disableEditing() {
		txtDestino.setEnabled(false);
		txtDestino.setEditable(false);
		txtOrigem.setEnabled(false);
		txtOrigem.setEditable(false);
		datePicker.setEnabled(false);
		timePicker.setEnabled(false);

		btnSalvar.setText("Editar");
	}

	private Locale determineLocale(String language, String country) {
		return new Locale(language, country);
	}

}

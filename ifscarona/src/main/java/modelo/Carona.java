package modelo;

import java.sql.Time;
import java.time.LocalDate;

public class Carona {

	private Long idCarona;
	private Trajeto trajeto;
	private Pessoa passageiro;
	private Pessoa motorista;
	private Veiculo veiculo;
	private Integer qntPassageiro;
	private LocalDate data;
	private Time horario;

	public Long getIdCarona() {
		return idCarona;
	}

	public void setIdCarona(Long sucesso) {
		this.idCarona = sucesso;
	}

	public Trajeto getTrajeto() {
		return trajeto;
	}

	public void setTrajeto(Trajeto trajeto) {
		this.trajeto = trajeto;
	}

	public Pessoa getPassageiro() {
		return passageiro;
	}

	public void setPassageiro(Pessoa passageiro) {
		this.passageiro = passageiro;
	}

	public Pessoa getMotorista() {
		return motorista;
	}

	public void setMotorista(Pessoa motorista) {
		this.motorista = motorista;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Integer getQntPassageiro() {
		return qntPassageiro;
	}

	public void setQntPassageiro(Integer qntLugar) {
		this.qntPassageiro = qntLugar;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Time getHorario() {
		return horario;
	}

	public void setHorario(Time horario) {
		this.horario = horario;
	}

}
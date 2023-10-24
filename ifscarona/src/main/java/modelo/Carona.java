package modelo;

import java.sql.Time;
import java.time.LocalDate;

public class Carona {

	private Integer idCarona;
	private Trajeto trajeto;
	private Pessoa passageiro;
	private Pessoa motorista;
	private Veiculo veiculo;
	private String qntPassageiro;
	private LocalDate data;
	private Time horario;

	public Integer getIdCarona() {
		return idCarona;
	}

	public void setIdCarona(Integer idCarona) {
		this.idCarona = idCarona;
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

	public String getQntPassageiro() {
		return qntPassageiro;
	}

	public void setQntPassageiro(String qntLugar) {
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
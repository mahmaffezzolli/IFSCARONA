package modelo;

public class Carona {

	private Integer idCarona;
	private Trajeto trajeto;
	private Pessoa[] passageiro;
	private Pessoa motorista;

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

	public Pessoa[] getPassageiro() {
		return passageiro;
	}

	public void setPassageiro(Pessoa[] passageiro) {
		this.passageiro = passageiro;
	}

	public Pessoa getMotorista() {
		return motorista;
	}

	public void setMotorista(Pessoa motorista) {
		this.motorista = motorista;
	}

}
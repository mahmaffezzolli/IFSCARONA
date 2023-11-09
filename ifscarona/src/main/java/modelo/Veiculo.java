package modelo;

public class Veiculo {

	private String placa;
	private String cor;
	private String marca;
	private String modelo;
	private Pessoa motorista;
	private Long idVeiculo;

	public Veiculo() {
		
	}
	
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Pessoa getMotorista() {
		return motorista;
	}

	public void setMotorista(Pessoa motorista) {
		this.motorista = motorista;
	}

	public Long getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(Long idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

}
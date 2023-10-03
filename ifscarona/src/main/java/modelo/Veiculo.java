package modelo;

public class Veiculo {

	private String cpf_pessoa;
	private String placa;
	private String cor;
	private String marca;
	private String modelo;
	private Pessoa pessoa;

	public String getCpf_pessoa() {
		return cpf_pessoa;
	}

	public void setCpf_pessoa(String cpf) {
		this.cpf_pessoa = cpf;
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

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
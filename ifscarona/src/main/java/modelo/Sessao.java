package modelo;

public class Sessao {
	private static Pessoa pessoaLogada;
	private static Motorista motoristaLogado;

	public static Pessoa getPessoaLogada() {
		return pessoaLogada;
	}

	public static void setPessoaLogada(Pessoa pessoa) {
		pessoaLogada = pessoa;
	}

	public static Motorista getMotoristaLogado() {
		return motoristaLogado;
	}

	public static void setMotoristaLogado(Motorista motoristaLogado) {
		Sessao.motoristaLogado = motoristaLogado;
	}

}
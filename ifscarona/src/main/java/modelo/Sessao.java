package modelo;

public class Sessao {
    private static Pessoa pessoaLogada;
    private static Veiculo veiculoLogado;

    public static Pessoa getPessoaLogada() {
        return pessoaLogada;
    }

    public static void setPessoaLogada(Pessoa pessoa) {
        pessoaLogada = pessoa;
    }

	public static Veiculo getVeiculoLogado() {
		return veiculoLogado;
	}

	public static void setVeiculoLogado(Veiculo veiculo) {
		veiculoLogado = veiculo;
	}
    
 
}
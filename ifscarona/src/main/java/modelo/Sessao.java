package modelo;

public class Sessao {
    private static Pessoa pessoaLogada;

    public static Pessoa getPessoaLogada() {
        return pessoaLogada;
    }

    public static void setPessoaLogada(Pessoa pessoa) {
        pessoaLogada = pessoa;
    }
}
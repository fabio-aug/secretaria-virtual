public class Aluno {
    private final int codigo;
    private final String nome;

    public Aluno(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "Aluno --->" +
                "\n     Codigo: " + codigo +
                "\n     Nome: " + nome +
                "\n";
    }
}

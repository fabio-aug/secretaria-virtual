public class Disciplina {
    private final int codigo;
    private final String nome;
    private final int cargaHorariaGeral;

    public Disciplina(int codigo, String nome, int cargaHorariaGeral) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargaHorariaGeral = cargaHorariaGeral;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getCargaHorariaGeral() {
        return cargaHorariaGeral;
    }

    @Override
    public String toString() {
        return
                "\n     Codigo: " + codigo +
                "\n     Nome: '" + nome +
                "\n     CargaHorariaGeral: " + cargaHorariaGeral;
    }
}

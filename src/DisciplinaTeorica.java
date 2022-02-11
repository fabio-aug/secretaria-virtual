public class DisciplinaTeorica extends Disciplina {
    private final String bibliografiaPrincipal;

    public DisciplinaTeorica(int codigo, String nome, int cargaHorariaGeral, String bibliografiaPrincipal) {
        super(codigo, nome, cargaHorariaGeral);
        this.bibliografiaPrincipal = bibliografiaPrincipal;
    }

    @Override
    public String toString() {
        return "DisciplinaTeorica --->" +
                super.toString() +
                "\n     BibliografiaPrincipal: " + bibliografiaPrincipal +
                "\n";
    }
}

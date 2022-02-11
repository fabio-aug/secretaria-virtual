public class DisciplinaPratica extends Disciplina {
    private final int cargaHorariaPratica;

    public DisciplinaPratica(int codigo, String nome, int cargaHorariaGeral, int cargaHorariaPratica) {
        super(codigo, nome, cargaHorariaGeral);
        this.cargaHorariaPratica = cargaHorariaPratica;
    }

    public int getCargaHorariaPratica() {
        return cargaHorariaPratica;
    }

    @Override
    public String toString() {
        return "DisciplinaPratica --->" +
                super.toString() +
                "\n     CargaHorariaPratica: " + cargaHorariaPratica +
                "\n";
    }
}

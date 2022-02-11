public class Matricula {
    private final int anoLetivo;
    private final int serie;
    private final Aluno aluno;
    private final Disciplina disciplina;
    private double notaBimestre1;
    private double notaBimestre2;
    private double notaBimestre3;
    private double notaBimestre4;

    public Matricula(int anoLetivo, int serie,Aluno aluno, Disciplina disciplina,double notaBimestre1, double notaBimestre2,double notaBimestre3, double notaBimestre4) {
        this.anoLetivo = anoLetivo;
        this.serie = serie;
        this.aluno = aluno;
        this.disciplina = disciplina;
        this.notaBimestre1 = notaBimestre1;
        this.notaBimestre2 = notaBimestre2;
        this.notaBimestre3 = notaBimestre3;
        this.notaBimestre4 = notaBimestre4;
    }

    public int getAnoLetivo() {
        return anoLetivo;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public double getNotaBimestre1() {
        return notaBimestre1;
    }

    public void setNotaBimestre1(double notaBimestre1) {
        this.notaBimestre1 = notaBimestre1;
    }

    public double getNotaBimestre2() {
        return notaBimestre2;
    }

    public void setNotaBimestre2(double notaBimestre2) {
        this.notaBimestre2 = notaBimestre2;
    }

    public double getNotaBimestre3() {
        return notaBimestre3;
    }

    public void setNotaBimestre3(double notaBimestre3) {
        this.notaBimestre3 = notaBimestre3;
    }

    public double getNotaBimestre4() {
        return notaBimestre4;
    }

    public void setNotaBimestre4(double notaBimestre4) {
        this.notaBimestre4 = notaBimestre4;
    }

    @Override
    public String toString() {
        return "Matricula {" +
                "\n     AnoLetivo: " + anoLetivo +
                "\n     Serie: " + serie +
                "\n\n     " + aluno.toString() +
                "\n     " + disciplina.toString() +
                "\n     NotaBimestre1: " + notaBimestre1 +
                "\n     NotaBimestre2: " + notaBimestre2 +
                "\n     NotaBimestre3: " + notaBimestre3 +
                "\n     NotaBimestre4: " + notaBimestre4 +
                "\n}";
    }
}

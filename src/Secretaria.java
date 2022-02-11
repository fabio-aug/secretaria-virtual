import javax.swing.*;

public class Secretaria {

    private static Database dados;
    private static Interface tela;

    // Register Disciplina (DisciplinaTeorica, DisciplinaPratica).
    public static void cadastrarDisciplina() {
        int tipoDisciplina = tela.getSelecionarDisciplina();
        String nome = tela.getNomeDisciplina();
        int cargaHorariaGeral = tela.getCargaHorariaGeral();

        int codigo;
        if (tipoDisciplina == 1) {
            int cargaHorariaPratica = tela.getCargaHorariaPratica();
            codigo = dados.addDisciplina(nome, cargaHorariaGeral, cargaHorariaPratica);
        } else {
            String bibliografiaPrincipal = tela.getBibliografiaPrincipal();
            codigo = dados.addDisciplina(nome, cargaHorariaGeral, bibliografiaPrincipal);
        }

        tela.showDisciplinaCadastrada(codigo);
    }

    // Register Aluno.
    public static void cadastrarAluno() {
        String nome = tela.getNomeAluno();
        int codigo = dados.addAluno(nome);
        tela.showAlunoCadastrado(codigo);
    }

    // Register Matricula.
    public static void fazerMatricula() {
        int anoLetivo = tela.getAnoLetivo();
        int serie = tela.getAnoSerie();
        int codigoAluno = tela.getCodgioAluno();

        Aluno aluno = dados.findAluno(codigoAluno);
        if (aluno == null) {
            tela.showAlunoNaoCadastrado();
            return;
        }

        int codigoDisciplina = tela.getCodigoDisciplina();
        Disciplina disciplina = dados.findDisciplina(codigoDisciplina);
        if (disciplina == null) {
            tela.showDisciplinaNaoCadastrada();
            return;
        }

        boolean statusCriacao = dados.checkMatricula(anoLetivo, aluno, disciplina);
        if (!statusCriacao) {
            dados.addMatricula(anoLetivo, serie, aluno, disciplina);
            tela.showMatriculaCadastrada();
        } else {
            tela.showNaoPossivelMatricula();
        }
    }

    // Adds a note for a student.
    public static void adicionarNota() {
        int codigoAluno = tela.getCodigoAluno();
        int codigoDisciplina = tela.getCodigoDisciplina();
        int anoLetivo = tela.getAnoLetivo();

        Integer encontrouMatricula = dados.findAndCheckMatriculaIndex(anoLetivo, codigoAluno, codigoDisciplina);
        if (encontrouMatricula == null) {
            tela.showMatriculaInvalida();
        } else {
            int bimestre = tela.getSeleionarBimestre();
            double nota = tela.getNotaBimestre((bimestre + 1));
            dados.addNotaMatriculaAluno(encontrouMatricula, bimestre, nota);
            tela.showNotaAdicionada();
        }
    }

    // It shows the entire report card of a student.
    public static void mostarBoletim() {
        int codigoAluno = tela.getCodgioAluno();
        int anoLetivo = tela.getAnoLetivo();
        JScrollPane tabela = dados.generateTable(codigoAluno, anoLetivo);
        tela.showBoletim(tabela, anoLetivo, codigoAluno, "teste");

    }

    public static void main(String[] args) {
        dados = new Database();
        tela = new Interface();

        try {
            while (true) {
                int acao = tela.menuOptions();

                if (acao == 1) cadastrarDisciplina();
                if (acao == 2) cadastrarAluno();
                if (acao == 3) fazerMatricula();
                if (acao == 4) adicionarNota();
                if (acao == 5) mostarBoletim();
                if (acao == 6) break;
            }
        } catch (Exception ex) {
            tela.showErro();
        }
    }
}
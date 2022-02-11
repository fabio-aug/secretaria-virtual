import javax.swing.*;
import java.awt.*;

public class Interface {
    public int menuOptions() {
        String[] options = new String[]{"1", "2", "3", "4", "5", "6"};
        return JOptionPane.showOptionDialog(
                null,
                (
                    "1) Cadastrar as disciplinas.\n" +
                    "2) Cadastrar alunos.\n"+
                    "3) Matricular aluno em uma disciplina.\n"+
                    "4) Lançar notas de um aluno.\n"+
                    "5) Mostrar boletim do aluno.\n"+
                    "6) Fechar aplicação.\n"
                ),
                "Deseja executar qual ação?",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                null
        ) + 1;
    }

    public int getSelecionarDisciplina() {
        String[] options = new String[]{"1", "2"};
        return JOptionPane.showOptionDialog(
                null,
                "1) Disciplina Pratica.\n2) Disciplina Teórica.",
                "Qual o tipo da disciplina? ",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                null
        ) + 1;
    }

    public String getNomeDisciplina() {
        return JOptionPane.showInputDialog("Informe o nome da disciplina: ");
    }

    public int getCargaHorariaGeral() {
        return Integer.parseInt(JOptionPane.showInputDialog("Informe a carga horária geral da disciplina: "));
    }

    public int getCargaHorariaPratica() {
        return Integer.parseInt(JOptionPane.showInputDialog("Informe a carga horária prática da disciplina: "));
    }

    public String getBibliografiaPrincipal() {
        return JOptionPane.showInputDialog("Informe a bibliografia principal da disciplina: ");
    }

    public void showDisciplinaCadastrada(int code) {
        JOptionPane.showMessageDialog(null, "Disciplina cadastrada!!! Seu código é: " + code);
    }

    public String getNomeAluno() {
        return JOptionPane.showInputDialog("Informe o nome do aluno: ");
    }

    public void showAlunoCadastrado(int code) {
        JOptionPane.showMessageDialog(null, "Aluno cadastrado!!! Seu código é: " + code);
    }

    public int getAnoLetivo() {
        return Integer.parseInt(JOptionPane.showInputDialog("Informe o ano letivo: "));
    }

    public int getAnoSerie() {
        return Integer.parseInt(JOptionPane.showInputDialog("Informe a série: "));
    }

    public int getCodgioAluno() {
        return Integer.parseInt(JOptionPane.showInputDialog("Informe o código do aluno: "));
    }

    public void showAlunoNaoCadastrado() {
        JOptionPane.showMessageDialog(null, "Aluno não cadastrado!!!");
    }

    public int getCodigoDisciplina() {
        return Integer.parseInt(JOptionPane.showInputDialog("Informe o código da disciplina: "));
    }

    public void showDisciplinaNaoCadastrada() {
        JOptionPane.showMessageDialog(null, "Disciplina não cadastrada!!!");
    }

    public void showMatriculaCadastrada() {
        JOptionPane.showMessageDialog(null, "Matrícula cadastrada!!!");
    }

    public void showNaoPossivelMatricula() {
        JOptionPane.showMessageDialog(null, "Não é possível cadastrar um aluno mais de uma vez na mesma disciplina durante o mesmo ano!!!");
    }

    public int getCodigoAluno() {
        return Integer.parseInt(JOptionPane.showInputDialog("Informe o código do aluno: "));
    }

    public int getSeleionarBimestre() {
        String[] options = new String[]{"1°", "2°", "3°", "4°"};
        return JOptionPane.showOptionDialog(
                null,
                "Qual o bimestre? ",
                "Bimetre",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                null
        );
    }

    public double getNotaBimestre(int bimestre) {
        double nota = Double.parseDouble(JOptionPane.showInputDialog("Informe a nota do bimestre " + bimestre + "°: "));
        while (nota < 0 || nota > 25) {
            nota = Double.parseDouble(JOptionPane.showInputDialog("Informe uma nota entre 0 e 25: "));
        }
        return nota;
    }

    public void showMatriculaInvalida() {
        JOptionPane.showMessageDialog(null, "Matrícula Inválida");
    }

    public void showNotaAdicionada() {
        JOptionPane.showMessageDialog(null, "Nota lançada com sucesso!!!");
    }

    public void showBoletim(JScrollPane table, int year, int code, String name) {
        table.setPreferredSize(new Dimension(600,300));
        JOptionPane.showMessageDialog(null, table, ("Código: " + code + " - Nome: " + name + " - Ano: " + year), JOptionPane.PLAIN_MESSAGE);
    }

    public void showErro() {
        JOptionPane.showMessageDialog(
                null,
                "Ops... Um erro inesperado aconteceu, por segurança iremos encerrar a aplicação.",
                "Erro",
                JOptionPane.ERROR_MESSAGE,
                null
        );
    }
}
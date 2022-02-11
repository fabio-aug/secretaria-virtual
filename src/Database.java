import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Database {
    private static ArrayList<Disciplina> disciplinas;
    private static ArrayList<Aluno> alunos;
    private static ArrayList<Matricula> matriculas;

    public Database() {
        disciplinas = new ArrayList<>();
        alunos = new ArrayList<>();
        matriculas = new ArrayList<>();
    }

    // Adds DisciplinaPratica to the subject array.
    // Returns the course code registered for viewing.
    public int addDisciplina(String nome, int cargaHorariaGeral, int cargaHorariaPratica) {
        int codigo = (disciplinas.size() + 1);
        disciplinas.add(new DisciplinaPratica(codigo, nome, cargaHorariaGeral, cargaHorariaPratica));
        return codigo;
    }

    // Adds DisciplinaTeorica to the subject array.
    // Retorna o código da disciplina cadastrada para vizualização;
    public int addDisciplina(String nome, int cargaHorariaGeral, String bibliografiaPrincipal) {
        int codigo = (disciplinas.size() + 1);
        disciplinas.add(new DisciplinaTeorica(codigo, nome, cargaHorariaGeral, bibliografiaPrincipal));
        return codigo;
    }

    // Adds Aluno to student array.
    // Returns the student's code registered for viewing.
    public int addAluno(String nome) {
        int codigo = (alunos.size() + 1);
        alunos.add(new Aluno(codigo, nome));
        return codigo;
    }

    // Searches for a student from a given code.
    // If nothing is found, it returns NULL.
    public Aluno findAluno(int codigo) {
        for (Aluno aluno : alunos) {
            if (aluno.getCodigo() == codigo) {
                return aluno;
            }
        }
        return null;
    }

    // Search for a course from a given code.
    // If nothing is found, it returns NULL.
    public Disciplina findDisciplina(int codigo) {
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getCodigo() == codigo) {
                return disciplina;
            }
        }
        return null;
    }

    // Checks if there is an enrollment of a student in the same course and school year.
    // If found, returns true, if there is no enrollment, returns false.
    public Boolean checkMatricula(int anoLetivo, Aluno aluno, Disciplina disciplina) {
        for (Matricula matricula : matriculas) {
            if (
                matricula.getAnoLetivo() == anoLetivo &&
                matricula.getAluno().getCodigo() == aluno.getCodigo() &&
                matricula.getDisciplina().getCodigo() == disciplina.getCodigo()
            ) {
                return true;
            }
        }
        return false;
    }

    // Adds an Enrollment to the array of enrollments.
    public void addMatricula(int anoLetivo, int serie, Aluno aluno, Disciplina disciplina) {
        matriculas.add(new Matricula(anoLetivo, serie, aluno, disciplina, 0, 0, 0, 0));
    }

    // Searches and checks if a license plate exists.
    // If it exists, returns its index in the license plate array.
    public Integer findAndCheckMatriculaIndex(int anoLetivo, int codigoAluno, int codigoDisciplina) {
        for (int i = 0; i < matriculas.size(); i++) {
            if (
                matriculas.get(i).getAnoLetivo() == anoLetivo &&
                matriculas.get(i).getAluno().getCodigo() == codigoAluno &&
                matriculas.get(i).getDisciplina().getCodigo() == codigoDisciplina
            ) {
                return i;
            }
        }
        return null;
    }

    // Adds a bimester grade to a student's license plate.
    // The process is done from the index information of the desired license plate.
    public void addNotaMatriculaAluno(int index, int bimestre, double nota) {
        if (bimestre == 0) {
            matriculas.get(index).setNotaBimestre1(nota);
        } else if (bimestre == 1) {
            matriculas.get(index).setNotaBimestre2(nota);
        } else if (bimestre == 2) {
            matriculas.get(index).setNotaBimestre3(nota);
        } else if (bimestre == 3) {
            matriculas.get(index).setNotaBimestre4(nota);
        }
    }

    // Calculates the weighted average of a license plate.
    public String generateMedia(Matricula matricula) {
        double mediaPonderada =
            (((matricula.getNotaBimestre1() * 1) +
            (matricula.getNotaBimestre2() * 1) +
            (matricula.getNotaBimestre3() * 2) +
            (matricula.getNotaBimestre4() * 2)) / 6);
        DecimalFormat df = new DecimalFormat("#,###.00");

        return (mediaPonderada == 0) ? "0.0" : df.format(mediaPonderada);
    }

    // Generates the table for viewing the data.
    public JScrollPane generateTable(int codigoAluno, int anoLetivo) {
        DefaultTableModel model = new DefaultTableModel();

        String[] cols = {"Disciplina", "CH", "CH Prática", "1° Bim.", "2° Bim.", "3° Bim.", "4° Bim.", "Média"} ;
        for (String col : cols) {
            model.addColumn(col);
        }

        for (Matricula matricula : matriculas) {
            if (matricula.getAluno().getCodigo() == codigoAluno && matricula.getAnoLetivo() == anoLetivo) {
                Disciplina disciplina = matricula.getDisciplina();
                boolean ePratica = matricula.getDisciplina() instanceof DisciplinaPratica;
                model.addRow(new Object[]{
                    matricula.getDisciplina().getNome(),
                    matricula.getDisciplina().getCargaHorariaGeral(),
                    (ePratica) ? ((DisciplinaPratica) disciplina).getCargaHorariaPratica() : "",
                    matricula.getNotaBimestre1(),
                    matricula.getNotaBimestre2(),
                    matricula.getNotaBimestre3(),
                    matricula.getNotaBimestre4(),
                    generateMedia(matricula)
                });
            }
        }

        JTable table = new JTable(model);
        table.setEnabled(false);
        return new JScrollPane(table);
    }
}
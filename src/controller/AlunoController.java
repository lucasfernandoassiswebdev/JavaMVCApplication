package controller;

import java.util.ArrayList;
import model.Aluno;

/**
 * @author LUCASFERNANDODEASSIS
 */
public class AlunoController {

    public static boolean SalvarAluno(String Matricula, String Nome) {
        Aluno a = new Aluno(Matricula, Nome);
        return a.Persistir();
    }

    public static ArrayList<String[]> getAlunos() {
        ArrayList<String[]> Alunos = new ArrayList();
        ArrayList<Aluno> A = Aluno.getAlunos();

        if (A != null) {
            for (int i = 0; i < A.size(); i++) {
                String a[] = new String[2];
                a[0] = A.get(i).getMatricula();
                a[1] = A.get(i).getNome();
                Alunos.add(a);
            }
        }

        return Alunos;
    }
}

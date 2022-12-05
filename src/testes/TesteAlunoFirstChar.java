package testes;

import java.util.List;
import actions.SelectAlunos;
import actions.SelectAlunosByFirstChar;
import model.Aluno;

public class TesteAlunoFirstChar {
	public static void main(String[] args) {
		try {
			SelectAlunosByFirstChar SA = new SelectAlunosByFirstChar();
			List<Aluno> alunos = SA.action("v");
			for (Aluno aluno : alunos) {
				System.out.println(aluno.getNome());
				System.out.println(aluno.getId());
			}			
		} catch (Exception e) {
		
		}
	}
}

package testes;

import java.util.List;
import actions.SelectAlunos;
import model.Aluno;

public class TesteSelectAlunos {
	public static void main(String[] args) {
		try {
			SelectAlunos SA = new SelectAlunos();
			List<Aluno> alunos = SA.action();
			for (Aluno aluno : alunos) {
				System.out.println(aluno.getNome());
				System.out.println(aluno.getId());
			}			
		} catch (Exception e) {
		
		}
	}
}

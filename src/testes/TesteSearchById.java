package testes;

import actions.SearchAlunoById;
import model.Aluno;

public class TesteSearchById {
	public static void main(String[] args) {
		SearchAlunoById SA = new SearchAlunoById();
		Aluno aluno = SA.action(6L);
		if(aluno != null) {
			System.out.println(aluno.getNome());
		}else {
			System.out.println("Nenhum aluno encontrado");
		}
			
	}
}

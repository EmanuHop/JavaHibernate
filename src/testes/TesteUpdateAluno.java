package testes;

import actions.SearchAlunoById;
import actions.UpdateAluno;
import model.Aluno;

public class TesteUpdateAluno {
	public static void main(String[] args) {
		SearchAlunoById SA = new SearchAlunoById();
		Aluno aluno = SA.action(4L);
		System.out.println(aluno.getEndereco());
		aluno.setEndereco("enderecoEndreco");
		UpdateAluno UA = new UpdateAluno();
		UA.action(aluno);
		Aluno aluno2 = SA.action(4L);
		System.out.println(aluno2.getEndereco());
	}
}

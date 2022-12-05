package testes;

import actions.DeleteAlunoById;

public class TesteDeleteAluno {
	public static void main(String[] args) {
		DeleteAlunoById DA = new DeleteAlunoById();
		boolean res = DA.action(6L);
		if(res) {
			System.out.println("Aluno deletado");
		}else {
			System.out.println("Nenhum aluno foi encontrado");
		}
	}
}

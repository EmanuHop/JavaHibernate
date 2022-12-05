package testes;

import java.util.Calendar;
import actions.InsertAluno;
import model.Aluno;

public class TesteInsertAluno {
	public static void main(String[] args) {
		Aluno a1 = new Aluno();
		a1.setCPF("11111111112");
		a1.setEndereco("ruaruarua");
		a1.setDataNascimento(Calendar.getInstance());
		a1.setNome("TheHomif");
		InsertAluno IA = new InsertAluno();
		IA.action(a1);
	}
}

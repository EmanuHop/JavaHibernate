package actions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import model.Aluno;

public class SearchAlunoById {
	public Aluno acao(Long id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
		EntityManager manager = factory.createEntityManager();
		
		Aluno aluno = manager.find(Aluno.class, id);
		
		manager.close();
		factory.close();
		return aluno;
	}
}

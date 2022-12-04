package actions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Aluno;

public class InsertAluno {
	public void acao(Aluno aluno) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		manager.persist(aluno);
		Aluno a1 = (Aluno) manager.merge(aluno);
		
		manager.getTransaction().commit();
	
		manager.close();
		factory.close();
	}
}

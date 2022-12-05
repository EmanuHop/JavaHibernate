package actions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Aluno;

public class UpdateAlunoById {
	public void action(Aluno aluno) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		manager.merge(aluno);
		
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}
}

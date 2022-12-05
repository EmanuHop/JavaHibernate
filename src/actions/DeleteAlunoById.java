package actions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Aluno;

public class DeleteAlunoById {
	public boolean action(Long id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
		EntityManager manager = factory.createEntityManager();
		Aluno aluno = manager.find(Aluno.class, id);
		if(aluno != null) {
			
			manager.getTransaction().begin();
			
			manager.remove(aluno);
			
			manager.getTransaction().commit();
			manager.close();
			factory.close();
			return true;
		}else {
			manager.close();
			factory.close();
			return false;
		}
	}
}

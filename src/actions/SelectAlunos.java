package actions;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Aluno;


public class SelectAlunos{
	public List<Aluno> acao(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
		EntityManager manager = factory.createEntityManager();
		
		String sql = "Select a from Aluno as a";
		Query query = manager.createQuery(sql);
		List<Aluno> alunos = query.getResultList();

		return alunos;
	}
}

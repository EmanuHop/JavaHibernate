package actions;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Aluno;

public class SelectAlunosByFirstChar {
	public List<Aluno> acao(String caracter){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
		EntityManager manager = factory.createEntityManager();
		
		String sql = "Select a from Aluno as a WHERE a.nome LIKE :paramChar";
		Query query = manager.createQuery(sql);
		query.setParameter("paramChar", caracter+"%");
		List<Aluno> alunos = query.getResultList();

		
		return alunos;
	}
}

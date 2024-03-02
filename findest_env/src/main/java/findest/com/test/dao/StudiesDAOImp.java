package findest.com.test.dao;

import java.util.Collections;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.NoResultException;
import jakarta.transaction.Transactional;
import jakarta.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import findest.com.test.entity.Studies;

@Repository
public class StudiesDAOImp implements StudiesDAO {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public StudiesDAOImp() {
	}

	@Transactional
	public void create(Studies stud) {
		if (stud == null) {
			return;
		}
		em.persist(stud);
	}

	@Transactional
	public void update(Studies stud) {
		if (stud == null) {
			return;
		}

		em.merge(stud);
	}

	@Transactional
	public Boolean remove(Studies p) {
		Studies studToRemove = findById(p.getId());
		try {
			em.remove(studToRemove);
		} catch (Exception pe) {
			System.err.println("Problem when deleting an entity ");
			return false;
		}
		return true;
	}

	public List<Studies> findAll(String sortBy, String order) {
		System.out.println("Recherche en cours...");
		StringBuilder queryBuilder = new StringBuilder("SELECT s FROM Studies s ORDER BY s.");
		queryBuilder.append(sortBy);
		if ("desc".equalsIgnoreCase(order)) {
			queryBuilder.append(" DESC");
		} else {
			queryBuilder.append(" ASC");
		}

		try {
			Query query = em.createQuery(queryBuilder.toString());
			List<Studies> resultList = query.getResultList();
			System.out.println("Result : " + resultList);
			return resultList;
		} catch (Exception e) {
			System.out.println("Querry eror : " + e.getMessage());
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	public Studies findById(Integer long1) {
		Query q = em.createNamedQuery("Studies.findById");
		q.setParameter("id", long1);
		return (Studies) q.getSingleResult();
	}

}
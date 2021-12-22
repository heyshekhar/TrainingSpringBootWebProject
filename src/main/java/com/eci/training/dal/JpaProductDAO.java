package com.eci.training.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.eci.training.domain.Product;

//@Profile("devDatabase")
@Repository
@Transactional
public class JpaProductDAO implements ProductDAO {

	@Autowired
	EntityManager em;
	
	@Override
	public Product save(Product toBeSaved) {
		em.persist(toBeSaved);
		return toBeSaved;
	}

	@Override
	public Product findById(int id) {
		return em.find(Product.class, id);
	}

	@Override
	public List<Product> findAll() {
		Query q = em.createQuery("select p from Product as p");
		return q.getResultList();
	}

	@Override
	public void removeById(int id) {
		Product p = em.find(Product.class, id);
		if(p != null) {
			em.remove(p);
		}
		
		/*
		 * Query q = em.createQuery("delete p from Product as p where p.id=:idParam");
		 * q.setParameter("idParam", id); q.executeUpdate();
		 */
	}

}


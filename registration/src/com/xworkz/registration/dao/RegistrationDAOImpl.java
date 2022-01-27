package com.xworkz.registration.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.xworkz.registration.entity.RegistrationEntity;
import com.xworkz.util.SingletonEmf;

public class RegistrationDAOImpl implements RegistrationDAO{

	@Override
	public void save(RegistrationEntity entity) {
		EntityManager entityManager = SingletonEmf.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		try {
			entityManager.persist(entity);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}

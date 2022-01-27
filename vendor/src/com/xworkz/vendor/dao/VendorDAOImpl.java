package com.xworkz.vendor.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.xworkz.util.SingletonEmf;
import com.xworkz.vendor.entity.VendorEntity;

public class VendorDAOImpl implements VendorDAO {

	@Override
	public void save(VendorEntity entity) {
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

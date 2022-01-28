package com.xworkz.vendor.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

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

	@Override
	public boolean findLogin(String loginName, String password) {
		EntityManager manager=SingletonEmf.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx=manager.getTransaction();
		tx.begin();
		try {
			Query query=manager.createNamedQuery("findLogin");
			query.setParameter("login",loginName);
			query.setParameter("pwd",password);
			Object obj=query.getSingleResult();
			if(obj!=null) {
				VendorEntity en=(VendorEntity)obj;
				return true;
			}
			
			
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		finally {
			if(manager!=null) {
				manager.close();
			}
		}
		return false;
	}

	@Override
	public boolean findByEmail(String email) {
		EntityManager manager=SingletonEmf.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx=manager.getTransaction();
		tx.begin();
		try {
			Query query=manager.createNamedQuery("findByEmail");
			query.setParameter("em", email);
			Object obj=query.getSingleResult();
			if(obj!=null) {
				return true;
			}
			tx.commit();
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		finally {
			if(manager!=null) {
				manager.close();
			}
		}
		return false;
	}

	@Override
	public void updatePasswordByEmail(String email, String password) {
		EntityManager manager=SingletonEmf.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx=manager.getTransaction();
		tx.begin();
		try {
			Query query=manager.createNamedQuery("updatePasswordByEmail");
			query.setParameter("pass", password);
			query.setParameter("em",email);
			int rowsAffected=query.executeUpdate();
		
			tx.commit();
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		
		
	}

}

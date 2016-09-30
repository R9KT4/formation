package com.etiennedesticourt.formation.service;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.etiennedesticourt.formation.model.Computer;
import com.etiennedesticourt.formation.util.HibernateUtil;

public class ComputerDao {
	private static final String SELECT_COMPUTERS_QUERY = "from Computer";
	private static final String DELETE_COMPUTER_QUERY = "delete Computer where id= :id";
	private static final String SEARCH_COMPUTERS_QUERY = "from Computer where name LIKE CONCAT('%',:name,'%')";
	
	public static ArrayList<Computer> getComputers() {
		ArrayList<Computer> computers;
		Session session = HibernateUtil.openSession();
		 
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery(SELECT_COMPUTERS_QUERY);
			computers = (ArrayList<Computer>) query.list();
		    tx.commit();
		 }
		 catch (Exception e) {
		     if (tx != null) {
		    	 tx.rollback();
		     }
		     throw e;
		 }
		 finally {
		     session.close();
		 }
		 
		 return computers;		 
	}
	
	public static void deleteComputer(int id) {		
	    Session session = HibernateUtil.openSession();
	    
	    Transaction tx = null;
	    try {
		    tx = session.beginTransaction();
		    Query q = session.createQuery(DELETE_COMPUTER_QUERY).setParameter("id", id);
		    q.executeUpdate();
		    tx.commit();
		 }
		 catch (Exception e) {
		     if (tx != null) {
		    	 tx.rollback();
		     }
		     throw e;
		 }
		 finally {
		     session.close();
		 }
	}
	
	public static ArrayList<Computer> searchComputers(String name) {
		ArrayList<Computer> computers;
		Session session = HibernateUtil.openSession();
		 
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery(SEARCH_COMPUTERS_QUERY).setParameter("name", name);
			computers = (ArrayList<Computer>) query.list();
		    tx.commit();
		 }
		 catch (Exception e) {
		     if (tx != null) {
		    	 tx.rollback();
		     }
		     throw e;
		 }
		 finally {
		     session.close();
		 }
		 
		 return computers;	
	}
}

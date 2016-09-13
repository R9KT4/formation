package com.etiennedesticourt.formation.service;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.etiennedesticourt.formation.model.Computer;
import com.etiennedesticourt.formation.util.HibernateUtil;

public class ComputerFetcher {
	private static final String SELECT_COMPUTERS_QUERY = "from Computer"; 
	
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
}

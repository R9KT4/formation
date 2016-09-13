package com.etiennedesticourt.formation.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.etiennedesticourt.formation.model.Company;
import com.etiennedesticourt.formation.model.Computer;

public class HibernateUtil {
	private static final String HIBERNATE_CONF_PATH = "/resources/hibernate.cfg.xml";
	private static final SessionFactory sessionFactory;

	static {
		 try {
			 Configuration configuration = new Configuration()
					   .addPackage("com.etiennedesticourt.formation.model")
					   .addAnnotatedClass(Computer.class)
					   .addAnnotatedClass(Company.class);
			 sessionFactory = configuration.configure(HIBERNATE_CONF_PATH).buildSessionFactory();
		 } 
		 catch (Throwable ex) {
			 System.err.println("Initial SessionFactory creation failed." + ex);
			 throw new ExceptionInInitializerError(ex);
		 }
	}
	
	public static Session openSession() {
		 return sessionFactory.openSession();
	}
}
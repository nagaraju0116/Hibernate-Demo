package com.hib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		
		//to create an obj in DB
		
		  Alien a = new Alien(); 
		  a.setAid(103); 
		  a.setAname("simon");
		  a.setTech("Gen AI");
		 
		 
		
		/*  //to make code in one line
		 * Configuration config = new Configuration();
		 * config.addAnnotatedClass(com.hib.Alien.class);
		 * config.configure("hibernate.cfg.xml");
		 */
		
		SessionFactory factory =new Configuration()
				.addAnnotatedClass(com.hib.Alien.class)
				.configure()
				.buildSessionFactory();
		
		Session session =factory.openSession();
		
		//to update the query
		//session.merge(a);
		
		//transaction is need only when save or update not to fetch a data
		Transaction transaction = session.beginTransaction();
		
		//used persist instead of save , save was deprecated in hibernate version- 7
		session.persist(a);
		//session remove should be always in transaction block
		/*
		 * Alien a = session.find(Alien.class,101);//eager
		 *  session.remove(a);
		 */
		transaction.commit();
		
		//get is deprecated instead use find
		
		//Alien a = session.get(Alien.class, 101);//eager fetching -sure about to use it
		
		//other method to fetch
		//Alien a = session.byId(Alien.class).load(102);//eager
		
		//Alien a = session.byId(Alien.class).getReference(101);//lazy fetching - not sure about to use it so it won't print in console about Hibernate
		//System.out.println(a);
		session.close();
		factory.close();
	}

}

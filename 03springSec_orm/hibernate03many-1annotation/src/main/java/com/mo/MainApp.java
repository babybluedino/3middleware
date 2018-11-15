package com.mo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class MainApp {

	public static void main(String[] args) {
		
		//create session factory
	    SessionFactory sfactory = new AnnotationConfiguration().configure().buildSessionFactory();
		
		//open session
		Session session = sfactory.openSession();
		
		//begin transaction
		Transaction txn = session.beginTransaction();
		
		//1.create complaint obj
		Complaint oc= new Complaint(11,"test complaint only");
		session.save(oc);
		//2.give same complaint object to multiple customer object
		Customer cr1 = new Customer(1,"Dino",oc);
		Customer cr2 = new Customer(2,"Dino's girlfriend Lola",oc);
		
		
		//to save the objects
		session.save(cr1);
		session.save(cr2);
		
		txn.commit();
		session.close();
		sfactory.close();
	}
	
}

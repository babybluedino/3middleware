package com.egg;

import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainAppl {
	private static SessionFactory factory;
	public static void main(String[] args) {
	//Create session factory
	factory = new Configuration().configure().buildSessionFactory();
	
	HashSet hs = new HashSet();
	hs.add(new Address("aaaa","bbbb"));
	hs.add(new Address("cccc","dddd"));
	hs.add(new Address("edee","ffff"));
	
	Employee emp = new Employee("Naveen", "HR", hs);
	
	MainAppl mappl = new MainAppl();
	mappl.saveEmployee(emp);
	
	}
	//Save employee
	void saveEmployee(Employee dummy){
		Integer emp_id = null;
		
		//open session
		Session session = factory.openSession();
		
		//Begin transaction
		Transaction txn = session.beginTransaction();
		 
		emp_id = (Integer)session.save(dummy);
		//Perform action
		
		System.out.println("Generated EMP ID is: " + emp_id);
		txn.commit();
		
		//Closing the session
		session.close();
	}
	
	//List employee
}

package com.egg;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainAppl {
	
	static SessionFactory factory;
	
	public static void main(String[] args) {
		
		//create session factory
		factory = new Configuration().configure().buildSessionFactory();
		
		//create an object of employee
		HashSet hs = new HashSet();
		hs.add(new Address("Kochi","Kerala"));
		hs.add(new Address("Chennai","TN"));
		hs.add(new Address("Bangalore","Karnataka"));
		
		Employee emp = new Employee("Raima","Finance",hs);
		
		//create an obj of mainappl so as to be able to access its methods
		MainAppl mappl = new MainAppl();
		mappl.saveEmployee(emp);

	}
	
	//save Employee
	void saveEmployee(Employee oemp)
	{
		Integer emp_id=null;
		
		//open the session-need factory
		Session session = factory.openSession();
		
		//begin transaction
		Transaction txn = session.beginTransaction();
		
		//once it is saved we will get its id as interger
		//we can return it(the generated id) for reference
		emp_id = (Integer)session.save(oemp);
		System.out.println("generated emp_id is "+emp_id);
		
		//perform action-->to commit
		txn.commit();
		
		session.close();
	}
	
	//List Employee(retrieving)

}

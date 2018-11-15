/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
import java.util.List; 
import java.util.HashMap;
import java.util.Iterator; 
 
import org.hibernate.HibernateException; 
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HQLManageEmployee {
   private static SessionFactory factory; 
   public static void main(String[] args) {
      try{
          //step 1: Create Session Factory
         factory = new Configuration().configure().buildSessionFactory();
      }catch (Throwable ex) { 
         System.err.println("Failed to create sessionFactory object." + ex);
         throw new ExceptionInInitializerError(ex); 
      }
      HQLManageEmployee ME = new HQLManageEmployee();

      ME.insertEg();
      
      ME.listEmployeesFull();

      
      System.out.println("---------------------------------");
      /* List down all the employees */
      ME.listEmployees();
   }

   /* HQL example to retrieve, when more than one field is selected */
   public void listEmployees( ){
      Session session = factory.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();

         Query qry = session.createQuery("SELECT SUM(Y.salary), Y.dept FROM "
                 + "Employee Y GROUP BY Y.dept HAVING SUM(Y.salary) >90");

        // Query qry = session.createQuery("SELECT firstName, lastName FROM "
          //       + "Employee WHERE salary >21");

          List<Object []> employees = qry.list(); 
        
         for (Iterator iterator = 
                           employees.iterator(); iterator.hasNext();){
            Object [] emp =  (Object [])iterator.next(); 

            System.out.print("salary");
            System.out.println(emp[0]+ "  Dept Name "+emp[1]);
         }
         
         for(Object [] obja: employees)
         {
        	 System.out.println(obja[0]+"------------"+obja[1]);
         }
         
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }
   
   /* HQL example to retrieve, when more than one field is selected */
   public void insertEg( ){
      Session session = factory.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();

        Query query = session.createSQLQuery("INSERT INTO mytable(fname, lname, salary) VALUES(:fnamec, :lnamec, :salaryc)");
         query.setParameter("fnamec", "dino");
         query.setParameter("lnamec", "on the table");
         query.setParameter("sryc", 245.85);
         
       /*  Query query = session.createSQLQuery("UPDATE mytable SET salary=:psalary where id =1");
         query.setParameter("psalary", 250000); */
         
         query.executeUpdate();
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }
   
   /* HQL example to retrieve, when more than one field is selected */
   public void listEmployeesFull( ){
      Session session = factory.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();

         Query qry = session.createQuery("FROM Employee WHERE salary>21");
         
        

          List employees = qry.list(); 
         for (Iterator iterator = 
                           employees.iterator(); iterator.hasNext();){
             Employee eObj = (Employee)iterator.next();
             System.out.println(eObj);
         }
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }
   
     
}

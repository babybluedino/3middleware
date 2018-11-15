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

public class HQLGroupByEg {
   private static SessionFactory factory; 
   public static void main(String[] args) {
      try{
          //step 1: Create Session Factory
         factory = new Configuration().configure().buildSessionFactory();
      }catch (Throwable ex) { 
         System.err.println("Failed to create sessionFactory object." + ex);
         throw new ExceptionInInitializerError(ex); 
      }
      HQLGroupByEg ME = new HQLGroupByEg();

      /* List down all the employees */
      ME.listEmployees();
   }

   /* HQL example to retrieve, when more than one field is selected */
   public void listEmployees( ){
      Session session = factory.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();

         Query qry = session.createQuery("SELECT SUM(Y.salary),Y.dept FROM "
                 + "Employee Y GROUP BY Y.dept");

          List<Object []> employees = qry.list(); 
         for (Iterator iterator = 
                           employees.iterator(); iterator.hasNext();){
            Object [] emp =  (Object [])iterator.next(); 

            System.out.println("Sum of salaries:"+emp[0]+"  Dept Name:"+emp[1]);
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

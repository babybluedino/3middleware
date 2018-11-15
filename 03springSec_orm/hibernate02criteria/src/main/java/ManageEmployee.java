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
import java.util.Date;
import java.util.Iterator; 
 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class ManageEmployee {
   private static SessionFactory factory; 
   public static void main(String[] args) {
      try{
         factory = new Configuration().configure().buildSessionFactory();
      }catch (Throwable ex) { 
         System.err.println("Failed to create sessionFactory object." + ex);
         throw new ExceptionInInitializerError(ex); 
      }
System.out.println("Hello");
      
Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
 
        //Get All Employees
        Criteria criteria = session.createCriteria(Employee.class);
        List<Employee> empList = criteria.list();
        for(Employee emp : empList){
            System.out.println("ID="+emp.getId()+", firstname="+emp.getFirstName());
        }
        
        System.out.println("-----------------------------------------------");
        // Get with ID, creating new Criteria 
        criteria = session.createCriteria(Employee.class)
                    .add(Restrictions.eq("id", new Integer(3)));
        Employee emp = (Employee) criteria.uniqueResult();
        System.out.println("Name=" + emp.getFirstName()+ ", Salary="
                + emp.getSalary());
 
        
        //Pagination Example
        empList = session.createCriteria(Employee.class)
                    .addOrder(Order.asc("id"))
                    .setFirstResult(3)
                    .setMaxResults(3)
                    .list();
        for(Employee emp4 : empList){
            System.out.println("Paginated Employees::"+emp4.getId()+","+emp4.getFirstName());
        }
 
        System.out.println("----------Like eg------------");
        //Like example
        empList = session.createCriteria(Employee.class)
                .add(Restrictions.like("firstName", "%t%")) //firstName is property name
                .list();
        for(Employee emp4 : empList){
            System.out.println("Employees having 't' in first name::"+emp4.getFirstName()+","+emp4.getLastName());
        }
        
        /*
        //Projections example
        long count = (Long) session.createCriteria(Employee.class)
                .setProjection(Projections.rowCount())
                .add(Restrictions.like("firstName", "%t%"))
                .uniqueResult();
        System.out.println("Number of employees with 't' in name="+count);
 
        //using Projections for sum, min, max aggregation functions
        long sumSalary = (Long) session.createCriteria(Employee.class)
            .setProjection(Projections.sum("salary"))
            .uniqueResult();
        System.out.println("Sum of Salaries="+sumSalary);
        */
        /* 
        //Join example for selecting few columns
        criteria = session.createCriteria(Employee.class, "employee");
        criteria.setFetchMode("employee.address", FetchMode.JOIN);
        criteria.createAlias("employee.address", "address"); // inner join by default
 
        ProjectionList columns = Projections.projectionList()
                        .add(Projections.property("name"))
                        .add(Projections.property("address.city"));
        criteria.setProjection(columns);
 
        List<Object[]> list = criteria.list();
        for(Object[] arr : list){
            System.out.println(Arrays.toString(arr));
        }
        */ 
         
        // Rollback transaction to avoid messing test data
        tx.commit();
        // closing hibernate resources
        session.close();
                
   }
  
}

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class MarshallDemo{
//Initialize the employees list
static EmployeesArray employees = new EmployeesArray();

//static
{
	Employee emp[] = new Employee[2];
    //Create two employees
    Employee emp1 = new Employee();
    emp1.setId(1);
    emp1.setFirstName("abc");
    emp1.setLastName("def");
    emp1.setIncome(100.0);
    emp[0] = emp1;
     
    Employee emp2 = new Employee();
    emp2.setId(2);
    emp2.setFirstName("qrs");
    emp2.setLastName("mno");
    emp2.setIncome(200.0);
    emp[1] = emp1;
     
    //Add the employees in list
    employees.setEmployees(emp);
}
public static void main(String args[]) throws JAXBException
{
    Employee emp2 = new Employee();
    emp2.setId(2);
    emp2.setFirstName("qrs");
    emp2.setLastName("mno");
    emp2.setIncome(200.0);
    
    JAXBContext jaxbContext = JAXBContext.newInstance(EmployeesArray.class);
    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
 
    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
     
    //Marshal the employees list in console
    jaxbMarshaller.marshal(emp2, System.out);
     
    //Marshal the employees list in file
    //jaxbMarshaller.marshal(employees, new File("c:/temp/employees.xml"));
}
}
import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class UnMarshallDemo {
	public static void main(String[] args) throws JAXBException{
		    JAXBContext jaxbContext = JAXBContext.newInstance(EmployeesArray.class);
		    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		     
		    //We had written this file in marshalling example
		    EmployeesArray emps = (EmployeesArray) jaxbUnmarshaller.unmarshal( new File("employees_array.xml") );
		     
		    for(Employee emp : emps.getEmployees())
		    {
		        System.out.println(emp.getId());
		        System.out.println(emp.getFirstName());
		    }
	}
}

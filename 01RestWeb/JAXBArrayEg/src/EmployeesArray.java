
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name = "employees")
@XmlAccessorType (XmlAccessType.FIELD)
public class EmployeesArray
{
    @XmlElement(name = "employee")
    private Employee employees[] = null;
 
    public Employee[] getEmployees() {
        return employees;
    }
 
    public void setEmployees(Employee employees[]) {
        this.employees = employees;
    }
}
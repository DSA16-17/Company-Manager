package proyecto;

import java.util.List;

public interface CompanyManager {
    void addDepartment(String name,String description);
    void addEmployee(String DNI, String name,double salary,String Department);
    void addSalesMan(String DNI,String name, double salary,String Department);
    void addDirector(String DNI,String name, double salary,String Department);
    List<Department> returnDepartments();
    List<Employee> employeeBySalary();
    List<Employee> employeeByDepartment(String name);
    void addSale(String DNI,int sale,double amount);
    double salaries(String Department);
    double salaries();

}

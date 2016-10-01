package proyecto;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public interface CompanyManager {
    void addDepartment(String name,String description);
    void addEmployee(String DNI, String name,double salary,String Department);
    void addSalesMan(String DNI,String name, double salary,String Department);
    void addDirector(String DNI,String name, double salary,String Department);
    ArrayList<Department> returnDepartments();
    ArrayList<Employee> EmployeeBySalary();
    ArrayList<Employee> EmployeeByDepartment(String name);
    void addSale(String DNI,int sale,double amount);
    double Salaries(String Department);
    double Salaries();

}

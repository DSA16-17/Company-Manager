package proyecto;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public interface CompanyManager {
    void addDepartment(String name,String description);
    void addEmployee(String DNI, String name,double salary,String Department);
    void addSalesMan(String DNI,String name, double salary,String Department);
    void addDirector(String DNI,String name, double salary,String Department);
    ArrayList<Department> Departmens();
    ArrayList<Employee> EmployerBySalary();
    ArrayList<Employee> EmployerByDepartment();
    void addSale(String name,int sale,double amount);
    double Salaries(String Department);
    double Salaries();

}

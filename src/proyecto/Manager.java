package proyecto;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Turpitude on 29/09/2016.
 */
public class Manager implements CompanyManager {
    HashMap<String, Department> departments;
    ArrayList<Employee> employees;

    @Override
    public void addDepartment(String name,String description) {

        Department dep= new Department(name,description);
        this.departments.put(name,dep);

    }

    @Override
    public void addEmployee(String DNI, String name, double salary, String Department) {
        Employee emp= new Employee(DNI,name,salary,Department,2);
        employees.add(emp);

    }

    @Override
    public void addSalesMan(String DNI, String name, double salary, String Department) {
        Employee emp= new Employee(DNI,name,salary,Department,1);
        employees.add(emp);
    }

    @Override
    public void addDirector(String DNI, String name, double salary, String Department) {
        Employee emp= new Employee(DNI,name,salary,Department,0);
        employees.add(emp);
    }

    @Override
    public ArrayList<Department> Departmens() {
        return null;
    }

    @Override
    public ArrayList<Employee> EmployerBySalary() {
        return null;
    }

    @Override
    public ArrayList<Employee> EmployerByDepartment() {
        return null;
    }

    @Override
    public void addSale(String name, int sale, double amount) {

    }

    @Override
    public double Salaries(String Department) {
        return 0;
    }

    @Override
    public double Salaries() {
        return 0;
    }
}

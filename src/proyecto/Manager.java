package proyecto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringJoiner;

public class Manager implements CompanyManager {
    HashMap<String, Department> departments = new HashMap<String,Department>();
    HashMap<String,Employee> employees;

    @Override
    public void addDepartment(String name,String description) {

        Department dep= new Department(name,description);
        this.departments.put(name,dep);

    }

    @Override
    public void addEmployee(String DNI, String name, double salary, String department) {
        Department dep = departments.get(department);
        Employee emp= new Employee(DNI,name,salary,department,2);
        dep.addemployee(emp);
        departments.put(department,dep);
        employees.put(DNI,emp);

    }

    @Override
    public void addSalesMan(String DNI, String name, double salary, String department) {
        Department dep = departments.get(department);
        Employee emp= new Employee(DNI,name,salary,department,1);
        dep.addemployee(emp);
        departments.put(department,dep);
        employees.put(DNI,emp);
    }

    @Override
    public void addDirector(String DNI, String name, double salary, String department) {
        Department dep = departments.get(department);
        Employee emp= new Employee(DNI,name,salary,department,0);
        dep.addemployee(emp);
        departments.put(department,dep);
        employees.put(DNI,emp);
    }

    @Override
    public ArrayList<Department> returnDepartments() {
        ArrayList<Department> Departmens =new ArrayList<Department>();
        for(int i=0;i<Departmens.size();i++){
            Departmens.add(departments.get(i));
        }
        return  Departmens;
    }

    @Override
    public ArrayList<Employee> EmployeeBySalary() {
        return null;


    }

    @Override
    public ArrayList<Employee> EmployeeByDepartment(String name) {
        ArrayList<Employee> emp = new ArrayList<Employee>();
        Department dep = departments.get(name);
        emp = dep.employees;
        return emp;




    }

    @Override
    public void addSale(String DNI, int sale, double amount) {
        Sales sales = new Sales(DNI, sale, amount);
        Employee emp = employees.get(DNI);
        emp.addSale(sales);
        employees.put(DNI,emp);
        Department dep = departments.get(emp.department);
        emp = dep.returnemp(DNI);
        emp.addSale(sales);
        dep.update(emp);
        departments.put(dep.name,dep);
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

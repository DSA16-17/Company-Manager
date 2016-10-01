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
        ArrayList<Department> Departmens =new ArrayList<Department>(departments.values());
        return  Departmens;
    }

    @Override
    public ArrayList<Employee> EmployeeBySalary() {
    ArrayList<Department> dep= new ArrayList<>(departments.values());
        ArrayList<Employee> emp=new ArrayList<>();
        ArrayList<Employee> emp1;
        for(int i=0;i<dep.size();i++){
            emp1=dep.get(i).salaries();
            emp.addAll(emp1);
        }
        return emp;
    }

    @Override
    public ArrayList<Employee> EmployeeByDepartment(String name) {
        ArrayList<Employee> emp;
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
    public double Salaries(String Department){
        Department dep=departments.get(Department);
        ArrayList<Employee> emp=dep.salaries();
        double sum=0;
        for(int i=0;i<emp.size();i++){
            sum=sum+emp.get(i).returnSalary();
        }
        return sum;
    }

    @Override
    public double Salaries() {
        ArrayList<Department> dep= new ArrayList<>(departments.values());
        ArrayList<Employee> emp=new ArrayList<>();
        ArrayList<Employee> emp1;
        for(int i=0;i<dep.size();i++){
            emp1=dep.get(i).salaries();
            emp.addAll(emp1);
        }
        double sum=0;
        for(int i=0;i<emp.size();i++){
            sum=sum+emp.get(i).returnSalary();
        }
        return sum;
    }
    }


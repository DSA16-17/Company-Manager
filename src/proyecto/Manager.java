package proyecto;

import java.util.*;

public class Manager implements CompanyManager {
    HashMap<String, Department> departments = new HashMap<String,Department>();
    HashMap<String,Employee> employees = new HashMap<String,Employee>();

    @Override
    public void addDepartment(String name,String description) { //Añadir departamento
        Department dep= new Department(name,description);
        this.departments.put(name,dep);
    }
    @Override
    public void addEmployee(String DNI, String name, double salary, String department) { //Añadri empleado
        Department dep = departments.get(department);
        Employee emp= new Employee(DNI,name,salary,2,department);
        dep.addemployee(emp);
        departments.put(department,dep);
        employees.put(DNI,emp);
    }
    @Override
    public void addSalesMan(String DNI, String name, double salary, String department) { //Añadir persona de ventas
        Department dep = departments.get(department);
        Employee emp= new Employee(DNI,name,salary,1,department);
        dep.addemployee(emp);
        departments.put(department,dep);
        employees.put(DNI,emp);
    }
    @Override
    public void addDirector(String DNI, String name, double salary, String department) { //Añadir director de departamento
        Department dep = departments.get(department);
        Employee emp= new Employee(DNI,name,salary,0,department);
        dep.addemployee(emp);
        departments.put(department,dep);
        employees.put(DNI,emp);
    }
    @Override
    public ArrayList<Department> returnDepartments() { //Devolver una lista con todos los departamentos
        ArrayList<Department> Departmens =new ArrayList<Department>(departments.values());
        return  Departmens;
    }

    @Override
    public List<Employee> employeeBySalary() { //Devuelve los empleados ordenados por salario
        List<Department> dep= new ArrayList<>(departments.values());
        List<Employee> emp=new ArrayList<>();

        for(int i=0;i<dep.size();i++){
            List<Employee> emp1;
            emp1=dep.get(i).salaries(); //Calcula el salario de cada persona del departamento y lo mete en una lista de empleados
            emp.addAll(emp1); //Mete la lista de empleados anterior en una lista mas grande donde estaran todos los empleados
        }
        Collections.sort(emp, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return new Double(o2.getSalary()).compareTo(new Double(o1.getSalary()));
            }
        });
        return emp;
    }

    @Override
    public List<Employee> employeeByDepartment(String name) { //Devuelve los empleados de un departamento
        List<Employee> emp;
        Department dep = departments.get(name);
        emp = dep.employees;
        return emp;

    }

    @Override
    public void addSale(String DNI, int sale, double amount) { //Añadir una venta a una persona de cierto departamento
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
    public double salaries(String Department){ //Devuelve la suma de los salarios de un departamento
        Department dep=departments.get(Department);
        List<Employee> emp=dep.salaries();
        double sum=0;
        for(int i=0;i<emp.size();i++){
            sum=sum+emp.get(i).getSalary(); //Aqui vamos creando la suma de todos los salarios
        }
        return sum;
    }

    @Override
    public double salaries() { //Devuelve el salario de toda la empresa
        List<Department> dep= new ArrayList<>(departments.values());
        double suma= 0;
        for(int i=0;i<dep.size();i++){
            suma=dep.get(i).salaries2()+suma; //Calcula el salario de cada departamento
        }
        return suma;
    }
    }


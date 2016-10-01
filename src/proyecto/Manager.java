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
    public ArrayList<Employee> EmployeeBySalary() { //Devuelve los empleados ordenados por salario
        ArrayList<Department> dep= new ArrayList<>(departments.values());
        ArrayList<Employee> emp=new ArrayList<>();

        for(int i=0;i<dep.size();i++){
            ArrayList<Employee> emp1;
            emp1=dep.get(i).salaries(); //Calcula el salario de cada persona del departamento y lo mete en una lista de empleados
            emp.addAll(emp1); //Mete la lista de empleados anterior en una lista mas grande donde estaran todos los empleados
        }
        Collections.sort(emp, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return new Double(o2.returnSalary()).compareTo(new Double(o1.returnSalary()));
            }
        });
        return emp;
    }

    @Override
    public ArrayList<Employee> EmployeeByDepartment(String name) { //Devuelve los empleados de un departamento
        ArrayList<Employee> emp;
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
    public double Salaries(String Department){ //Devuelve la suma de los salarios de un departamento
        Department dep=departments.get(Department);
        ArrayList<Employee> emp=dep.salaries();
        double sum=0;
        for(int i=0;i<emp.size();i++){
            sum=sum+emp.get(i).returnSalary(); //Aqui vamos creando la suma de todos los salarios
        }
        return sum;
    }

    @Override
    public double Salaries() { //Devuelve el salario de toda la empresa
        ArrayList<Department> dep= new ArrayList<>(departments.values());
        ArrayList<Employee> emp=new ArrayList<>();
        ArrayList<Employee> emp1;
        for(int i=0;i<dep.size();i++){
            emp1=dep.get(i).salaries(); //Calcula el salario de cada empleados por departamento y lo mete en emp1
            emp.addAll(emp1);//Metemos los valores de emp1 en emp
        }
        double sum=0;
        for(int i=0;i<emp.size();i++){
            sum=sum+emp.get(i).returnSalary(); //Creamos la suma de salarios de toda la empresa
        }
        return sum;
    }
    }


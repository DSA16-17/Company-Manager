package proyecto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Department {
    public String name;
    public String description;
    ArrayList<Employee> employees;


    public Department(String name,String description) {
        this.name=name;
        this.description=description;
        employees = new ArrayList<Employee>();

    }
    public void addemployee (Employee e){

        employees.add(e);
    }
    public Employee returnemp (String DNI){
        for (int i = 0; i<employees.size();i++){
            if (employees.get(i).DNI == DNI)
            {
                return employees.get(i);
            }
        }
        return null;
    }
    public void update (Employee e){
        for (int i = 0; i<employees.size();i++){
            if (e.DNI == employees.get(i).DNI){
                employees.set(i,e);
            }
        }
    }
    public ArrayList<Employee> salaries(){
        Employee emp;
        ArrayList<Employee> employ = new ArrayList<Employee>();
        int dire=0;//Posicion del director
        double sum=0;

        for (int i=0;i<employees.size();i++){
            emp=employees.get(i);
            double salary=emp.returnSalary(sum);
            if(emp.category==0){//Director
                    dire=i;
                sum=sum-salary;
            }
            sum=sum+salary;
            employ.add(emp);
        }
        emp=employ.get(dire);
        employ.remove(dire);
        double salary= emp.returnSalary(sum);
        employ.add(emp);
        Collections.sort(employ, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return new Double(o2.getSalary()).compareTo(new Double(o1.getSalary()));
            }
        });
        return employ;
    }
    public double salaries2(){
        double sum=0;
        for(Employee e:this.employees){
            sum=e.returnSalary(sum)+sum;
        }
        return sum;
    }
}



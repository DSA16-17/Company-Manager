package proyecto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;


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
        double sum=0;
        ArrayList<Employee> employ = new ArrayList<>();
        int dire=0;
        for (int i=0;i<employees.size();i++){
            emp=employees.get(i);
            double salary=emp.salary;
            if(emp.category==1){
              for(int j=0;j<emp.empsales.size();j++)
              {
                  salary=salary+(0.1*emp.empsales.get(j).amount);

              }
            }

            if(emp.category==0){
                    dire=i;
                sum=sum-salary;
            }
            sum=sum+salary;
            emp.salary=salary;
            employ.add(emp);
        }
        emp=employ.get(dire);
        emp.salary=emp.salary+(0.05*sum);
        employ.set(dire,emp);
        Collections.sort(employ, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return new Double(o2.returnSalary()).compareTo(new Double(o1.returnSalary()));
            }
        });
        return employ;
    }


}



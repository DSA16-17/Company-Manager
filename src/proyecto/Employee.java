package proyecto;

import java.util.ArrayList;

public class Employee{
    public String DNI;
    public String name;
    public double salary;
    public int category;
    public String department;
    ArrayList<Sales> empsales;


    public Employee(String DNI, String name, double salary,String department, int category) {
        this.DNI = DNI;
        this.name = name;
        this.salary = salary;
        this.category = category;
        this.department = department;
        if (category == 1){
           empsales = new ArrayList<Sales>();
        }
    }
    public void addSale(Sales s){
        empsales.add(s);
    }
    public double returnSalary(){
        return this.salary;
    }

}
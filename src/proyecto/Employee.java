package proyecto;

public class Employee{
    public String DNI;
    public String name;
    public double salary;
    public String Department;
    public int category;


    public Employee(String DNI, String name, double salary, String department, int category) {
        this.DNI = DNI;
        this.name = name;
        this.salary = salary;
        Department = department;
        this.category = category;
    }
}
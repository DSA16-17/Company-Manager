package proyecto;

import java.util.ArrayList;

public class Employee {
    public String DNI;
    public String name;
    public double salary;
    public int category;
    public String department;
    ArrayList<Sales> empsales;


    public Employee(String DNI, String name, double salary, int category, String department) {
        this.DNI = DNI;
        this.name = name;
        this.salary = salary;
        this.category = category;
        this.department = department;
        if (category == 1) {
            empsales = new ArrayList<Sales>();
        }
    }

    public double returnSalary(double sum) {
        double sal = this.salary;

        if (this.category == 1) {
            for (int j = 0; j < this.empsales.size() - 1; j++) //Ponemos el -1 porque las ventas empiezan en el 1
            {
                sal = sal + 0.1 * this.empsales.get(j).amount;
            }
        }
        if (this.category == 0) {
            sal = sal + 0.05 * sum;
        }
        return sal;

    }

    public void addSale(Sales s) {
        empsales.add(s);
    }

    public double getSalary() {
        return salary;
    }
}

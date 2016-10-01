package proyecto;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	CompanyManager man = new Manager();
        man.addDepartment("DET","Tecnologia");
        man.addDepartment("IT","Informatica");
        man.addDepartment("DDS","Distribución");

        man.addEmployee("666J","Dolc",100,"DET");
        man.addEmployee("69F","Llas",50,"DET");
        man.addDirector("1337A","Grig",1000,"DET");

        man.addEmployee("100T","Tirojeta",100,"IT");
        man.addSalesMan("300K","Cojo",500,"IT");
        man.addDirector("27C","Lobo",20,"IT");

        man.addEmployee("50X","Pallus",20,"DDS");
        man.addSalesMan("110R","Yisas",200,"DDS");
        man.addDirector("999H","Gunzi",1001,"DDS");

        man.addSale("110R",1,1000);//Añadir venta a Yisas
        man.addSale("300K",1,5000);//Es la primera venta y por eso ponemos el 1 para ser mas amigable

        ArrayList<Department> dep = man.returnDepartments();
        for (int i = 0; i<dep.size();i++){  //Imprimir los tres departamentos
            System.out.println(dep.get(i).name);
        }
        ArrayList<Employee> emp = man.EmployeeByDepartment("IT");
        for (int i = 0; i<emp.size();i++){ //Imprimir los empleados del departamento
            System.out.println(emp.get(i).name);
        }

        ArrayList<Employee>empl = man.EmployeeBySalary();
        for (int i = 0; i<empl.size();i++){ //Imprimir los empleados
            System.out.println(empl.get(i).name);
        }

        double salaries = man.Salaries();
        System.out.println(salaries);



    }
}

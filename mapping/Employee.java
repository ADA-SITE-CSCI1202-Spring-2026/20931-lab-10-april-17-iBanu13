package mapping;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Employee {
    String firstName;
    String lastName;
    double salary;

    public Employee(String firstName, String lastName, double salary){
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    } 

    public String getFirstName(){
        return this.firstName;
    } 
    public String getLastName(){
        return this.lastName;
    } 

    public double getSalary(){
        return this.salary;
    } 
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Kayra", "Han", 1000.50));
        employeeList.add(new Employee("Ilyas", "Mehdiyev", 2000.35));
        employeeList.add(new Employee("Dogukan", "Yilmaz", 2500.63));
        employeeList.add(new Employee("Tabriz", "Ahmadli", 3000.46));


        Function<Employee, String> formatCard = e -> "Name: [" + e.getLastName() + " " + e.getFirstName() + "]-Salary: $[" + e.getSalary() + "]";
        Function<Employee, Double> salaryPicker = Employee::getSalary;

        for (Employee emp : employeeList) {
            System.out.println(formatCard.apply(emp));
            System.out.println("Direct Salary Access: " + salaryPicker.apply(emp) + "\n");
        }
    }
}

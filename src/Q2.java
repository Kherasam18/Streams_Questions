import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private String department;
    private int age;
    private double salary;

    public Employee(String name, String department, int age, double salary) {
        this.name = name;
        this.department = department;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }
}

public class Q2 {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John Doe", "IT", 30, 50000));
        employees.add(new Employee("Jane Doe", "Engineering", 35, 600));
        employees.add(new Employee("Bob Smith", "Finance", 40, 70000));
        employees.add(new Employee("Alice Johnson", "Engineering", 45, 800));
        employees.add(new Employee("Charlie Brown", "HR", 50, 90000));
        employees.add(new Employee("Eve Green", "Engineering", 55, 1000));
        employees.add(new Employee("Frank White", "IT", 60, 110000));
        employees.add(new Employee("Grace Black", "Engineering", 65, 1200));
        employees.add(new Employee("Hank Davis", "Finance", 70, 130000));
        employees.add(new Employee("Ivy Miller", "Engineering", 75, 1400));

        double avgSalary = employees.stream().filter(employee -> employee.getDepartment().equals("Engineering"))
                .collect(Collectors.averagingDouble(Employee::getSalary));

        System.out.println(avgSalary);
    }
}

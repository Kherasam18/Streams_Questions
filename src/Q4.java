import java.util.ArrayList;
import java.util.List;

class Emp {
    private String name;
    private String department;
    private int age;
    private double salary;

    public Emp(String name, String department, int age, double salary) {
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

public class Q4 {
    public static void main(String[] args) {
        List<Emp> emps = new ArrayList<>();

        emps.add(new Emp("John Doe", "IT", 30, 50000));
        emps.add(new Emp("Jane Doe", "Engineering", 35, 600));
        emps.add(new Emp("Bob Smith", "Finance", 40, 70000));
        emps.add(new Emp("Alice Johnson", "Engineering", 45, 800));
        emps.add(new Emp("Charlie Brown", "HR", 50, 90000));
        emps.add(new Emp("Eve Green", "Engineering", 55, 1000));
        emps.add(new Emp("Frank White", "IT", 60, 110000));
        emps.add(new Emp("Grace Black", "Engineering", 65, 1200));
        emps.add(new Emp("Hank Davis", "Finance", 70, 130000));
        emps.add(new Emp("Ivy Miller", "Engineering", 75, 1400));

        List<String> departmentNames = emps.stream()
                .map(Emp::getDepartment)
                .distinct()
                .toList();

        System.out.println(departmentNames);
    }
}

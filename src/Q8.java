import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

class Car{
    private String name;
    private String Color;
    private int doors;
    private String engine;

    public Car(String name, String color, int doors, String engine) {
        this.name = name;
        this.Color = color;
        this.doors = doors;
        this.engine = engine;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return Color;
    }

    public int getDoors() {
        return doors;
    }

    public String getEngine() {
        return engine;
    }
}

public class Q8 {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Car 1", "Red", 4, "V8"));
        cars.add(new Car("Car 2", "Blue", 2, "V6"));
        cars.add(new Car("Car 3", "Green", 4, "V8"));
        cars.add(new Car("Car 4", "Blue", 2, "V6"));
        cars.add(new Car("Car 5", "Black", 4, "V8"));
        cars.add(new Car("Car 6", "White", 2, "V6"));
        cars.add(new Car("Car 7", "Gray", 4, "V8"));
        cars.add(new Car("Car 8", "Silver", 2, "V6"));
        cars.add(new Car("Car 9", "Brown", 4, "V8"));
        cars.add(new Car("Car 10", "Orange", 2, "V6"));

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the color of the car: ");
        String color = sc.next();
        System.out.println("Enter the number of doors 2 or 4: ");;
        int doors = sc.nextInt();
        System.out.println("Enter the engine type V8 or V6: ");
        String engine = sc.next();

        Predicate<Car> filter = car -> car.getColor().equals(color)
                && car.getDoors() == doors
                && car.getEngine().equals(engine);
        cars.stream()
                .filter(filter)
                .forEach(car -> System.out.println(car.getName()));
    }
}

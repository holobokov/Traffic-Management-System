import java.util.ArrayList;
import java.util.Random;

public class Car {
    private String id;
    private final int priority;
    private static ArrayList<Car> vehicles = new ArrayList<Car>();

    protected Car(int priority) {
        id = generateId();
        this.priority = priority;
        vehicles.add(this);
    }

    public Car() {
        this(1);
    }

    private String generateId() {
        Random rand = new Random();
        String newId;

        do {
            int id = rand.nextInt(100000);
            newId = "CAR-" + id;
        } while (idExists(newId));

        return newId;
    }

    private boolean idExists(String id) {
        for (Car v: vehicles) {
            if (v.id.equals(id)) {
                return true;
            }
        }
        return false;
    }

    public int getPriority() {
        return priority;
    }

    public String getId() {
        return id;
    }

    public static ArrayList<Car> getVehicles() {
        return vehicles;
    }
}

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Direction> directions = new ArrayList<Direction>(Arrays.asList(Direction.north, Direction.east, Direction.west));

        ArrayList<TrafficLights> trfc = new ArrayList<TrafficLights>();
        Collections.addAll(trfc, new TrafficLights(Light.red, Direction.north, WorkingMode.auto),
                new TrafficLights(Light.green, Direction.east, WorkingMode.auto),
                new TrafficLights(Light.green, Direction.west, WorkingMode.auto));

        Map<Direction, Car> vehiclesByDirection = new HashMap<Direction, Car>();


        Intersection intersection = new Intersection("318935", "Marszałkowska x Warszawska", 93.22, 224.1, directions, trfc, 3);
        Intersection intersection2 = new Intersection("318936", "Mikołowska x Karola Miarki", 53.22, 224.1, directions, trfc, 3);
        Intersection intersection3 = new Intersection("318937", "Mickiewicza x 3 maja", 97.22, 224.1, directions, trfc, 3);

//        Intersection.printIntersections();

        Car car = new Car();
        Bus bus = new Bus();
        EmergencyVehicle ambulance = new EmergencyVehicle();

        intersection.addVehicle(car, Direction.east);
        intersection.addVehicle(bus, Direction.east);
        intersection.addVehicle(ambulance, Direction.north);

        intersection.showVehicles();
    }

    public static void greetings() {
        System.out.println("Welcome to the Traffic Management System!");
        System.out.println("Menu:");
        System.out.println("1. Add");
        System.out.println("2. Delete");
        System.out.println("3. System");
        System.out.println("0. Quit");
    }
}


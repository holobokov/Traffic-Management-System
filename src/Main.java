import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        greetings();
        ArrayList<Direction> directions = new ArrayList<Direction>();
        directions.add(Direction.north);
        directions.add(Direction.south);
        directions.add(Direction.west);

        ArrayList<TrafficLights> trfc = new ArrayList<TrafficLights>();
        trfc.add(new TrafficLights(Light.red, Direction.north, WorkingMode.auto));
        trfc.add(new TrafficLights(Light.green, Direction.east, WorkingMode.auto));
        trfc.add(new TrafficLights(Light.green, Direction.west, WorkingMode.auto));


        Intersection intersection = new Intersection("318935", "Marszałkowska", 93.22, 224.1, directions, 3, trfc);
        Intersection intersection2 = new Intersection("318936", "Marszałkowska2", 93.22, 224.1, directions, 3, trfc);
        Intersection intersection3 = new Intersection("318937", "Marszałkowska3", 93.22, 224.1, directions, 3, trfc);

        intersection.addIntersection();
        intersection2.addIntersection();
        intersection3.addIntersection();

        Intersection.printIntersections();
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


import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        greetings();
        ArrayList<Direction> directions = new ArrayList<Direction>();
        directions.add(Direction.north);
        directions.add(Direction.south);
        directions.add(Direction.west);

        Intersection intersection = new Intersection("318935", "Marszałkowska", 93.22, 224.1, directions, 3);
        Intersection intersection2 = new Intersection("318936", "Marszałkowska2", 93.22, 224.1, directions, 3);
        Intersection intersection3 = new Intersection("318937", "Marszałkowska3", 93.22, 224.1, directions, 3);

        intersection.addIntersection();
        intersection2.addIntersection();
        intersection3.addIntersection();

        Intersection.printIntersections();

        intersection.removeIntersection();
        intersection2.removeIntersection();
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


import java.util.*;

enum Direction {
    north,
    south,
    east,
    west;
}

public class Intersection {
    private String id;
    private String name;
    private double lat;
    private double lon;
    private int vehiclesWaiting;
    private Map<Direction, TrafficLights> trafficLightsByDirection = new HashMap<Direction, TrafficLights>();
    private Map<Direction, ArrayList<Car>> vehiclesByDirection = new HashMap<Direction, ArrayList<Car>>();
    private static ArrayList<Intersection> intersections = new ArrayList<Intersection>();

    public Intersection() {
        id = "-";
        name = "-";
        lat = 0;
        lon = 0;
        trafficLightsByDirection = new HashMap<>();
        vehiclesWaiting = 0;
        intersections.add(this);
    }

    public Intersection(String name, double lat, double lon,
                        ArrayList<Direction> availableDirections,
                        ArrayList<TrafficLights> trafficLights,
                        int vehiclesWaiting) {
        this.id = generateId();
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.trafficLightsByDirection = new HashMap<>();
        this.vehiclesWaiting = vehiclesWaiting;

        for (TrafficLights light : trafficLights) {
            if (availableDirections.contains(light.getDirection())) {
                this.trafficLightsByDirection.put(light.getDirection(), light);
            }
        }
        intersections.add(this);
    }

    private String generateId() {
        Random rand = new Random();
        String newId;

        do {
            int id = rand.nextInt(100000);
            newId = "INT-" + id;
        } while (idExists(newId));

        return newId;
    }

    private boolean idExists(String id) {
        for (Intersection inters: intersections) {
            if (inters.id.equals(id)) {
                return true;
            }
        }
        return false;
    }

    public void addVehicle(Car vehicle, Direction direction) {
        if (!trafficLightsByDirection.containsKey(direction)) return;
        if (!vehiclesByDirection.containsKey(direction)) vehiclesByDirection.put(direction, new ArrayList<>());
        vehiclesByDirection.get(direction).add(vehicle);
        vehiclesWaiting++;
    }

    public void showVehicles() {
        for (Direction dir : vehiclesByDirection.keySet()) {
            int[] vehicles = getVehiclesByDirection(dir);
            System.out.println("Direction: " + dir + ", cars: " + vehicles[0] + ", buses: " + vehicles[1] + ", emergency vehicles:" + vehicles[2]);
        }
    }

    public int[] getVehiclesByDirection(Direction direction) {
        int c = 0;
        int b = 0;
        int e = 0;
        for (Car car : vehiclesByDirection.get(direction)) {
            if (car.getPriority() == 1) c++;
            else if (car.getPriority() == 3) b++;
            else if (car.getPriority() == 10) e++;
        }

        return new int[]{c, b, e};
    }


    public void removeIntersection() {
        Iterator<Intersection> it = intersections.iterator();

        while (it.hasNext()) {
            Intersection curr = it.next();
            if (curr.getId().equals(id)) {
                it.remove();
            }
        }
    }

    public ArrayList<Intersection> getIntersections() {
        return intersections;
    }

    public static void printIntersections() {
        for (Intersection intersection : intersections) {
            System.out.println(intersection.toString());
        }
    }

    public String getStringDirections() {
        String str = "";
        for (Direction direction : trafficLightsByDirection.keySet()) {
            str += direction + ", ";
        }

        return str;
    }

    public String getStringLights() {
        String str = "";

        for (TrafficLights light : trafficLightsByDirection.values()) {
            str += light.toString() + "\n";
        }

        return str;
    }

    public String getId() {
        return id;
    }

    public void printIntersection() {
        int[] north = trafficLightsByDirection.containsKey(Direction.north) ? getVehiclesByDirection(Direction.north) : new int[]{0, 0, 0};
        int[] south = trafficLightsByDirection.containsKey(Direction.south) ? getVehiclesByDirection(Direction.south) : new int[]{0, 0, 0};
        int[] west = trafficLightsByDirection.containsKey(Direction.west) ? getVehiclesByDirection(Direction.west) : new int[]{0, 0, 0};
        int[] east = trafficLightsByDirection.containsKey(Direction.east) ? getVehiclesByDirection(Direction.east) : new int[]{0, 0, 0};
        
        System.out.println("\n========================================");
        System.out.println("  INTERSECTION: " + name + " (ID: " + id + ")");
        System.out.println("========================================");
        System.out.println();
        System.out.println("                   NORTH");
        System.out.println("                 C:" + north[0] + " B:" + north[1] + " E:" + north[2]);
        System.out.println("                     |");
        System.out.println("                     |");
        System.out.println(" WEST C:" + west[0] + " B:" + west[1] + " E:" + west[2] + "--- + ---E:" + east[2] + " B:" + east[1] + " C:" + east[0] + " EAST");
        System.out.println("                     |");
        System.out.println("                     |");
        System.out.println("                 C:" + south[0] + " B:" + south[1] + " E:" + south[2]);
        System.out.println("                   SOUTH");
        System.out.println();
        System.out.println("Total waiting vehicles: " + vehiclesWaiting);
        System.out.println("Legend: C=Cars, B=Buses, E=Emergency");
        System.out.println("========================================\n");
    }

    @Override
    public String toString() {
        return "Id: " + id + ", Name: " + name + ", Lat: " + lat + ", Lon: " + lon + ", Directions: " + getStringDirections() + "Number of waiting vehicles: " + vehiclesWaiting;
    }
}

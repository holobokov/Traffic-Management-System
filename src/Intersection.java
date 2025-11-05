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

    public Intersection(String id, String name, double lat, double lon,
                        ArrayList<Direction> availableDirections,
                        ArrayList<TrafficLights> trafficLights,
                        int vehiclesWaiting) {
        this.id = id;
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

    public void addVehicle(Car vehicle, Direction direction) {
        if (!vehiclesByDirection.containsKey(direction)) vehiclesByDirection.put(direction, new ArrayList<>());
        vehiclesByDirection.get(direction).add(vehicle);
    }

    public void showVehicles() {
        for (Direction dir: vehiclesByDirection.keySet()) {
            int c = 0;
            int b = 0;
            int e = 0;
            for (Car car : vehiclesByDirection.get(dir)) {
                if (car.getPriority() == 1) c++;
                else if (car.getPriority() == 3) b++;
                else if (car.getPriority() == 10) e++;
            }

            System.out.println("Direction: " + dir + ", cars: " + c + ", buses: " + b + ", emergency vehicles:" + e);
        }
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

    @Override
    public String toString() {
        return "Id: " + id + ", Name: " + name + ", Lat: " + lat + ", Lon: " + lon + ", Directions: " + getStringDirections() + "Number of waiting vehicles: " + vehiclesWaiting;
    }
}

import java.util.*;

enum Direction {
    north(1),
    south(2),
    east(3),
    west(4);

    public final int value;

    Direction(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

public class Intersection {
    private String id;
    private String name;
    private double lat;
    private double lon;
    private Map<Direction, TrafficLights> trafficLightsByDirection = new HashMap<>();
    private int vehiclesWaiting;
    private static ArrayList<Intersection> intersections = new  ArrayList<Intersection>();

    public Intersection() {
        id = "-";
        name = "-";
        lat = 0;
        lon = 0;
        trafficLightsByDirection = new HashMap<>();
        vehiclesWaiting = 0;
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
    }

    public void addIntersection() {
        intersections.add(this);
    }

    public void removeIntersection() {
        Iterator<Intersection> it =  intersections.iterator();

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
        for (Intersection intersection: intersections) {
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
        return "Id: " + id + ", Name: " + name + ", Lat: " + lat + ", Lon: " + lon + ", Directions: " + getStringDirections() + "Number of waiting vehicles: " + vehiclesWaiting + '\n' + getStringLights();
    }
}

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
    private ArrayList<Direction> directions;
    private int vehiclesWaiting;
    private static ArrayList<Intersection> intersections = new  ArrayList<Intersection>();
    //TODO: dodac sygnalizacje swietlna jako private pole klasy.
    //TODO: idea zeby zrobic mape w ktorej kazdy direction bedzie mial odpowiadajace mu swiatlo;

    public Intersection() {
        id = "-";
        name = "-";
        lat = 0;
        lon = 0;
        directions = new ArrayList<>();
        vehiclesWaiting = 0;
    }

    public Intersection(String id, String name, double lat, double lon,  ArrayList<Direction> directions, int vehiclesWaiting) {
        this.id = id;
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.directions = new ArrayList<>(directions);
        this.vehiclesWaiting = vehiclesWaiting;
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
        for (int i = 0; i < directions.size(); i++) {
            if (directions.get(i).getValue() == 1) {
                str += "north";
            } else if (directions.get(i).getValue() == 2) {
                str += "south";
            } else if (directions.get(i).getValue() == 3) {
                str += "east";
            } else {
                str += "west";
            }

            str += ", ";
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

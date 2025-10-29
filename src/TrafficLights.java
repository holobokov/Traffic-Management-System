import java.util.ArrayList;

enum Light {
    green,
    yellow,
    red;
}

enum WorkingMode {
    auto,
    manual,
    emergency;
}

public class TrafficLights {
    private Light currentLight;
    private double greenDuration;
    private Direction direction;
    private WorkingMode workingMode;
    private static ArrayList<Light> statesHistory =  new ArrayList<Light>();
    private static ArrayList<TrafficLights> trafficLights = new ArrayList<TrafficLights>();

    public TrafficLights() {
        currentLight = Light.red;
        greenDuration = 0;
        direction = Direction.north;
        workingMode = WorkingMode.auto;
        statesHistory.add(currentLight);
    }

    public TrafficLights(Light currentLight, Direction direction, WorkingMode workingMode) {
        this.currentLight = currentLight;
        this.greenDuration = 30;
        this.direction = direction;
        this.workingMode = workingMode;
        statesHistory.add(currentLight);
    }

    public TrafficLights(Light currentLight, double greenDuration, Direction direction, WorkingMode workingMode) {
        this.currentLight = currentLight;
        this.greenDuration = greenDuration;
        this.direction = direction;
        this.workingMode = workingMode;
        statesHistory.add(currentLight);
    }

    public Light getCurrentLight() {
        return currentLight;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return "Direction: " + direction + ", Current light: " + currentLight + ", " + "Green duration: " + greenDuration + ", " + "Working mode: " + workingMode;
    }
}
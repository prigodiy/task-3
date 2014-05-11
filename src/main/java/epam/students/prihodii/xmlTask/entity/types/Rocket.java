package epam.students.prihodii.xmlTask.entity.types;

public class Rocket {

    private int rockets;

    public Rocket(int rockets) {
        this.rockets = rockets;
    }

    public int getRockets() {
        return rockets;
    }

    @Override
    public String toString() {
        return String.valueOf(rockets);
    }
}

package epam.students.prihodii.xmlTask.entity.types;

public class Radar {

    private boolean radar;

    public Radar(boolean radar) {
        this.radar = radar;
    }

    public boolean getRadar() {
        return radar;
    }

    public void setRadar(boolean radar) {
        this.radar = radar;
    }


    @Override
    public String toString() {
        return String.valueOf(radar);
    }
}

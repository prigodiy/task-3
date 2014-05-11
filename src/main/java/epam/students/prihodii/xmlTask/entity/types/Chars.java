package epam.students.prihodii.xmlTask.entity.types;

import epam.students.prihodii.xmlTask.entity.enumTypes.Crew;
import epam.students.prihodii.xmlTask.entity.enumTypes.PlaneType;

public class Chars {

    private PlaneType planeType;
    private Crew crew;
    private Ammo ammo;
    private Rocket rocket = new Rocket(0);
    private Radar radar = new Radar(false);

    public PlaneType getPlaneType() {
        return planeType;
    }

    public Crew getCrew() {
        return crew;
    }

    public Ammo getAmmo() {
        return ammo;
    }

    public Rocket getRocket() {
        return rocket;
    }

    public Radar getRadar() {
        return radar;
    }

    public void setPlaneType(PlaneType planeType) {
        this.planeType = planeType;
    }

    public void setCrew(Crew crew) {
        this.crew = crew;
    }

    public void setAmmo(Ammo ammo) {
        this.ammo = ammo;
    }

    public void setRocket(Rocket rocket) {
        this.rocket = rocket;
    }

    public void setRadar(Radar radar) {
        this.radar = radar;
    }

    @Override
    public String toString() {
        return "Plane Type: " + planeType + " Crew: " + crew +
                " Ammo: " + ammo + " Rockets: " + rocket +
                " Radar: " + radar;

    }
}

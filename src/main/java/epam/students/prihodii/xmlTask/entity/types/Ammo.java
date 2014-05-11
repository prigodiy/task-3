package epam.students.prihodii.xmlTask.entity.types;

public class Ammo {

    private boolean ammo;

    public Ammo(boolean ammo) {
        this.ammo = ammo;
    }

    public boolean getAmmo() {
        return ammo;
    }

    public void setAmmo(boolean ammo) {
        this.ammo = ammo;
    }

    @Override
    public String toString() {
        return String.valueOf(ammo);
    }
}

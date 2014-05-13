package epam.students.prihodii.xmlTask.entity;

import epam.students.prihodii.xmlTask.entity.types.Chars;
import epam.students.prihodii.xmlTask.entity.types.Parameters;

public class Plane implements Comparable<Plane> {

    private String id;
    private String model;
    private String origin;
    private Chars chars;
    private Parameters parameters;
    private int price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Chars getChars() {
        return chars;
    }

    public void setChars(Chars chars) {
        this.chars = chars;
    }

    public Parameters getParameters() {
        return parameters;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int compareTo(Plane o) {
        return model.compareTo(o.model);
    }

    @Override
    public String toString() {
        return "ID: " + id + "\n" +
                "Model: " + model + "\n" +
                "Origin: " + origin + "\n" +
                "Chars: " + chars + "\n" +
                "Parameters: " + parameters + "\n" +
                "Price: " + price;
    }
}

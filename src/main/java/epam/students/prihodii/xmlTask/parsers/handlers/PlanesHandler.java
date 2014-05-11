package epam.students.prihodii.xmlTask.parsers.handlers;

import epam.students.prihodii.xmlTask.entity.Plane;
import epam.students.prihodii.xmlTask.entity.enumTypes.Crew;
import epam.students.prihodii.xmlTask.entity.enumTypes.PlaneType;
import epam.students.prihodii.xmlTask.entity.types.*;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class PlanesHandler extends DefaultHandler {

    private List<Plane> planes = new ArrayList<>();

    private Plane assembledPlane;
    private Chars assembledChars;
    private Ammo assembledAmmo;
    private Parameters assembledParameters;

    private String contentHolder;

    public List<Plane> getPlanes() {
        return planes;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        switch (qName) {
            case "plane":
                assembledPlane = new Plane();
                assembledPlane.setId(attributes.getValue("id"));
                break;
            case "chars":
                assembledChars = new Chars();
                break;
            case "ammo":
                assembledAmmo = new Ammo(Boolean.valueOf(attributes.getValue("status")));
                break;
            case "parameters":
                assembledParameters = new Parameters();
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        switch (qName) {
            case "plane":
                planes.add(assembledPlane);
                break;
            case "model":
                assembledPlane.setModel(contentHolder);
                break;
            case "origin":
                assembledPlane.setOrigin(contentHolder);
                break;
            case "chars":
                assembledPlane.setChars(assembledChars);
                break;
            case "type":
                assembledChars.setPlaneType(PlaneType.valueOf(contentHolder));
                break;
            case "crew":
                assembledChars.setCrew(Crew.valueOf(contentHolder));
                break;
            case "ammo":
                assembledChars.setAmmo(assembledAmmo);
                break;
            case "rocket":
                assembledChars.setRocket(new Rocket(Integer.valueOf(contentHolder)));
                break;
            case "radar":
                assembledChars.setRadar(new Radar(Boolean.valueOf(contentHolder)));
                break;
            case "parameters":
                assembledPlane.setParameters(assembledParameters);
                break;
            case "length":
                assembledParameters.setLength(Integer.valueOf(contentHolder));
                break;
            case "width":
                assembledParameters.setWidth(Integer.valueOf(contentHolder));
                break;
            case "height":
                assembledParameters.setHeight(Integer.valueOf(contentHolder));
                break;
            case "price":
                assembledPlane.setPrice(Integer.valueOf(contentHolder));
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        contentHolder = String.valueOf(ch, start, length);
    }
}

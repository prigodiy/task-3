package epam.students.prihodii.xmlTask.parsers;

import epam.students.prihodii.xmlTask.entity.Plane;
import epam.students.prihodii.xmlTask.entity.enumTypes.Crew;
import epam.students.prihodii.xmlTask.entity.enumTypes.PlaneType;
import epam.students.prihodii.xmlTask.entity.types.*;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class PlanesStAXParser extends AbstractPlanesParser {

    private Plane assembledPlane;
    private Chars assembledChars;
    private Ammo assembledAmmo;
    private Parameters assembledParameters;

    public List<Plane> parseDocument(String xmlPath) {
        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader reader = factory.createXMLStreamReader(new FileReader(xmlPath));
            parsePlanesList(reader);
            return planes;
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void parsePlanesList(XMLStreamReader reader) throws XMLStreamException {
        while (reader.hasNext()) {
            int event = reader.next();
            switch (event) {
                case XMLStreamConstants.START_ELEMENT:
                    String localName = reader.getLocalName();
                    switch (localName) {
                        case "plane":
                            assembledPlane = new Plane();
                            assembledPlane.setId(reader.getAttributeValue("", "id"));
                            break;
                        case "model":
                            assembledPlane.setModel(reader.getElementText());
                            break;
                        case "origin":
                            assembledPlane.setOrigin(reader.getElementText());
                            break;
                        case "chars":
                            assembledChars = new Chars();
                            break;
                        case "type":
                            assembledChars.setPlaneType(PlaneType.valueOf(reader.getElementText()));
                            break;
                        case "crew":
                            assembledChars.setCrew(Crew.valueOf(reader.getElementText()));
                            break;
                        case "ammo":
                            assembledAmmo = new Ammo(Boolean.valueOf(reader.getAttributeValue("", "status")));
                            assembledChars.setAmmo(assembledAmmo);
                            break;
                        case "rocket":
                            assembledChars.setRocket(new Rocket(Integer.valueOf(reader.getElementText())));
                            break;
                        case "radar":
                            assembledChars.setRadar(new Radar(Boolean.valueOf(reader.getElementText())));
                            break;
                        case "parameters":
                            assembledParameters = new Parameters();
                            break;
                        case "length":
                            assembledParameters.setLength(Integer.valueOf(reader.getElementText()));
                            break;
                        case "width":
                            assembledParameters.setWidth(Integer.valueOf(reader.getElementText()));
                            break;
                        case "height":
                            assembledParameters.setHeight(Integer.valueOf(reader.getElementText()));
                            break;
                        case "price":
                            assembledPlane.setPrice(Integer.valueOf(reader.getElementText()));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    localName = reader.getLocalName();
                    switch (localName) {
                        case "plane":
                            planes.add(assembledPlane);
                            break;
                        case "chars":
                            assembledPlane.setChars(assembledChars);
                            break;
                        case "parameters":
                            assembledPlane.setParameters(assembledParameters);
                            break;
                    }
                    break;
            }
        }
    }
}

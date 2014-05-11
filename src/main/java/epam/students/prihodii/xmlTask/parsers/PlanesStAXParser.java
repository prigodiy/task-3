package epam.students.prihodii.xmlTask.parsers;

import epam.students.prihodii.xmlTask.entity.Plane;
import epam.students.prihodii.xmlTask.parsers.handlers.PlanesHandler;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.helpers.AttributesImpl;

public class PlanesStAXParser {

    private List<Plane> planes = new ArrayList<>();

    private Plane assembledPlane;

    public List<Plane> getPlanes() {
        return planes;
    }

    public void parseDocument(String xmlPath) {
        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader reader = factory.createXMLStreamReader(new FileReader(xmlPath));
            parsePlanesList(reader, xmlPath);
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }

    private void parsePlanesList(XMLStreamReader reader, String xmlPath) throws XMLStreamException {
        PlanesHandler handler = new PlanesHandler();
        while (reader.hasNext()) {
            int event = reader.next();
            switch (event) {
                case XMLStreamConstants.START_ELEMENT:

                    break;
                case XMLStreamConstants.END_ELEMENT:

                    break;
                case XMLStreamConstants.CHARACTERS:

                    break;
            }
        }
    }
}

package epam.students.prihodii.xmlTask.parsers;

import epam.students.prihodii.xmlTask.entity.Plane;
import epam.students.prihodii.xmlTask.parsers.handlers.PlanesHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

public class PlanesSAXParser extends AbstractPlanesParser {

    public List<Plane> parseDocument(String xmlPath) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            PlanesHandler handler = new PlanesHandler();
            parser.parse(xmlPath, handler);
            return handler.getPlanes();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

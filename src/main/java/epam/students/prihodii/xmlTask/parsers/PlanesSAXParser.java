package epam.students.prihodii.xmlTask.parsers;

import epam.students.prihodii.xmlTask.parsers.handlers.PlanesHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class PlanesSAXParser {

    public void parseDocument(String xmlPath) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            PlanesHandler handler = new PlanesHandler();
            parser.parse(xmlPath, handler);

            System.out.println(handler.getPlanes().get(0));
            System.out.println();
            System.out.println(handler.getPlanes().get(1));
            System.out.println();
            System.out.println(handler.getPlanes().get(2));

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}

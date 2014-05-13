package epam.students.prihodii.xmlTask;

import epam.students.prihodii.xmlTask.parsers.PlanesDOMParser;
import epam.students.prihodii.xmlTask.parsers.PlanesSAXParser;
import epam.students.prihodii.xmlTask.parsers.PlanesStAXParser;
import epam.students.prihodii.xmlTask.validator.PlanesXSDValidator;
import epam.students.prihodii.xmlTask.view.PlanesListView;

import java.io.IOException;

public class Test {

    private static final String XML_PATH = ".\\src\\main\\resources\\Planes.xml";
    private static final String XSD_PATH = ".\\src\\main\\resources\\Planes.xsd";

    public static void main(String[] args) throws IOException {
        if (PlanesXSDValidator.validate(XML_PATH, XSD_PATH)) {
            System.out.println("DOM:");
            PlanesListView.print(new PlanesDOMParser().parseDocument(XML_PATH));
            System.out.println();
            System.out.println("SAX:");
            PlanesListView.print(new PlanesSAXParser().parseDocument(XML_PATH));
            System.out.println();
            System.out.println("StAX:");
            PlanesListView.print(new PlanesStAXParser().parseDocument(XML_PATH));
            System.out.println();
        }
    }
}

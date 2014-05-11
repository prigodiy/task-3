package epam.students.prihodii.xmlTask;

import epam.students.prihodii.xmlTask.parsers.PlanesSAXParser;
import epam.students.prihodii.xmlTask.parsers.PlanesStAXParser;
import epam.students.prihodii.xmlTask.validator.PlanesXSDValidator;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        System.out.print("Validate: ");
        System.out.println(PlanesXSDValidator
                .validateXML(".\\src\\main\\resources\\Planes.xml",
                        ".\\src\\main\\resources\\Planes.xsd"));
        System.out.println("==============================");

        //new PlanesDOMParser().parseDocument(".\\src\\main\\resources\\Planes.xml");
        //new PlanesSAXParser().parseDocument(".\\src\\main\\resources\\Planes.xml");
        new PlanesStAXParser().parseDocument(".\\src\\main\\resources\\Planes.xml");
    }
}

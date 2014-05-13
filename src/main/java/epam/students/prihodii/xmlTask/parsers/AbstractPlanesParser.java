package epam.students.prihodii.xmlTask.parsers;

import epam.students.prihodii.xmlTask.entity.Plane;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPlanesParser {

    protected List<Plane> planes = new ArrayList<>();

    public abstract List<Plane> parseDocument(String xmlPath);
}

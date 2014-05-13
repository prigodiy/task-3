package epam.students.prihodii.xmlTask.view;

import epam.students.prihodii.xmlTask.entity.Plane;

import java.util.Collections;
import java.util.List;

public class PlanesListView {

    private static final String PLANE_SEPARATOR = "===============================";

    public static void print(List<Plane> planes) {
        Collections.sort(planes);
        for (Plane plane : planes) {
            System.out.println(plane);
            System.out.println(PLANE_SEPARATOR);
        }
    }
}

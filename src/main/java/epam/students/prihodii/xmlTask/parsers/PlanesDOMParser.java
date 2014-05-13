package epam.students.prihodii.xmlTask.parsers;

import epam.students.prihodii.xmlTask.entity.Plane;
import epam.students.prihodii.xmlTask.entity.enumTypes.Crew;
import epam.students.prihodii.xmlTask.entity.enumTypes.PlaneType;
import epam.students.prihodii.xmlTask.entity.types.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class PlanesDOMParser extends AbstractPlanesParser {

    public List<Plane> parseDocument(String xmlPath) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlPath);
            Element root = document.getDocumentElement();
            NodeList nodeList = root.getChildNodes();
            parsePlanesList(nodeList);
            return planes;
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void parsePlanesList(NodeList planesNodeList) {
        for (int index = 0; index < planesNodeList.getLength(); index++) {
            Node planesNode = planesNodeList.item(index);
            if (planesNode.getNodeType() == Node.ELEMENT_NODE) {
                Element planeElement = (Element) planesNode;
                Plane plane = new Plane();
                plane.setId(planeElement.getAttribute("id"));

                Element modelElement = (Element) planeElement.getElementsByTagName("model").item(0);
                Element originElement = (Element) planeElement.getElementsByTagName("origin").item(0);
                Element priceElement = (Element) planeElement.getElementsByTagName("price").item(0);

                plane.setModel(modelElement.getFirstChild().getNodeValue());
                plane.setOrigin(originElement.getFirstChild().getNodeValue());
                plane.setPrice(Integer.valueOf(priceElement.getFirstChild().getNodeValue()));

                Chars chars = new Chars();

                plane.setChars(chars);

                NodeList charsNodeList = planeElement.getElementsByTagName("chars");
                for (int i = 0; i < charsNodeList.getLength(); i++) {
                    Node charsNode = charsNodeList.item(i);
                    if (charsNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element charsElement = (Element) charsNode;

                        Element typeElement = (Element) charsElement.getElementsByTagName("type").item(0);
                        Element crewElement = (Element) charsElement.getElementsByTagName("crew").item(0);
                        Element ammoElement = (Element) charsElement.getElementsByTagName("ammo").item(0);
                        String ammo = ammoElement.getAttribute("status");
                        if (Boolean.valueOf(ammo)) {
                            NodeList ammoNodeList = charsElement.getElementsByTagName("ammo");
                            for (int j = 0; j < ammoNodeList.getLength(); j++) {
                                Node ammoNode = ammoNodeList.item(j);
                                if (ammoNode.getNodeType() == Node.ELEMENT_NODE) {
                                    ammoElement = (Element) ammoNode;

                                    Element rocketElement = (Element) ammoElement.getElementsByTagName("rocket").item(0);
                                    Element radarElement = (Element) ammoElement.getElementsByTagName("radar").item(0);

                                    chars.setRocket(new Rocket(Integer.valueOf(rocketElement.getFirstChild().getNodeValue())));
                                    chars.setRadar(new Radar(Boolean.valueOf(radarElement.getFirstChild().getNodeValue())));
                                }
                            }
                        }

                        chars.setPlaneType(PlaneType.valueOf(typeElement.getFirstChild().getNodeValue()));
                        chars.setCrew(Crew.valueOf(crewElement.getFirstChild().getNodeValue()));
                        chars.setAmmo(new Ammo(Boolean.valueOf(ammo)));
                    }
                }

                Parameters parameters = new Parameters();

                plane.setParameters(parameters);

                NodeList parametersNodeList = planeElement.getElementsByTagName("parameters");
                for (int i = 0; i < parametersNodeList.getLength(); i++) {
                    Node parametersNode = parametersNodeList.item(i);
                    if (parametersNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element parametersElement = (Element) parametersNode;

                        Element lengthElement = (Element) parametersElement.getElementsByTagName("length").item(0);
                        Element widthElement = (Element) parametersElement.getElementsByTagName("width").item(0);
                        Element heightElement = (Element) parametersElement.getElementsByTagName("height").item(0);

                        parameters.setLength(Integer.valueOf(lengthElement.getFirstChild().getNodeValue()));
                        parameters.setWidth(Integer.valueOf(widthElement.getFirstChild().getNodeValue()));
                        parameters.setHeight(Integer.valueOf(heightElement.getFirstChild().getNodeValue()));
                    }
                }

                planes.add(plane);
            }
        }
    }
}

package epam.students.prihodii.xmlTask.validator;

import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class PlanesXSDValidatorTest {

    private static final String VALID_XML_PATH = ".\\src\\main\\resources\\Planes.xml";
    private static final String INVALID_XML_PATH = ".\\src\\main\\resources\\InvalidPlanes.xml";
    private static final String XSD_PATH = ".\\src\\main\\resources\\Planes.xsd";

    @Test
    public void testValidate_validXML_expectedEqualsTrue() throws Exception {
        assertTrue(PlanesXSDValidator.validate(VALID_XML_PATH, XSD_PATH));
    }

    @Test
    public void testValidate_invalidXML_expectedEqualsFalse() throws Exception {
        assertFalse(PlanesXSDValidator.validate(INVALID_XML_PATH, XSD_PATH));
    }
}

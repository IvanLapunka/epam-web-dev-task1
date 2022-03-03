package by.training.task1.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class XmlValidatorTest {
    private XmlValidator validator = XmlValidator.getInstance();
    private static final String XSD_SCHEMA = "data/example.xsd";
    private static final String BAD_XML_ELEMENT = "test_data/example_bad_element.xml";
    private static final String BAD_XML_ID = "test_data/example_duplicate_id.xml";


    @Test
    public void isNotValidXmlElementTest(){
        boolean result;
        validator = XmlValidator.getInstance();
        result = validator.isValid(BAD_XML_ELEMENT,XSD_SCHEMA);
        assertFalse(result);
    }

    @Test
    public void isNotValidXmlIdTest(){
        boolean result;
        validator = XmlValidator.getInstance();
        result = validator.isValid(BAD_XML_ID,XSD_SCHEMA);
        assertFalse(result);
    }


}
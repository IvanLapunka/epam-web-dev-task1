package by.training.task1.validator;

import by.training.task1.builder.GemErrorHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XmlValidator {
    Logger log = LogManager.getLogger();
    private static XmlValidator INSTANCE;
    private XmlValidator(){}

    public static XmlValidator getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new XmlValidator();
        }
        return INSTANCE;
    }

    public boolean isValid(String xmlFile, String xsdFile) {
        try {
            final SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            final Schema schema = schemaFactory.newSchema(new File(xsdFile));
            final Validator validator = schema.newValidator();
            validator.setErrorHandler(new GemErrorHandler());
            validator.validate(new StreamSource(new File(xmlFile)));
        } catch (SAXException e) {
            log.error("There was errors during xml parsing", e);
            return false;
        } catch (IOException e) {
            log.error("There were errors during xml reading", e);
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        final XmlValidator instance = XmlValidator.getInstance();
        System.out.println(instance.isValid("test_data/example_bad_element.xml", "data/example.xsd"));
    }
}

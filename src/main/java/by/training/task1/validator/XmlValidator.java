package by.training.task1.validator;

import by.training.task1.builder.GemErrorHandler;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XmlValidator {
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
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static void main(String[] args) {
        final XmlValidator instance = XmlValidator.getInstance();
        System.out.println(instance.isValid("data/example_bad.xml", "data/example.xsd"));
    }
}

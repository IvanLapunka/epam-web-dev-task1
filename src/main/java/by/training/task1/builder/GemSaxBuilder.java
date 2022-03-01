package by.training.task1.builder;

import by.training.task1.exception.XmlCustomException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class GemSaxBuilder extends AbstractGemBuilder{
    Logger log = LogManager.getLogger();
    private GemSaxHandler handler;
    private XMLReader reader;

    public GemSaxBuilder() {
        handler = new GemSaxHandler();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            final SAXParser saxParser = factory.newSAXParser();
            reader = saxParser.getXMLReader();
            reader.setContentHandler(handler);
        } catch (ParserConfigurationException e) {
            log.error(e.getMessage());
        } catch (SAXException e) {
            log.error(e.getMessage());
        }
    }

    public void buildGemSet(String fileName) throws XmlCustomException {
        try {
            reader.parse(fileName);
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new XmlCustomException("There was an error during reading the file", e);
        } catch (SAXException e) {
            log.error(e.getMessage());
            throw new XmlCustomException("There was saxError", e);
        }
        gemSet = handler.getGems();
    }
}

package by.training.task1.builder;

import by.training.task1.entity.Gem;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class GemSaxBuilder {
    private Set<Gem> gemSet;
    private GemSaxHandler handler;
    private XMLReader reader;

    public GemSaxBuilder() {
        gemSet = new HashSet<>();
        handler = new GemSaxHandler();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            final SAXParser saxParser = factory.newSAXParser();
            reader = saxParser.getXMLReader();
            reader.setContentHandler(handler);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    public Set<Gem> getGemSet() {
        return gemSet;
    }

    public void buildGemSet(String fileName) {
        try {
            reader.parse(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        gemSet = handler.getGems();
    }
}

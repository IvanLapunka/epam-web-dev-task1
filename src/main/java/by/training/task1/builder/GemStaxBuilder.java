package by.training.task1.builder;

import by.training.task1.entity.Beauty;
import by.training.task1.entity.Color;
import by.training.task1.entity.Gem;
import by.training.task1.entity.Origin;
import by.training.task1.entity.Precious;
import by.training.task1.entity.Quality;
import by.training.task1.entity.SemiPrecious;
import by.training.task1.entity.XmlGemTags;
import com.sun.xml.fastinfoset.stax.factory.StAXInputFactory;
import org.codehaus.plexus.util.xml.XmlStreamReader;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Set;

public class GemStaxBuilder {
    Set<Gem> gemSet;
    XMLInputFactory factory;
    EnumMap<XmlGemTags, String> tagValues;

    public GemStaxBuilder() {
        gemSet = new HashSet<>();
        factory = StAXInputFactory.newInstance();
        tagValues = new EnumMap<>(XmlGemTags.class);
    }

    public Set<Gem> getGemSet() {
        return gemSet;
    }

    public void buildGemsSet(String fullFilaPath) {
        try(XmlStreamReader streamReader = new XmlStreamReader(new File(fullFilaPath))) {
            final XMLStreamReader xmlStreamReader = factory.createXMLStreamReader(streamReader);
            while (xmlStreamReader.hasNext()) {
                int type = xmlStreamReader.next();
                if (XMLStreamConstants.START_ELEMENT == type) {
                    if (xmlStreamReader.getLocalName().equals(XmlGemTags.PRECIOUS.getValue())
                            || XmlGemTags.SEMIPRECIOUS.getValue().equals(xmlStreamReader.getLocalName())) {
                        Gem gem = buildGem(xmlStreamReader, xmlStreamReader.getLocalName());
                        gemSet.add(gem);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    private Gem buildGem(XMLStreamReader xmlStreamReader, String elementName) throws XMLStreamException {
        tagValues.clear();

        final String id = xmlStreamReader.getAttributeValue(null, XmlGemTags.ID.getValue());
        final String valuable = xmlStreamReader.getAttributeValue(null, XmlGemTags.VALUABLE.getValue());
        final String quality = xmlStreamReader.getAttributeValue(null, XmlGemTags.QUALITY.getValue());

        while (xmlStreamReader.hasNext()) {
             int type = xmlStreamReader.next();
             Gem gem;
             if (type == XMLStreamConstants.START_ELEMENT) {
                 XmlGemTags tag = XmlGemTags.fromValue(xmlStreamReader.getLocalName());

                 switch(tag) {
                     case NAME: tagValues.put(XmlGemTags.NAME, getText(xmlStreamReader));
                         break;
                     case ORIGIN: tagValues.put(XmlGemTags.ORIGIN, getText(xmlStreamReader));
                         break;
                     case COLOR: tagValues.put(XmlGemTags.COLOR, getText(xmlStreamReader));
                         break;
                     case TRANSPARENCY: tagValues.put(XmlGemTags.TRANSPARENCY, getText(xmlStreamReader));
                         break;
                     case WEIGHT: tagValues.put(XmlGemTags.WEIGHT, getText(xmlStreamReader));
                         break;
                     case CUTTING: tagValues.put(XmlGemTags.CUTTING, getText(xmlStreamReader));
                         break;
                     case DATE: tagValues.put(XmlGemTags.DATE, getText(xmlStreamReader));
                         break;
                     case BEAUTY: tagValues.put(XmlGemTags.BEAUTY, getText(xmlStreamReader));
                         break;
                     default: throw new XMLStreamException("there is an unknown element");
                 }
             }

             if (type == XMLStreamConstants.END_ELEMENT && xmlStreamReader.getLocalName().equals(elementName)) {
                 gem = tagValues.containsKey(XmlGemTags.BEAUTY) ? new SemiPrecious() : new Precious();
                 gem.setId(id);
                 gem.setValuable(Boolean.parseBoolean(valuable));
                 gem.setName( tagValues.get(XmlGemTags.NAME));
                 gem.setOrigin(Origin.fromValue( tagValues.get(XmlGemTags.ORIGIN)));
                 gem.setColor(Color.fromValue(tagValues.get(XmlGemTags.COLOR)));
                 gem.setTransparency(Integer.parseInt( tagValues.get(XmlGemTags.TRANSPARENCY)));
                 gem.setWeight(Double.parseDouble( tagValues.get(XmlGemTags.WEIGHT)));

                 if (quality != null) {
                     gem.setQuality(Quality.fromValue(quality));
                 }

                 if (xmlStreamReader.getLocalName().equals(XmlGemTags.PRECIOUS.getValue())) {
                     ((Precious)gem).setCutting(Integer.parseInt( tagValues.get(XmlGemTags.CUTTING)));
                     ((Precious)gem).setGetDate(LocalDate.parse( tagValues.get(XmlGemTags.DATE)));
                 } else {
                     ((SemiPrecious)gem).setBeauty(Beauty.fromValue( tagValues.get(XmlGemTags.BEAUTY)));
                 }
                 return gem;
             }
         }
         throw new RuntimeException("Something went wrong!");
    }

    private String getText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}

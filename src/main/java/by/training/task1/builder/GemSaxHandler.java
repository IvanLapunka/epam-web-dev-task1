package by.training.task1.builder;

import by.training.task1.entity.Beauty;
import by.training.task1.entity.Color;
import by.training.task1.entity.Gem;
import by.training.task1.entity.Origin;
import by.training.task1.entity.Precious;
import by.training.task1.entity.Quality;
import by.training.task1.entity.SemiPrecious;
import by.training.task1.entity.XmlGemTags;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.time.LocalDate;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class GemSaxHandler extends DefaultHandler {
    private static Logger log = LogManager.getLogger();

    private Set<Gem> gems = new HashSet<>();
    private EnumSet<XmlGemTags> xmlGemTags = EnumSet.range(XmlGemTags.NAME, XmlGemTags.BEAUTY);
    private final String START_PRECIOUS = XmlGemTags.PRECIOUS.getValue();
    private final String START_SEMI_PRECIOUS = XmlGemTags.SEMIPRECIOUS.getValue();
    private XmlGemTags currentTag;
    private Gem currentGem;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if (START_PRECIOUS.equals(qName) || START_SEMI_PRECIOUS.equals(qName)) {
            currentGem = START_PRECIOUS.equals(qName) ? new Precious() : new SemiPrecious();
            setAttributes(attributes);
        } else {
            final XmlGemTags tag = XmlGemTags.fromValue(qName);
            currentTag = null;
            if (xmlGemTags.contains(tag)) {
                currentTag = tag;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if (START_SEMI_PRECIOUS.equals(qName) || START_PRECIOUS.equals(qName)) {
            gems.add(currentGem);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        String tagValue = new String(ch, start, length).strip();
        log.error(tagValue);

        if (currentTag == null || !xmlGemTags.contains(currentTag)) {
            return;
        }
        log.error(currentTag.getValue());

        switch (currentTag) {
            case NAME: currentGem.setName(tagValue);
                break;
            case ORIGIN: currentGem.setOrigin(Origin.fromValue(tagValue));
                break;
            case COLOR: currentGem.setColor(Color.fromValue(tagValue));
                break;
            case TRANSPARENCY: currentGem.setTransparency(Integer.parseInt(tagValue));
                break;
            case WEIGHT: currentGem.setWeight(Double.parseDouble(tagValue));
                break;
            case CUTTING: ((Precious)currentGem).setCutting(Integer.parseInt(tagValue));
                break;
            case DATE: ((Precious)currentGem).setGetDate(LocalDate.parse(tagValue));
                break;
            case BEAUTY:((SemiPrecious)currentGem).setBeauty(Beauty.fromValue(tagValue));
                break;
            default: throw new EnumConstantNotPresentException(XmlGemTags.BEAUTY.getDeclaringClass(), currentTag.name());
        }
        currentTag = null; // important -> if not then will process strings out of end tag - between end and start tags
    }

    public Set<Gem> getGems() {
        return gems;
    }

    private void setAttributes(Attributes attr) {
        for (int i = 0; i < attr.getLength(); i++) {
            String attrName = attr.getQName(i);
            String attrValue = attr.getValue(i);
            switch (XmlGemTags.fromValue(attrName)) {
                case ID: currentGem.setId(attrValue);
                break;
                case VALUABLE: currentGem.setValuable(Boolean.valueOf(attrValue));
                break;
                case QUALITY: currentGem.setQuality(Quality.fromValue(attrValue));
                break;
                default: throw new EnumConstantNotPresentException(XmlGemTags.QUALITY.getDeclaringClass(), XmlGemTags.SEMIPRECIOUS.name());
            }
        }
    }
}

package by.training.task1.builder;

import by.training.task1.entity.Beauty;
import by.training.task1.entity.Color;
import by.training.task1.entity.Gem;
import by.training.task1.entity.Origin;
import by.training.task1.entity.Precious;
import by.training.task1.entity.Quality;
import by.training.task1.entity.SemiPrecious;
import by.training.task1.entity.XmlGemTags;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class GemDomBuilder {
    private Set<Gem> gemSet;
    private DocumentBuilder builder;

    public Set<Gem> getGemSet() {
        return gemSet;
    }

    public GemDomBuilder() {
        gemSet = new HashSet<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void buildGemsSet(String fullFilePath) {
        try {
            final Document parse = builder.parse(new File(fullFilePath));
            final Element document = parse.getDocumentElement();
            final NodeList precious = document.getElementsByTagName(XmlGemTags.PRECIOUS.getValue());
            final NodeList semiprecious = document.getElementsByTagName(XmlGemTags.SEMIPRECIOUS.getValue());

            for (int i = 0; i < precious.getLength(); i++) {
                final Element element = (Element) precious.item(i);
                Gem gem = buildGem(element);
                gemSet.add(gem);
            }

            for (int i = 0; i < semiprecious.getLength(); i++) {
                final Element element = (Element) precious.item(i);
                Gem gem = buildGem(element);
                gemSet.add(gem);
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Gem buildGem(Element element) {
        final String name = getElementText(element, XmlGemTags.NAME.getValue());
        final String origin = getElementText(element, XmlGemTags.ORIGIN.getValue());
        final String color = getElementText(element, XmlGemTags.COLOR.getValue());
        final String transparency = getElementText(element, XmlGemTags.TRANSPARENCY.getValue());
        final String weight = getElementText(element, XmlGemTags.WEIGHT.getValue());

        final String id = element.getAttribute(XmlGemTags.ID.getValue());
        final String valuable = element.getAttribute(XmlGemTags.VALUABLE.getValue());
        final String quality = element.getAttribute(XmlGemTags.QUALITY.getValue());

        final Optional<String> optionalBeauty = getOptionalElementText(element, XmlGemTags.BEAUTY.getValue());
        final Optional<String> optionalCutting = getOptionalElementText(element, XmlGemTags.CUTTING.getValue());
        final Optional<String> optionalGetDate = getOptionalElementText(element, XmlGemTags.DATE.getValue());
        Gem gem;
        if (optionalBeauty.isPresent()) {
            gem = new SemiPrecious();
            ((SemiPrecious)gem).setBeauty(Beauty.fromValue(optionalBeauty.get()));
        } else {
            gem = new Precious();
            ((Precious)gem).setCutting(Integer.parseInt(optionalCutting.get()));
            ((Precious)gem).setGetDate(LocalDate.parse(optionalGetDate.get()));
        }

        gem.setName(name);
        gem.setOrigin(Origin.fromValue(origin));
        gem.setColor(Color.fromValue(color));
        gem.setTransparency(Integer.parseInt(transparency));
        gem.setWeight(Double.parseDouble(weight));
        gem.setId(id);
        gem.setValuable(Boolean.parseBoolean(valuable));
        if (0 < quality.length()) {
            gem.setQuality(Quality.fromValue(quality));
        }
        return gem;
    }

    private String getElementText(Element element, String elementName) {
        final NodeList elementsByTagName = element.getElementsByTagName(elementName);
        final Node item = elementsByTagName.item(0);
        return item.getTextContent();
    }

    private Optional<String> getOptionalElementText(Element element, String elementName) {
        final NodeList elementsByTagName = element.getElementsByTagName(elementName);
        final Node item = elementsByTagName.item(0);
        if (item == null) {
            return Optional.empty();
        }
        return Optional.of(item.getTextContent());
    }
}

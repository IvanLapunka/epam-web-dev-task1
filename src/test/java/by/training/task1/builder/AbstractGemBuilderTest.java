package by.training.task1.builder;

import by.training.task1.entity.Beauty;
import by.training.task1.entity.Color;
import by.training.task1.entity.Gem;
import by.training.task1.entity.Origin;
import by.training.task1.entity.Precious;
import by.training.task1.entity.Quality;
import by.training.task1.entity.SemiPrecious;
import by.training.task1.exception.XmlCustomException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class AbstractGemBuilderTest {

    private static List<Gem> gems = new ArrayList<>();

    private static String str;
    static
    {
        Precious.PreciousBuilder agate = (Precious.PreciousBuilder) new Precious.PreciousBuilder("Agate")
                .withId("AAAA10621231")
                .withValuable(true)
                .withOrigin(Origin.AMERICA)
                .withColor(Color.GREEN)
                .withTransparency(79)
                .withWeight(376.3);

        final Precious firstGem = agate
                .withCutting(12)
                .withGetDate(LocalDate.of(1980, 1, 13))
                .build();

        Precious.PreciousBuilder amethyst = (Precious.PreciousBuilder) new Precious.PreciousBuilder("Amethyst")
                .withId("AAAA30743074")
                .withValuable(false)
                .withOrigin(Origin.AMERICA)
                .withColor(Color.BLACK)
                .withTransparency(89)
                .withWeight(476);

        final Precious secondGem = amethyst.withCutting(10)
                .withGetDate(LocalDate.of(1994, 2, 12))
                .build();

        SemiPrecious.SemiPreciousBuilder onyx = (SemiPrecious.SemiPreciousBuilder) new SemiPrecious.SemiPreciousBuilder("Onyx")
                .withId("LLLL20682068")
                .withValuable(true)
                .withQuality(Quality.MIDDLE)
                .withOrigin(Origin.AFRICA)
                .withColor(Color.BLACK)
                .withTransparency(26)
                .withWeight(787);

        final SemiPrecious thirdGem = onyx.withBeauty(Beauty.LOVELY).build();

        SemiPrecious.SemiPreciousBuilder amber = (SemiPrecious.SemiPreciousBuilder) new SemiPrecious.SemiPreciousBuilder("Amber")
                .withId("MMMM45434543")
                .withValuable(true)
                .withQuality(Quality.HIGH)
                .withOrigin(Origin.AMERICA)
                .withColor(Color.RED)
                .withTransparency(24)
                .withWeight(629);

        final SemiPrecious forthGem = amber.withBeauty(Beauty.GORGEOUS).build();

        gems.add(firstGem);
        gems.add(secondGem);
        gems.add(thirdGem);
        gems.add(forthGem);
        gems = gems.stream().sorted().collect(Collectors.toList());
    }




    @Test
    void testDomBuildGemSet() {
        GemDomBuilder builder = (GemDomBuilder) GemBuilderFactory.createGemBuilder(GemBuilderFactory.TypeParser.DOM);
        try {
            builder.buildGemSet("test_data/example.xml");
        } catch (XmlCustomException e) {
            e.printStackTrace();
        }
        final List<Gem> result = builder.getGemSet().stream().sorted().collect(Collectors.toList());
        Assertions.assertIterableEquals(gems, result);
    }

    @Test
    void testStaxBuildGemSet() {
        GemStaxBuilder builder = (GemStaxBuilder) GemBuilderFactory.createGemBuilder(GemBuilderFactory.TypeParser.STAX);
        try {
            builder.buildGemSet("test_data/example.xml");
        } catch (XmlCustomException e) {
            e.printStackTrace();
        }
        final List<Gem> result = builder.getGemSet().stream().sorted().collect(Collectors.toList());
        Assertions.assertIterableEquals(gems, result);
    }

    @Test
    void testSaxBuildGemSet() {
        GemSaxBuilder builder = (GemSaxBuilder) GemBuilderFactory.createGemBuilder(GemBuilderFactory.TypeParser.SAX);
        try {
            builder.buildGemSet("test_data/example.xml");
        } catch (XmlCustomException e) {
            e.printStackTrace();
        }
        final List<Gem> result = builder.getGemSet().stream().sorted().collect(Collectors.toList());
        Assertions.assertIterableEquals(gems, result);
    }

}
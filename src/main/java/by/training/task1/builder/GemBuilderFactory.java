package by.training.task1.builder;

public class GemBuilderFactory {
    public enum TypeParser {
        SAX, STAX, DOM
    }

    private GemBuilderFactory(){}

    public static AbstractGemBuilder createGemBuilder(TypeParser type) {
        switch (type) {
            case SAX: return new GemSaxBuilder();
            case STAX: return new GemStaxBuilder();
            case DOM: return new GemDomBuilder();
            default: throw new EnumConstantNotPresentException(type.getDeclaringClass(), type.name());
        }
    }
}

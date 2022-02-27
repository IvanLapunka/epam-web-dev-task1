package by.training.task1.entity;

public enum XmlGemTags {
    GEMS("gems"),
    PRECIOUS("precious"),
    SEMIPRECIOUS("semi-precious"),
    NAME("name"),
    ORIGIN("origin"),
    COLOR("color"),
    TRANSPARENCY("transparency"),
    WEIGHT("weight"),
    CUTTING("cutting"),
    DATE("get-date"),
    BEAUTY("beauty"),
    ID("id"),
    VALUABLE("valuable"),
    QUALITY("quality");
    private final String value;

    XmlGemTags(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static XmlGemTags fromValue(String s) {
        for (XmlGemTags tag : XmlGemTags.values()) {
            if (tag.value.equals(s)) {
                return tag;
            }
        }
        throw new IllegalArgumentException(s);
    }
}

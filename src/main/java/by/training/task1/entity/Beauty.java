//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.02.25 at 09:35:44 PM MSK 
//


package by.training.task1.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

public enum Beauty {

    FINE("fine"),
    LOVELY("lovely"),
    GORGEOUS("gorgeous");

    private final String value;

    Beauty(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Beauty fromValue(String v) {
        for (Beauty c: Beauty.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

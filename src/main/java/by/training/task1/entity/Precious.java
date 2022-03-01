//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.02.25 at 04:47:16 PM MSK 
//


package by.training.task1.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Precious", propOrder = {
        "cutting",
        "getDate"
})
public class Precious extends Gem {

    protected int cutting;
    @XmlElement(name = "get-date", required = true)
    @XmlSchemaType(name = "date")
    protected LocalDate getDate;

    public int getCutting() {
        return cutting;
    }

    public void setCutting(int value) {
        this.cutting = value;
    }

    public LocalDate getGetDate() {
        return getDate;
    }

    public void setGetDate(LocalDate value) {
        this.getDate = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Precious precious = (Precious) o;

        if (cutting != precious.cutting) return false;
        return getDate.equals(precious.getDate);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + cutting;
        result = 31 * result + getDate.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Precious{" +
                "cutting=" + cutting +
                ", getDate=" + getDate +
                '}' + super.toString();
    }
}

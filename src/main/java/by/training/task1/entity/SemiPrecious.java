//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.02.25 at 09:35:44 PM MSK 
//


package by.training.task1.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Semi-precious complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Semi-precious"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.example.org/gems}Gem"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.example.org/gems}beauty"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Semi-precious", propOrder = {
        "beauty"
})
public class SemiPrecious extends Gem {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected Beauty beauty;

    /**
     * Gets the value of the beauty property.
     *
     * @return possible object is
     * {@link Beauty }
     */
    public Beauty getBeauty() {
        return beauty;
    }

    /**
     * Sets the value of the beauty property.
     *
     * @param value allowed object is
     *              {@link Beauty }
     */
    public void setBeauty(Beauty value) {
        this.beauty = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        SemiPrecious that = (SemiPrecious) o;

        return beauty == that.beauty;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + beauty.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "SemiPrecious{" +
                "beauty=" + beauty +
                '}'
                + super.toString();
    }
}

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.02.25 at 04:47:16 PM MSK 
//


package by.training.task1.entity;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for Gems complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Gems"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.example.org/gems}gem" maxOccurs="unbounded" minOccurs="8"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Gems", propOrder = {
    "gem"
})
public class Gems {

    @XmlElementRef(name = "gem", namespace = "http://www.example.org/gems", type = JAXBElement.class)
    protected List<? extends Gem> gem;

    /**
     * Gets the value of the gem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the gem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link Precious }{@code >}
     * {@link JAXBElement }{@code <}{@link SemiPrecious }{@code >}
     * {@link JAXBElement }{@code <}{@link Gem }{@code >}
     * 
     * 
     */
    public List<? extends Gem> getGem() {
        if (gem == null) {
            gem = new ArrayList<>();
        }
        return this.gem;
    }

}
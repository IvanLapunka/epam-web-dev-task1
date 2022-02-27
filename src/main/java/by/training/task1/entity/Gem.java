//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.02.25 at 04:47:16 PM MSK 
//


package by.training.task1.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.StringJoiner;


/**
 * <p>Java class for Gem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Gem"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.example.org/gems}name"/&gt;
 *         &lt;element ref="{http://www.example.org/gems}origin"/&gt;
 *         &lt;element ref="{http://www.example.org/gems}color"/&gt;
 *         &lt;element ref="{http://www.example.org/gems}transparency"/&gt;
 *         &lt;element ref="{http://www.example.org/gems}weight"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="id" use="required" type="{http://www.example.org/gems}GemId" /&gt;
 *       &lt;attribute name="valuable" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" /&gt;
 *       &lt;attribute name="quality" type="{http://www.example.org/gems}Quality" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Gem", propOrder = {
    "name",
    "origin",
    "color",
    "transparency",
    "weight"
})
@XmlSeeAlso({
    Precious.class,
    SemiPrecious.class
})
public abstract class Gem {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected Origin origin;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected Color color;
    protected int transparency;
    protected double weight;
    @XmlAttribute(name = "id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String id;
    @XmlAttribute(name = "valuable")
    protected Boolean valuable;
    @XmlAttribute(name = "quality")
    protected Quality quality;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the origin property.
     * 
     * @return
     *     possible object is
     *     {@link Origin }
     *     
     */
    public Origin getOrigin() {
        return origin;
    }

    /**
     * Sets the value of the origin property.
     * 
     * @param value
     *     allowed object is
     *     {@link Origin }
     *     
     */
    public void setOrigin(Origin value) {
        this.origin = value;
    }

    /**
     * Gets the value of the color property.
     * 
     * @return
     *     possible object is
     *     {@link Color }
     *     
     */
    public Color getColor() {
        return color;
    }

    /**
     * Sets the value of the color property.
     * 
     * @param value
     *     allowed object is
     *     {@link Color }
     *     
     */
    public void setColor(Color value) {
        this.color = value;
    }

    /**
     * Gets the value of the transparency property.
     * 
     */
    public int getTransparency() {
        return transparency;
    }

    /**
     * Sets the value of the transparency property.
     * 
     */
    public void setTransparency(int value) {
        this.transparency = value;
    }

    /**
     * Gets the value of the weight property.
     * 
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Sets the value of the weight property.
     * 
     */
    public void setWeight(double value) {
        this.weight = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the valuable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isValuable() {
        if (valuable == null) {
            return true;
        } else {
            return valuable;
        }
    }

    /**
     * Sets the value of the valuable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setValuable(Boolean value) {
        this.valuable = value;
    }

    /**
     * Gets the value of the quality property.
     * 
     * @return
     *     possible object is
     *     {@link Quality }
     *     
     */
    public Quality getQuality() {
        return quality;
    }

    /**
     * Sets the value of the quality property.
     * 
     * @param value
     *     allowed object is
     *     {@link Quality }
     *     
     */
    public void setQuality(Quality value) {
        this.quality = value;
    }



    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "Gem{","}");
        return joiner
                .add(name + '\'')
                .add("id='" + id + '\'')
                .add("color=" + color)
                .add("origin=" + origin)
                .add("name='" + name + '\'')
                .add("transparency=" + transparency)
                .add("weight=" + weight)
                .add("valuable=" + valuable)
                .add("quality=" + quality)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gem gem = (Gem) o;

        if (transparency != gem.transparency) return false;
        if (Double.compare(gem.weight, weight) != 0) return false;
        if (!name.equals(gem.name)) return false;
        if (origin != gem.origin) return false;
        if (color != gem.color) return false;
        if (!id.equals(gem.id)) return false;
        if (!valuable.equals(gem.valuable)) return false;
        return quality == gem.quality;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        result = 31 * result + origin.hashCode();
        result = 31 * result + color.hashCode();
        result = 31 * result + transparency;
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + id.hashCode();
        result = 31 * result + valuable.hashCode();
        result = 31 * result + (quality != null ? quality.hashCode() : 0);
        return result;
    }
}
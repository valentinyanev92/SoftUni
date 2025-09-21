package org.example.jaxb.dtos;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {

    @XmlElement
    private String name;

    @XmlElement
    private String country;

    @XmlAttribute(name = "city") // Top <>
    private String city;

    public Person() {
    }

    public Person(String name, String country, String city) {
        this.name = name;
        this.country = country;
        this.city = city;
    }
}

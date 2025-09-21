package org.example.jaxb.dtos;

import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlRootElement(name = "person-info")
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonInfo {

    @XmlElement(name = "info")
    private Person person;

    @XmlElementWrapper(name = "order-list") // make it like array []
    @XmlElement(name = "order")
    private List<Order> orders;

    public PersonInfo() {
    }

    public PersonInfo(Person person, List<Order> orders) {
        this.person = person;
        this.orders = orders;
    }
}

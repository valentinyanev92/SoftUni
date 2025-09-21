package org.example.jaxb.dtos;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;


@XmlRootElement(name = "addressBook")
public class AddressBook {

    @XmlElement(name = "address")
    List<Address> addressList;

    public AddressBook() {
    }

    public AddressBook(List<Address> addressList) {
        this.addressList = addressList;
    }

    @Override
    public String toString() {
        return "AddressBook{" +
                "addressList=" + addressList +
                '}';
    }
}

package org.example.jaxb;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.example.jaxb.dtos.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JAXBException {
//        writeXML();

        readXML();
    }

    private static void readXML() throws JAXBException {
        JAXBContext addressContext = JAXBContext.newInstance(AddressBook.class);
        Unmarshaller unmarshaller = addressContext.createUnmarshaller();

        AddressBook parsed = (AddressBook) unmarshaller.unmarshal(System.in); // CTR + D to end reading!!!

        System.out.println(parsed);
    }

    private static void writeXML() throws JAXBException {
        Person person = new Person("Pesho", "Bg", "Varna");

        JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
        Marshaller personMarshaller = jaxbContext.createMarshaller();
        personMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        personMarshaller.marshal(person, System.out);

        JAXBContext jaxbContext2 = JAXBContext.newInstance(PersonInfo.class);
        Marshaller personInfoMarshaller = jaxbContext2.createMarshaller();
        personInfoMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        PersonInfo personInfo = new PersonInfo(person, new ArrayList<>());

        personInfoMarshaller.marshal(personInfo, System.out);

        Order order = new Order("1", BigDecimal.valueOf(123), LocalDate.now());
        Order order2 = new Order("2", BigDecimal.valueOf(1233), LocalDate.now());
        List<Order> orders = new ArrayList<>();
        orders.add(order);
        orders.add(order2);

        PersonInfo personInfo2 = new PersonInfo(person, orders);
        personInfoMarshaller.marshal(personInfo2, System.out);

        Address address = new Address("Bg", "Sofia");
        Address address2 = new Address("Bg", "Stara Zagora");
        Address address3 = new Address("Bg", "Plovdiv");
        List<Address> addresses = new ArrayList<>();
        addresses.add(address);
        addresses.add(address2);
        addresses.add(address3);
        AddressBook book = new AddressBook(addresses);
        JAXBContext jaxbContext3 = JAXBContext.newInstance(AddressBook.class);
        Marshaller addressBookMarshaller = jaxbContext3.createMarshaller();
        addressBookMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        addressBookMarshaller.marshal(book, System.out);
    }
}
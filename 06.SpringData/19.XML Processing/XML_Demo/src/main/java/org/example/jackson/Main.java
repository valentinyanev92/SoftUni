package org.example.jackson;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import jakarta.xml.bind.JAXBException;
import org.example.jackson.dto.CustomerList;
import org.example.jackson.dto.Order;
import org.example.jackson.dto.Product;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JAXBException, IOException {

//        writeXml();

        readXml();
    }

    private static void readXml() throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
//
//        Order order = xmlMapper.readValue(System.in, Order.class);
//        System.out.println(order);


        CustomerList customerList = xmlMapper.readValue(System.in, CustomerList.class);
        System.out.println(customerList);
    }

    private static void writeXml() throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

        Product p = new Product("Apple", "Apple");
        Product p2 = new Product("Pear", "Pear");
        Product p3 = new Product("Pineapple", "Pineapple");
        List<Product> items = new ArrayList<Product>();
        items.add(p);
        items.add(p2);
        items.add(p3);
        Order order = new Order(items, 2, BigDecimal.valueOf(23.24));

        xmlMapper.writeValue(System.out, order);

    }
}

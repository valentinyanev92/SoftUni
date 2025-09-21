package org.example.jackson.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

//@JacksonXmlRootElement(localName = "item")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Product {

    private String name;

    private String manufacturer;

    public Product() {
    }

    public Product(String name, String manufacturer) {
        this.name = name;
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
}

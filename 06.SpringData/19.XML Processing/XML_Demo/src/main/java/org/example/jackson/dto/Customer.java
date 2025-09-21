package org.example.jackson.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.math.BigDecimal;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Customer {

    @JacksonXmlProperty
    private String name;

    @JacksonXmlProperty
    private BigDecimal totalSpent;

    public Customer() {
    }

    public Customer(String name, BigDecimal totalSpent) {
        this.name = name;
        this.totalSpent = totalSpent;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", totalSpent=" + totalSpent +
                '}';
    }
}

package org.example.jaxb.dtos;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.math.BigDecimal;
import java.time.LocalDate;

@XmlRootElement(name = "order")
@XmlAccessorType(XmlAccessType.FIELD)
public class Order {

    private String orderId;

    private BigDecimal price;

    private LocalDate createdAt;

    public Order() {
    }

    public Order(String orderId, BigDecimal price, LocalDate createdAt) {
        this.orderId = orderId;
        this.price = price;
        this.createdAt = createdAt;
    }
}

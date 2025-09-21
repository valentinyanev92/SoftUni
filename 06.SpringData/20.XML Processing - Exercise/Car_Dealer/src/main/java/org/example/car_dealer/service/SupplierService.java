package org.example.car_dealer.service;

import org.example.car_dealer.entities.Supplier;
import org.springframework.validation.annotation.Validated;

import java.io.IOException;

@Validated
public interface SupplierService {
    void importData() throws IOException;
    Supplier getRandomSupplier();
}

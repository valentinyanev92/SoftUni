package org.example.productshop.service;

import java.io.IOException;

public interface ProductService {

    void importData() throws IOException;
    void getUnsoldProductsInRange(double from, double to) throws IOException;
}

package org.example.car_dealer.service;

import org.example.car_dealer.entities.Part;

import java.io.IOException;

public interface PartService {
    void importData() throws IOException;
    Part getRandomPart();
}

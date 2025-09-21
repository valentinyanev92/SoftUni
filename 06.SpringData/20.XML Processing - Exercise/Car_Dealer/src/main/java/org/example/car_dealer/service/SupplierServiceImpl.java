package org.example.car_dealer.service;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.example.car_dealer.dtos.supplierDto.SupplierInputDto;
import org.example.car_dealer.entities.Supplier;
import org.example.car_dealer.repositories.SupplierRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;
    private final XmlMapper xmlMapper;
    private final ModelMapper mapper;


    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository, XmlMapper configureXmlMapper, ModelMapper mapper) {
        this.supplierRepository = supplierRepository;
        this.xmlMapper = configureXmlMapper;
        this.mapper = mapper;
    }

    @Override
    public void importData() throws IOException {
        Path path = Path.of("src/main/resources/suppliers.xml");
        List<String> xml = Files.readAllLines(path);

        SupplierInputDto[] supplierInputDtos = xmlMapper.readValue(String.join("", xml), SupplierInputDto[].class);

        for (SupplierInputDto supplier : supplierInputDtos) {
            Supplier mapped = mapper.map(supplier, Supplier.class);
            supplierRepository.save(mapped);
        }
    }

    @Override
    public Supplier getRandomSupplier() {
        Random random = new Random();
        Long randomId = random.nextLong(1, this.supplierRepository.count());
        return supplierRepository.getSupplierById(randomId);
    }
}
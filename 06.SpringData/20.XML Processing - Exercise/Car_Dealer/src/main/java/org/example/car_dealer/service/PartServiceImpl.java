package org.example.car_dealer.service;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.example.car_dealer.dtos.partDto.PartInputDto;
import org.example.car_dealer.entities.Part;
import org.example.car_dealer.entities.Supplier;
import org.example.car_dealer.repositories.PartRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

@Service
public class PartServiceImpl implements PartService {

    private final PartRepository partRepository;
    private final SupplierService supplierService;
    private final XmlMapper xmlMapper;
    private final ModelMapper modelMapper;

    @Autowired
    public PartServiceImpl(PartRepository partRepository, SupplierService supplierService, XmlMapper xmlMapper, ModelMapper mapper) {
        this.partRepository = partRepository;
        this.supplierService = supplierService;
        this.xmlMapper = xmlMapper;
        this.modelMapper = mapper;
    }

    @Override
    public void importData() throws IOException {
        Path path = Path.of("src/main/resources/parts.xml");
        List<String> xml = Files.readAllLines(path);

        PartInputDto[] partInputDtos = xmlMapper.readValue(String.join("", xml), PartInputDto[].class);
        for (PartInputDto part : partInputDtos) {
            Supplier supplier = supplierService.getRandomSupplier();
            Part partEntity = modelMapper.map(part, Part.class);
            partEntity.setSupplier(supplier);
            partRepository.save(partEntity);
        }
    }

    @Override
    public Part getRandomPart() {
        Random random = new Random();
        Long count = partRepository.count();
        Long randomId = random.nextLong(1, count);
        return partRepository.getPartById(randomId);
    }
}

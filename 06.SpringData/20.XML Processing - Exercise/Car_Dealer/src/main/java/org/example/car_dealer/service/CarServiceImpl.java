package org.example.car_dealer.service;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.example.car_dealer.dtos.carDto.CarInputDto;
import org.example.car_dealer.entities.Car;
import org.example.car_dealer.entities.Part;
import org.example.car_dealer.repositories.CarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final PartService partService;
    private final XmlMapper xmlMapper;
    private final ModelMapper mapper;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, PartService partService, XmlMapper xmlMapper, ModelMapper mapper) {
        this.carRepository = carRepository;
        this.partService = partService;
        this.xmlMapper = xmlMapper;
        this.mapper = mapper;
    }

    @Override
    public void importData() throws IOException {
        Random random = new Random();
        int count = random.nextInt(3, 5);
        Path path = Path.of("src/main/resources/cars.xml");
        List<String> xml = Files.readAllLines(path);

        List<Part> parts = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Part randomPart = partService.getRandomPart();
            parts.add(randomPart);
        }

        CarInputDto[] carInputDtos = xmlMapper.readValue(String.join("", xml), CarInputDto[].class);
        for (CarInputDto car : carInputDtos) {
            Car carEntity = mapper.map(car, Car.class);
            carEntity.setParts(parts);
            carRepository.save(carEntity);
        }
    }

    @Override
    public Car getRandomCar() {
        Long count = carRepository.count();
        Random random = new Random();
        Long id = random.nextLong(1, count);
        return carRepository.getCarById(id);
    }
}
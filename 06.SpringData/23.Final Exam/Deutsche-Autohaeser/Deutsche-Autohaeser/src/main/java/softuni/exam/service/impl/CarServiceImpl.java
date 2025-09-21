package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CarInputDto;
import softuni.exam.models.entity.Car;
import softuni.exam.models.entity.CarType;
import softuni.exam.models.entity.Dealership;
import softuni.exam.repository.CarRepository;
import softuni.exam.service.CarService;
import softuni.exam.service.DealershipService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;
    private final Gson gson;
    private final DealershipService dealershipService;


    public CarServiceImpl(CarRepository carRepository, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser, Gson gson, DealershipService dealershipService) {
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.gson = gson;
        this.dealershipService = dealershipService;
    }

    @Override
    public boolean areImported() {
        return carRepository.count() > 0;
    }

    @Override
    public String readCarsFileContent() throws IOException {
//        Path path = Paths.get("D:\\SpringData\\23.Final Exam\\Deutsche-Autohaeser\\Deutsche-Autohaeser\\src\\main\\resources\\files\\json\\cars.json");
        Path path = Paths.get("src/main/resources/files/json/cars.json");
        return Files.readString(path);
    }

    @Override
    public String importCars() throws IOException {
        CarInputDto[] carInputDtos = gson.fromJson(readCarsFileContent(), CarInputDto[].class);

        StringBuilder sb = new StringBuilder();
        for (CarInputDto carInputDto : carInputDtos) {
            Car car = createCar(carInputDto);

            if (car == null) {
                sb.append(String.format("Invalid car%n"));
            } else {
                sb.append(String.format("Successfully imported car %s - %d km.%n", car.getBrand(), car.getMileage()));
            }

        }
        return sb.toString();
    }


    public Car createCar(CarInputDto carInputDto) {
        if (!validationUtil.isValid(carInputDto)) {
            return null;
        }

        try {
            Car car = modelMapper.map(carInputDto, Car.class);

//            Dealership dealership = dealershipService.getReferenceById(carInputDto.getDealership());
            Dealership dealership = dealershipService.getDealershipById(carInputDto.getDealership());
            car.setDealership(dealership);

            carRepository.save(car);
            return car;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String exportCars() {
        List<Car> cars = carRepository.exportCars(CarType.COMBI, 100000);

        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(String.format("Brand: %s%n", car.getBrand()));
            sb.append(String.format("   *Mileage: %d km.%n", car.getMileage()));
            sb.append(String.format("   **Model: %s%n", car.getModel()));
            sb.append(String.format("   ***Dealership: %s%n", car.getDealership().getName()));
        }
        return sb.toString();
    }

    @Override
    public Car getCarById(Long carId) {
        return carRepository.getCarById(carId);
    }
}

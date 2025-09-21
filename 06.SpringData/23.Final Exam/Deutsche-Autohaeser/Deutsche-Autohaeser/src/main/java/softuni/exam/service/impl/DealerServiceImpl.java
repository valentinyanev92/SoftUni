package softuni.exam.service.impl;

import jakarta.xml.bind.JAXBException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.DealerImportDto;
import softuni.exam.models.dto.DealerInputDto;
import softuni.exam.models.entity.Car;
import softuni.exam.models.entity.Dealer;
import softuni.exam.repository.DealerRepository;
import softuni.exam.service.CarService;
import softuni.exam.service.DealerService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class DealerServiceImpl implements DealerService {

    private final DealerRepository dealerRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;
    private final CarService carService;


    public DealerServiceImpl(DealerRepository dealerRepository, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser, CarService carService) {
        this.dealerRepository = dealerRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.carService = carService;
    }

    @Override
    public boolean areImported() {
        return dealerRepository.count() > 0;
    }

    @Override
    public String readDealersFromFile() throws IOException {
//        Path path = Paths.get("D:\\SpringData\\23.Final Exam\\Deutsche-Autohaeser\\Deutsche-Autohaeser\\src\\main\\resources\\files\\xml\\dealers.xml");
        Path path = Paths.get("src/main/resources/files/xml/dealers.xml");
        return Files.readString(path);
    }

    @Override
    public String importDealers() throws IOException, JAXBException {
        DealerImportDto dealerImportDto = xmlParser.fromFile(readDealersFromFile(), DealerImportDto.class);

        StringBuilder sb = new StringBuilder();
        for (DealerInputDto dealerInputDto : dealerImportDto.getDealerInputDto()) {
            Dealer dealer = createDealer(dealerInputDto);

            if (dealer == null) {
                sb.append(String.format("Invalid dealer%n"));
            } else {
                sb.append(String.format("Successfully imported dealer %s %s%n", dealer.getFirstName(), dealer.getLastName()));
            }
        }
        return sb.toString();
    }

    public Dealer createDealer(DealerInputDto dealerInputDto) {
        if (!validationUtil.isValid(dealerInputDto)) {
            return null;
        }

        try {
            Dealer dealer = modelMapper.map(dealerInputDto, Dealer.class);

            Long offeringCarId = dealerInputDto.getOfferingCar();
            Car car = carService.getCarById(offeringCarId);
            if (car == null) {
                return null;
            } else {
                dealer.setOfferingCar(car);
                dealerRepository.save(dealer);
                return dealer;
            }
        } catch (Exception e) {
            return null;
        }
    }
}

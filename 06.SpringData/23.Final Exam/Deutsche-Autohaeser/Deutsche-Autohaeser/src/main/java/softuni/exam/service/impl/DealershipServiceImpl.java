package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.DealershipInputDto;
import softuni.exam.models.entity.Dealer;
import softuni.exam.models.entity.Dealership;
import softuni.exam.repository.DealershipRepository;
import softuni.exam.service.DealershipService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class DealershipServiceImpl implements DealershipService {

    private final DealershipRepository dealershipRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;


    @Autowired
    public DealershipServiceImpl(DealershipRepository dealershipRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson) {
        this.dealershipRepository = dealershipRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return dealershipRepository.count() > 0;
    }

    @Override
    public String readDealershipsFromFile() throws IOException {
//        Path path = Paths.get("D:\\SpringData\\23.Final Exam\\Deutsche-Autohaeser\\Deutsche-Autohaeser\\src\\main\\resources\\files\\json\\dealerships.json");
        Path path = Paths.get("src/main/resources/files/json/dealerships.json");
        return Files.readString(path);
    }

    @Override
    public String importDealerships() throws IOException {
        DealershipInputDto[] dealershipInputDtos = gson.fromJson(readDealershipsFromFile(), DealershipInputDto[].class);

        StringBuilder sb = new StringBuilder();
        for (DealershipInputDto dealershipDto : dealershipInputDtos) {
            Dealership dealership = createDealer(dealershipDto);

            if (dealership == null) {
                sb.append(String.format("Invalid dealership%n"));
            }else {
                sb.append(String.format("Successfully imported dealership %s%n",dealership.getName()));
            }
        }

        return sb.toString();
    }

    @Override
    public Dealership getReferenceById(Long dealershipId) {
        return dealershipRepository.getReferenceById(dealershipId);
    }

    @Override
    public Dealership getDealershipById(Long dealershipId) {
        return dealershipRepository.getDealershipById(dealershipId);
    }

    public Dealership createDealer(DealershipInputDto dealershipInputDto) {
        if (!validationUtil.isValid(dealershipInputDto)) {
            return null;
        }

        try {
            Dealership dealership = modelMapper.map(dealershipInputDto, Dealership.class);
            dealershipRepository.save(dealership);
            return dealership;
        } catch (Exception e) {
            return null;
        }
    }
}

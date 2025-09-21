package sofuni.exam.service.Impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sofuni.exam.models.dto.DiscovererInputDto;
import sofuni.exam.models.entity.Discoverer;
import sofuni.exam.repository.DiscovererRepository;
import sofuni.exam.service.DiscovererService;
import sofuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class DiscovererServiceImpl implements DiscovererService {

    private final DiscovererRepository discovererRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;


    public DiscovererServiceImpl(DiscovererRepository discovererRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.discovererRepository = discovererRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return discovererRepository.count() > 0;
    }

    @Override
    public String readDiscovererFileContent() throws IOException {
//        Path path = Paths.get("D:\\SpringData\\21.Exam Preparation\\SolarMoons\\SolarMoons\\src\\main\\resources\\files\\json\\discoverers.json");
        Path path = Paths.get("src/main/resources/files/json/discoverers.json");
        return Files.readString(path);
    }

    @Override
    public String importDiscoverers() throws IOException {
        DiscovererInputDto[] discovererInputDtos = gson.fromJson(readDiscovererFileContent(), DiscovererInputDto[].class);

        StringBuilder sb = new StringBuilder();
        for (DiscovererInputDto discovererInput : discovererInputDtos) {
            Discoverer discoverer = create(discovererInput);

            if (discoverer == null) {
                sb.append(String.format("Invalid discoverer%n"));
            } else {
                sb.append(String.format("Successfully imported discoverer %s %s%n", discoverer.getFirstName(), discoverer.getLastName()));
            }
        }

        return sb.toString();
    }

    @Override
    public Discoverer getReferenceById(Long discoverId) {
        return discovererRepository.getReferenceById(discoverId);
    }

    public Discoverer create(DiscovererInputDto discovererInputDto) {
        if (!validationUtil.isValid(discovererInputDto)) {
            return null;
        }

        try {
            Discoverer discoverer = modelMapper.map(discovererInputDto, Discoverer.class);
            discovererRepository.save(discoverer);
            return discoverer;
        } catch (Exception e) {
            return null;
        }
    }
}

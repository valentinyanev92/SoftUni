package sofuni.exam.service.Impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sofuni.exam.models.dto.PlanetInputDto;
import sofuni.exam.models.entity.Planet;
import sofuni.exam.repository.PlanetRepository;
import sofuni.exam.service.PlanetService;
import sofuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class PlanetServiceImpl implements PlanetService {

    private final PlanetRepository planetRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;



    public PlanetServiceImpl(PlanetRepository planetRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.planetRepository = planetRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return planetRepository.count() > 0;
    }

    @Override
    public String readPlanetsFileContent() throws IOException {
//        Path path = Paths.get("D:\SpringData\21.Exam Preparation\SolarMoons\SolarMoons\src\main\resources\files\json\planets.json");
        Path path = Paths.get("src/main/resources/files/json/planets.json");
        return Files.readString(path);
    }

    @Override
    public String importPlanets() throws IOException {
        PlanetInputDto[] planetInputDto = gson.fromJson(readPlanetsFileContent(), PlanetInputDto[].class);

        StringBuilder sb = new StringBuilder();
        for (PlanetInputDto planetInput : planetInputDto) {
            Planet planet = create(planetInput);

            if (planet == null) {
                sb.append(String.format("Invalid planet%n"));
            }else {
                sb.append(String.format("Successfully imported planet %s%n", planet.getName()));
            }
        }
        return sb.toString();
    }

    @Override
    public Planet getReferenceById(Long planetId) {
        return planetRepository.getReferenceById(planetId);
    }

    public Planet create(PlanetInputDto planetDto) {
        if (!validationUtil.isValid(planetDto)) {return  null;}

        try {
            Planet planet = modelMapper.map(planetDto, Planet.class);
            planetRepository.save(planet);
            return planet;
        }catch (Exception e){
            return  null;
        }
    }
}

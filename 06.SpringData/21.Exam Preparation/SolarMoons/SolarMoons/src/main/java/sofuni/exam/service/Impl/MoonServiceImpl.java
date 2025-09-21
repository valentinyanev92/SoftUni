package sofuni.exam.service.Impl;

import com.google.gson.Gson;
import jakarta.xml.bind.JAXBException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sofuni.exam.models.dto.MoonInputDto;
import sofuni.exam.models.dto.MoonsImportDto;
import sofuni.exam.models.entity.Discoverer;
import sofuni.exam.models.entity.Moon;
import sofuni.exam.models.entity.Planet;
import sofuni.exam.models.enums.Type;
import sofuni.exam.repository.MoonRepository;
import sofuni.exam.service.DiscovererService;
import sofuni.exam.service.MoonService;
import sofuni.exam.service.PlanetService;
import sofuni.exam.util.ValidationUtil;
import sofuni.exam.util.XmlParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class MoonServiceImpl implements MoonService {

    private final MoonRepository moonRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final DiscovererService discovererService;
    private final PlanetService planetService;


    public MoonServiceImpl(MoonRepository moonRepository, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil, DiscovererService discovererService, PlanetService planetService) {
        this.moonRepository = moonRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.discovererService = discovererService;
        this.planetService = planetService;
    }

    @Override
    public boolean areImported() {
        return moonRepository.count() > 0;
    }

    @Override
    public String readMoonsFileContent() throws IOException {
//        Path path = Paths.get("D:\SpringData\21.Exam Preparation\SolarMoons\SolarMoons\src\main\resources\files\xml\moons.xml");
        Path path = Paths.get("src/main/resources/files/xml/moons.xml");
        return Files.readString(path);
    }

    @Override
    public String importMoons() throws IOException, JAXBException {
        MoonsImportDto moonsImportDto = xmlParser.fromXml(readMoonsFileContent(), MoonsImportDto.class);

        StringBuilder sb = new StringBuilder();
        for (MoonInputDto moonInputDto : moonsImportDto.getMoons()) {
            Moon moon = create(moonInputDto);

            if (moon == null) {
                sb.append(String.format("Invalid moon%n"));
            }else {
                sb.append(String.format("Successfully imported moon %s%n", moon.getName()));
            }
        }

        return sb.toString();
    }

    public Moon create(MoonInputDto moonInputDto) {
        if (!validationUtil.isValid(moonInputDto)) {
            return null;
        }

        try {
            Moon moon = modelMapper.map(moonInputDto, Moon.class);

            Long planetId = moonInputDto.getPlanet();
            Planet planet = planetService.getReferenceById(planetId);
            moon.setPlanet(planet);

            Long discoverId = moonInputDto.getDiscover();
            Discoverer discoverer = discovererService.getReferenceById(discoverId);
            moon.setDiscoverer(discoverer);

            moonRepository.save(moon);
            return moon;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String exportMoons() {
        List<Moon> exportable = moonRepository.exportable(Type.GAS_GIANT,700.0, 2000.0);

        StringBuilder sb = new StringBuilder();
        for (Moon moon : exportable) {
            sb.append(String.format("***Moon %s is a natural satellite of %s and has a radius of %.2f km.%n",
                    moon.getName(), moon.getPlanet().getName(), moon.getRadius()));
            sb.append(String.format("****Discovered by %s %s%n",
                    moon.getDiscoverer().getFirstName(), moon.getDiscoverer().getLastName()));
            sb.append(String.format("%n"));
        }
        return sb.toString();
    }
}
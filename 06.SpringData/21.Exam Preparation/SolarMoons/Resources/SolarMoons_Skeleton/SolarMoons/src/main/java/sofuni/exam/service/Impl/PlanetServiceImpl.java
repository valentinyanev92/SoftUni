package sofuni.exam.service.Impl;

import sofuni.exam.service.PlanetService;
import java.io.IOException;

public class PlanetServiceImpl implements PlanetService {


    @Override
    public boolean areImported() {
        return false;
    }

    @Override
    public String readPlanetsFileContent() throws IOException {
        return null;
    }

    @Override
    public String importPlanets() throws IOException {
        return null;
    }
}

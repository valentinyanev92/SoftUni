package sofuni.exam.service.Impl;

import jakarta.xml.bind.JAXBException;
import sofuni.exam.service.MoonService;
import java.io.IOException;

public class MoonServiceImpl implements MoonService {

    @Override
    public boolean areImported() {
        return false;
    }

    @Override
    public String readMoonsFileContent() throws IOException {
        return null;
    }

    @Override
    public String importMoons() throws IOException, JAXBException {
        return null;
    }

    @Override
    public String exportMoons() {
        return null;
    }
}

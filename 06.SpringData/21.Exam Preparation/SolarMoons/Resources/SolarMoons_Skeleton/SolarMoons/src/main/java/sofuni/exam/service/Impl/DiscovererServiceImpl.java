package sofuni.exam.service.Impl;

import sofuni.exam.service.DiscovererService;
import java.io.IOException;

public class DiscovererServiceImpl implements DiscovererService {


    @Override
    public boolean areImported() {
        return false;
    }

    @Override
    public String readDiscovererFileContent() throws IOException {
        return null;
    }

    @Override
    public String importDiscoverers() throws IOException {
        return null;
    }
}

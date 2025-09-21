package softuni.exam.service.impl;

import org.springframework.stereotype.Service;
import softuni.exam.service.PartService;

import java.io.IOException;

@Service
public class PartServiceImpl implements PartService {
    @Override
    public boolean areImported() {
        return false;
    }

    @Override
    public String readPartsFileContent() throws IOException {
        return "";
    }

    @Override
    public String importParts() throws IOException {
        return "";
    }
}

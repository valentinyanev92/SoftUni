package softuni.exam.service;



import softuni.exam.models.entity.Dealership;

import java.io.IOException;
import java.util.Optional;

public interface DealershipService {

    boolean areImported();

    String readDealershipsFromFile() throws IOException;

	String importDealerships() throws IOException;

    Dealership getReferenceById(Long dealershipId);

    Dealership getDealershipById(Long dealershipId);
}

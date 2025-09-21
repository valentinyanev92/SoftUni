package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.SellerInputDto;
import softuni.exam.models.entity.Seller;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class SellerServiceImpl implements SellerService {

    private final SellerRepository repository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validator;


    public SellerServiceImpl(SellerRepository repository, Gson gson, ModelMapper modelMapper, ValidationUtil validator) {
        this.repository = repository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validator = validator;
    }

    @Override
    public boolean areImported() {
        return repository.count() > 0;
    }

    @Override
    public String readSellersFromFile() throws IOException {
        Path path = Paths.get("src/main/resources/files/json/sellers.json");
//        Path path = Paths.get("D:\\SpringData\\21.Exam Preparation\\Mobiles\\Mobiles\\Mobiles\\src\\main\\resources\\files\\json\\sellers.json");
        return Files.readString(path);
    }

    @Override
    public String importSellers() throws IOException {
        SellerInputDto[] sellerInputDtos = gson.fromJson(readSellersFromFile(), SellerInputDto[].class);

        StringBuilder sb = new StringBuilder();
        for (SellerInputDto sellerDto : sellerInputDtos) {
            Seller createdSeller = create(sellerDto);

            if (createdSeller == null){
                sb.append(String.format("Invalid seller%n"));
            }else {
                sb.append(String.format("Successfully imported seller %s %s%n", createdSeller.getFirstName(), createdSeller.getLastName()));
            }
        }

        return sb.toString();
    }

    @Override
    public Seller getReferenceById(Long sellerId) {
        return repository.getReferenceById(sellerId);
    }

    @Override
    public Seller getSellerById(Long sellerId) {
        return repository.getSellerById(sellerId);
    }


    private Seller create(SellerInputDto inputDto) {
        if (!validator.isValid(inputDto)) return null;

        try {
            Seller seller = modelMapper.map(inputDto, Seller.class);
            repository.save(seller);

            return seller;
        }catch (Exception e) {
            return null;
        }
    }
}
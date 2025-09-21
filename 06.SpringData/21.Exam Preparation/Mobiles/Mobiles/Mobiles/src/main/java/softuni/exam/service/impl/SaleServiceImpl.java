package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.SaleInputDto;
import softuni.exam.models.entity.Sale;
import softuni.exam.models.entity.Seller;
import softuni.exam.repository.SaleRepository;
import softuni.exam.service.SaleService;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final SellerService sellerService;

    public SaleServiceImpl(SaleRepository saleRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validator, SellerService sellerService) {
        this.saleRepository = saleRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validator;
        this.sellerService = sellerService;
    }

    @Override
    public boolean areImported() {
        return saleRepository.count() > 0;
    }

    @Override
    public String readSalesFileContent() throws IOException {
        Path path = Paths.get("src/main/resources/files/json/sales.json");
//        Path path = Paths.get("D:\\SpringData\\21.Exam Preparation\\Mobiles\\Mobiles\\Mobiles\\src\\main\\resources\\files\\json\\sales.json");
        return Files.readString(path);
    }

    @Override
    public String importSales() throws IOException {
        SaleInputDto[] saleInputDtos = gson.fromJson(readSalesFileContent(), SaleInputDto[].class);

        StringBuilder sb = new StringBuilder();
        for (SaleInputDto saleInputDto : saleInputDtos) {
            Sale sale = create(saleInputDto);

            if (sale == null) {
                sb.append(String.format("Invalid sale%n"));
            }else {
                sb.append(String.format("Successfully imported sale with number %s%n", sale.getNumber()));
            }
        }
        return sb.toString();
    }

    @Override
    public Sale getSaleById(Long saleId) {
        return saleRepository.getSaleById(saleId);
    }

    @Override
    public Sale getReferenceById(Long saleId) {
        return saleRepository.getReferenceById(saleId);
    }

    private Sale create(SaleInputDto saleInputDto) {
        if (!validationUtil.isValid(saleInputDto)) return null;

        try {
            Sale sale = modelMapper.map(saleInputDto, Sale.class);

            Long sellerId = saleInputDto.getSeller();
//            if (sellerId != null) {
                Seller seller = sellerService.getSellerById(sellerId);
                sale.setSeller(seller);
//            }

            saleRepository.save(sale);
            return sale;
        } catch (Exception e) {
            return null;
        }
    }
}

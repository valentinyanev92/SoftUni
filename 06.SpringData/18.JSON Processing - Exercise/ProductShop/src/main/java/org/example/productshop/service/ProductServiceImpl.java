package org.example.productshop.service;

import com.google.gson.Gson;
import org.example.productshop.dtos.ProductInputDTO;
import org.example.productshop.dtos.ProductsUnsoldDTO;
import org.example.productshop.entities.Product;
import org.example.productshop.entities.User;
import org.example.productshop.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper mapper;
    private final Gson gson;
    private final UserService userService;
    private final CategoryService categoryService;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper mapper, Gson gson, UserService userService, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.mapper = mapper;
        this.gson = gson;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void importData() throws IOException {
        Path path = Path.of("src/main/resources/jsons/products.json");
        List<String> json = Files.readAllLines(path);

        ProductInputDTO[] s = gson.fromJson(String.join(" ", json), ProductInputDTO[].class);
        for (ProductInputDTO current : s) {
            if (current.getName() == null || current.getName().length() < 3) {
                System.out.println("Cannot add product without name!");
                continue;
            }

            Product product = mapper.map(current, Product.class);
            product.setSeller(getRandomUser(false));
            product.setBuyer(getRandomUser(true));
            product.setCategories(categoryService.getRandomCategories());

            productRepository.save(product);
        }
    }

    @Override
    public void getUnsoldProductsInRange(double from, double to) throws IOException {
        List<Product> products = productRepository.getByPriceBetweenAndBuyerOrderByPriceAsc(BigDecimal.valueOf(from), BigDecimal.valueOf(to), null);

        List<ProductsUnsoldDTO> result = new ArrayList<>();
        for (Product product : products) {
            result.add(new ProductsUnsoldDTO(product));
        }

        String json = gson.toJson(result);

        Path path = Path.of("src/main/resources/jsons/result/unsoldProducts.json");
        Files.write(path, json.getBytes());
    }


    private User getRandomUser(boolean canReturnNull) {
        Random random = new Random();

        if (canReturnNull) {
            boolean nullResult = random.nextBoolean();

            if (nullResult) {
                return null;
            }
        }

        return userService.getRandomUser();
    }
}

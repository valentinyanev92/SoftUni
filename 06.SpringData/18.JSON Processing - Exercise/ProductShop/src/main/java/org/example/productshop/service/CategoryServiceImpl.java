package org.example.productshop.service;

import com.google.gson.Gson;
import org.example.productshop.dtos.CategoryInputDTO;
import org.example.productshop.dtos.CategorySummaryDTO;
import org.example.productshop.entities.Category;
import org.example.productshop.repositories.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper mapper;
    private final Gson gson;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper, Gson gson) {
        this.categoryRepository = categoryRepository;
        this.mapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public void importData() throws IOException {
        Path path = Path.of("src/main/resources/jsons/categories.json");
        List<String> lines = Files.readAllLines(path);

        CategoryInputDTO[] inputDTOS = gson.fromJson(String.join("", lines), CategoryInputDTO[].class);
        for (CategoryInputDTO category : inputDTOS) {
            if (category.getName() == null || category.getName().length() < 3 || category.getName().length() > 15) {
                System.out.println("Invalid category name!");
                continue;
            }

            Category categoryToAdd = mapper.map(category, Category.class);
            categoryRepository.save(categoryToAdd);
        }
    }

    @Override
    public List<Category> getRandomCategories() {
        Random rand = new Random();

        long total = this.categoryRepository.count();
        long count = rand.nextLong(total);

        List<Category> categories = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            long id = rand.nextLong(total) + 1;
            Optional<Category> category = this.categoryRepository.findById(id);

            if (category.isPresent()) {
                categories.add(category.get());
            }
        }

        return categories;
    }

    @Override
    public void categorySummary() throws IOException {
        List<Category> categories = categoryRepository.findAllOrderByProductsCountAsc();

        List<CategorySummaryDTO> summaryDTOS = new ArrayList<>();
        for (Category category : categories) {
            CategorySummaryDTO summaryDTO = new CategorySummaryDTO(category);
            summaryDTOS.add(summaryDTO);
        }

        String json = gson.toJson(summaryDTOS);

        Path path = Path.of("src/main/resources/jsons/result/categoriesSummary.json");
        Files.write(path, json.getBytes());
    }
}

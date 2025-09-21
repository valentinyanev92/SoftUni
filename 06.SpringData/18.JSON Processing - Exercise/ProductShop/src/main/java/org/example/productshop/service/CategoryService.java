package org.example.productshop.service;

import org.example.productshop.entities.Category;

import java.io.IOException;
import java.util.List;

public interface CategoryService {

    void importData() throws IOException;
    List<Category> getRandomCategories();

    void categorySummary() throws IOException;
}

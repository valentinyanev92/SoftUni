package bookshopsystem.services;

import bookshopsystem.dtos.CategoryInputDto;
import bookshopsystem.entities.Category;
import bookshopsystem.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category create(CategoryInputDto inputDto) {
        Category category = new Category();
        category.setName(inputDto.getName());

        return this.categoryRepository.save(category);
    }
}

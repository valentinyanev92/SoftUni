package bookshopsystem.services;

import bookshopsystem.dtos.CategoryInputDto;
import bookshopsystem.entities.Category;

public interface CategoryService {
    Category create(CategoryInputDto inputDto);
}

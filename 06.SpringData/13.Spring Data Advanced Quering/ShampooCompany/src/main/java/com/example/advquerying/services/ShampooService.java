package com.example.advquerying.services;


import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;

import java.math.BigDecimal;
import java.util.List;

public interface ShampooService {
    List<Shampoo> findAllBySize(Size size);
    List<Shampoo> findAllBySizeOrId(Size size, Long id);
    List<Shampoo> findAllByPriceGreaterThan(BigDecimal price);

    int CountByPriceLessThan(BigDecimal price);

    List<Shampoo> findAllByIngredientList(List<String> ingredients);
    List<Shampoo> findAllByIngredientsCount(int count);
}

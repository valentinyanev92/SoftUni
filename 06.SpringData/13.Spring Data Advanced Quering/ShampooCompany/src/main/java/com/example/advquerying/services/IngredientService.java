package com.example.advquerying.services;

import com.example.advquerying.entities.Ingredient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IngredientService {
    List<Ingredient> findAllByNameStartingWith(String name);
    List<Ingredient> findAllByNameIn(List<String> names);

    void deleteByName(String name);
    void updateIngredientsByPrice();
    void updateIngredientByNameList(List<String> nameList);
}

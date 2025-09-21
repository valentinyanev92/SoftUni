package com.example.advquerying.services;

import com.example.advquerying.entities.Ingredient;
import com.example.advquerying.repositories.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    public final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> findAllByNameStartingWith(String name) {
        return ingredientRepository.findAllByNameStartingWith(name);
    }

    @Override
    public List<Ingredient> findAllByNameIn(List<String> names) {
        return ingredientRepository.findAllByNameIn(names);
    }

    @Override
    public void deleteByName(String name) {
        ingredientRepository.deleteAllByName(name);
        ingredientRepository.flush();
    }

    @Override
    public void updateIngredientsByPrice() {
        ingredientRepository.updateIngredientsByPrice();
    }

    @Override
    public void updateIngredientByNameList(List<String> nameList) {
        ingredientRepository.updateIngredientsByName(nameList);
    }

}
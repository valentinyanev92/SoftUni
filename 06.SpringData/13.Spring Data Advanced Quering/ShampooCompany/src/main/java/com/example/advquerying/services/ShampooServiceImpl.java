package com.example.advquerying.services;

import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import com.example.advquerying.repositories.ShampooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ShampooServiceImpl implements ShampooService {
    private ShampooRepository shampooRepository;

    @Autowired
    public ShampooServiceImpl(ShampooRepository shampooRepository) {
        this.shampooRepository = shampooRepository;
    }

    @Override
    public List<Shampoo> findAllBySize(Size size) {
        return shampooRepository.findAllBySizeOrderById(size);
    }

    @Override
    public List<Shampoo> findAllBySizeOrId(Size size, Long id) {
        return shampooRepository.findAllBySizeOrLabelIdOrderByPriceAsc(size, id);
    }

    @Override
    public List<Shampoo> findAllByPriceGreaterThan(BigDecimal price) {
        return shampooRepository.findAllByPriceGreaterThanOrderByPriceDesc(price);
    }

    @Override
    public int CountByPriceLessThan(BigDecimal price) {
        return shampooRepository.countAllByPriceLessThan(price);
    }

    @Override
    public List<Shampoo> findAllByIngredientList(List<String> ingredients) {
//        return shampooRepository.findDistinctByIngredientsNameIn(ingredients);
        return shampooRepository.findAllByIngredientsNameInQuery(ingredients);
    }

    @Override
    public List<Shampoo> findAllByIngredientsCount(int count) {
        return shampooRepository.findAllByIngredientsCountLessThan(count);
    }
}

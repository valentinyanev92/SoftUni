package com.example.advquerying.repositories;

import com.example.advquerying.entities.Ingredient;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findAllByNameStartingWith(String name);
    List<Ingredient> findAllByNameIn(List<String> names);

    @Modifying
    @Transactional
    @Query("delete Ingredient as i where i.name = :deleteName")
    void deleteAllByName(String deleteName);


    @Modifying
    @Transactional
    @Query("update Ingredient as i set i.price = i.price + i.price*0.1")
    void updateIngredientsByPrice();

    @Modifying
    @Transactional
    @Query("update Ingredient  as i set i.price = i.price + i.price*0.2 where i.name in :nameList")
    void updateIngredientsByName(List<String> nameList);
}

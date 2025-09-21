package com.example.advquerying.repositories;

import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {
    List<Shampoo> findAllBySizeOrderById(Size size);
    List<Shampoo> findAllBySizeOrLabelIdOrderByPriceAsc(Size size, Long id);
    List<Shampoo> findAllByPriceGreaterThanOrderByPriceDesc(BigDecimal price);

    int countAllByPriceLessThan(BigDecimal price);

    List<Shampoo> findDistinctByIngredientsNameIn(List<String> ingredients); //same as down findAllByIngredientsNameInQuery
    @Query("select s from Shampoo as s join s.ingredients as i where i.name in :nameList")
    List<Shampoo> findAllByIngredientsNameInQuery(List<String> nameList);

    @Query("select s from Shampoo s where size(s.ingredients) < :counter")
    List<Shampoo> findAllByIngredientsCountLessThan(int counter);
}

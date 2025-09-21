package org.example.productshop.repositories;

import org.example.productshop.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("select c from Category as c order by size(c.products)")
    List<Category> findAllOrderByProductsCountAsc();
}

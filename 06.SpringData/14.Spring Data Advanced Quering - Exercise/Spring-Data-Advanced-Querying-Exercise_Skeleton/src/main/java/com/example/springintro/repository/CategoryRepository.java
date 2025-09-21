package com.example.springintro.repository;

import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}

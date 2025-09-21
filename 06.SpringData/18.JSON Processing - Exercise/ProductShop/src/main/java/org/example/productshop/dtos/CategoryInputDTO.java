package org.example.productshop.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class CategoryInputDTO {

    @NotEmpty
    @Size(min = 2, max = 15)
    private String name;

    public CategoryInputDTO() {

    }

    public CategoryInputDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

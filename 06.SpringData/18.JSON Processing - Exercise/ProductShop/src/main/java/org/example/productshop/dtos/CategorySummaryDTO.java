package org.example.productshop.dtos;

import org.example.productshop.entities.Category;
import org.example.productshop.entities.Product;

public class CategorySummaryDTO {

    private String name;
    private int productCount;
    private double averagePrice;
    private double totalRevenue;

    public CategorySummaryDTO() {
    }

    public CategorySummaryDTO(Category category) {
        this.name = category.getName();
        this.productCount = category.getProducts().size();

        this.averagePrice = 0;
        category.getProducts().forEach(product -> {
            double price = product.getPrice().doubleValue();
           this.averagePrice += price;
        });
        this.averagePrice /= productCount;

        this.totalRevenue = 0;
        for (Product product : category.getProducts()) {
            this.totalRevenue += product.getPrice().doubleValue();
        }


    }
}

package org.example.productshop.dtos.usersAndProducts;

import org.example.productshop.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductCountDTO {

    private int count;
    private List<ProductCountProductDTO> products;

    public ProductCountDTO() {
    }

    public ProductCountDTO(List<Product> soldProduct) {
        this.count = soldProduct.size();
        this.products = new ArrayList<>();

        for (Product product : soldProduct) {
            ProductCountProductDTO productCountProductDTO = new ProductCountProductDTO(product);
            this.products.add(productCountProductDTO);
        }
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<ProductCountProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductCountProductDTO> products) {
        this.products = products;
    }
}

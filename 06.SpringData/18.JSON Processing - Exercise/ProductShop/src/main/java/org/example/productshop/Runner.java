package org.example.productshop;

import org.example.productshop.service.CategoryService;
import org.example.productshop.service.ProductService;
import org.example.productshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    private final UserService userService;
    private final ProductService productService;
    private final CategoryService categoryService;

    @Autowired
    public Runner(UserService userService, ProductService productService, CategoryService categoryService) {
        this.userService = userService;
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {
//        userService.importData();
//        categoryService.importData();
//        productService.importData();

//        productService.getUnsoldProductsInRange(500,1000);
//        userService.findAllWhoHadSells();
//        categoryService.categorySummary();
        userService.getSummary();
    }
}

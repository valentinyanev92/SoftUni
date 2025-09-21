package com.example.advquerying;

import com.example.advquerying.entities.Ingredient;
import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import com.example.advquerying.services.IngredientService;
import com.example.advquerying.services.ShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class Runner implements CommandLineRunner {

    private final Scanner scanner = new Scanner(System.in);
    private final ShampooService shampooService;
    private final IngredientService ingredientService;

    @Autowired
    public Runner(ShampooService shampooService, IngredientService ingredientService) {
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
    }


    @Override
    public void run(String... args) throws Exception {
        //01.
//        findShampooBySizeFromInput();

        //02.
//        findShampooBySizeOrLabelIdFromInput();

        //03.
//        findShampooByPriceGreaterThan();

        //04.
//        findIngredientByNameStartingWith();

        //05.
//        sortIngredientByPrice();

        //06.
//        countByPriceLowerThan();

        //07.
//        findShampooByIngredientList();

        //08.
//        findShampoosByIngredientCountLessThan();

        //09.
//        deleteIngredientByName();

        //10.
//        updateIngredientsByPrice();

        //11.
        updateIngredientsByName();
    }

    private void updateIngredientsByName() {
        List<String> namesForUpdate = new ArrayList<>();
        namesForUpdate.add("Apple");
        namesForUpdate.add("Nettle");
        namesForUpdate.add("Herbs");

        ingredientService.updateIngredientByNameList(namesForUpdate);
    }

    private void updateIngredientsByPrice() {
        ingredientService.updateIngredientsByPrice();
    }

    private void deleteIngredientByName() {
        System.out.print("Enter ingredient's name: ");
        String name = scanner.nextLine();

        ingredientService.deleteByName(name);
    }

    private void findShampoosByIngredientCountLessThan() {
        System.out.print("Enter ingredients count: ");
        int counter = Integer.parseInt(scanner.nextLine());

        List<Shampoo> shampoos = shampooService.findAllByIngredientsCount(counter);
        for (Shampoo shampoo : shampoos) {
            System.out.printf("%s%n", shampoo.getBrand());
        }
    }

    private void findShampooByIngredientList() {
        List<String> ingredients = new ArrayList<>();
        ingredients.add("Berry");
        ingredients.add("Mineral-Collagen");

        List<Shampoo> shampoos = shampooService.findAllByIngredientList(ingredients);
        for (Shampoo s : shampoos) {
            System.out.println(s.getBrand());
        }
    }

    private void countByPriceLowerThan() {
        System.out.print("Enter the price of the shampoo: ");
        BigDecimal price = new BigDecimal(scanner.nextLine());
        int shampoosCount = shampooService.CountByPriceLessThan(price);
        System.out.println(shampoosCount);
    }

    private void sortIngredientByPrice(){
        List<String> list = new ArrayList<>();
        list.add("Lavender");
        list.add("Herbs");
        list.add("Apple");

        List<Ingredient> ingredients = ingredientService.findAllByNameIn(list);
        for (Ingredient ingredient : ingredients) {
            System.out.println(ingredient.getName());
        }
    }

    private void findIngredientByNameStartingWith() {
        System.out.print("Enter the start of name of the ingredient: ");
        String startingName = scanner.nextLine();

        List<Ingredient> ingredients = ingredientService.findAllByNameStartingWith(startingName);
        for (Ingredient ingredient : ingredients) {
            System.out.println(ingredient.getName());
        }
    }

    private void findShampooByPriceGreaterThan() {
        System.out.print("Enter shampoo price greater than or equal to: ");
        BigDecimal price = scanner.nextBigDecimal();

        List<Shampoo> shampoos = shampooService.findAllByPriceGreaterThan(price);
        for (Shampoo shampoo : shampoos) {
            System.out.printf("%s %s %slv.%n", shampoo.getBrand(), shampoo.getSize(), shampoo.getPrice());
        }
    }

    private void findShampooBySizeOrLabelIdFromInput() {
        System.out.print("Enter the size of the shampoo: ");
        Size size = Size.valueOf(scanner.nextLine());

        System.out.print("Enter the id of the label: ");
        Long id = Long.valueOf(scanner.nextLine());

        List<Shampoo> shampoos = shampooService.findAllBySizeOrId(size, id);
        for (Shampoo shampoo : shampoos) {
            System.out.printf("%s %s %slv.%n",shampoo.getBrand(),shampoo.getSize(),shampoo.getPrice());
        }
    }

    private void findShampooBySizeFromInput() {
        System.out.print("Enter the size of the shampoo: ");
        Size size = Size.valueOf(scanner.nextLine());

        List<Shampoo> shampoos = shampooService.findAllBySize(size);
        for (Shampoo shampoo : shampoos) {
            System.out.printf("%s %s %slv.%n",shampoo.getBrand(),shampoo.getSize(),shampoo.getPrice());
        }
    }


}

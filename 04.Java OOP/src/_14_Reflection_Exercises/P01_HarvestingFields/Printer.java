package _14_Reflection_Exercises.P01_HarvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Printer {

    public static void print(String type) {
        Field[] declaredFields = RichSoilLand.class.getDeclaredFields();
        switch (type.trim()) {
            case "private" -> {
                for (Field field : declaredFields) {
                    if (Modifier.isPrivate(field.getModifiers())) {
                        System.out.printf("%s %s %s\n", field.accessFlags().toString().replace("[", "").replace("]", "").toLowerCase(), field.getType().getSimpleName(), field.getName());
                    }
                }
            }
            case "protected" -> {
                for (Field field : declaredFields) {
                    if (Modifier.isProtected(field.getModifiers())) {
                        System.out.printf("%s %s %s\n", field.accessFlags().toString().replace("[", "").replace("]", "").toLowerCase(), field.getType().getSimpleName(), field.getName());
                    }
                }
            }
            case "public" -> {
                for (Field field : declaredFields) {
                    if (Modifier.isPublic(field.getModifiers())) {
                        System.out.printf("%s %s %s\n", field.accessFlags().toString().replace("[", "").replace("]", "").toLowerCase(), field.getType().getSimpleName(), field.getName());
                    }
                }
            }
            case "all" -> {
                for (Field field : declaredFields) {
                    System.out.printf("%s %s %s\n", field.accessFlags().toString().replace("[", "").replace("]", "").toLowerCase(), field.getType().getSimpleName(), field.getName());

                }
            }
            default -> System.out.println("Invalid type!");
        }
    }
}